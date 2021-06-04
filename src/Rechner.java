
public class Rechner
{
    /*Attribute
     */
    private int Kalorienbedarf ;
    private int Kalorienverbrauch;
    private String Rezeptsortierung;                     //List?

    /*Standartkonsturktor
     */
    public Rechner()
    {
    Kalorienbedarf=0;
    Kalorienverbrauch=0;
    Rezeptsortierung=;
    }
    /*Konstruktor
     */
    public Rechner(int Kalorienbedarf, int Kalorienverbrauch)
    {
        this.Kalorienbedarf = Kalorienbedarf;
        this.Kalorienverbrauch = Kalorienverbrauch;
    }

    // Set und Get Methode
    public void setKalorienverbrauch(int neuKalorienverbrauch)
    {
        Kalorienverbrauch = neuKalorienverbrauch;
    }
    public int getKalorienverbrauch()
    {
      return Kalorienverbrauch;
    }

    public void setKalorienbedarf(int neuKalorienbedarf)
    {
        Kalorienbedarf = neuKalorienbedarf;
    }
    public int getKalorienbedarf()
    {
        return Kalorienbedarf;
    }

    /*Methoden,Operationen

     */

    /*Extrakalorien, UserID, return:Gesamtumsatz, Funktionsweise: Berechnung von Grundbedarf und Gesamtumsatz

     */
    public double Rechneroperation()
    {
     /*Rechnung

      */
        //655,1+(9,6xKörpergewicht_in_kg) + (1,8 x Körpergröße_in_cm)–(4,7xAlter_in _Jahren);
        //= Grundbedarf
        //return Grundbedarf+Extrakalorien=Gesamtumsatz;
    }

    /*Gesamtumsatz, Trainingsziel, Nahrungspräferenz, return: Liste, Funktionsweise: Gibt passendes Rezept aus
     */
    public String Rezept_sortieren()                   //Liste mit Rezepten?
    {
     //
    }

    /*Grundbedarf, return: Nichts, Funktionsweise:berechnung des Grundbedarf
    */

    public void Grundbedarf()                          //?? siehe Rechneroperation
    {}

}
