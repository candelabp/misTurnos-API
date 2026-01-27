package com.example.sistematurnos.mapper;

import com.example.sistematurnos.model.dto.profesional.ProfesionalRequestDTO;
import com.example.sistematurnos.model.dto.profesional.ProfesionalResponseDTO;
import com.example.sistematurnos.model.entity.Profesional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, DisponibilidadMapper.class})
public interface ProfesionalMapper {
    @Mapping(target = "id", ignore = true)
    Profesional toEntity(ProfesionalRequestDTO dto);
    ProfesionalResponseDTO toResponseDto(Profesional profesional);
}
