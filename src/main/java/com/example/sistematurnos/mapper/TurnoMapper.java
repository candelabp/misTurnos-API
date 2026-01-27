package com.example.sistematurnos.mapper;

import com.example.sistematurnos.model.dto.turno.TurnoRequestDTO;
import com.example.sistematurnos.model.dto.turno.TurnoResponseDTO;
import com.example.sistematurnos.model.entity.Turno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses ={ClienteMapper.class, ProfesionalMapper.class, ServicioMapper.class})
public interface TurnoMapper {
    @Mapping(target = "id", ignore = true)
    Turno toEntity(TurnoRequestDTO dto);
    TurnoResponseDTO toResponseDto(Turno turno);

}
