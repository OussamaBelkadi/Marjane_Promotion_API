package ma.yc.marjane.repository;

import ma.yc.marjane.entity.Promotion;
import ma.yc.marjane.enums.StatusPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface StatisticsPromotionsAuNiveauDuRoyaumeRepository extends JpaRepository<Promotion ,Long> {

    public Optional<Collection<Promotion>> findAllByStatus(StatusPromotion statusPromotion);
}
