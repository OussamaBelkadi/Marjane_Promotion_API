package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsablePromotionResponse {
    private Collection<ResponsablePromotionDto> promotionDtos = new ArrayList<>();
}
