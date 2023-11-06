package ma.yc.marjane.services;

import ma.yc.marjane.dto.ResponsablePromotionRequest;
import ma.yc.marjane.dto.ResponsablePromotionResponse;

public interface ResponsablePromotionService {

    public ResponsablePromotionResponse ApprouverOuRefuserPromotion(ResponsablePromotionRequest responsablePromotionRequest);

}
