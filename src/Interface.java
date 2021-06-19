public class Interface {
    /**
     * Klassenattribute der Klasse Interface
     */
    private double Kalorien_sollwert;
    private String Rezeptvorschläge;

    /**
     *
     * @param Kalorien_sollwert Sollwert der Kalorien
     * @param Rezeptvorschläge Rezeptvorschläge aus externer Datei
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
     * Get Methode
     * @return Rezeptvorschläge
     */
    public String getRezeptvorschläge() {
        return Rezeptvorschläge;
    }
    /**
     * Set Methode
     * @param rezeptvorschläge
     */
    public void setRezeptvorschläge(String rezeptvorschläge) {
        Rezeptvorschläge = rezeptvorschläge;
    }
    /**
     * Get Methode
     * @return Kalorien_sollwert
     */
    public double getKalorien_sollwert() {
        return Kalorien_sollwert;
    }
    /**
     * Set Methode
     * @param kalorien_sollwert
     */
    public void setKalorien_sollwert(double kalorien_sollwert) {
        Kalorien_sollwert = kalorien_sollwert;
    }

    public UserDaten User_erstellen(String name,int alter,double groesse,String geschlecht, String training,String nahrung,double gewicht) {
//Erstellt einen neuen User//konstruktor aufrufen
        UserDaten User=new UserDaten(name,alter, groesse, geschlecht,training,nahrung,gewicht);
        return User;
    }


    public void Information_display() {
    }
//ruft Rezepte auf, und gibt aufgerufene Rezepte an GUI um darzustellen


    public int User_aufruf(int UserID) {
//ruft die die Daten des entsprechenden Users auf (aus UserDatenDatei über Userdaten_auslesen())
        return UserID;
    }

    public int User_änderung(int UserID) {
//geänderte User/null(wenn User nicht existiert)
//Funktionsweise: ersetzt alte Userdaten mit neuen, ruft Userdaten_aendern() auf wenn nicht null
        return UserID;
    }

}