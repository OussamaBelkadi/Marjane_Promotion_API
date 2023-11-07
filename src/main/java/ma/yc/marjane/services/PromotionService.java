package ma.yc.marjane.services;

import ma.yc.marjane.dto.ProduitDto;
import ma.yc.marjane.dto.PromotionDto;

import java.util.List;

public interface PromotionService {
    public ProduitDto addPromotion(ProduitDto produitDto, PromotionDto promotionDto);
    public List<PromotionDto> getAll();
}
