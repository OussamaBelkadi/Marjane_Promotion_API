package ma.yc.marjane.repository;

import ma.yc.marjane.entity.AdminGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository<T,e> extends   JpaRepository<T,e>{
    public T findByEmail(String email);
}
