package ma.yc.marjane.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nom ;
    private String description ;
    private String image;
    private double prix;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

}

