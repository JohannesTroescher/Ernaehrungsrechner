import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDatenTest {

    @Test
    void Name() {
        UserDaten test = new UserDaten();
        test.setName("Melanie Müller");
        assertEquals(test.getName(),"Melanie Müller");
    }

    @Test
    void Alter_positiv() throws Exception {
        UserDaten test = new UserDaten();
        test.setAlter(35);
        assertEquals(test.getAlter(),35);
    }

    @Test
    void Alter_negativ() throws Exception {
        assertThrows(Exception.class, () -> {
            UserDaten test = new UserDaten();
            test.setAlter(-35);
        });
    }

    @Test
    void Koerpergroesse_positiv() throws Exception{
        UserDaten test = new UserDaten();
        test.setKoerpergroesse(170);
        assertEquals(test.getKoerpergroesse(),170);
    }

    @Test
    void Koerpergroesse_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test = new UserDaten();
            test.setKoerpergroesse(-170);
        });
    }

    @Test
    void Geschlecht_positiv() throws Exception{
        UserDaten test = new UserDaten();
        test.setGeschlecht("MäNNliCH");
        assertEquals(test.getGeschlecht(),"MäNNliCH");
    }

    @Test
    void KGeschlecht_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test = new UserDaten();
            test.setGeschlecht("brot");
        });
    }

    @Test
    void Trainingsziel_positiv() throws Exception {
        UserDaten test = new UserDaten();
        test.setTrainingsziel("mUSKelAufbaU");
        assertEquals(test.getTrainingsziel(),"mUSKelAufbaU");
    }

    @Test
    void Trainingsziel_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test = new UserDaten();
            test.setTrainingsziel("brot");
        });
    }

    @Test
    void Gewicht_positiv() throws Exception{
        UserDaten test = new UserDaten();
        test.setGewicht(85);
        assertEquals(test.getGewicht(),85);
    }

    @Test
    void Gewicht_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test = new UserDaten();
            test.setGewicht(-100);
        });
    }


    @Test
    void Grundbedarf_positiv() throws Exception{
        UserDaten test = new UserDaten();
        test.setGrundbedarf(4000);
        assertEquals(test.getGrundbedarf(),4000);
    }

    @Test
    void Grundbedarf_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test = new UserDaten();
            test.setGrundbedarf(-4000);
        });
    }


    @Test
    void Nahrungspraeferenz_positiv() throws Exception{
        UserDaten test = new UserDaten();
        test.setNahrungspraeferenz("NorMAl");
        assertEquals(test.getNahrungspraeferenz(),"NorMAl");
    }

    @Test
    void Nahrungspraeferenz_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test = new UserDaten();
            test.setNahrungspraeferenz("brot");
        });
    }

    @Test
    void getUserID() {
        UserDaten test = new UserDaten();
        assertEquals(test.getUserID(),11);
    }
}