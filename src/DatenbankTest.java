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
        UserDaten Nutzera = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzerb = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        Datenbank.Userdaten_einlesen(Nutzera);
        Datenbank.Userdaten_einlesen(Nutzerb);
        Datenbank.saveUserListe(Datenbank.UserListe);
        Datenbank.loadUserListe();
        assertEquals(Datenbank.UserListe.get(Nutzera.getUserID()).getName(),Nutzera.getName());
        assertEquals(Datenbank.UserListe.get(Nutzera.getUserID()).getUserID(),0);

    }
    @Test
    @Order(14)
    void UserListespeicheroperationen_negativ()throws Exception{
        UserDaten Nutzerc = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzerd = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        Datenbank.Userdaten_einlesen(Nutzerc);
        Datenbank.Userdaten_einlesen(Nutzerd);
        Datenbank.saveUserListe(Datenbank.UserListe);
        Datenbank.loadUserListe();
        assertNotEquals(Datenbank.UserListe.get(Nutzerc.getUserID()).getName(),"Wolfgang");
        assertNotEquals(Datenbank.UserListe.get(Nutzerd.getUserID()).getUserID(),1);

    }
}
