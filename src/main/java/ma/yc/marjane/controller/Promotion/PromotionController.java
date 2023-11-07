package ma.yc.marjane.controller.Promotion;


import ma.yc.marjane.dto.projectDto.ProduitDto;
import ma.yc.marjane.dto.projectDto.PromotionDto;
import ma.yc.marjane.exception.ResourceNotFoundException;
import ma.yc.marjane.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/product")
    public ResponseEntity<?> promotionProduct(@RequestBody ProduitDto produitDto, PromotionDto promotionDto){
        try{
            produitDto = this.promotionService.addPromotion(produitDto,promotionDto);
            return  ResponseEntity.ok(produitDto);
        }catch(ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
