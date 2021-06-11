
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
    public double Rechneroperation(int UserID) throws Exception
    {
       /**
        /*Rechnung
      */
      if ((Datenbank.UserListe.contains(UserID)))
        return Datenbank.UserListe.get(UserID).getGrundbedarf()+Kalorienverbrauch;
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
