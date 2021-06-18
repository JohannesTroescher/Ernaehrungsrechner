
public class Rechner
{
    /**
     *Attribute
     */
    private double Gesamtkalorien;
    private double Kalorienverbrauch;
    private String Rezeptsortierung;

    /**
     *Standartkonsturktor
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
    public Rechner(double Kalorienbedarf, double Kalorienverbrauch)
    {
        this.Gesamtkalorien = Kalorienbedarf;
        this.Kalorienverbrauch = Kalorienverbrauch;
    }

    /**
     * Set Methode
     * @param neuKalorienverbrauch
     */
    public void setKalorienverbrauch(double neuKalorienverbrauch)
    {
        Kalorienverbrauch = neuKalorienverbrauch;
    }

    /**
     * Get Methode
     * @return Kalorienverbrauch
     */
    public double getKalorienverbrauch()
    {
      return Kalorienverbrauch;
    }

    /**
     * Set Methode
     * @param neuKalorienbedarf
     */
    public void setKalorienbedarf(double neuKalorienbedarf)
    {
        Gesamtkalorien = neuKalorienbedarf;
    }

    /**
     * Get Methode
     * @return Gesamtkalorien
     */
    public double getKalorienbedarf()
    {
        return Gesamtkalorien;
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

    /**
    /*Gesamtumsatz, Trainingsziel, Nahrungspräferenz, return: Liste, Funktionsweise: Gibt passendes Rezept aus
     */
    public String Rezept_sortieren(int UserID)                   //Liste mit Rezepten?
    {
        String nahrung=Datenbank.UserListe.get(UserID).getNahrungspraeferenz();
        //Rezeptsortierungs-blargh
        return "null";
    }
}
