public class Rezepte {
    /***
     * Klassenattribute der Klasse Rezept
     */
    private String art="null";
    private double kalorien=0;

    /***                    Konstruktor für die Klasse Rezept
     *                      Erzeugt Objekt der Klasse Rezept
     * @param art           Art des Rezepts
     * @param kalorien      Anzahl der Kalorien des Rezepts
     */
    public Rezepte(String art,double kalorien) {
        try {
            this.setArt(art);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            this.setKalorien(kalorien);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    /***    Standardkonstruktor für die Klasse Rezept
     *      Erzeugt ein Objekt der Klasse Rezept und setzt alle Attribute auf "null" bzw. 0
     */
    public Rezepte() {
        this.art="null";
        this.kalorien=0;
    }

    /***            Get-Methode für Art des Rezepts
     * @return      Gibt Art des Rezeptes zurück
     */
    public String getArt() {
        return art;
    }

    /***                    Set-Mrthode für die Art des Rezeptes
     *                      Setzt das Attribut "art" des Rezeptes auf den gewünschten Wert
     * @param art           Gewünschte Art des Rezeptes
     * @throws Exception    Wirft Exception, wenn die gewünschte Art des Rezeptes nicht "normal", "vegetarisch" oder "vegan" ist
     */
    public void setArt(String art)throws Exception {
        if(art=="normal" ||art=="vegetarisch"||art=="vegan")
            this.art = art;
        else
            throw new Exception("Bitte geben Sie einen gültigen Rezepttyp an!");
    }

    /***                    Set-Methode für die Kalorien
     *                      Setzt das Attribut "kalorien" auf den gewünschten Wert
     * @param Kalorien      Gewünschter Kalorienwert
     * @throws Exception    Wirft Exception, wenn der gewünschte Wert "0" oder negativ ist
     */
    public void setKalorien(double Kalorien) throws Exception{
        if(kalorien>1)
            this.kalorien=kalorien;
        else
            throw new Exception("Bitte geben Sie einen gültigen Kalorienwert an!");
    }

    /***            Get-Methode für die Kalorien
     * @return      Gibt den Kalorienwert zurück
     */
    public double getKalorien(){
        return this.kalorien;
    }
}
