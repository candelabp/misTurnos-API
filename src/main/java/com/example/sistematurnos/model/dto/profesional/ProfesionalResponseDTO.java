package com.example.sistematurnos.model.dto.profesional;

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
public class ProfesionalResponseDTO {
    private Long id;
    private Usuario usuario;
    private String especialidad;
    private List<Disponibilidad> disponibilidades;
}
