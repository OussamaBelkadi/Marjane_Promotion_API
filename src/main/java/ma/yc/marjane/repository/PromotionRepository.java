package ma.yc.marjane.repository;

import ma.yc.marjane.entity.Promotion;
import ma.yc.marjane.enums.StatusPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    public Promotion findByDescription(String description);
    public Collection<Promotion> saveAll(Collection<Promotion> promotions);
    public Collection<Promotion> findAllByStatus(StatusPromotion status);



}
