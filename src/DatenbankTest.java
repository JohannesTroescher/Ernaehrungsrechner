import java.io.IOException;

public class DatenbankTest {

    public static void main(String[] args) throws Exception {
        UserDaten Nutzer1 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer2 = new UserDaten("Rolf",55,180.1,"männlich","Muskelaufbau","normal",75.2);
        UserDaten Nutzer3 = new UserDaten("Ro324lf",15,280.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer4 = new UserDaten("Rolfwwer",75,480.1,"männlich","Muskelaufbau","normal",65.2);
        UserDaten Nutzer5 = new UserDaten("Rowerlf",35,580.1,"männlich","Muskelaufbau","normal",85.2);
        UserDaten neueNutzer = new UserDaten("DeineMudda",100,480.1,"weiblich","Muskelaufbau","normal",185.2);
        Datenbank.Userdaten_einlesen(Nutzer3);
        Datenbank.Userdaten_einlesen(Nutzer4);
        Datenbank.Userdaten_einlesen(Nutzer5);
        Datenbank.Userdaten_einlesen(Nutzer2);
        Datenbank.Userdaten_einlesen(Nutzer1);
        Datenbank.saveUserliste(Datenbank.UserListe);
        Datenbank.loadUserListe();

        Datenbank.UserID_exists(1);
        //Datenbank.Userdaten_aendern(1, neueNutzer);
        System.out.println(Datenbank.UserListe);
        //System.out.println(Datenbank.Rezepte_dateiaufruf_normal());
        //Datenbank.Rezepte_dateiaufruf_normal();
        //System.out.println(Datenbank.RezepteNormalListe.get(0));

    }

}
