package mapper;

import model.dto.servicio.ServicioRequestDTO;
import model.dto.servicio.ServicioResponseDTO;
import model.entity.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={})
public interface ServicioMapper {
    Servicio toEntity(ServicioRequestDTO dto);
    ServicioResponseDTO toResponseDto(Servicio servicio);

}
