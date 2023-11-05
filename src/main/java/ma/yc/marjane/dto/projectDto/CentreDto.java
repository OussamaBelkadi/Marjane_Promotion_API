package ma.yc.marjane.dto.projectDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.marjane.entity.Ville;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CentreDto {
    private Ville ville;
    private String nom;
    private String adresse;
    private String tel;
    private String email;
}
