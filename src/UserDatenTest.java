import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDatenTest {

    @Test
    void Name() {
        UserDaten test0 = new UserDaten();
        test0.setName("Melanie Müller");
        assertEquals(test0.getName(),"Melanie Müller");
    }

    @Test
    void Alter_positiv() throws Exception {
        UserDaten test1 = new UserDaten();
        test1.setAlter(35);
        assertEquals(test1.getAlter(),35);
    }

    @Test
    void Alter_negativ() throws Exception {
        assertThrows(Exception.class, () -> {
            UserDaten test2 = new UserDaten();
            test2.setAlter(-35);
        });
    }

    @Test
    void Koerpergroesse_positiv() throws Exception{
        UserDaten test3 = new UserDaten();
        test3.setKoerpergroesse(170);
        assertEquals(test3.getKoerpergroesse(),170);
    }

    @Test
    void Koerpergroesse_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test4 = new UserDaten();
            test4.setKoerpergroesse(-170);
        });
    }

    @Test
    void Geschlecht_positiv() throws Exception{
        UserDaten test5 = new UserDaten();
        test5.setGeschlecht("MäNNliCH");
        assertEquals(test5.getGeschlecht(),"MäNNliCH");
    }

    @Test
    void KGeschlecht_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test6 = new UserDaten();
            test6.setGeschlecht("brot");
        });
    }

    @Test
    void Trainingsziel_positiv() throws Exception {
        UserDaten test7 = new UserDaten();
        test7.setTrainingsziel("mUSKelAufbaU");
        assertEquals(test7.getTrainingsziel(),"mUSKelAufbaU");
    }

    @Test
    void Trainingsziel_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test8 = new UserDaten();
            test8.setTrainingsziel("brot");
        });
    }

    @Test
    void Gewicht_positiv() throws Exception{
        UserDaten test9 = new UserDaten();
        test9.setGewicht(85);
        assertEquals(test9.getGewicht(),85);
    }

    @Test
    void Gewicht_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test10 = new UserDaten();
            test10.setGewicht(-100);
        });
    }


    @Test
    void Grundbedarf_positiv() throws Exception{
        UserDaten test11 = new UserDaten();
        test11.setGrundbedarf(4000);
        assertEquals(test11.getGrundbedarf(),4000);
    }

    @Test
    void Grundbedarf_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test12 = new UserDaten();
            test12.setGrundbedarf(-4000);
        });
    }


    @Test
    void Nahrungspraeferenz_positiv() throws Exception{
        UserDaten test13 = new UserDaten();
        test13.setNahrungspraeferenz("NorMAl");
        assertEquals(test13.getNahrungspraeferenz(),"NorMAl");
    }

    @Test
    void Nahrungspraeferenz_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test14 = new UserDaten();
            test14.setNahrungspraeferenz("brot");
        });
    }

    @Test
    void getUserID() {
        UserDaten test15 = new UserDaten();
        assertEquals(test15.getUserID(),11);
    }
    @Test
    void setUserID_positiv() throws Exception{
        UserDaten test16 = new UserDaten();
        int i=UserDaten.counter;
        test16.setUserID(2);
        assertEquals(test16.getUserID(),2);
        assertEquals(UserDaten.counter,i-1);
    }
    @Test
    void setUserID_negativ() throws Exception{
        UserDaten test17 = new UserDaten();
        assertThrows(Exception.class,()->{test17.setUserID(-1);});
    }


    @Test
    void Gesamttest(){
        UserDaten test18 = new UserDaten("Manfred Müller",45,185,"männlich","Muskelaufbau","Normal",85);
        assertEquals(test18.getName(),"Manfred Müller");
        assertEquals(test18.getAlter(),45);
        assertEquals(test18.getKoerpergroesse(),185);
        assertEquals(test18.getGeschlecht(),"männlich");
        assertEquals(test18.getTrainingsziel(),"Muskelaufbau");
        assertEquals(test18.getNahrungspraeferenz(),"Normal");
        assertEquals(test18.getGewicht(),85);
        assertEquals(test18.getUserID(),2);
    }

}