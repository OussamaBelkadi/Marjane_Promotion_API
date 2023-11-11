package ma.yc.marjane.controller.AdminCentre;

import ma.yc.marjane.dto.PromotionCentreRequestDto;
import ma.yc.marjane.dto.PromotionStatistique;
import ma.yc.marjane.dto.projectDto.PromotionDto;
import ma.yc.marjane.services.PromotiomAuNiveauCentreService;
import ma.yc.marjane.services.impl.PromotiomAuNiveauCentreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/statistics/promotion/centre")
public class StatistiquePromotionAuNiveauCentreController {
    private final PromotiomAuNiveauCentreService PromotiomAuNiveauCentreService;

    @Autowired
    public StatistiquePromotionAuNiveauCentreController(PromotiomAuNiveauCentreServiceImp PromotiomAuNiveauCentreServiceImp){
        this.PromotiomAuNiveauCentreService = PromotiomAuNiveauCentreServiceImp;
    }

    @GetMapping()
    public Collection<PromotionDto> listPromotion(@PathVariable PromotionCentreRequestDto promotionCentreRequestDto) {
        return this.PromotiomAuNiveauCentreService.ListPromotion(promotionCentreRequestDto);
    }
    @PostMapping()
    public Collection<PromotionStatistique> StatisticPromotionCentre(@RequestBody PromotionCentreRequestDto promotionCentreRequestDto){
         return this.PromotiomAuNiveauCentreService.StatisticPromotionCentre(promotionCentreRequestDto);
    }
}
