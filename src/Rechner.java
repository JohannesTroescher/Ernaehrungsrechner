
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

    /**
    /*Methoden,Operationen
     */

    /**
    /*Extrakalorien, UserID, return:Gesamtumsatz, Funktionsweise: Berechnung von Grundbedarf und Gesamtumsatz
     */
    public double Rechneroperation()
    {
       /**
        /*Rechnung
      */
        //655,1+(9,6xKörpergewicht_in_kg) + (1,8 x Körpergröße_in_cm)–(4,7xAlter_in _Jahren);
        //= Grundbedarf
        //return Grundbedarf+Extrakalorien=Gesamtumsatz;
        return 0;
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

    public void Grundbedarf()                          //?? siehe Rechneroperation
    {}

}
