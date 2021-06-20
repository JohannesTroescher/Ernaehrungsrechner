import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RechnerTest {

    @Test
    void Kalorienverbrauch_positiv() throws Exception{
        Rechner test = new Rechner();
        test.setKalorienverbrauch(1000);
        assertEquals(test.getKalorienverbrauch(),1000);
    }

    @Test
    void Kalorienverbrauch_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rechner test = new Rechner();
            test.setKalorienverbrauch(-10);
        });
    }

    @Test
    void Kalorienbedarf_positiv() throws Exception{
        Rechner test = new Rechner();
        test.setKalorienbedarf(500);
        assertEquals(test.getKalorienbedarf(),500);
    }

    @Test
    void Kalorienbedarf_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rechner test = new Rechner();
            test.setKalorienbedarf(-10);
        });
    }


    @Test
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
    void rechneroperation_negativ() throws Exception {
        UserDaten testuser1=new UserDaten();
        testuser1.setGrundbedarf(500);
        ArrayList<UserDaten> UserListe = new ArrayList<UserDaten>();
        Datenbank.UserListe.add(testuser1);
        Rechner testRechner=new Rechner();
        testRechner.setKalorienverbrauch(200);
        assertNotEquals(testRechner.Rechneroperation(testuser1.getUserID()),500);
    }

    //@Test
    //void rezept_sortieren() {
     //   Rechner test= new Rechner(800,800);
      //  assertEquals(test.Rezeptsortierung(),Datenbank.RezepteNormalListe.get(0));
       // assertEquals(test.RezeptsortierungVegetarisch(),Datenbank.RezepteVegetarischListe.get(0));
        //assertEquals(test.RezeptsortierungVegan(),Datenbank.RezepteVeganListe.get(0));
    //}

    @Test
    void grundbedarf() {
    }
}