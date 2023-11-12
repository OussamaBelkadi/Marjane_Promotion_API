package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.ResponsableDto;
import ma.yc.marjane.entity.Responsable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponsableMapper {
    ResponsableMapper Instance = Mappers.getMapper(ResponsableMapper.class);
    Responsable toEntity(ResponsableDto responsableDto);

    ResponsableDto toDto(Responsable responsable);
}
