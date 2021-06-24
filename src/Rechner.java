import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rechner
{
    /**
     *Klassenattribute der Klasse Rechner
     */
    private double Gesamtkalorien;
    private double Kalorienverbrauch;
    static ArrayList<Rezepte> RezepteNormalProteinhaltig=new ArrayList<Rezepte>();
    static ArrayList<Rezepte> RezepteNormalProteinarm=new ArrayList<Rezepte>();
    static ArrayList<Rezepte> RezepteVegetarischProteinhaltig=new ArrayList<Rezepte>();
    static ArrayList<Rezepte> RezepteVegetarischProteinarm=new ArrayList<Rezepte>();
    static ArrayList<Rezepte> RezepteVeganProteinhaltig=new ArrayList<Rezepte>();
    static ArrayList<Rezepte> RezepteVeganProteinarm=new ArrayList<Rezepte>();


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
     * Konstruktor
     */
    public Rechner(double Kalorienbedarf, double Kalorienverbrauch) throws Exception
    {
        this.setKalorienbedarf(Kalorienbedarf);
        this.setKalorienverbrauch(Kalorienverbrauch);

    }

    /**
     *                                                  Set Methode für den Kalorienverbrauch
     * @param neuKalorienverbrauch                      Setzt das Attribut Kalorienverbrauch auf den eingegebenen Wert
     */
    public void setKalorienverbrauch(double neuKalorienverbrauch) throws Exception{
        if(neuKalorienverbrauch>0)
            Kalorienverbrauch = neuKalorienverbrauch;
        else throw new Exception("Bitte geben Sie einen gültigen Kalorienverbrauch an!");
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
    public void setKalorienbedarf(double neuKalorienbedarf) throws Exception{
        if(neuKalorienbedarf>=0)
            Gesamtkalorien = neuKalorienbedarf;
        else throw new Exception("Bitte geben Sie einen gültigen Kalorienbedarf an!");
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
    public void Rezeptsortierung() throws Exception {
        Scanner s = null;
        try {
            s = new Scanner(new File("src/RezepteNormal.txt"));

            while (s.hasNextLine()) {
                    Rezepte normal = new Rezepte(s.next(), s.next(), Double.parseDouble(s.next()), s.nextLine());
                    if (normal.getProteine().equalsIgnoreCase("proteinhaltig"))
                        Rechner.RezepteNormalProteinhaltig.add(normal);
                    else
                        Rechner.RezepteNormalProteinarm.add(normal);
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            s.close();

        }

    public void RezeptsortierungVegetarisch() throws Exception {
        Scanner s = null;
        try {
            s = new Scanner(new File("src/RezepteVegetarisch.txt"));

            while (s.hasNextLine()) {
                Rezepte normal = new Rezepte(s.next(), s.next(), Double.parseDouble(s.next()), s.nextLine());
                if (normal.getProteine().equalsIgnoreCase("proteinhaltig"))
                    Rechner.RezepteVegetarischProteinhaltig.add(normal);
                else
                    Rechner.RezepteVegetarischProteinarm.add(normal);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

            s.close();
    }

    public void RezeptsortierungVegan() throws Exception {
        Scanner s = null;
        try {
            s = new Scanner(new File("src/RezepteVegan.txt"));

            while (s.hasNextLine()) {
                Rezepte normal = new Rezepte(s.next(), s.next(), Double.parseDouble(s.next()), s.nextLine());
                if (normal.getProteine().equalsIgnoreCase("proteinhaltig"))
                    Rechner.RezepteVeganProteinhaltig.add(normal);
                else
                    Rechner.RezepteVeganProteinarm.add(normal);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

            s.close();
    }
}
