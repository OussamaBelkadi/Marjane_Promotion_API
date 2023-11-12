package ma.yc.marjane.repository;

import ma.yc.marjane.entity.AdminGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminGeneralAuthentificationRespository extends JpaRepository<AdminGeneral, Long> {
    public AdminGeneral findByEmail(String email);
    

}
