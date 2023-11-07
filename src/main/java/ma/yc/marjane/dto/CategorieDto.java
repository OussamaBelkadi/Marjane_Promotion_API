package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategorieDto {
    private String nom;
    private String description;
    private String image;
    private String slug;
}
