package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.AdminGeneralDto;
import ma.yc.marjane.entity.AdminGeneral;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminGeneralMapper {
    AdminGeneralMapper adminGeneralMapper = Mappers.getMapper(AdminGeneralMapper.class);

    AdminGeneral toEntity(AdminGeneralDto adminGeneralDto);

    AdminGeneralDto toDto(AdminGeneral adminGeneral);
}
