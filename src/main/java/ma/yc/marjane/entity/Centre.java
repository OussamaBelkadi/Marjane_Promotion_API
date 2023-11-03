package ma.yc.marjane.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Centre {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Ville ville;
    private String nom;
    private String adresse;
    private String tel;
    private String email;
    @ManyToMany
    private Collection<Categorie> categories = new ArrayList<>();
    @OneToOne
    private Admin_Centre admin_centre;
    @OneToMany
    private Collection<Rayon> rayons = new ArrayList<>();
    @OneToMany
    private Collection<Responsable> responsables = new ArrayList<>();





}
