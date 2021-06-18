
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
    public Rechner(double Kalorienbedarf, double Kalorienverbrauch, String Rezeptsortierung)
    {
        this.Gesamtkalorien = Kalorienbedarf;
        this.Kalorienverbrauch = Kalorienverbrauch;
        this.Rezeptsortierung = Rezeptsortierung;
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
    public String Rezeptsortierung(String nahrungspraeferenz,double Gesamtkalorien,String Trainingsziel) throws Exception
    {
        if (nahrungspraeferenz.equals("normal"));

        return String.valueOf(Datenbank.RezepteNormalListe);

        else if(nahrungspraeferenz.equals("Vegetarisch"));

        return String.valueOf(Datenbank.RezepteVegetarischListe);

        else if (nahrungspraeferenz.equals("Vegan"));

        return String.valueOf(Datenbank.RezepteVeganListe);

        else
        throw new Exception ("Leider gibt es für Ihre Angaben kein Rezept!");

        // String nahrung=Datenbank.UserListe.get(UserID).getNahrungspraeferenz();
        //Rezeptsortierungs-blargh
        return "null";
    }
}
