package ma.yc.marjane.services;

import ma.yc.marjane.dto.PromotionStatistiques;

import java.util.Collection;

public interface StatisticsPromotionsAuNiveauDuRoyaumeService {

    public Collection<PromotionStatistiques> getStatisticsPromotionsAuNiveauDuRoyaume(String...status);
}
