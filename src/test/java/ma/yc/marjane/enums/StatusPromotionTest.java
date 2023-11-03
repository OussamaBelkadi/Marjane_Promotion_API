package ma.yc.marjane.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusPromotionTest {

    StatusPromotion statusPromotion ;
    @Test
    void values() {
        StatusPromotion[] statusPromotions = StatusPromotion.values();
        assertEquals(statusPromotions[0],StatusPromotion.ACCPETER);
        assertEquals(statusPromotions[1],StatusPromotion.REFUSER);
    }

    @Test
    void valueOf() {
        StatusPromotion statusPromotion = StatusPromotion.valueOf("ACCPETER");
        assertEquals(statusPromotion,StatusPromotion.ACCPETER);
        statusPromotion = StatusPromotion.valueOf("REFUSER");
        assertEquals(statusPromotion,StatusPromotion.REFUSER);

    }
}