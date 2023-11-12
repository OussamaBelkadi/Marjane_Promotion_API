package ma.yc.marjane.repository;

import ma.yc.marjane.entity.Produit;
import ma.yc.marjane.entity.Promotion;
import ma.yc.marjane.enums.StatusPromotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PromotionRepositoryTest {

    private PromotionRepository promotionRepositoryUnderTest;
    private  Collection<Promotion> promotionCollection = new ArrayList<>();
    @BeforeEach
    void setUp() {

        Promotion promotion = new Promotion();
        promotion.setDescription("description promotion");
        promotion.setStatus(StatusPromotion.EN_ATTENTE);
        promotion.setPrecentage(10.0);
        promotion.setDateFin(new Date());
        promotion.setDateDebut(new Date());

        Produit produit = new Produit();
        produit.setNom("nom produit");
        produit.setPrix(10.0);
        produit.setQuantite(10);
        produit.setPromotion(promotion);
        promotion.getProduits().add(produit);


        promotionCollection.add(promotion);


    }

    @Test
    void findByDescription() {

    }

//    @Test
    void saveAll() {
        // Setup

        // Run the test
        final Collection<Promotion> result = promotionRepositoryUnderTest.saveAll(promotionCollection);
        int size = result.size();

        // Verify the results
        assertNotNull(result);
        assertEquals(1,size);

    }

//    @Test
    void findAllByStatus() {
        // Setup

        // Run the test
        final Collection<Promotion> result = promotionRepositoryUnderTest.findAllByStatus(StatusPromotion.EN_ATTENTE);
        int size = result.size();

        // Verify the results
        assertNotNull(result);
        assertEquals(1,size);
    }
}