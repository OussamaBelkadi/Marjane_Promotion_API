package ma.yc.marjane.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ville {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String codePostal;
    @OneToMany(mappedBy = "ville")
    private Collection<Centre> centres = new ArrayList<>();


}
