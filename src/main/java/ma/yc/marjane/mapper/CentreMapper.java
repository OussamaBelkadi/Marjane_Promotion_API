package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.projectDto.CentreDto;
import ma.yc.marjane.entity.Centre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CentreMapper {
    CentreMapper centreMapper = Mappers.getMapper(CentreMapper.class);

    Centre toEntity(CentreDto centreDto);

    CentreDto toDto(Centre centre);
}
