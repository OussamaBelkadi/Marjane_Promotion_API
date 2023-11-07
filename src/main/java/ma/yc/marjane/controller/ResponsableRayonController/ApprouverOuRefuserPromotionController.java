package ma.yc.marjane.controller.ResponsableRayonController;

import ma.yc.marjane.dto.ResponsablePromotionRequest;
import ma.yc.marjane.dto.ResponsablePromotionResponse;
import ma.yc.marjane.services.ResponsablePromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/responsables-promotion")
public class ApprouverOuRefuserPromotionController {


    private ResponsablePromotionService responsablePromotionService ;



    @Autowired
    public ApprouverOuRefuserPromotionController(ResponsablePromotionService responsablePromotionService) {
        this.responsablePromotionService = responsablePromotionService;
    }


    @PostMapping()
    public ResponsablePromotionResponse approuverOuRefuserPromotion(@RequestBody ResponsablePromotionRequest responsablePromotionRequest){
        return  this.responsablePromotionService.ApprouverOuRefuserPromotion(responsablePromotionRequest);

    }
}
