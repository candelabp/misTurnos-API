package com.example.sistematurnos.model.dto.turno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sistematurnos.model.enums.EstadoTurno;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnoResponseDTO {
    Long id;
    Long clienteId;
    Long profesionalId;
    Long servicioId;
    LocalDateTime fechaInicio;
    LocalDateTime fechaFin;
    EstadoTurno estado;
    String observaciones;

}
