
public class Rezepte {
    /**
     * Klassenattribute der Klasse Rezept
     * @author  J.Bamboschek und J.Hofmann
     * @version 1.1
     */
    private String art="null";
    private double kalorien=0;
    private String proteine="null";
    private String Beschreibung="null";

    /**                     Konstruktor für die Klasse Rezept
     *                      Erzeugt Objekt der Klasse Rezept
     * @param art           Art des Rezepts
     * @param kalorien      Anzahl der Kalorien des Rezepts
     * @param beschreibung  Beschreibung des Rezeptes
     */
    public Rezepte(String art,String proteine, double kalorien, String beschreibung)throws Exception{

            this.setBeschreibung(beschreibung);
            this.setArt(art);
            this.setKalorien(kalorien);
            this.setProteine(proteine);
    }
    /**     Standardkonstruktor für die Klasse Rezept
     *      Erzeugt ein Objekt der Klasse Rezept und setzt alle Attribute auf "null" bzw. 0
     */
    public Rezepte() {
        this.art="null";
        this.kalorien=0;
        this.Beschreibung="null";
        this.proteine="null";
    }

    /**             To-String-Methode
     * @return      Gibt Attribute als String zurück
     */
    @Override
    public String toString(){
        return ":"+this.art + ": " + this.getProteine() + " " + "Kalorien: " + this.kalorien + " " + "Rezeptbeschreibung: " + this.Beschreibung;
}

    /**             Get-Methode für Art des Rezepts
     * @return      Gibt Art des Rezeptes zurück
     */
    public String getArt() {
        return art;
    }

    /**                     Set-Mrthode für die Art des Rezeptes
     *                      Setzt das Attribut "art" des Rezeptes auf den gewünschten Wert
     * @param art           Gewünschte Art des Rezeptes
     * @throws Exception    Wirft Exception, wenn die gewünschte Art des Rezeptes nicht "normal", "vegetarisch" oder "vegan" ist
     */
    public void setArt(String art)throws Exception {
        if(art.equalsIgnoreCase("normal") ||art.equalsIgnoreCase("vegetarisch")||art.equalsIgnoreCase("vegan"))
            this.art = art;
        else
            throw new Exception("Bitte geben Sie einen gültigen Rezepttyp an!");
    }

    /**                     Set-Methode für die Kalorien
     *                      Setzt das Attribut "kalorien" auf den gewünschten Wert
     * @param kalorien      Gewünschter Kalorienwert
     * @throws Exception    Wirft Exception, wenn der gewünschte Wert "0" oder negativ ist
     */
    public void setKalorien(double kalorien) throws Exception{
        if(kalorien>=1)
            this.kalorien=kalorien;
        else
            throw new Exception("Bitte geben Sie einen gültigen Kalorienwert an!");
    }

    /**             Get-Methode für die Kalorien
     * @return      Gibt den Kalorienwert zurück
     */
    public double getKalorien(){
        return this.kalorien;
    }

    /**             Get-Methode für Beschreibung
     * @return      Gibt die Beschreibung zurück
     */
    public String getBeschreibung() {
        return Beschreibung;
    }

    /**                         Set-Methode für Beschreibung
     * @param beschreibung      Setzt Attribut "Beschreibung" auf gewünschten Wert
     */
    public void setBeschreibung(String beschreibung) {
        Beschreibung = beschreibung;
    }

    /**                     Set-Methode für Proteingehalt
     * @param proteine      Setzt Attribut "Proteine" auf "proteinhaltig" oder "proteinarm"
     * @throws Exception    Wirft Exception, wenn Eingabe von "proteinhaltig" oder "proteinarm" abweicht
     */
    public void setProteine(String proteine)throws Exception{
        if(proteine.equalsIgnoreCase("proteinhaltig")||proteine.equalsIgnoreCase("proteinarm"))
            this.proteine=proteine;
        else throw new Exception("Bitte wähle \"proteinhaltig\" oder \"proteinarm\"");
    }

    /**             Get-Methode für Proteingehalt
     * @return      Gibt Proteingehalt zurück
     */
    public String getProteine() {
        return proteine;
    }
}
