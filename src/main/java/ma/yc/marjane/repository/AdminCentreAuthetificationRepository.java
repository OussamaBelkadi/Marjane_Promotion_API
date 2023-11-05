package ma.yc.marjane.repository;

import ma.yc.marjane.entity.AdminCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCentreAuthetificationRepository extends JpaRepository<AdminCentre, Long> {
    public AdminCentre findByEmail(String email);
}