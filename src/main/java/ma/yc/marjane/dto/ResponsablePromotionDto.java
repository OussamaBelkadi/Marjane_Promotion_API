package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.marjane.enums.StatusPromotion;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsablePromotionDto {
    private Long id ;
    private StatusPromotion status ;
}
