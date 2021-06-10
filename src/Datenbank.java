import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;

public class Datenbank {

    /**
     * ArrayList "UserListe" wird erstellt um sie später mit UserDaten zu füllen
     */
    static ArrayList<UserDaten> UserListe = new ArrayList<UserDaten>();


    /**
     * fügt ein Objekt vom Typ UserDaten der "UserListe" hinzu
     * @param User  Objekt vom Typ UserDaten
     */
    public static void Userdaten_einlesen(UserDaten User){
        UserListe.add(User);
    }


    /**
     * durchsucht die "UserListe" nach einer "UserID", wenn die "UserID" gefunden wurde sollen die Werte der Attribute
     * des entsprechenden Objekts geändert werden
     * @param UserID    durchlaufende einzigartige Nummer um ein Objekt vom Typ "UserDaten" eindeutig zu identifizieren
     * @param newUser   geänderte User-Daten eines Users
     * @throws Exception    wirft Exception wenn "UserListe" die gesuchte "UserID" nicht enthält
     */
    public void Userdaten_aendern(long UserID, UserDaten newUser) throws Exception  {
        if(UserListe.contains(UserID))  {
            int index = UserListe.indexOf(UserID);
                UserListe.set(index, newUser);
        }
        else throw new Exception("User existiert nicht.");
    }


    /**
     * soll die "UserListe" nach einer "UserID" durchsuchen und returnen ob die "UserID" vorhanden ist oder nicht
     * @param UserID    durchlaufende einzigartige Nummer um ein Objekt vom Typ "UserDaten" eindeutig zu identifizieren
     * @return  returnt true wenn die "UserID" in der "UserListe" vorhanden ist, false wenn nicht
     */
    public boolean UserID_exists(long UserID) {
        if(UserListe.contains(UserID)){
            return true;
        }
        else
            return false;
    }


    /**
     * soll aus der "UserListe" eine externe Datei machen (z.B ein .txt File, --> einfach editierbar und testbar)
     * Objekte würden dann Zeilenweise in das File geschrieben werden
     * @return returnt eine externe, abspeicherbare Datei
     */
    //public externeDatei UserDaten_dateierstellung(){
        //erstellt externe UserDatenListe-Datei aus der ArrayList UserListe

        public static void save(ArrayList<UserDaten> UserListe) {
            try {
                FileOutputStream fos = new FileOutputStream(
                        "src/Datenbank txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(UserListe);
                oos.close();
                fos.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

      //  return externeUserDatei;
   // }


    /**
     * soll das abgespeicherte (.txt) File in das Programm laden
     * @return returnt das abgespeicherte File
     */
   // public externeDatei UserDaten_dateiaufruf(){
        //ruft in Speicher abgelegte Datei ab, und gibt die Datei an System zur weiteren Nutzung

        public static ArrayList<UserDaten> load() {
            ArrayList<UserDaten> UserListe = new ArrayList<UserDaten>();
            try {
                FileInputStream fis = new FileInputStream(
                        "src/Datenbank txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                UserListe = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
            return UserListe;
        }

     //   return externeUserDatei;
   // }


    /**
     * soll die aufgerufene File wieder in eine "ArrayList" (z.B. wieder die UserListe) umwandeln
     * @param externeUserDatei  das aufgerufenen File
     */
   // public void UserDaten_auslesen(irgendeineExterne externeUserDatei){
        //methode soll externe UserDatenListe-Datei auslesen (wandelt externeUserDatei in UserListe um)
   //     UserListe=UserListeausDatei;
   // }


    /**
     * soll abgespeicherte normaleRezept-Datei aufrufen und in Programm laden
     * @return  returnt normaleRezepteDatei
     */
  /**  public externeDatei Rezepte_dateiaufruf_normal(){
        //ruft in Speicher abgelegte normaleRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung
        return normaleRezepteDatei;
    }


    /**
     * soll abgespeicherte vegetarischeRezept-Datei aufrufen und in Programm laden
     * @return  returnt vegetarischeRezeptDatei
     */
    //public externeDatei Rezepte_dateiaufruf_vegetarisch(){
        //ruft in Speicher abgelegte vegetarischeRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung
      //  return vegetarischeRezepteDatei;
    }


    /**
     * soll abgespeicherte veganeRezept-Datei aufrufen und in Programm laden
     * @return  returnt veganeRezepteDatei
     */
    //public externeDatei Rezepte_dateiaufruf_vegan(){
        //ruft in Speicher abgelegte veganeRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung
    //    return veganeRezepteDatei;
    //}
//}
