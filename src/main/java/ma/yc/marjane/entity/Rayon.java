package ma.yc.marjane.entity;


import jakarta.persistence.*;
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
    @OneToOne(mappedBy = "rayon")
    private Categorie categorie;
    @OneToOne
    private Responsable responsable;

    @ManyToOne
    private Centre centre;

}
