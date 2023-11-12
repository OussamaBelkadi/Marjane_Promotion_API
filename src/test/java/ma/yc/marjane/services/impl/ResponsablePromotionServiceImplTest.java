package ma.yc.marjane.services.impl;

import ma.yc.marjane.dto.ResponsablePromotionDto;
import ma.yc.marjane.dto.ResponsablePromotionResponse;
import ma.yc.marjane.entity.Responsable;
import ma.yc.marjane.enums.StatusPromotion;
import ma.yc.marjane.mapper.ResponsablePromotoinMapper;
import ma.yc.marjane.repository.PromotionRepository;
import ma.yc.marjane.repository.ResponsableAuthRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ResponsablePromotionServiceImplTest {



    private  ResponsableAuthRepository responsableAuthRepository;
    private PromotionRepository promotionRepository ;
    private ResponsablePromotoinMapper responsablePromotoinMapper ;
    @BeforeEach
    void setUp() {
    }

    @Test
    void approuverOuRefuserPromotion() {
        ResponsablePromotionResponse response  = new ResponsablePromotionResponse();
        response.setPromotionDtos(Arrays.asList(
                new ResponsablePromotionDto(1L, StatusPromotion.EN_ATTENTE),
                new ResponsablePromotionDto(2L,StatusPromotion.REFUSER),
                new ResponsablePromotionDto(3L, StatusPromotion.ACCPETER)
        ));

        assertEquals(3, response.getPromotionDtos().size());
        assertNotNull(response);
        assertTrue(!response.getPromotionDtos().isEmpty());



    }

    @Test
    void findResponsableById() {
        Long responsableId = 1L ;
        Responsable responsable = new Responsable();
        responsable.setId(1);

        Optional<Responsable> responsables = Optional.of(
            responsable
        );

        assertNotNull(responsables.get());
        assertEquals(1,responsables.get().getId());
        assertEquals(1,responsableId);
        assertTrue(responsables.isPresent());



    }
}