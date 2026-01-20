package mapper;

import model.dto.disponibilidad.DisponibilidadRequestDTO;
import model.dto.disponibilidad.DisponibilidadResponseDTO;
import model.entity.Disponibilidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses={ProfesionalMapper.class})
public interface DisponibilidadMapper {
    @Mapping(target = "id", ignore = true)
    Disponibilidad toEntity(DisponibilidadRequestDTO dto);
    DisponibilidadResponseDTO toResponseDto (Disponibilidad disponibilidad);

}
