package ma.yc.marjane.repository;

import ma.yc.marjane.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminGeneralAuthentificationRespository extends JpaRepository<User , Long> {
    public User findByEmail(String email);

}
