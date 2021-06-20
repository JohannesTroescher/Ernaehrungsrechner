import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class InterfaceTest {
    @Test
    @Order(1)
    void Rezeptvorschläge_positiv() {
        Interface test = new Interface(800,"Test-Rezept");
        assertEquals(test.getRezeptvorschläge(),"Test-Rezept");
        test.setRezeptvorschläge("Rezept");
        assertEquals(test.getRezeptvorschläge(),"Rezept");
    }
    @Order(2)
    @Test
    void Rezeptvorschläge_negativ() {
        Interface test = new Interface(500,"Test-Rezept");
        assertNotEquals(test.getRezeptvorschläge(),"Rezept");
        test.setRezeptvorschläge("Rezept");
        assertNotEquals(test.getRezeptvorschläge(),"Test");
    }
    @Test
    @Order(3)
    void Kaloriensollwert_positiv(){
        Interface test = new Interface(800,"Test-Rezept");
        assertEquals(test.getKalorien_sollwert(),800);
        test.setKalorien_sollwert(500);
        assertEquals(test.getKalorien_sollwert(),500);
    }
    @Test
    @Order(4)
    void Kaloriensollwert_negativ(){
        Interface test = new Interface(500,"Test-Rezept");
        assertNotEquals(test.getKalorien_sollwert(),800);
        test.setKalorien_sollwert(800);
        assertNotEquals(test.getKalorien_sollwert(),900);
    }
    @Order(5)
    @Test
    void UserErstellen_positiv()throws Exception{
        Interface test = new Interface(800,"Test-Rezept");
        test.User_erstellen("Günther", 30, 180, "männlich", "abnehmen", "normal", 60.6);test.User_erstellen("Frieder",80,180,"männlich","abnehmen","normal",60.6);
        test.User_erstellen("Rüdiger",34,180,"männlich","abnehmen","normal",60.6);
        test.User_erstellen("Heinz",50,180,"männlich","abnehmen","normal",60.6);

        test.User_erstellen("Walter",30,180,"männlich","abnehmen","normal",60.6);
        test.User_erstellen("Waltraud",30,180,"weiblich","abnehmen","normal",60.6);
        assertEquals(Datenbank.UserListe.get(4).getName(),"Walter");
        assertEquals(Datenbank.UserListe.get(4).getAlter(),30);
        assertEquals(Datenbank.UserListe.get(4).getKoerpergroesse(),180);
        assertEquals(Datenbank.UserListe.get(4).getGeschlecht(),"männlich");
        assertEquals(Datenbank.UserListe.get(4).getTrainingsziel(),"abnehmen");
        assertEquals(Datenbank.UserListe.get(4).getNahrungspraeferenz(),"normal");
        assertEquals(Datenbank.UserListe.get(4).getGewicht(),60.6);
        assertEquals(Datenbank.UserListe.get(4).getGrundbedarf(),1593);
        assertEquals(Datenbank.UserListe.get(5).getGrundbedarf(),1420);
    }
    @Test
    @Order(6)
    void UserErstellen_negativ()throws Exception{
        Interface test2 = new Interface(800,"Test-Rezept");
        test2.User_erstellen("Walter",30,180,"weiblich","abnehmen","normal",60.6);
        test2.User_erstellen("Marianne",30,180,"weiblich","abnehmen","normal",60.6);
        assertNotEquals(Datenbank.UserListe.get(Datenbank.UserListe.get(0).getUserID()).getName(),"Richter");
        assertNotEquals(Datenbank.UserListe.get(0).getAlter(),45);
        assertNotEquals(Datenbank.UserListe.get(0).getKoerpergroesse(),18);
        assertNotEquals(Datenbank.UserListe.get(0).getGeschlecht(),"männlic");
        assertNotEquals(Datenbank.UserListe.get(0).getTrainingsziel(),"Kör");
        assertNotEquals(Datenbank.UserListe.get(0).getNahrungspraeferenz(),"brot");
        assertNotEquals(Datenbank.UserListe.get(0).getGewicht(),60);
        assertNotEquals(Datenbank.UserListe.get(0).getGrundbedarf(),1447.5);
        assertNotEquals(Datenbank.UserListe.get(0).getGrundbedarf(),1447.5);
        assertThrows(Exception.class, () -> {
            Interface test3= new Interface(500,"Test");
            test3.User_erstellen("Walter", -30, 180, "weiblich", "abnehmen", "normal", 60.6);
            });
    }
    @Test
    @Order(7)
    void User_aenderung_positiv() throws Exception {
        Interface test4= new Interface(4,"Bla");
        UserDaten Nutzerx = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzery = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        Datenbank.Userdaten_einlesen(Nutzerx);
        Datenbank.Userdaten_einlesen(Nutzery);
        test4.User_aenderung(Nutzerx.getUserID(),"Frieder",35,180,"männlich","muskelaufbau","normal",80);
        assertEquals(Datenbank.UserListe.get(Nutzerx.getUserID()).getName(),"Frieder");
        assertEquals(Datenbank.UserListe.get(Nutzerx.getUserID()).getAlter(),35);
        assertEquals(Datenbank.UserListe.get(Nutzerx.getUserID()).getKoerpergroesse(),180);
        assertEquals(Datenbank.UserListe.get(Nutzerx.getUserID()).getGeschlecht(),"männlich");
        assertEquals(Datenbank.UserListe.get(Nutzerx.getUserID()).getTrainingsziel(),"muskelaufbau");
        assertEquals(Datenbank.UserListe.get(Nutzerx.getUserID()).getNahrungspraeferenz(),"normal");
        assertEquals(Datenbank.UserListe.get(Nutzerx.getUserID()).getGewicht(),80);
    }
}
