import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RechnerTest {

    @Test
    void Kalorienverbrauch() {
        Rechner test = new Rechner();
        test.setKalorienverbrauch(1000);
        assertEquals(test.getKalorienverbrauch(),1000);
    }


    @Test
    void Kalorienbedarf() {
        Rechner test = new Rechner();
        test.setKalorienbedarf(500);
        assertEquals(test.getKalorienbedarf(),500);
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