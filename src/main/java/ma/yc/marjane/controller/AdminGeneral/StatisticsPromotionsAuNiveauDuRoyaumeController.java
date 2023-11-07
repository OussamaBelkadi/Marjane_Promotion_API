package ma.yc.marjane.controller.AdminGeneral;

import ma.yc.marjane.dto.PromotionStatistiques;
import ma.yc.marjane.services.StatisticsPromotionsAuNiveauDuRoyaumeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/statistics/promotions/royaume")
public class StatisticsPromotionsAuNiveauDuRoyaumeController {

    private StatisticsPromotionsAuNiveauDuRoyaumeService statisticsPromotionsAuNiveauDuRoyaumeService;

    public StatisticsPromotionsAuNiveauDuRoyaumeController(StatisticsPromotionsAuNiveauDuRoyaumeService statisticsPromotionsAuNiveauDuRoyaumeService) {
        this.statisticsPromotionsAuNiveauDuRoyaumeService = statisticsPromotionsAuNiveauDuRoyaumeService;
    }


    @GetMapping()
    public Collection<PromotionStatistiques> getStatisticsPromotionsAuNiveauDuRoyaume(
            @RequestHeader("Authorization") String token ,
            @RequestParam(value = "status",required = false)  String status) {

        if (status !=null){
            return this.statisticsPromotionsAuNiveauDuRoyaumeService.getStatisticsPromotionsAuNiveauDuRoyaume(status);
        }
        else{
            return  this.statisticsPromotionsAuNiveauDuRoyaumeService.getStatisticsPromotionsAuNiveauDuRoyaume();
        }
    }
}
