package ma.yc.marjane.mapper;

import ma.yc.marjane.dto.ResponsablePromotionDto;
import ma.yc.marjane.entity.Promotion;
import ma.yc.marjane.enums.StatusPromotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponsablePromotoinMapperTest {


    ResponsablePromotoinMapper responsablePromotoinMapper = ResponsablePromotoinMapper.INSTANCE;
    @Test
    void toEntity() {
        ResponsablePromotionDto responsablePromotionDto = new ResponsablePromotionDto();
        responsablePromotionDto.setId(1L);
        responsablePromotionDto.setStatus(StatusPromotion.ACCPETER);
        Promotion promotion = this.responsablePromotoinMapper.toEntity(responsablePromotionDto);

        assertEquals(promotion.getId(),responsablePromotionDto.getId());
        assertEquals(promotion.getStatus(),responsablePromotionDto.getStatus());
    }

    @Test
    void toDto() {
        Promotion promotion = new Promotion();
        promotion.setId(1L);
        promotion.setStatus(StatusPromotion.ACCPETER);
        ResponsablePromotionDto responsablePromotionDto = this.responsablePromotoinMapper.toDto(promotion);

        assertEquals(promotion.getId(),responsablePromotionDto.getId());
        assertEquals(promotion.getStatus(),responsablePromotionDto.getStatus());
        assertNotNull(responsablePromotionDto);

    }
}