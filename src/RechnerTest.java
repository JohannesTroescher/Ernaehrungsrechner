import org.junit.jupiter.api.Test;

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
    void rechneroperation() {
    }

    @Test
    void rezept_sortieren() {
    }

    @Test
    void grundbedarf() {
    }
}