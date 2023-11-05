package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.projectDto.RayonDto;
import ma.yc.marjane.entity.Rayon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RayonMapper {
    RayonMapper rayonMapper = Mappers.getMapper(RayonMapper.class);

    Rayon toEntity(RayonDto rayonDto);
    RayonDto toDto(Rayon rayon);
}
