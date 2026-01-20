package mapper;

import model.dto.usuario.UsuarioRequestDTO;
import model.dto.usuario.UsuarioResponseDTO;
import model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "id", ignore = true)
    Usuario toEntity(UsuarioRequestDTO dto);
    UsuarioResponseDTO toResponseDto(Usuario usuario);
}
