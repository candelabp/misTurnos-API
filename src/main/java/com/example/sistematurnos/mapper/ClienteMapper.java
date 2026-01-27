package com.example.sistematurnos.mapper;

import com.example.sistematurnos.model.dto.cliente.ClienteRequestDTO;
import com.example.sistematurnos.model.dto.cliente.ClienteResponseDTO;
import com.example.sistematurnos.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses={ UsuarioMapper.class})
public interface ClienteMapper {
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequestDTO dto);
    ClienteResponseDTO toResponseDto(Cliente cliente);
}
