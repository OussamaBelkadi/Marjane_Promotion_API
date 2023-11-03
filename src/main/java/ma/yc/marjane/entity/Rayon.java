package ma.yc.marjane.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rayon {
    @Id
    private int id;
    private String nom;
    private String description;
    private String image;
    @OneToMany
    private Collection<Categorie> categories = new ArrayList<>();
    @OneToOne
    private Responsable responsable;

}
