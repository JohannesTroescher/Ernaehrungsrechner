import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class DatenbankTest {

    @Test
    @Order(1)
    void UserDaten_einlesen_positiv()throws Exception{
        UserDaten Nutzer1 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer2 = new UserDaten("Rolf",55,180.1,"männlich","Muskelaufbau","normal",75.2);
        Datenbank.Userdaten_einlesen(Nutzer1);
        Datenbank.Userdaten_einlesen(Nutzer2);
        assertEquals(Datenbank.UserListe.get(Nutzer1.getUserID()),Nutzer1);
        assertEquals(Datenbank.UserListe.get(Nutzer2.getUserID()),Nutzer2);
    }
    @Test
    @Order(2)
    void UserDaten_einlesen_negativ()throws Exception{
        UserDaten Nutzer3 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer4 = new UserDaten("Rolf",55,180.1,"männlich","Muskelaufbau","normal",75.2);
        Datenbank.Userdaten_einlesen(Nutzer3);
        Datenbank.Userdaten_einlesen(Nutzer4);
        assertNotEquals(Datenbank.UserListe.get(1),Nutzer3);
        assertNotEquals(Datenbank.UserListe.get(0),Nutzer4);
        assertNotEquals(UserDaten.counter,-1);
    }
    @Test
    @Order(3)
    void UserDaten_aendern_positiv()throws Exception{
        UserDaten Nutzer5 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer6 = new UserDaten("Rolf",55,180.1,"männlich","Muskelaufbau","normal",75.2);
        Datenbank.Userdaten_einlesen(Nutzer5);
        Datenbank.Userdaten_einlesen(Nutzer6);
        Datenbank.Userdaten_aendern(0,Nutzer5);
        assertEquals(Datenbank.UserListe.get(5),Nutzer6);
        assertEquals(UserDaten.counter,5);
    }
    @Test
    @Order(4)
    void UserDaten_aendern_negativ()throws Exception{
        UserDaten Nutzer7 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer8 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        Datenbank.Userdaten_einlesen(Nutzer7);
        Datenbank.Userdaten_einlesen(Nutzer8);
        Datenbank.Userdaten_aendern(0,Nutzer7);
        assertNotEquals(Datenbank.UserListe.get(0),Nutzer8);
        assertNotEquals(UserDaten.counter,5);
    }
    @Test
    @Order(5)
    void UserID_exists_positiv()throws Exception{
        assertEquals(Datenbank.UserID_exists(3),3);
    }
    @Test
    @Order(6)
    void UserID_exists_negativ()throws Exception{
        assertThrows(Exception.class,()->{
            Datenbank.UserID_exists(25);
            Datenbank.UserID_exists(-1);
        });
    }
}
