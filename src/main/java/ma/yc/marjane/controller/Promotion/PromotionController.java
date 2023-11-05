package ma.yc.marjane.controller.Promotion;


import ma.yc.marjane.dto.projectDto.PromotionDto;
import ma.yc.marjane.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    private PromotionService promotionService;


    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public List<PromotionDto> getAll(){
//        throw new RuntimeException("not implemented yet");
        return this.promotionService.getAll();
    }
}
