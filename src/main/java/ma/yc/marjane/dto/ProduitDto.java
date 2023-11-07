package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProduitDto {
    private int id_pdt;
    private String nom ;
    private String description ;
    private String image ;
    private double prix ;
    private int quantite ;
}
