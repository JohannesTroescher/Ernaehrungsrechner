
public class Rechner
{
    /**
    /*Attribute
     */
    private double Grundbedarf ;
    private double Kalorienverbrauch;
    private String Rezeptsortierung;                     //List?

    /**
    /*Standartkonsturktor
     */
    public Rechner()
    {
    Grundbedarf=0;
    Kalorienverbrauch=0;
    Rezeptsortierung="Null";
    }
    /**
    /*Konstruktor
     */
    public Rechner(double Kalorienbedarf, double Kalorienverbrauch)
    {
        this.Grundbedarf = Kalorienbedarf;
        this.Kalorienverbrauch = Kalorienverbrauch;
    }

    /**
    /* Set und Get Methode
     */
    public void setKalorienverbrauch(double neuKalorienverbrauch)
    {
        Kalorienverbrauch = neuKalorienverbrauch;
    }
    public double getKalorienverbrauch()
    {
      return Kalorienverbrauch;
    }

    public void setKalorienbedarf(double neuKalorienbedarf)
    {
        Grundbedarf = neuKalorienbedarf;
    }
    public double getKalorienbedarf()
    {
        return Grundbedarf;
    }

    /**                     Rechenoperation für Kalorien
     * @param UserID        UserID des gewünschten Nutzers
     * @return              Gibt Gesamtkalorienbedarf zurück
     * @throws Exception    Wirft Exception, wenn der gewünschte Nutzer nicht existiert
     */
    public double Rechneroperation(int UserID) throws Exception
    {
      if ((Datenbank.UserListe.contains(UserID)))
        return Datenbank.UserListe.get(UserID).getGrundbedarf()+this.Kalorienverbrauch;
      else
          throw new Exception ("Der gewünschte Nutzer existiert nicht!");
    }

    /**
    /*Gesamtumsatz, Trainingsziel, Nahrungspräferenz, return: Liste, Funktionsweise: Gibt passendes Rezept aus
     */
    public String Rezept_sortieren()                   //Liste mit Rezepten?
    {
        return "null";
    }

    /**
    /*Grundbedarf, return: nichts , Funktionsweise:berechnung des Grundbedarf
    */


}
