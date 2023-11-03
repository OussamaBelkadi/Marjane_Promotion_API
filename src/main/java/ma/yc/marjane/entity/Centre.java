package ma.yc.marjane.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Centre {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ville_id")
    private Ville ville;
    private String nom;
    private String adresse;
    private String tel;
    private String email;
    @ManyToMany
    @JoinTable(
            name = "categorie_centre",
            joinColumns = { @JoinColumn(name = "center_id") },
            inverseJoinColumns = { @JoinColumn(name = "categorie_id") }
    )
    private Collection<Categorie> categories = new ArrayList<>();
    @OneToOne(mappedBy = "centre",cascade = CascadeType.ALL)
    private AdminCentre admin_centre;
    @OneToMany(mappedBy = "centre",cascade = CascadeType.ALL)
    private Collection<Rayon> rayons = new ArrayList<>();
    @OneToMany(mappedBy = "centre",cascade = CascadeType.ALL)
    private Collection<Responsable> responsables = new ArrayList<>();




}
