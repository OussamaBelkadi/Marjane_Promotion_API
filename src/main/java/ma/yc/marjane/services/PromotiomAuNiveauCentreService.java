package ma.yc.marjane.services;

import ma.yc.marjane.dto.PromotionCentreRequestDto;
import ma.yc.marjane.dto.PromotionStatistique;
import ma.yc.marjane.dto.projectDto.PromotionDto;

import java.util.Collection;

public interface PromotiomAuNiveauCentreService {
    Collection<PromotionDto> ListPromotion(PromotionCentreRequestDto promotionCentreRequestDto);
    Collection<PromotionStatistique> StatisticPromotionCentre(PromotionCentreRequestDto promotionCentreRequestDto);
}
