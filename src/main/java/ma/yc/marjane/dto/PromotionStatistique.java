package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.marjane.enums.StatusPromotion;

import java.text.DateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PromotionStatistique {

    private StatusPromotion status ;
    private Date dateApplique;
    private String centre ;
    private Date dateDebut;
    private Date dateFin;
}
