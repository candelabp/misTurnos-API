package model.dto.Turno;

import model.enums.EstadoTurno;

import java.time.LocalDateTime;

public class TurnoResponseDto {
    Long id;
    Long clienteId;
    Long profesionalId;
    Long servicioId;
    LocalDateTime fechaInicio;
    LocalDateTime fechaFin;
    EstadoTurno estado;
    String observaciones;

}
