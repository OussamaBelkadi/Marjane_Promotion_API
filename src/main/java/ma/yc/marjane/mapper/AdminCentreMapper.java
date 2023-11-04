package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.projectDto.AdminCentreDto;
import ma.yc.marjane.entity.AdminCentre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminCentreMapper {
    AdminCentreMapper adminCentreMapper = Mappers.getMapper(AdminCentreMapper.class);

    AdminCentre toEntity(AdminCentreDto adminCentreDto);

    AdminCentreDto toDto(AdminCentre adminCentre);

}
