package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.PromotionDto;
import ma.yc.marjane.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PromotiomMapper {
    PromotiomMapper promotionMapper = Mappers.getMapper(PromotiomMapper.class);

    Promotion toEntity(PromotionDto promotionDto);

    PromotionDto toDto(Promotion promotion);
}
