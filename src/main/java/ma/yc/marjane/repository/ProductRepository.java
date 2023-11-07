package ma.yc.marjane.repository;


import ma.yc.marjane.entity.Produit;
import ma.yc.marjane.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produit,Integer> {
}
