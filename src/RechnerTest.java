import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RechnerTest {

    @Test
    @Order(1)
    void Kalorienverbrauch_positiv() throws Exception{
        Rechner test = new Rechner();
        test.setKalorienverbrauch(1000);
        assertEquals(test.getKalorienverbrauch(),1000);
    }

   @Test
   @Order(2)
    void Kalorienverbrauch_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rechner test = new Rechner();
            test.setKalorienverbrauch(-10);
        });
    }

    @Test
    @Order(3)
    void Kalorienbedarf_positiv() throws Exception{
        Rechner test = new Rechner();
        test.setKalorienbedarf(500);
        assertEquals(test.getKalorienbedarf(),500);
    }

    @Test
    @Order(4)
    void Kalorienbedarf_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rechner test = new Rechner();
            test.setKalorienbedarf(-10);
        });
    }
    @Test
    @Order(5)
    void Konstruktor_positiv() throws Exception{
        Rechner test = new Rechner();
        Rechner test2= new Rechner(200,400,"test");
        assertEquals(test.getKalorienbedarf(),0);
        assertEquals(test.getKalorienverbrauch(),0);
        assertEquals(test2.getKalorienbedarf(),200);
        assertEquals(test2.getKalorienverbrauch(),400);
    }

    @Test
    @Order(6)
    void Konstruktor_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rechner test3 = new Rechner(-2,-500,"test");
        });
    }

    @Test
    @Order(7)
    void rechneroperation_positiv() throws Exception {
        UserDaten testuser=new UserDaten();
        testuser.setGrundbedarf(500);
        //ArrayList<UserDaten> UserListe = new ArrayList<UserDaten>();
        Datenbank.Userdaten_einlesen(testuser);
        Rechner testRechner=new Rechner();
        testRechner.setKalorienverbrauch(200);
        assertEquals(testRechner.Rechneroperation(testuser.getUserID()),700);
    }
    @Test
    @Order(8)
    void rechneroperation_negativ() throws Exception {
        UserDaten testuser1=new UserDaten();
        testuser1.setGrundbedarf(500);
        ArrayList<UserDaten> UserListe = new ArrayList<UserDaten>();
        Datenbank.UserListe.add(testuser1);
        Rechner testRechner=new Rechner();
        testRechner.setKalorienverbrauch(200);
        assertNotEquals(testRechner.Rechneroperation(testuser1.getUserID()),500);
    }

    @Test
    @Order(9)
    void rezept_sortieren_positiv() throws Exception {
        Datenbank.Rezepte_dateiaufruf_normal();
        Datenbank.Rezepte_dateiaufruf_vegetarisch();
        Datenbank.Rezepte_dateiaufruf_vegan();
        UserDaten testU1 = new UserDaten("Manfred Müller",45,185,"männlich","Muskelaufbau","normal",85);
        UserDaten testU2= new UserDaten("Sybille Fred",45,185,"weiblich","Muskelaufbau","vegetarisch",85);
        UserDaten testU3 = new UserDaten("Manfred Te",45,185,"männlich","Muskelaufbau","vegan",85);
        UserDaten testU4 = new UserDaten("Manfred Müller",45,185,"männlich","Muskelaufbau","Normal",85);
        UserDaten testU5= new UserDaten("Sybille Fred",45,185,"weiblich","Muskelaufbau","Vegetarisch",85);
        UserDaten testU6 = new UserDaten("Manfred Te",45,185,"männlich","Muskelaufbau","Vegan",85);
        Datenbank.Userdaten_einlesen(testU1);
        Datenbank.Userdaten_einlesen(testU2);
        Datenbank.Userdaten_einlesen(testU3);
        Datenbank.Userdaten_einlesen(testU4);
        Datenbank.Userdaten_einlesen(testU5);
        Datenbank.Userdaten_einlesen(testU6);
        Rechner test= new Rechner(800,800,"test");
        assertEquals(test.Rezeptsortierung(Datenbank.UserListe.get(testU1.getUserID()).getUserID()),"[:Normal: proteinhaltig Kalorien: 1500.0 Rezeptbeschreibung:  Kuchen, :Normal: proteinarm Kalorien: 500.0 Rezeptbeschreibung:  Brot, :Normal: proteinhaltig Kalorien: 1000.0 Rezeptbeschreibung:  Salamander]");
        assertEquals(test.Rezeptsortierung(Datenbank.UserListe.get(testU2.getUserID()).getUserID()),"[:Vegetarisch: proteinhaltig Kalorien: 1500.0 Rezeptbeschreibung:  Kuchen, :Vegetarisch: proteinarm Kalorien: 1000.0 Rezeptbeschreibung:  Brot, :Vegetarisch: proteinhaltig Kalorien: 500.0 Rezeptbeschreibung:  Gras]");
        assertEquals(test.Rezeptsortierung(Datenbank.UserListe.get(testU3.getUserID()).getUserID()),"[:Vegan: proteinhaltig Kalorien: 500.0 Rezeptbeschreibung:  Kuchen, :Vegan: proteinarm Kalorien: 1000.0 Rezeptbeschreibung:  Brot, :Vegan: proteinhaltig Kalorien: 1500.0 Rezeptbeschreibung:  Erde]");
        assertEquals(test.Rezeptsortierung(Datenbank.UserListe.get(testU4.getUserID()).getUserID()),"[:Normal: proteinhaltig Kalorien: 1500.0 Rezeptbeschreibung:  Kuchen, :Normal: proteinarm Kalorien: 500.0 Rezeptbeschreibung:  Brot, :Normal: proteinhaltig Kalorien: 1000.0 Rezeptbeschreibung:  Salamander]");
        assertEquals(test.Rezeptsortierung(Datenbank.UserListe.get(testU5.getUserID()).getUserID()),"[:Vegetarisch: proteinhaltig Kalorien: 1500.0 Rezeptbeschreibung:  Kuchen, :Vegetarisch: proteinarm Kalorien: 1000.0 Rezeptbeschreibung:  Brot, :Vegetarisch: proteinhaltig Kalorien: 500.0 Rezeptbeschreibung:  Gras]");
        assertEquals(test.Rezeptsortierung(Datenbank.UserListe.get(testU6.getUserID()).getUserID()),"[:Vegan: proteinhaltig Kalorien: 500.0 Rezeptbeschreibung:  Kuchen, :Vegan: proteinarm Kalorien: 1000.0 Rezeptbeschreibung:  Brot, :Vegan: proteinhaltig Kalorien: 1500.0 Rezeptbeschreibung:  Erde]");
    }
}
