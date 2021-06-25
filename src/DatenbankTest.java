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
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        UserDaten User2 = new UserDaten("Hannelore Zweit",50,160.5,"weiblich","muskelaufbau","vegetarisch",50.5);
        Datenbank.Userdaten_einlesen(User1);
        Datenbank.Userdaten_einlesen(User2);
        assertEquals(Datenbank.UserListe.get(User1.getUserID()),User1);
        assertEquals(Datenbank.UserListe.get(User2.getUserID()),User2);
    }
    @Test
    @Order(2)
    void UserDaten_einlesen_negativ()throws Exception{
        UserDaten User3 = new UserDaten("Dietmar Dritt",25,190.5,"männlich","muskelaufbau","vegan",90.5);
        UserDaten User4 = new UserDaten("Willi Quadro",65,190.5,"männlich","abnehmen","normal",90.5);
        Datenbank.Userdaten_einlesen(User3);
        Datenbank.Userdaten_einlesen(User4);
        assertNotEquals(Datenbank.UserListe.get(1),User3);
        assertNotEquals(Datenbank.UserListe.get(0),User4);
        assertNotEquals(UserDaten.counter,-1);
    }
    @Test
    @Order(3)
    void UserDaten_aendern_positiv()throws Exception{
        UserDaten User5 = new UserDaten("Heinz Penta",70,180.5,"männlich","abnehmen","normal",80.5);
        UserDaten User6 = new UserDaten("Hannelore Hexa",50,160.5,"weiblich","muskelaufbau","vegetarisch",50.5);
        Datenbank.Userdaten_einlesen(User5);
        Datenbank.Userdaten_aendern(0,User6);
        assertEquals(Datenbank.UserListe.get(0),User6);
        assertEquals(UserDaten.counter,5);
    }
    @Test
    @Order(4)
    void UserDaten_aendern_negativ()throws Exception{
        UserDaten User7 = new UserDaten("Siegfried Septi",70,180.5,"männlich","abnehmen","normal",80.5);
        UserDaten User8 = new UserDaten("Olga Okta",50,160.5,"weiblich","muskelaufbau","vegetarisch",50.5);
        Datenbank.Userdaten_einlesen(User7);
        Datenbank.Userdaten_aendern(0,User7);
        assertNotEquals(Datenbank.UserListe.get(0),User8);
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
    @Test
    @Order(7)
    void Rezepte_Dateiaufruf_normal_positiv()throws Exception{
        Datenbank.Rezepte_dateiaufruf_normal();
        assertEquals(Datenbank.RezepteNormalListe.get(0).getKalorien(),1500.0);
        assertEquals(Datenbank.RezepteNormalListe.get(1).getProteine(),"proteinarm");
        assertEquals(Datenbank.RezepteNormalListe.get(2).getBeschreibung()," Salamander");

    }
    @Test
    @Order(8)
    void Rezepte_Dateiaufruf_normal_negativ()throws Exception{
        Datenbank.Rezepte_dateiaufruf_normal();
        assertNotEquals(Datenbank.RezepteNormalListe.get(0).getKalorien(),840.0);
        assertNotEquals(Datenbank.RezepteNormalListe.get(1).getProteine(),"protenarm");
        assertNotEquals(Datenbank.RezepteNormalListe.get(2).getBeschreibung()," Salamaner");

    }
    @Test
    @Order(9)
    void Rezepte_Dateiaufruf_vegeta_positiv()throws Exception{
        Datenbank.Rezepte_dateiaufruf_vegetarisch();
        assertEquals(Datenbank.RezepteVegetarischListe.get(0).getKalorien(),1500);
        assertEquals(Datenbank.RezepteVegetarischListe.get(1).getProteine(),"proteinarm");
        assertEquals(Datenbank.RezepteVegetarischListe.get(2).getBeschreibung()," Gras");

    }
    @Test
    @Order(10)
    void Rezepte_Dateiaufruf_vegeta_negativ()throws Exception{
        Datenbank.Rezepte_dateiaufruf_vegetarisch();
        assertNotEquals(Datenbank.RezepteVegetarischListe.get(0).getKalorien(),56);
        assertNotEquals(Datenbank.RezepteVegetarischListe.get(1).getProteine(),"protenarm");
        assertNotEquals(Datenbank.RezepteVegetarischListe.get(2).getBeschreibung()," Salamaner");

    }
    @Test
    @Order(11)
    void Rezepte_Dateiaufruf_vega_positiv()throws Exception{
        Datenbank.Rezepte_dateiaufruf_vegan();
        assertEquals(Datenbank.RezepteVeganListe.get(0).getKalorien(),500);
        assertEquals(Datenbank.RezepteVeganListe.get(1).getProteine(),"proteinarm");
        assertEquals(Datenbank.RezepteVeganListe.get(2).getBeschreibung()," Erde");

    }
    @Test
    @Order(12)
    void Rezepte_Dateiaufruf_vega_negativ()throws Exception{
        Datenbank.Rezepte_dateiaufruf_vegan();
        assertNotEquals(Datenbank.RezepteVeganListe.get(0).getKalorien(),56);
        assertNotEquals(Datenbank.RezepteVeganListe.get(1).getProteine(),"protenarm");
        assertNotEquals(Datenbank.RezepteVeganListe.get(2).getBeschreibung()," Salamaner");

    }
    @Test
    @Order(13)
    void UserListespeicheroperationen_positiv()throws Exception{
        UserDaten User9 = new UserDaten("Wiedla Wadl",70,180.5,"männlich","abnehmen","normal",80.5);
        UserDaten User10 = new UserDaten("Waldo Kein",50,160.5,"männlich","muskelaufbau","vegetarisch",50.5);
        Datenbank.Userdaten_einlesen(User9);
        Datenbank.Userdaten_einlesen(User10);
        Datenbank.saveUserListe(Datenbank.UserListe);
        Datenbank.loadUserListe();
        assertEquals(Datenbank.UserListe.get(User9.getUserID()).getName(),User9.getName());
        assertEquals(Datenbank.UserListe.get(User9.getUserID()).getUserID(),User9.getUserID());

    }
    @Test
    @Order(14)
    void UserListespeicheroperationen_negativ()throws Exception{
        UserDaten User11 = new UserDaten("Quaternion",70,180.5,"männlich","abnehmen","normal",80.5);
        UserDaten User12 = new UserDaten("Unendlickeit",50,160.5,"männlich","muskelaufbau","vegetarisch",50.5);
        Datenbank.Userdaten_einlesen(User11);
        Datenbank.Userdaten_einlesen(User12);
        Datenbank.saveUserListe(Datenbank.UserListe);
        Datenbank.loadUserListe();
        assertNotEquals(Datenbank.UserListe.get(User11.getUserID()).getName(),"Wolfgang");
        assertNotEquals(Datenbank.UserListe.get(User12.getUserID()).getUserID(),1);

    }
}
