import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class DatenbankTest implements Serializable {

    public static void main(String[] args) throws Exception {

        UserDaten Nutzer1 = new UserDaten("Ulf",25,140.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer2 = new UserDaten("Rolf",55,180.1,"männlich","Muskelaufbau","normal",75.2);
        UserDaten Nutzer3 = new UserDaten("Udo",15,280.1,"männlich","Muskelaufbau","normal",45.2);
        UserDaten Nutzer4 = new UserDaten("Rollo",75,480.1,"männlich","Muskelaufbau","normal",65.2);
        UserDaten Nutzer5 = new UserDaten("Rowe",35,580.1,"männlich","Muskelaufbau","normal",85.2);
        UserDaten newUser = new UserDaten("DeineMudda",100,480.1,"weiblich","Muskelaufbau","normal",185.2);
        Datenbank.Userdaten_einlesen(Nutzer1);
        Datenbank.Userdaten_einlesen(Nutzer2);
        Datenbank.Userdaten_einlesen(Nutzer3);
        Datenbank.Userdaten_einlesen(Nutzer4);
        Datenbank.Userdaten_einlesen(Nutzer5);
        Datenbank.saveUserliste(Datenbank.UserListe);
        ArrayList<UserDaten>TempListe=Datenbank.loadUserListe();
        //ArrayList<UserDaten>TestListe = new ArrayList<>();
        //UserDaten neuernutzer=new UserDaten("Moritz", 34,187.2,"männlich","Muskelaufbau","normal", 67.5);
        //TestListe.add(neuernutzer);
        //System.out.println(TestListe.indexOf(neuernutzer));
        //System.out.println(Nutzer2.getUserID());
       //Datenbank.UserID_exists(1);
        int index = Datenbank.UserListe.indexOf(Nutzer1);
        System.out.println(TempListe.contains(Nutzer1));
        System.out.println(index);
        System.out.println(Datenbank.lookUpUser(Nutzer2));
        Datenbank.Userdaten_aendern("Rolf", newUser);
        System.out.println(TempListe);
        //System.out.println(Datenbank.Rezepte_dateiaufruf_normal());
        //Datenbank.Rezepte_dateiaufruf_normal();
        //System.out.println(Datenbank.RezepteNormalListe.get(0));

    }

}
