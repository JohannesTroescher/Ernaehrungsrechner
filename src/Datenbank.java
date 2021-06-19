import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Datenbank implements Serializable {

    /**
     * ArrayList "UserListe" wird erstellt um sie später mit UserDaten zu füllen
     * static weil : ...
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
     * @param UserID  Durchlaufende einzigartige Nummer um ein Objekt vom Typ "UserDaten" eindeutig zu identifizieren
     * @param newUser Deänderte User-Daten eines Users
     * @throws Exception Wirft Exception wenn "UserListe" die gesuchte "UserID" nicht enthält
     */
    public static void Userdaten_aendern(int UserID, UserDaten newUser) throws Exception {
        if (Datenbank.UserListe.size()>=UserID) {
            UserListe.set(UserID, newUser);
            try {
                newUser.setUserID(UserID);
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else throw new Exception("User existiert nicht.");
    }


    /**
     * Soll die "UserListe" nach einer "UserID" durchsuchen und returnen ob die "UserID" vorhanden ist oder nicht
     *
     * @param UserID Durchlaufende einzigartige Nummer um ein Objekt vom Typ "UserDaten" eindeutig zu identifizieren
     * @throws Exception Wirft eine Exception, wenn die "UserID" > "UserListen.size" ist
     */
    public static void UserID_exists(int UserID) throws Exception{
        if (UserListe.size()>=UserID) {

        } else throw new Exception("gibts nicht");
    }


    /**
     * Soll aus der "UserListe" eine externe Datei machen (z.B ein .txt File, --> einfach editierbar und testbar)
     * Objekte würden dann Zeilenweise in das File geschrieben werden
     *
     * @param UserListe "UserListe" mit enthaltenen "Userdaten" wird in eine externe .txt File geschrieben
     */
    public static void saveUserliste(ArrayList<UserDaten> UserListe) {
        try{
            FileOutputStream writeData = new FileOutputStream("Datenbank");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(UserListe);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Soll das abgespeicherte .txt File in das Programm laden
     *
     * @return Gibt die geladene "UserListe" aus der .txt File wieder
     */

    public static ArrayList<UserDaten> loadUserListe() {
        try{
            FileInputStream readData = new FileInputStream("Datenbank");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            UserListe = (ArrayList<UserDaten>) readStream.readObject();

            readStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return UserListe;
    }



    /**
     * Soll abgespeicherte normaleRezept-Datei aufrufen und in Programm laden
     *
     * @return Gibt die geladene .txt File der ArrayList "normaleRezepteDatei" wieder
     */
    public static ArrayList<Rezepte> Rezepte_dateiaufruf_normal() {
        try {
            Scanner s = new Scanner(new File("src/RezepteNormal.txt"));
            while (s.hasNextLine()) {
                Rezepte normal = new Rezepte(s.next(),s.next(), Double.parseDouble(s.next()),s.nextLine());
                RezepteNormalListe.add(normal);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return RezepteNormalListe;
    }

    /**
     * Soll abgespeicherte vegetarischeRezept-Datei aufrufen und in Programm laden
     *
     * @return Gibt die geladene .txt File der ArrayList "RezepteVegetarischListe" wieder
     */
    public static ArrayList<Rezepte> Rezepte_dateiaufruf_vegetarisch() {
        try {
            Scanner s = new Scanner(new File("src/RezepteVegetarisch.txt"));
            while (s.hasNextLine()) {
                Rezepte vegetarisch = new Rezepte(s.next(),s.next(), Double.parseDouble(s.next()),s.nextLine());
                RezepteVegetarischListe.add(vegetarisch);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return RezepteVegetarischListe;
    }


    /**
     * Soll abgespeicherte veganeRezept-Datei aufrufen und in Programm laden
     *
     * @return Gibt die geladene .txt File der ArrayList "RezepteVeganListe" wieder
     */
    public static ArrayList<Rezepte> Rezepte_dateiaufruf_vegan() {
        try {
            Scanner s = new Scanner(new File("src/RezepteVegan.txt"));
            while (s.hasNextLine()) {
                Rezepte vegan = new Rezepte(s.next(), s.next(),Double.parseDouble(s.next()),s.nextLine());
                RezepteVeganListe.add(vegan);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return RezepteVeganListe;
    }
}

