package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.PromotionStatistique;
import ma.yc.marjane.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface StatisticPromotionMapper {
    StatisticPromotionMapper statisticPromotionMapper = Mappers.getMapper(StatisticPromotionMapper.class);

    Promotion toEntity(PromotionStatistique promotionStatistique);

    PromotionStatistique toDto(Promotion promotion);
}
