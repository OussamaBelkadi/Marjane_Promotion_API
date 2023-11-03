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
    @OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
    Collection<Produit> produits = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "categorie_centre",
            joinColumns = { @JoinColumn(name = "categorie_id") },
            inverseJoinColumns = { @JoinColumn(name = "center_id") }
    )
    private Collection<Centre> centres = new ArrayList<>();

    @OneToOne()
    @JoinColumn(name = "rayon_id")
    private Rayon rayon;





}
