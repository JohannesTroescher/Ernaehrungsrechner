import org.junit.Ignore;
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
        test.setKalorienverbrauch(0);
        assertEquals(test.getKalorienverbrauch(),0);
    }

   @Test
   @Order(2)
    void Kalorienverbrauch_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rechner test = new Rechner();
            test.setKalorienverbrauch(-10);
            test.setKalorienverbrauch(-0.1);
        });
    }
    @Ignore("Attribut existiert nicht mehr")
    @Test
    @Order(3)
    void Kalorienbedarf_positiv() throws Exception{
        //Rechner test = new Rechner();
        //test.setKalorienbedarf(500);
        //assertEquals(test.getKalorienbedarf(),500);
        //test.setKalorienbedarf(0.1);
        //assertEquals(test.getKalorienbedarf(),0.1);
    }
    @Ignore("Attribut existiert nicht mehr")
    @Test
    @Order(4)
    void Kalorienbedarf_negativ() throws Exception{
        //assertThrows(Exception.class,()->{
        //Rechner test = new Rechner();
        //test.setKalorienbedarf(-10);
        //test.setKalorienbedarf(0.9);
        //});
    }
    @Test
    @Order(5)
    void Konstruktor_positiv() throws Exception{
        Rechner test = new Rechner(0);
        Rechner test2= new Rechner(200);
        assertEquals(test.getKalorienverbrauch(),0);
        assertEquals(test2.getKalorienverbrauch(),200);
    }

    @Test
    @Order(6)
    void Konstruktor_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rechner test3 = new Rechner(-2);
            Rechner test4 = new Rechner(-0.1);
        });
    }

    @Test
    @Order(7)
    void rechneroperation_positiv() throws Exception {
        UserDaten testuser=new UserDaten();
        testuser.setGrundbedarf(500);
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
        assertThrows(Exception.class,()->{
            testRechner.Rechneroperation(99);
        });
    }

    @Test
    @Order(9)
    void rezept_sortieren_positiv() throws Exception {
        UserDaten testU1 = new UserDaten("Manfred Müller",45,185,"männlich","Muskelaufbau","normal",85);
        UserDaten testU2= new UserDaten("Sybille Fred",45,185,"weiblich","Muskelaufbau","vegetarisch",85);
        UserDaten testU3 = new UserDaten("Manfred Te",45,185,"männlich","Muskelaufbau","vegan",85);
        UserDaten testU4 = new UserDaten("Manfred Müller",45,185,"männlich","Abnehmen","Normal",85);
        UserDaten testU5= new UserDaten("Sybille Fred",45,185,"weiblich","Abnehmen","Vegetarisch",85);
        UserDaten testU6 = new UserDaten("Manfred Te",45,185,"männlich","Abnehmen","Vegan",85);
        Datenbank.Userdaten_einlesen(testU1);
        Datenbank.Userdaten_einlesen(testU2);
        Datenbank.Userdaten_einlesen(testU3);
        Datenbank.Userdaten_einlesen(testU4);
        Datenbank.Userdaten_einlesen(testU5);
        Datenbank.Userdaten_einlesen(testU6);
        Rechner test= new Rechner(800);
        test.Rezeptsortierung();
        test.RezeptsortierungVegetarisch();
        test.RezeptsortierungVegan();
        assertEquals(Rechner.RezepteNormalProteinhaltig.get(0).getBeschreibung()," Kuchen");
        assertEquals(Rechner.RezepteNormalProteinhaltig.get(1).getBeschreibung()," Salamander");
        assertEquals(Rechner.RezepteVegetarischProteinhaltig.get(0).getBeschreibung()," Sand-Kuchen");
        assertEquals(Rechner.RezepteVegetarischProteinhaltig.get(1).getBeschreibung()," Gras");
        assertEquals(Rechner.RezepteVeganProteinhaltig.get(0).getBeschreibung()," Tofu");
        assertEquals(Rechner.RezepteVeganProteinhaltig.get(1).getBeschreibung()," Erde");
        assertEquals(Rechner.RezepteNormalProteinarm.get(0).getBeschreibung()," Brot");
        assertEquals(Rechner.RezepteNormalProteinarm.get(1).getBeschreibung()," Salbei");
        assertEquals(Rechner.RezepteVegetarischProteinarm.get(0).getBeschreibung()," Brot");
        assertEquals(Rechner.RezepteVegetarischProteinarm.get(1).getBeschreibung()," Luft");
        assertEquals(Rechner.RezepteVeganProteinarm.get(0).getBeschreibung()," Brotteig");
        assertEquals(Rechner.RezepteVeganProteinarm.get(1).getBeschreibung()," Blätter");
    }
}
