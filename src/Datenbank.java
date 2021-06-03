import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;

public class Datenbank {

    ArrayList<UserDaten> UserListe = new ArrayList<UserDaten>();

    public void Userdaten_einlesen(UserDaten User){
        UserListe.add(User);
    }

    public void Userdaten_aendern(long UserID, UserDaten newUser) throws Exception  {
        if(UserListe.contains(UserID))  {
            int index = UserListe.indexOf(UserID);
                UserListe.set(index, newUser);
        }
        else throw new Exception("User existiert nicht.");
    }

    public boolean UserID_exists(long UserID) {
        if(UserListe.contains(UserID)){
            return true;
        }
        else
            return false;
    }

    public externeDatei UserDaten_dateierstellung(){
        //erstellt externe UserDatenListe-Datei aus der ArrayList UserListe
        return externeUserDatei;
    }

    public externeDatei UserDaten_dateiaufruf(){
        //ruft in Speicher abgelegte Datei ab, und gibt die Datei an System zur weiteren Nutzung
        return externeUserDatei;
    }

    public UserDaten_auslesen(irgendeineExterne externeUserDatei){
        //methode soll externe UserDatenListe-Datei auslesen (wandelt externeUserDatei in UserListe um)
        UserListe=UserListeausDatei;
    }


    public externeDatei Rezepte_dateiaufruf_normal(){
        //ruft in Speicher abgelegte normaleRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung
        return normaleRezepteDatei;
    }

    public externeDatei Rezepte_dateiaufruf_vegetarisch(){
        //ruft in Speicher abgelegte vegetarischeRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung
        return vegetarischeRezepteDatei;
    }

    public externeDatei Rezepte_dateiaufruf_vegan(){
        //ruft in Speicher abgelegte veganeRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung
        return veganeRezepteDatei;
    }
}
