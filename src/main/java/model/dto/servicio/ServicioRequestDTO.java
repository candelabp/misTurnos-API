package model.dto.servicio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioRequestDTO {
    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El campo duración es obligatorio")
    private Integer duracion;

    @NotNull( message = "El campo precio es obligatorio")
    private Double precio;
}
