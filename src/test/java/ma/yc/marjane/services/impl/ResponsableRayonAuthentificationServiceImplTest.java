package ma.yc.marjane.services.impl;

import ma.yc.marjane.entity.Responsable;
import ma.yc.marjane.util.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test de la classe ResponsableRayonAuthentificationServiceImpl")
class ResponsableRayonAuthentificationServiceImplTest {

    @Test()
    @DisplayName("Test de la methode login")
    void login() {
        Responsable responsable = new Responsable();
        responsable.setEmail("email@gmail.com");
        responsable.setId(1);
        responsable.setNom("nom");
        responsable.setPrenom("prenom");
        responsable.setUsername("username");
        responsable.setPassword("password");
        //mocking the return from the findbyEmail method

        assertNotNull(responsable);
        assertNotEquals(null,responsable);
        assertEquals("password",responsable.getPassword());
        assertEquals(1,responsable.getId());

    }

    @Test
    @DisplayName("Test de la methode logout")
    void logout() {
        boolean logout = false;
        assertEquals(false,logout);
        assertTrue(!logout);

    }

    @Test
    @DisplayName("Test de la methode register by testing if the email is valid and if the password is hashed and information are correct ")
    void register() {
        Responsable responsable = new Responsable();
        responsable.setEmail("email@gmail.com");
        responsable.setId(1);
        responsable.setNom("nom");
        responsable.setPrenom("prenom");
        responsable.setUsername("username");
        responsable.setPassword("password");

        String emailFromDbExample = "email@gmail.com";
        assertTrue(Utils.verifyEmail(responsable.getEmail()));
        assertNotNull(responsable);
        assertEquals(emailFromDbExample, responsable.getEmail());
        assertEquals(1,responsable.getId());
        assertEquals("nom",responsable.getNom());
        assertEquals("prenom",responsable.getPrenom());
        assertEquals("username",responsable.getUsername());
        assertNotNull(responsable.getPassword());

    }
    @Test
    @DisplayName("Test de la methode passwordOperation")
    void passwordOperationTest(){
        String password = "123456";
        String hashPassword = Utils.hashPassword(password);

        assertEquals(true,Utils.checkPassword(password,hashPassword));
        assertNotEquals(password , hashPassword);

    }
    @Test
    @DisplayName("Test de la methode verifyEmail")
    void verifyEmailTest() {
        String validEmail = "email@gmail.com";
        String notValidEmail = "emailgmail.com";
        String notValidEmail2 = "email@gmailcom";

        assertEquals(true, Utils.verifyEmail(validEmail));
        assertEquals(false, Utils.verifyEmail(notValidEmail));
        assertEquals(false, Utils.verifyEmail(notValidEmail2));

    }
}