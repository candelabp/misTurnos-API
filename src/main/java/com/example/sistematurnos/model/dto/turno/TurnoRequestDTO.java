package com.example.sistematurnos.model.dto.turno;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnoRequestDTO {
    @NotNull(message = "El campo clienteId es obligatorio")
    private Long clienteId;

    @NotNull(message = "El campo profesionalId es obligatorio")
    private Long profesionalId;

    @NotNull(message = "El campo servicioId es obligatorio")
    private Long servicioId;

    private LocalDateTime fechaInicio;

    @Size(max = 500, message = "La observación no puede tener más de 500 caracteres")
    private String observaciones;
}
