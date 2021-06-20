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

   // @Test
   //@Order(2)
    //void Kalorienverbrauch_negativ() throws Exception{
     //   assertThrows(Exception.class,()->{
       //     Rechner test = new Rechner();
         //   test.setKalorienverbrauch(-10);
        //});
    //}

    @Test
    @Order(3)
    void Kalorienbedarf_positiv() throws Exception{
        Rechner test = new Rechner();
        test.setKalorienbedarf(500);
        assertEquals(test.getKalorienbedarf(),500);
    }

    //@Test
    //@Order(4)
    //void Kalorienbedarf_negativ() throws Exception{
     //   assertThrows(Exception.class,()->{
       //     Rechner test = new Rechner();
         //   test.setKalorienbedarf(-10);
        //});
    //}


    @Test
    @Order(5)
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
    @Order(6)
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
    @Order(7)
    void rezept_sortieren() throws Exception {
        Rechner test= new Rechner(800,800);
        test.Rezeptsortierung();
        test.RezeptsortierungVegetarisch();
        test.RezeptsortierungVegan();
        assertEquals(Datenbank.RezepteNormalListe.get(0).getKalorien(),540);
        assertEquals(Datenbank.RezepteNormalListe.get(1).getKalorien(),485.1);
    //}

    //@Test
    //@Order(8)
    //void grundbedarf() {
    }
}