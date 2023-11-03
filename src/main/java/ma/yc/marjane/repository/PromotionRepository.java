package ma.yc.marjane.repository;

import ma.yc.marjane.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    public Promotion findByDescription(String description);


}
