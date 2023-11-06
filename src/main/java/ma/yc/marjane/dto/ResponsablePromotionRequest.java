package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.marjane.dto.projectDto.PromotionDto;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsablePromotionRequest {
    private Long responsableId ;
    private Collection<ResponsablePromotionDto> promotion  = new ArrayList<>();

}
