package model.dto.disponibilidad;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.Profesional;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilidadRequestDTO {
    private Profesional profesional;
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFIn;
}
