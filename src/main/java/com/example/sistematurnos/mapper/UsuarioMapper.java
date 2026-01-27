package com.example.sistematurnos.mapper;

import com.example.sistematurnos.model.dto.usuario.UsuarioRequestDTO;
import com.example.sistematurnos.model.dto.usuario.UsuarioResponseDTO;
import com.example.sistematurnos.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "id", ignore = true)
    Usuario toEntity(UsuarioRequestDTO dto);
    UsuarioResponseDTO toResponseDto(Usuario usuario);
}
