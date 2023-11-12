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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "centre_id")
    private Centre centre;
    @OneToMany(mappedBy = "promotion",fetch = FetchType.EAGER)
    private Collection<Produit> produits = new ArrayList<>() ;


}
