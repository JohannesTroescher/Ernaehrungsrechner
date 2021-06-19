
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
     * Get Methode
     * @return Gesamtkalorien
     */
    public double getKalorienbedarf()
    {
        return Gesamtkalorien;
    }

    /**
     * Set Methode
     * @param neuRezeptsortierung
     */
    public void setRezeptsortierung(String neuRezeptsortierung)
    {
        Rezeptsortierung = neuRezeptsortierung;
    }

    /**
     * Get Methode
     * @return Rezeptsortierung
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
     /*@param                 Nahrungspräferenz, Trainingsziel, Gesamtumsatz des User
     *@return                 Liste mit Rezepten
     */
    public String Rezeptsortierung(int UserID) throws Exception
    {
        return switch (Datenbank.UserListe.get(UserID).getNahrungspraeferenz()) {
            case "normal" -> String.valueOf(Datenbank.RezepteNormalListe);
            case "Vegetarisch" -> String.valueOf(Datenbank.RezepteVegetarischListe);
            case "Vegan" -> String.valueOf(Datenbank.RezepteVeganListe);
            default -> throw new Exception("Leider gibt es für Ihre Angaben kein Rezept!");
        };

        // String nahrung=Datenbank.UserListe.get(UserID).getNahrungspraeferenz();
        //Rezeptsortierungs-blargh
        //return "null";
    }
}
