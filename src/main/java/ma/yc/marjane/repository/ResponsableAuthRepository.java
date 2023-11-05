package ma.yc.marjane.repository;

import ma.yc.marjane.entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableAuthRepository extends JpaRepository<Responsable,Long>{
    public Responsable findByEmail(String email);
}
