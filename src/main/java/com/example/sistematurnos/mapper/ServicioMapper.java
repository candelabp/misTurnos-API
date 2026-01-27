package com.example.sistematurnos.mapper;

import com.example.sistematurnos.model.dto.servicio.ServicioRequestDTO;
import com.example.sistematurnos.model.dto.servicio.ServicioResponseDTO;
import com.example.sistematurnos.model.entity.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={})
public interface ServicioMapper {
    Servicio toEntity(ServicioRequestDTO dto);
    ServicioResponseDTO toResponseDto(Servicio servicio);

}
