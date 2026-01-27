package com.example.sistematurnos.service;

import com.example.sistematurnos.exception.BusinessConflictException;
import com.example.sistematurnos.exception.ResourceNotFoundException;
import com.example.sistematurnos.repository.*;
import org.springframework.transaction.annotation.Transactional;import lombok.RequiredArgsConstructor;
import com.example.sistematurnos.mapper.TurnoMapper;
import com.example.sistematurnos.model.dto.turno.TurnoRequestDTO;
import com.example.sistematurnos.model.dto.turno.TurnoResponseDTO;
import com.example.sistematurnos.model.entity.Turno;
import com.example.sistematurnos.model.enums.EstadoTurno;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurnoService {
private final TurnoRepository turnoRepository;
private final ClienteRepository clienteRepository;
private final ProfesionalRepository profesionalRepository;
private final ServicioRepository servicioRepository;
private final DisponibilidadRepository disponibilidadRepository;
private final TurnoMapper turnoMapper;

@Transactional
    public TurnoResponseDTO reservar(TurnoRequestDTO request){
    if (request.getFechaInicio() == null){
        throw new BusinessConflictException("fecha de inicio obligatoria");
    }
    if (request.getFechaInicio().isBefore(LocalDateTime.now())){
        throw new BusinessConflictException("La fecha de inicio debe ser futura");
    }
    var cliente = clienteRepository.findById(request.getClienteId())
            .orElseThrow(()-> new ResourceNotFoundException("CLiente", request.getClienteId()));
    var profesional = profesionalRepository.findById(request.getProfesionalId())
            .orElseThrow(()-> new ResourceNotFoundException("Profesional", request.getServicioId()));
    var servicio = servicioRepository.findById(request.getServicioId())
            .orElseThrow(()-> new ResourceNotFoundException("Servicio", request.getServicioId()));
    LocalDateTime inicio = request.getFechaInicio();
    LocalDateTime fin = inicio.plusMinutes(servicio.getDuracion());

    boolean dentro = disponibilidadRepository.estaDentroDeDisponibilidad(
            profesional.getId(),
            inicio.getDayOfWeek(),
            inicio.toLocalTime(),
            fin.toLocalTime()
    );
    if (!dentro){
        throw new BusinessConflictException("El horario no esta dentro de la disponibilidad del profesional");

    }
    boolean solapamiento = turnoRepository.existeSolapamiento(profesional.getId(), inicio, fin);
    if(solapamiento){
        throw new BusinessConflictException("El profesional ya tiene un turno en ese horario");
    }

    Turno turno = new Turno();
    turno.setCliente(cliente);
    turno.setProfesional(profesional);
    turno.setServicio(servicio);
    turno.setFechaInicio(inicio);
    turno.setFechaFin(fin);
    turno.setEstado(EstadoTurno.RESERVADO);
    turno.setObservaciones(request.getObservaciones());

    Turno guardado = turnoRepository.save(turno);

    return new TurnoResponseDTO(
            guardado.getId(),
            guardado.getCliente().getId(),
            guardado.getProfesional().getId(),
            guardado.getServicio().getId(),
            guardado.getFechaInicio(),
            guardado.getFechaFin(),
            guardado.getEstado(),
            guardado.getObservaciones()
    );
}
@Transactional
    public TurnoResponseDTO cancelarTurno(Long id, String motivo){
    Turno turno = turnoRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Turno", id));
    if(turno.getEstado() == EstadoTurno.CANCELADO || turno.getEstado() == EstadoTurno.COMPLETADO){
        throw new BusinessConflictException("No se puede cambiar el turno con estado: " + turno.getEstado());
    }
    turno.setEstado(EstadoTurno.CANCELADO);
    turno.setMotivoCancelacion(motivo);

    return turnoMapper.toResponseDto(turnoRepository.save(turno));

}
@Transactional(readOnly = true)
    public List<TurnoResponseDTO>listarTodos(){
    return turnoRepository.findAll().stream()
            .map(turnoMapper::toResponseDto)
            .toList();
}

}
