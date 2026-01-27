package com.example.sistematurnos.mapper;

import com.example.sistematurnos.model.dto.disponibilidad.DisponibilidadRequestDTO;
import com.example.sistematurnos.model.dto.disponibilidad.DisponibilidadResponseDTO;
import com.example.sistematurnos.model.entity.Disponibilidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses={ProfesionalMapper.class})
public interface DisponibilidadMapper {
    @Mapping(target = "id", ignore = true)
    Disponibilidad toEntity(DisponibilidadRequestDTO dto);
    DisponibilidadResponseDTO toResponseDto (Disponibilidad disponibilidad);

}
