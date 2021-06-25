import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RezepteTest {

    @Test
    @Order(1)
    void Art_positiv() throws Exception {
        Rezepte test = new Rezepte();
        test.setArt("vegetarisch");
        assertEquals(test.getArt(),"vegetarisch");
        test.setArt("normal");
        assertEquals(test.getArt(),"normal");
        test.setArt("vegan");
        assertEquals(test.getArt(),"vegan");
    }
    @Order(2)
    @Test
    void Art_negativ() throws Exception {
        assertThrows(Exception.class,()->{
            Rezepte test = new Rezepte();
            test.setArt("brot");
            test.setArt("vegn");
        });

    }
    @Order(3)
    @Test
    void Kalorien_positiv() throws Exception{
        Rezepte test = new Rezepte();
        test.setKalorien(10000);
        assertEquals(test.getKalorien(),10000);
        test.setKalorien(1);
        assertEquals(test.getKalorien(),1);
    }
    @Order(4)
    @Test
    void Kalorien_negativ() throws Exception{
        assertThrows(Exception.class,()->{
            Rezepte test = new Rezepte();
            test.setKalorien(-10);
            test.setKalorien(0.9);
        });
    }
    @Order(6)
    @Test
    void Proteine_positiv() throws Exception{
        Rezepte test1= new Rezepte();
        Rezepte test2= new Rezepte();
        test1.setProteine("proteinhaltig");
        test2.setProteine("proteinarm");
        assertEquals(test1.getProteine(),"proteinhaltig");
        assertEquals(test2.getProteine(),"proteinarm");
    }
    @Order(7)
    @Test
    void Proteine_negativ() throws Exception {
        Rezepte test3 = new Rezepte();
        assertThrows(Exception.class, () -> {
            test3.setProteine("proteinhatig");
            Rezepte test5 = new Rezepte();
            test5.setKalorien(-10);
            test5.setKalorien(-0);
            test5.setKalorien(0.1);
        });
    }
    @Order(8)
    @Test
    void Beschreibung() throws Exception {
        Rezepte test6 = new Rezepte();
        test6.setBeschreibung("test");
        assertEquals(test6.getBeschreibung(),"test");
    }
    @Order(9)
    @Test
    void Konstruktor_positiv() throws Exception {
        Rezepte test7 = new Rezepte("normal","proteinhaltig",500,"test");
        Rezepte test8= new Rezepte();
        assertEquals(test7.getArt(),"normal");
        assertEquals(test7.getProteine(),"proteinhaltig");
        assertEquals(test7.getKalorien(),500);
        assertEquals(test7.getBeschreibung(),"test");
        assertEquals(test8.getArt(),"null");
        assertEquals(test8.getProteine(),"null");
        assertEquals(test8.getKalorien(),0);
        assertEquals(test8.getBeschreibung(),"null");
    }

    @Test
    @Order(10)
    void Konstruktor_negativ() throws Exception {
        assertThrows(Exception.class, () -> {
            Rezepte test9 = new Rezepte("Brot","proteinhaltig",500,"test");
            Rezepte test10 = new Rezepte("normal","test",500,"test");
        });
    }

}