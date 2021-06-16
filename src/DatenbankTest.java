import java.io.IOException;

public class DatenbankTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserDaten Nutzer1 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer2 = new UserDaten("Rolf",55,180.1,"männlich","Muskelaufbau","normal",75.2);
        Datenbank.Userdaten_einlesen(Nutzer1);
        Datenbank.Userdaten_einlesen(Nutzer2);
        Datenbank.saveUserliste(Datenbank.UserListe);
        Datenbank.loadUserListe();

        System.out.println(Datenbank.UserListe);
        //System.out.println(Datenbank.Rezepte_dateiaufruf_normal());
        //Datenbank.Rezepte_dateiaufruf_normal();
        //System.out.println(Datenbank.RezepteNormalListe.get(0));

    }

}
