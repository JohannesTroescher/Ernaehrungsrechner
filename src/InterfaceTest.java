import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterfaceTest {
    @Test
    void Rezeptvorschläge_positiv() {
        Interface test = new Interface(800,"Test-Rezept");
        assertEquals(test.getRezeptvorschläge(),"Test-Rezept");
        test.setRezeptvorschläge("Rezept");
        assertEquals(test.getRezeptvorschläge(),"Rezept");
    }
    @Test
    void Rezeptvorschläge_negativ() {
        Interface test = new Interface(500,"Test-Rezept");
        assertNotEquals(test.getRezeptvorschläge(),"Rezept");
        test.setRezeptvorschläge("Rezept");
        assertEquals(test.getRezeptvorschläge(),"Test");
    }
    @Test
    void Kaloriensollwert_positiv(){
        Interface test = new Interface(800,"Test-Rezept");
        assertEquals(test.getKalorien_sollwert(),800);
        test.setKalorien_sollwert(500);
        assertEquals(test.getKalorien_sollwert(),500);
    }
    @Test
    void Kaloriensollwert_negativ(){
        Interface test = new Interface(500,"Test-Rezept");
        assertNotEquals(test.getKalorien_sollwert(),800);
        test.setKalorien_sollwert(800);
        assertEquals(test.getKalorien_sollwert(),900);
    }
    @Test
    void UserErstellen_positiv(){
        Interface test = new Interface(800,"Test-Rezept");
        UserDaten a=test.User_erstellen("Walter",30,180,"männlich","abnehmen","normal",60.6);
        assertEquals(a.getName(),"Walter");
        assertEquals(a.getAlter(),30);
        assertEquals(a.getKoerpergroesse(),180);
        assertEquals(a.getGeschlecht(),"mÄnnlich");
        assertEquals(a.getTrainingsziel(),"AbnEhmen");
        assertEquals(a.getNahrungspraeferenz(),"normAl");
        assertEquals(a.getGewicht(),60.6);
        assertEquals(a.getGrundbedarf(),1447.5);
    }
    @Test
    void UserErstellen_negativ(){
        Interface test2 = new Interface(800,"Test-Rezept");
        UserDaten b=test2.User_erstellen("Walter",30,180,"weiblich","abnehmen","normal",60.6);
        assertNotEquals(b.getName(),"Richter");
        assertNotEquals(b.getAlter(),45);
        assertNotEquals(b.getKoerpergroesse(),18);
        assertNotEquals(b.getGeschlecht(),"mÄnnlic");
        assertNotEquals(b.getTrainingsziel(),"Kör");
        assertNotEquals(b.getNahrungspraeferenz(),"brot");
        assertNotEquals(b.getGewicht(),60);
        assertNotEquals(b.getGrundbedarf(),1447.5);
        assertThrows(Exception.class, () ->{
            UserDaten a=test2.User_erstellen("Walter",-30,180,"weiblich","abnehmen","normal",60.6);
        });
    }
}
