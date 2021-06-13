import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Datenbank {

    /**
     * ArrayList "UserListe" wird erstellt um sie später mit UserDaten zu füllen
     */
    static ArrayList<UserDaten> UserListe = new ArrayList<UserDaten>();
    static ArrayList<Rezepte> RezepteNormalListe = new ArrayList<>();
    static ArrayList<Rezepte> RezepteVegetarischListe = new ArrayList<Rezepte>();
    static ArrayList<Rezepte> RezepteVeganListe = new ArrayList<Rezepte>();


    /**
     * fügt ein Objekt vom Typ UserDaten der "UserListe" hinzu
     *
     * @param User Objekt vom Typ UserDaten
     */
    public static void Userdaten_einlesen(UserDaten User) {

        UserListe.add(User);
    }


    /**
     * durchsucht die "UserListe" nach einer "UserID", wenn die "UserID" gefunden wurde sollen die Werte der Attribute
     * des entsprechenden Objekts geändert werden
     *
     * @param UserID  durchlaufende einzigartige Nummer um ein Objekt vom Typ "UserDaten" eindeutig zu identifizieren
     * @param newUser geänderte User-Daten eines Users
     * @throws Exception wirft Exception wenn "UserListe" die gesuchte "UserID" nicht enthält
     */
    public void Userdaten_aendern(long UserID, UserDaten newUser) throws Exception {
        if (UserListe.contains(UserID)) {
            int index = UserListe.indexOf(UserID);
            UserListe.set(index, newUser);
        } else throw new Exception("User existiert nicht.");
    }


    /**
     * soll die "UserListe" nach einer "UserID" durchsuchen und returnen ob die "UserID" vorhanden ist oder nicht
     *
     * @param UserID durchlaufende einzigartige Nummer um ein Objekt vom Typ "UserDaten" eindeutig zu identifizieren
     * @return returnt true wenn die "UserID" in der "UserListe" vorhanden ist, false wenn nicht
     */
    public boolean UserID_exists(long UserID) {
        if (UserListe.contains(UserID)) {
            return true;
        } else
            return false;
    }


    /**
     * soll aus der "UserListe" eine externe Datei machen (z.B ein .txt File, --> einfach editierbar und testbar)
     * Objekte würden dann Zeilenweise in das File geschrieben werden
     *
     * @return returnt eine externe, abspeicherbare Datei
     */
    //public externeDatei UserDaten_dateierstellung(){
    //erstellt externe UserDatenListe-Datei aus der ArrayList UserListe
    public static void saveUserliste(ArrayList<UserDaten> UserListe) {
        try {
            FileOutputStream fos = new FileOutputStream("src/Datenbank.txt");
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
     *
     * @return returnt das abgespeicherte File
     */
    // public externeDatei UserDaten_dateiaufruf(){
    //ruft in Speicher abgelegte Datei ab, und gibt die Datei an System zur weiteren Nutzung
    public static ArrayList<UserDaten> loadUserListe() {
        try {
            FileInputStream fis = new FileInputStream("src/Datenbank.txt");
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
     *
     *
     *                          !!!!!!!!!!!!! Wird nicht mehr benötigt
     *
     */
    // public void UserDaten_auslesen(irgendeineExterne externeUserDatei){
    //methode soll externe UserDatenListe-Datei auslesen (wandelt externeUserDatei in UserListe um)
    //     UserListe=UserListeausDatei;
    // }


    /**
     * soll abgespeicherte normaleRezept-Datei aufrufen und in Programm laden
     *
     * @return returnt normaleRezepteDatei
     */
    public static ArrayList<Rezepte> Rezepte_dateiaufruf_normal() {
        //ruft in Speicher abgelegte normaleRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung

        try {
            Scanner s = new Scanner(new File("src/RezepteNormal.txt"));
            while (s.hasNext()) {
                Rezepte normal = new Rezepte(s.next(), Double.parseDouble(s.next()));
                RezepteNormalListe.add(normal);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return RezepteNormalListe;
    }

    /**
     * soll abgespeicherte vegetarischeRezept-Datei aufrufen und in Programm laden
     *
     * @return returnt vegetarischeRezeptDatei
     */
    public static ArrayList<Rezepte> Rezepte_dateiaufruf_vegetarisch() {
        //ruft in Speicher abgelegte vegetarischeRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung
        try {
            Scanner s = new Scanner(new File("src/RezepteVegetarisch.txt"));
            while (s.hasNext()) {
                Rezepte vegetarisch = new Rezepte(s.next(), Double.parseDouble(s.next()));
                RezepteVegetarischListe.add(vegetarisch);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return RezepteVegetarischListe;
    }


    /**
     * soll abgespeicherte veganeRezept-Datei aufrufen und in Programm laden
     *
     * @return returnt veganeRezepteDatei
     */
    public static ArrayList<Rezepte> Rezepte_dateiaufruf_vegan() {
        //ruft in Speicher abgelegte veganeRezepte-Datei auf, und gibt die Datei an System zur weiteren Nutzung
        try {
            Scanner s = new Scanner(new File("src/RezepteVegan.txt"));
            while (s.hasNext()) {
                Rezepte vegan = new Rezepte(s.next(), Double.parseDouble(s.next()));
                RezepteVeganListe.add(vegan);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return RezepteVeganListe;
    }
}

