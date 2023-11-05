package ma.yc.marjane.dto.projectDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponsableDto {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String username;
}
