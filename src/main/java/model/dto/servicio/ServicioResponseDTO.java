package model.dto.servicio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioResponseDTO {

    private Long id;
    private String nombre;
    private Integer duracion;
    private Double precio;

}
