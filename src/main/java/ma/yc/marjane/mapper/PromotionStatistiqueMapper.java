package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.PromotionDto;
import ma.yc.marjane.dto.PromotionStatistique;
import ma.yc.marjane.dto.PromotionStatistiques;
import ma.yc.marjane.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PromotionStatistiqueMapper
{

    PromotionStatistiqueMapper promotionMapper = Mappers.getMapper(PromotionStatistiqueMapper.class);

    @Mapping(target = "updatedAt", source = "promotionStatistique.dateApplique")
    Promotion toEntity(PromotionStatistique promotionStatistique);

    @Mapping(target = "dateApplique", source = "promotion.updatedAt")
    PromotionStatistique toDto(Promotion promotion);
}
