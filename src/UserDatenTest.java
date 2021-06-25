import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDatenTest {

    @Test
    @Order(1)
    void Name() throws Exception {
        UserDaten User1P = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        User1P.setName("Melanie Müller");
        assertEquals(User1P.getName(),"Melanie Müller");
    }

    @Test
    @Order(2)
    void Alter_positiv() throws Exception {
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        User1.setAlter(35);
        assertEquals(User1.getAlter(),35);
        User1.setAlter(1);
        assertEquals(User1.getAlter(),1);
    }

    @Test
    @Order(3)
    void Alter_negativ() throws Exception {
        assertThrows(Exception.class, () -> {
            UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
            User1.setAlter(-1);
        });
    }

    @Test
    @Order(4)
    void Koerpergroesse_positiv() throws Exception{
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        User1.setKoerpergroesse(170);
        assertEquals(User1.getKoerpergroesse(),170);
        User1.setKoerpergroesse(0.1);
        assertEquals(User1.getKoerpergroesse(),0.1);
    }

    @Test
    @Order(5)
    void Koerpergroesse_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
            User1.setKoerpergroesse(-170);
            User1.setKoerpergroesse(-0.1);
        });
    }

    @Test
    @Order(6)
    void Geschlecht_positiv() throws Exception{
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        User1.setGeschlecht("MäNNliCH");
        assertEquals(User1.getGeschlecht(),"MäNNliCH");
        User1.setGeschlecht("WeiBLich");
        assertEquals(User1.getGeschlecht(),"WeiBLich");
    }

    @Test
    @Order(7)
    void KGeschlecht_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
            User1.setGeschlecht("brot");
            User1.setGeschlecht("Frau");
        });
    }

    @Test
    @Order(8)
    void Trainingsziel_positiv() throws Exception {
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        User1.setTrainingsziel("mUSKelAufbaU");
        assertEquals(User1.getTrainingsziel(),"mUSKelAufbaU");
        User1.setTrainingsziel("aBnEhmen");
        assertEquals(User1.getTrainingsziel(),"aBnEhmen");
    }

    @Test
    @Order(9)
    void Trainingsziel_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
            User1.setTrainingsziel("brot");
            User1.setTrainingsziel("wegnehmen");
        });
    }

    @Test
    @Order(10)
    void Gewicht_positiv() throws Exception{
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        User1.setGewicht(85);
        assertEquals(User1.getGewicht(),85);
        User1.setGewicht(0.1);
        assertEquals(User1.getGewicht(),0.1);
    }

    @Test
    @Order(11)
    void Gewicht_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
            User1.setGewicht(-100);
            User1.setGewicht(-0.1);
        });
    }


    @Test
    @Order(12)
    void Grundbedarf_positiv() throws Exception{
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        User1.setGrundbedarf(4000.5);
        assertEquals(User1.getGrundbedarf(),4000.5);
        User1.setGrundbedarf(0.1);
        assertEquals(User1.getGrundbedarf(),0.1);
    }

    @Test
    @Order(13)
    void Grundbedarf_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
            User1.setGrundbedarf(-4000);
            User1.setGrundbedarf(-0.1);
        });
    }


    @Test
    @Order(14)
    void Nahrungspraeferenz_positiv() throws Exception{
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        User1.setNahrungspraeferenz("NorMAl");
        assertEquals(User1.getNahrungspraeferenz(),"NorMAl");
        User1.setNahrungspraeferenz("VEgan");
        assertEquals(User1.getNahrungspraeferenz(),"VEgan");
        User1.setNahrungspraeferenz("VEGEtarisch");
        assertEquals(User1.getNahrungspraeferenz(),"VEGEtarisch");
    }

    @Test
    @Order(15)
    void Nahrungspraeferenz_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
            User1.setNahrungspraeferenz("brot");
            User1.setNahrungspraeferenz("Norml");
            User1.setNahrungspraeferenz("Vegähn");
            User1.setNahrungspraeferenz("Wegetarisch");
        });
    }

    @Test
    @Order(16)
    void getUserID() throws Exception {
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        UserDaten User2 = new UserDaten("Hannelore Zweit",50,160.5,"weiblich","muskelaufbau","vegetarisch",50.5);
        UserDaten User3 = new UserDaten("Dietmar Dritt",25,190.5,"männlich","muskelaufbau","vegan",90.5);
        assertEquals(User1.getUserID(),15);
        assertEquals(User2.getUserID(),16);
        assertEquals(User3.getUserID(),17);
    }
    @Test
    @Order(17)
    void setUserID_positiv() throws Exception{
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        UserDaten User2 = new UserDaten("Hannelore Zweit",50,160.5,"weiblich","muskelaufbau","vegetarisch",50.5);
        UserDaten User3 = new UserDaten("Dietmar Dritt",25,190.5,"männlich","muskelaufbau","vegan",90.5);
        int i=UserDaten.counter;
        User2.setUserID(2);
        assertEquals(User2.getUserID(),2);
        assertEquals(UserDaten.counter,i-1);
    }
    @Test
    @Order(18)
    void setUserID_negativ() throws Exception{
        UserDaten User1 = new UserDaten("Heinz Erst",70,180.5,"männlich","abnehmen","normal",80.5);
        assertThrows(Exception.class,()->{User1.setUserID(-1);});
    }


    @Test
    @Order(20)
    void Konstruktor_positiv()throws Exception{
        UserDaten User1 = new UserDaten("Heinz Erst",1,0.1,"männlich","abnehmen","normal",0.5);
        UserDaten User2 = new UserDaten("Hannelore Zweit",50,160.5,"weiblich","muskelaufbau","vegetarisch",50.5);
        UserDaten Userempty= new UserDaten();
        assertEquals(User1.getName(),"Heinz Erst");
        assertEquals(User1.getAlter(),1);
        assertEquals(User1.getKoerpergroesse(),0.1);
        assertEquals(User1.getGeschlecht(),"männlich");
        assertEquals(User1.getTrainingsziel(),"abnehmen");
        assertEquals(User1.getNahrungspraeferenz(),"normal");
        assertEquals(User1.getGewicht(),0.5);
        assertEquals(User1.getUserID(),21);
        assertEquals(User1.getGrundbedarf(),67);
        assertEquals(User2.getGrundbedarf(),1194);
        assertEquals(Userempty.getName(),"null");
        assertEquals(Userempty.getAlter(),0);
        assertEquals(Userempty.getKoerpergroesse(),0);
        assertEquals(Userempty.getGeschlecht(),"null");
        assertEquals(Userempty.getTrainingsziel(),"null");
        assertEquals(Userempty.getNahrungspraeferenz(),"null");
        assertEquals(Userempty.getGewicht(),0);
        assertEquals(Userempty.getUserID(),23);
    }
    @Test
    @Order(21)
    void Konstruktor_negativ() throws Exception{
        assertThrows(Exception.class, () -> {
            UserDaten test1 = new UserDaten("Manfred Müller",-1,0.1,"männlich","Muskelaufbau","Normal",0.1);
            UserDaten test2= new UserDaten("Manfred Müller",1,-0.1,"männlich","Muskelaufbau","Normal",0.1);
            UserDaten test3 = new UserDaten("Manfred Müller",1,0.1,"ännlich","Muskelaufbau","Normal",0.1);
            UserDaten test4= new UserDaten("Manfred Müller",1,0.1,"männlich","Mskelaufbau","Normal",0.1);
            UserDaten test5 = new UserDaten("Manfred Müller",1,0.1,"männlich","Muskelaufbau","Norml",0.1);
            UserDaten test6= new UserDaten("Manfred Müller",1,0.1,"männlich","Muskelaufbau","Normal",-0.1);

        });
    }
}