package ma.yc.marjane.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
    @Id
    private int id;
    private String nom;
    private String description;
    private String image;
    private String slug;
    @OneToMany()
    Collection<Produit> produits = new ArrayList<>();
    @ManyToMany
    private Collection<Centre> centres = new ArrayList<>();
    @ManyToOne
    private Rayon rayon;
    @OneToMany
    private Collection<Promotion> promotions = new ArrayList<>();





}
