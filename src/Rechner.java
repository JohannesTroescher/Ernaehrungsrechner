import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rechner
{
    /**
     *Klassenattribute der Klasse Rechner
     * @author F.Hahn und J.Kusmat
     * @version1.1
     */
    private double Gesamtkalorien;
    private double Kalorienverbrauch;
    static ArrayList<Rezepte> RezepteNormalProteinhaltig;
    static ArrayList<Rezepte> RezepteNormalProteinarm;
    static ArrayList<Rezepte> RezepteVegetarischProteinhaltig;
    static ArrayList<Rezepte> RezepteVegetarischProteinarm;
    static ArrayList<Rezepte> RezepteVeganProteinhaltig;
    static ArrayList<Rezepte> RezepteVeganProteinarm;


    /**
     *Standardkonsturktor
     *Setzt alle Werte auf "Null"/0.
     */
    public Rechner()
    {
        Gesamtkalorien =0;
        Kalorienverbrauch=0;
    }
    /**
     *Konstruktor
     */
    public Rechner(double Kalorienbedarf, double Kalorienverbrauch)
    {
        this.Gesamtkalorien = Kalorienbedarf;
        this.Kalorienverbrauch = Kalorienverbrauch;
    }

    /**
     *                                                  Set Methode für den Kalorienverbrauch
     * @param neuKalorienverbrauch                      Setzt das Attribut Kalorienverbrauch auf den eingegebenen Wert
     */
    public void setKalorienverbrauch(double neuKalorienverbrauch)
    {
        Kalorienverbrauch = neuKalorienverbrauch;
    }

    /**
     *                                                  Get Methode fÃ¼r den Kalorienverbrauch
     * @return Kalorienverbrauch                        Gibt den Kalorienverbrauch zurÃ¼ck
     */
    public double getKalorienverbrauch()
    {
        return Kalorienverbrauch;
    }


    /**
     *                                                  Set Methode fÃ¼r den Kalorienbedarf
     * @param neuKalorienbedarf                         Setzt das Attribut Kalorienbedarf auf den eingegebenen Wert
     */
    public void setKalorienbedarf(double neuKalorienbedarf)
    {
        Gesamtkalorien = neuKalorienbedarf;
    }

    /**
     *                                                  Get Methode fÃ¼r den Kalorienbedarf
     * @return Gesamtkalorien                           Gibt den Gesamtkalorien zurÃ¼ck
     */
    public double getKalorienbedarf()
    {
        return Gesamtkalorien;
    }


    /**                     Rechenoperation für Kalorien
     * @param UserID        UserID des gewünschten Nutzers
     * @return              Gibt Gesamtkalorienbedarf zurÃ¼ck
     * @throws Exception    Wirft Exception, wenn der gewÃ¼nschte Nutzer nicht existiert
     */
    public double Rechneroperation(int UserID) throws Exception
    {
        if (Datenbank.UserListe.size()>=UserID)
            return Datenbank.UserListe.get(UserID).getGrundbedarf()+this.Kalorienverbrauch;
        else
            throw new Exception ("Der gewünschte Nutzer existiert nicht!");
    }

    /**                       Rezeptsortieren um passendes Rezept auszugeben
     /*@param                 Trainingsziel (Proteinhaltig/Proteinarm)
     *@return                 Liste mit Rezepten
     */
    public ArrayList<Rezepte> Rezeptsortierung() throws Exception {
        Scanner s = null;
        try {
            s = new Scanner(new File("src/RezepteNormal.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNextLine())
        {
            if (s.hasNext("proteinhaltig"))
            {
                Rezepte normal = new Rezepte(s.next(),s.next(), Double.parseDouble(s.next()),s.nextLine());
                Datenbank.RezepteNormalListe.add(normal);
            }
            else
            {
            return RezepteNormalProteinarm;
            }
            s.close();

        }
        return RezepteNormalProteinhaltig;
    }

    public ArrayList<Rezepte> RezeptsortierungVegetarisch() throws Exception {
        Scanner s = null;
        try {
            s = new Scanner(new File("src/RezepteVegetarisch.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNextLine()) {
            if (s.hasNext("proteinhaltig"))
            {
                Rezepte Vegetarisch = new Rezepte(s.next(), s.next(), Double.parseDouble(s.next()), s.nextLine());
                Datenbank.RezepteVegetarischListe.add(Vegetarisch);
            }
            else
            {
            return RezepteVegetarischProteinarm;
            }
            s.close();

        }
        return RezepteVegetarischProteinhaltig;

    }

    public ArrayList<Rezepte> RezeptsortierungVegan() throws Exception {
        Scanner s = null;
        try {
            s = new Scanner(new File("src/RezepteVegan.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNextLine())
        {
            if (s.hasNext("proteinhaltig"))
            {
                Rezepte Vegan = new Rezepte(s.next(),s.next(), Double.parseDouble(s.next()),s.nextLine());
                Datenbank.RezepteVeganListe.add(Vegan);
            }
            else
            {
            return RezepteVeganProteinarm;
            }
            s.close();

        }
        return RezepteVeganProteinhaltig;
    }
}
