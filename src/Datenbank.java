import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

/**
 * Alle Methoden in der Datenbank sind static damit sie nicht Objektgebunden sind. So muss nicht erst ein Objekt vom Typ Datenbank instanziiert werden um die Methoden aufzurufen.
 * So spart man sich auch einen Konstruktor, und diverse get/set-Methoden. Außerdem macht es das nutzen der Datenbank-Methoden im Programm selbst deutlich einfacher, und unkomplizierter.
 *          --> es wurde Objektorientiert/funktionell programmiert
 */


public class Datenbank implements Serializable {

    /**
     * ArrayList "UserListe" wird erstellt um sie später mit UserDaten zu füllen
     * ArrayList "RezepteNormalListe" wird erstellt um sie später mit Rezepten aus RezepteNormal-Datei zu befüllen
     * ArrayLÖist "RezepteVegetarischListe" wird erstellt um sie später mit Rezepten aus RezepteVegetarisch-Datei zu befüllen
     * Arraylist "RezepteVeganListe" wird erstellt um sie später mit Rezepten aus RezepteVegan-Datei zu befüllen
     *
     * static weil : Damit zum nutzen der Methoden und der Listen aus der Datenbank nicht erst ein Objekt instanziiert werden muss
     *                  --> die Listen sind so nicht Objektgebunden, und können einfach von überall aufgerufen/verwendet/verändert werden
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
     * Soll aus der "UserListe" eine externe Datei machen
     * Objekte in UserListe wwerden in das File geschrieben
     *
     * @param UserListe "UserListe" mit enthaltenen "Userdaten"
     */
    public static void saveUserListe(ArrayList<UserDaten> UserListe) {
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
     * Läd das abgespeicherte File wieder in die UserListe (ArrayList<>)
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
     * Soll abgespeicherte RezepteNormal-Datei aufrufen und in RezepteNormalListe laden
     *
     * @return returnt RezepteNormalListe
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
     * Soll abgespeicherte RezepteVegetarisch-Datei aufrufen und in RezepteVegetarischListe laden
     *
     * @return returnt RezepteVegetarischListe
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
     * Soll abgespeicherte RezepteVegan-Datei aufrufen und in RezepteVeganListe laden
     *
     * @return returnt RezepteVeganListe
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

