package mapper;

import model.dto.profesional.ProfesionalRequestDTO;
import model.dto.profesional.ProfesionalResponseDTO;
import model.entity.Profesional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, DisponibilidadMapper.class})
public interface ProfesionalMapper {
    @Mapping(target = "id", ignore = true)
    Profesional toEntity(ProfesionalRequestDTO dto);
    ProfesionalResponseDTO toResponseDto(Profesional profesional);
}
