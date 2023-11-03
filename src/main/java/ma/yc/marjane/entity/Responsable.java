package ma.yc.marjane.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Responsable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String username;
    @ManyToOne
    private Ville ville;
    @ManyToOne
    @JoinColumn(name="centre_id")
    private Centre  centre;

    @OneToOne
    private Rayon rayon;

}
