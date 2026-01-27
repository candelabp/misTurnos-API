package com.example.sistematurnos.model.dto.profesional;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sistematurnos.model.entity.Disponibilidad;
import com.example.sistematurnos.model.entity.Usuario;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionalRequestDTO {
    private Usuario usuario;

    @NotBlank(message = "El campo especialidad es obligatorio")
    private String especialidad;

    private List<Disponibilidad> disponibilidades;
}
