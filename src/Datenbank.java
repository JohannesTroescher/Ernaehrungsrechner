import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;

public class Datenbank {

    ArrayList<UserDaten> UserListe = new ArrayList<UserDaten>();

    public void Userdaten_einlesen(long UserID){

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
        //erstellt externe UserDatenListe Datei
        return externeDatei;
    }

    public externeDatei UserDaten_dateiaufruf(){
        //ruft in Speicher abgelegte Datei ab, und gibt die Datei an System zur weiteren Nutzung
        return irgendeineExterne;
    }

    public externeDatei UserDaten_auslesen(irgendeineExterne Datei){
        //methode soll externe UserDatenListe Datei auslesen
        return externeDatei;
    }


    public externeDatei Rezepte_dateiaufruf_normal(){
        //ruft in Speicher abgelegte normaleRezepteDatei auf, und gibt die Datei an System zur weiteren Nutzung
        return normaleRezepteDatei;
    }

    public externeDatei Rezepte_dateiaufruf_vegetarisch(){
        //ruft in Speicher abgelegte vegetarischeRezepteDatei auf, und gibt die Datei an System zur weiteren Nutzung
        return vegetarischeRezepteDatei;
    }

    public externeDatei Rezepte_dateiaufruf_vegan(){
        //ruft in Speicher abgelegte veganeRezepteDatei auf, und gibt die Datei an System zur weiteren Nutzung
        return veganeRezepteDatei;
    }
}
