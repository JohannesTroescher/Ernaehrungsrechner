
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
    public Rechner(double Kalorienbedarf, double Kalorienverbrauch, String Rezeptsortierung) throws Exception {
        this.setKalorienbedarf(Kalorienbedarf);
        this.setKalorienverbrauch(Kalorienverbrauch);
        this.Rezeptsortierung = Rezeptsortierung;
    }

    /**
     *                                                  Set Methode für den Kalorienverbrauch
     * @param neuKalorienverbrauch                      Setzt das Attribut Kalorienverbrauch auf den eingegebenen Wert
     */
    public void setKalorienverbrauch(double neuKalorienverbrauch) throws Exception
    {
        if (neuKalorienverbrauch>=0)Kalorienverbrauch = neuKalorienverbrauch;
        else throw new Exception ("Bitte wählen Sie einen gültigen Kalorienverbrauch!");
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
    public void setKalorienbedarf(double neuKalorienbedarf)throws Exception
    {
        if(neuKalorienbedarf>0)Gesamtkalorien = neuKalorienbedarf;
        else throw new Exception("Bitte wählen Sie einen gültigen Kalorienbedarf!");
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
     * @throws Exception    Wirft Exception, sofern der gewünschte Nutzer nicht existiert
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
    public String Rezeptsortierung(int UserID) throws Exception
    {

        return switch (Datenbank.UserListe.get(UserID).getNahrungspraeferenz()) {
            case "normal" -> String.valueOf(Datenbank.RezepteNormalListe);
            case "Normal" -> String.valueOf(Datenbank.RezepteNormalListe);
            case "vegetarisch" -> String.valueOf(Datenbank.RezepteVegetarischListe);
            case "Vegetarisch" -> String.valueOf(Datenbank.RezepteVegetarischListe);
            case "vegan" -> String.valueOf(Datenbank.RezepteVeganListe);
            case "Vegan" -> String.valueOf(Datenbank.RezepteVeganListe);
            default -> throw new Exception("Leider gibt es für Ihre Angaben kein Rezept!");
        };

    }
}
