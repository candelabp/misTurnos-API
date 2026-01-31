package com.example.sistematurnos.model.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sistematurnos.model.enums.Rol;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    private String nombre;
    private String email;
    private Rol rol;
    private boolean activo;
    private String auth0Id;

}
