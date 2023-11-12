package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsablePromotionRequest {
    private Long responsableId ;
    private Collection<ResponsablePromotionDto> promotionList  = new ArrayList<>();

}
