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
        Rechner test2= new Rechner(200,400);
        assertEquals(test.getKalorienbedarf(),0);
        assertEquals(test.getKalorienverbrauch(),0);
        assertEquals(test2.getKalorienbedarf(),200);
        assertEquals(test2.getKalorienverbrauch(),400);
    }

    @Test
    @Order(6)
    void Konstruktor_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rechner test3 = new Rechner(-2,-500);
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

    //@Test
    //@Order(9)
    //void rezept_sortieren() throws Exception {
     //   Rechner test= new Rechner(800,800);
      //  test.Rezeptsortierung();
       // test.RezeptsortierungVegetarisch();
        //test.RezeptsortierungVegan();
        //assertEquals(Datenbank.RezepteNormalListe.get(0).getKalorien(),540);
        //assertEquals(Datenbank.RezepteNormalListe.get(1).getKalorien(),485.1);
    //}

    @Test
    @Order(10)
    void RechnerProb_test()throws Exception{
        UserDaten test1=new UserDaten("Walter",50,180,"männlich","muskelaufbau","normal",80);
        UserDaten test2=new UserDaten("Marianne",50,180,"weiblich","abnehmen","vegetarisch",80);
        UserDaten test3=new UserDaten("Walter",50,180,"männlich","muskelaufbau","vegan",80);
        Datenbank.UserListe.add(test1);
        Datenbank.UserListe.add(test2);
        Datenbank.UserListe.add(test3);
        RechnerProb testR1=new RechnerProb();
        RechnerProb testR2=new RechnerProb();
        RechnerProb testR3=new RechnerProb();
        testR1.Rezeptsortierung(Datenbank.UserListe.get(test1.getUserID()).getUserID());
        testR2.Rezeptsortierung(Datenbank.UserListe.get(test2.getUserID()).getUserID());
        testR3.Rezeptsortierung(Datenbank.UserListe.get(test3.getUserID()).getUserID());
        assertEquals(testR1.RezepteAusgabe.get(0).getBeschreibung(),"Kuchen");
        assertEquals(testR2.RezepteAusgabe.get(0).getBeschreibung(),"Kuchen");
        assertEquals(testR3.RezepteAusgabe.get(0).getBeschreibung(),"Kuchen");
        }
    }
