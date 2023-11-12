package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.ResponsablePromotionDto;
import ma.yc.marjane.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponsablePromotoinMapper {
    ResponsablePromotoinMapper INSTANCE = Mappers.getMapper(ResponsablePromotoinMapper.class);

    Promotion toEntity(ResponsablePromotionDto responsablePromotionDto);

    ResponsablePromotionDto toDto(Promotion promotion);
}
