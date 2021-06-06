import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RezepteTest {

    @Test
    void Art_positiv() throws Exception {
        Rezepte test = new Rezepte();
        test.setArt("vegetarisch");
        assertEquals(test.getArt(),"vegetarisch");
    }

    @Test
    void Art_negativ() throws Exception {
        assertThrows(Exception.class,()->{
            Rezepte test = new Rezepte();
            test.setArt("brot");
        });

    }

    @Test
    void Kalorien() {
    }
}