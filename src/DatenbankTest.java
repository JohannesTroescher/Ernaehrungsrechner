import java.util.ArrayList;

public class DatenbankTest {

    public static void main(String[] args) {
        UserDaten Nutzer1 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        Datenbank.Userdaten_einlesen(Nutzer1);
        Datenbank.save(Datenbank.UserListe);

        System.out.println(Datenbank.UserListe);

    }

}
