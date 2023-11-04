package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.projectDto.PromotionDto;
import ma.yc.marjane.entity.Promotion;
import org.mapstruct.factory.Mappers;

public interface PromotiomMapper {
    PromotiomMapper promotionMapper = Mappers.getMapper(PromotiomMapper.class);

    Promotion toEntity(PromotionDto promotionDto);

    PromotionDto toDto(Promotion promotion);
}
