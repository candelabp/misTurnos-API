package mapper;

import model.dto.cliente.ClienteRequestDTO;
import model.dto.cliente.ClienteResponseDTO;
import model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses={ UsuarioMapper.class})
public interface ClienteMapper {
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequestDTO dto);
    ClienteResponseDTO toResponseDto(Cliente cliente);
}
