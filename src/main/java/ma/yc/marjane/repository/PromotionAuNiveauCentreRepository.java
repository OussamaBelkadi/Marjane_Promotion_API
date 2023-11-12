package ma.yc.marjane.repository;

import ma.yc.marjane.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface PromotionAuNiveauCentreRepository extends JpaRepository<Promotion, Long> {
    Optional<Collection<Promotion>> findAllByCentre_idAndStatus(Long id, String status);
    Optional<Collection<Promotion>> findAllByCentre_id(Long id);

}
