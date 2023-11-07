package ma.yc.marjane.services.impl;

import ma.yc.marjane.dto.PromotionStatistique;
import ma.yc.marjane.dto.PromotionStatistiques;
import ma.yc.marjane.entity.Promotion;
import ma.yc.marjane.enums.StatusPromotion;
import ma.yc.marjane.mapper.PromotionStatistiqueMapper;
import ma.yc.marjane.repository.StatisticsPromotionsAuNiveauDuRoyaumeRepository;
import ma.yc.marjane.services.StatisticsPromotionsAuNiveauDuRoyaumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class StatisticsPromotionsAuNiveauDuRoyaumeServiceImpl implements StatisticsPromotionsAuNiveauDuRoyaumeService {




    private final StatisticsPromotionsAuNiveauDuRoyaumeRepository statisticsPromotionsAuNiveauDuRoyaumeRepository ;

    public StatisticsPromotionsAuNiveauDuRoyaumeServiceImpl(StatisticsPromotionsAuNiveauDuRoyaumeRepository statisticsPromotionsAuNiveauDuRoyaumeRepository  ) {
        this.statisticsPromotionsAuNiveauDuRoyaumeRepository = statisticsPromotionsAuNiveauDuRoyaumeRepository;
    }

    @Override
    public Collection<PromotionStatistiques> getStatisticsPromotionsAuNiveauDuRoyaume(String... status) {


        // TODO: 7/11/2023 get all promotion than you need to map them as wanted .

        Collection<PromotionStatistiques> promotionStatistiques = new ArrayList<>();
        if (status.length ==0){
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.ACCPETER));
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.REFUSER));
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion.EN_ATTENTE));

       }else {
           StatusPromotion statusPromotion = StatusPromotion.valueOf(status[0]);
           promotionStatistiques.add(getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(statusPromotion));
       }


        return promotionStatistiques;



    }

    private PromotionStatistiques getStatisticsPromotionsAuNiveauDuRoyaumeByStatus(StatusPromotion statusPromotion) {
        Optional<Collection<Promotion>> promotionsList =  this.statisticsPromotionsAuNiveauDuRoyaumeRepository.findAllByStatus(statusPromotion);
        Collection<PromotionStatistique> promotionStatistiques = new ArrayList<>();

        if (promotionsList.isPresent()){
            for (Promotion promotion:promotionsList.get()){
                PromotionStatistique promotionStatistique  = PromotionStatistiqueMapper.promotionMapper.toDto(promotion);
                promotionStatistiques.add(promotionStatistique);
            }
            
        PromotionStatistiques promotionStatistiquesList = new PromotionStatistiques();
            promotionStatistiquesList.setSize(promotionsList.get().size());
            promotionStatistiquesList.setStatus(statusPromotion);
            promotionStatistiquesList.getPromoitons().addAll(promotionStatistiques);

            return promotionStatistiquesList;
        }
        return null;
    }
}
