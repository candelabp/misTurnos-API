package model.dto.Turno;

import java.time.LocalDateTime;

public class TurnoRequestDto {
    Long clienteId;
    Long profesionalId;
    Long servicioId;
    LocalDateTime fechaInicio;
    String observaciones;
}
