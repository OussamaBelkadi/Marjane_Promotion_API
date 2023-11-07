package ma.yc.marjane.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.marjane.enums.StatusPromotion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Double precentage;
    private String description;
    @Enumerated(EnumType.STRING)
    private StatusPromotion status;
    private Date dateDebut;
    private Date dateFin;
    @OneToMany(mappedBy = "promotion")
    private Collection<Produit> produits = new ArrayList<>();


}
