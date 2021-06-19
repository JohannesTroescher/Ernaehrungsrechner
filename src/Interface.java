public class Interface {
    /**
     * Klassenattribute der Klasse Interface
     */
    private double Kalorien_sollwert;
    private String Rezeptvorschläge;

    /**
     *                                             Konstruktor der Klasse Interface
     * @param Kalorien_sollwert                    Sollwert der Kalorien
     * @param Rezeptvorschläge                     Rezeptvorschläge aus externer Datei
     */
    public Interface(double Kalorien_sollwert,String Rezeptvorschläge) {
        this.Kalorien_sollwert = Kalorien_sollwert;
        this.Rezeptvorschläge = Rezeptvorschläge;
    }

    /**
     * Standardkonstruktor der Klasse Interface
     */
    public Interface() {
    }

    /**
     *                                            Get Methode für die Rezeptvorschläge
     * @return Rezeptvorschläge                   gibt die passenden Rezeptvorschläge zurück
     */
    public String getRezeptvorschläge() {
        return Rezeptvorschläge;
    }

    /**
     *                                           Set Methode für die Rezeptvorschläge
     * @param rezeptvorschläge                   setzt Rezeptvorschläge auf eienen bestimmten Wert
     */
    public void setRezeptvorschläge(String rezeptvorschläge) {
        Rezeptvorschläge = rezeptvorschläge;
    }

    /**
     *                                           Get Methode für den Kalorien_sollwert
     * @return                                   Kalorien_sollwert  gibt den Kaloriensollwert zurück
     */
    public double getKalorien_sollwert() {
        return Kalorien_sollwert;
    }

    /**
     *                                           Set Methode für den Kaloriensollwert
     * @param kalorien_sollwert                  Setzt den Kaloriensollwert auf einen bestimmten Wert
     */
    public void setKalorien_sollwert(double kalorien_sollwert) {
        Kalorien_sollwert = kalorien_sollwert;
    }

    public UserDaten User_erstellen(String name,int alter,double groesse,String geschlecht, String training,String nahrung,double gewicht) {
//Erstellt einen neuen User//konstruktor aufrufen
        UserDaten User=new UserDaten(name,alter, groesse, geschlecht,training,nahrung,gewicht);
        return User;
    }

    /**
     *  ruft Rezepte auf, und gibt aufgerufene Rezepte an GUI um darzustellen
     */

    public void Information_display() {
    }

    /**
     * ruft die die Daten des entsprechenden Users auf (aus UserDatenDatei über Userdaten_auslesen()
     * @param UserID                             UserID des "Users"
     * @return                                   UserID
     */
    public int User_aufruf(int UserID) {
        return UserID;
    }

    /**
     * Funktionsweise: ersetzt alte Userdaten mit neuen, ruft Userdaten_aendern() auf wenn nicht null
     * @param UserID                             UserID
     * @return                                   geänderte UserID
     * @throws Exception                         Wirft Exception, wenn UserID nicht vorhanden
     */
    public int User_änderung(int UserID) throws Exception {
if(UserID!=0)
        return UserID;
else
    throw new Exception ("UserID existiert nicht");
    }

}