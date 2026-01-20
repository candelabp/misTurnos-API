package mapper;

import model.dto.turno.TurnoRequestDTO;
import model.dto.turno.TurnoResponseDTO;
import model.entity.Turno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses ={ClienteMapper.class, ProfesionalMapper.class, ServicioMapper.class})
public interface TurnoMapper {
    @Mapping(target = "id", ignore = true)
    Turno toEntity(TurnoRequestDTO dto);
    TurnoResponseDTO toResponseDto(Turno turno);

}
