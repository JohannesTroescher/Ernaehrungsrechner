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
    private String Rezeptsortierung;

    /**
     *Standartkonsturktor
     *Setzt alle Werte auf "Null"/0.
     */
    public Rechner()
    {
    Gesamtkalorien =0;
    Kalorienverbrauch=0;
    Rezeptsortierung="Null";
    }
    /**
     *Konstruktor
     */
    public Rechner(double Kalorienbedarf, double Kalorienverbrauch, String Rezeptsortierung)
    {
        this.Gesamtkalorien = Kalorienbedarf;
        this.Kalorienverbrauch = Kalorienverbrauch;
        this.Rezeptsortierung = Rezeptsortierung;
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
     *                                                  Get Methode für den Kalorienverbrauch
     * @return Kalorienverbrauch                        Gibt den Kalorienverbrauch zurück
     */
    public double getKalorienverbrauch()
    {
      return Kalorienverbrauch;
    }


    /**
     *                                                  Set Methode für den Kalorienbedarf
     * @param neuKalorienbedarf                         Setzt das Attribut Kalorienbedarf auf den eingegebenen Wert
     */
    public void setKalorienbedarf(double neuKalorienbedarf)
    {
        Gesamtkalorien = neuKalorienbedarf;
    }

    /**
     *                                                  Get Methode für den Kalorienbedarf
     * @return Gesamtkalorien                           Gibt den Gesamtkalorien zurück
     */
    public double getKalorienbedarf()
    {
        return Gesamtkalorien;
    }

    /**
     *                                                  Set Methode für Rezeptsortierung
     * @param neuRezeptsortierung                       Setzt das Attribut Rezeptsortierung auf den eingeben Wert
     */
    public void setRezeptsortierung(String neuRezeptsortierung)
    {
        Rezeptsortierung = neuRezeptsortierung;
    }

    /**
     *                                                  Get Methode für den Rezeptsortierung
     * @return Rezeptsortierung                         Gibt Rezeptsortierung zurück
     */
    public String getRezeptsortierung()
    {
        return Rezeptsortierung;
    }

    /**                     Rechenoperation für Kalorien
     * @param UserID        UserID des gewünschten Nutzers
     * @return              Gibt Gesamtkalorienbedarf zurück
     * @throws Exception    Wirft Exception, wenn der gewünschte Nutzer nicht existiert
     */
    public double Rechneroperation(int UserID) throws Exception
    {
      if (Datenbank.UserListe.size()>=UserID)
          return Datenbank.UserListe.get(UserID).getGrundbedarf()+this.Kalorienverbrauch;
      else
          throw new Exception ("Der gewünschte Nutzer existiert nicht!");
    }

    /**                       Rezeptsortieren um passendes Rezept auszugeben
     /*@param                 Nahrungspräferenz
     *@return                 Liste mit Rezepten
     */
    public ArrayList<Rezepte> Rezeptsortierung()
    {
        Scanner s = null;
        try {
            s = new Scanner(new File("src/RezeptNormal.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNextLine())
        {
            if (s.hasNext("proteinhaltig"));
            {
                Rezepte normal = new Rezepte(s.next(),s.next(), Double.parseDouble(s.next()),s.nextLine());
                Datenbank.RezepteNormalListe.add(normal);
            }
            s.close();

        }
        return Datenbank.RezepteNormalListe;

    }
}
