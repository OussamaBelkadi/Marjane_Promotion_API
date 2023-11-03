package ma.yc.marjane.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.marjane.enums.StatusPromotion;

import java.util.Date;

//
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PromotionDto {
private Long id;
    private Double precentage;
    private String description;
    private StatusPromotion status;
    private Date dateDebut;
    private Date dateFin;

}
