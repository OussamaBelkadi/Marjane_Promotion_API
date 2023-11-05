package ma.yc.marjane.dto.projectDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VilleDto {
    private String nom;
    private String codePostal;
}
