package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AdminCentreDto {
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private Long id_admCentre;

}
