package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.projectDto.CentreDto;
import ma.yc.marjane.entity.Centre;
import org.mapstruct.factory.Mappers;

public interface CentreMapper {
    CentreMapper centreMapper = Mappers.getMapper(CentreMapper.class);

    Centre toEntity(CentreDto centreDto);

    CentreDto toDto(Centre centre);
}
