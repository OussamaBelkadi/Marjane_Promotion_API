package ma.yc.marjane.controller.AdminCentre;

import ma.yc.marjane.dto.PromotionCentreRequestDto;
import ma.yc.marjane.dto.PromotionStatistique;
import ma.yc.marjane.dto.PromotionDto;
import ma.yc.marjane.services.PromotiomAuNiveauCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/statistics/promotion/centre")
public class StatistiquePromotionAuNiveauCentreController {

    private  PromotiomAuNiveauCentreService PromotiomAuNiveauCentreService;

    @Autowired
    public StatistiquePromotionAuNiveauCentreController( ma.yc.marjane.services.PromotiomAuNiveauCentreService promotiomAuNiveauCentreService) {
        PromotiomAuNiveauCentreService = promotiomAuNiveauCentreService;
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
