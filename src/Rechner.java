import java.util.concurrent.ExecutionException;

public class Rechner
{
    /**
    /*Attribute
     */
    private double Gesamtkalorien;
    private double Kalorienverbrauch;
    private String Rezeptsortierung;

    /**
    /*Standartkonsturktor
     */
    public Rechner()
    {
    Gesamtkalorien =0;
    Kalorienverbrauch=0;
    Rezeptsortierung="Null";
    }
    /**
    /*Konstruktor
     */
    public Rechner(double Kalorienbedarf, double Kalorienverbrauch)
    {
        this.Gesamtkalorien = Kalorienbedarf;
        this.Kalorienverbrauch = Kalorienverbrauch;
    }

    /**
    /* Set und Get Methode
     */
    /**
     *                                       Set Methode für den Kalorienverbrauch
     *                                       setzt das Attribut Kalorienverbrauch  auf den eingegeben Wert
     * @param neuKalorienverbrauch
     */
    public void setKalorienverbrauch(double neuKalorienverbrauch)
    {
        Kalorienverbrauch = neuKalorienverbrauch;
    }

    /**
     *                                      Get Methode für den Kalorienverbrauch
     * @return Kalorienverbrauch            Gibt Kalorienverbrauch aus
     */
    public double getKalorienverbrauch()
    {
      return Kalorienverbrauch;
    }

    /**
     *                                      Set Methode für Kalorienbedarf
     *
     * @param neuKalorienbedarf
     */
    public void setKalorienbedarf(double neuKalorienbedarf)
    {
        Gesamtkalorien = neuKalorienbedarf;
    }

    /**
     *                                      Get Methode für den Kalorienbedarf
     * @return gesamtumsatz                 Gibt den Gesamtumsatz aus
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

    /**                      Rezeptsortieren um passendes Rezept auszugeben
    /*@param                 Nahrungspräferenz, Trainingsziel, Gesamtumsatz des User
     *@return                Liste mit Rezepten
     */
    public String Rezept_sortieren(String nahrungspraeferenz,double Gesamtkalorien,String Trainingsziel) throws Exception
    {
        if (nahrungspraeferenz.equals("normal"));

            return String.valueOf(Datenbank.RezepteNormalListe);

        else if(nahrungspraeferenz.equals("Vegetarisch"));

            return String.valueOf(Datenbank.RezepteVegetarischListe);

        else if (nahrungspraeferenz.equals("Vegan"));

            return String.valueOf(Datenbank.RezepteVeganListe);

            else
        throw new Exception ("Leider gibt es für Ihre Angaben kein Rezept!");

        /**String nahrung=Datenbank.UserListe.get(UserID).getNahrungspraeferenz();
        //Rezeptsortierungs-blargh
        return "null";
         **/
    }
}
