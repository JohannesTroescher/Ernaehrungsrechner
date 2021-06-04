public class Interface {
    /**
     * Klassenattribute der Klasse Interface
     */
    private int Kalorien_sollwert;
    private String Rezeptvorschläge;

    /**
     * Konstruktor Interface identisch mit UserDaten?
     *
     * @param

     */
    public Interface(int Kalorien_sollwert,String Rezeptvorschläge) {
        this.Kalorien_sollwert=Kalorien_sollwert;
        this.Rezeptvorschläge= Rezeptvorschläge;
    }

    /**
     * Standardkonstruktor der Klasse Interface
     */
    public Interface() {
    }

    public String getRezeptvorschläge() {
        return Rezeptvorschläge;
    }

    public void setRezeptvorschläge(String rezeptvorschläge) {
        Rezeptvorschläge = rezeptvorschläge;
    }

    public int getKalorien_sollwert() {
        return Kalorien_sollwert;
    }

    public void setKalorien_sollwert(int kalorien_sollwert) {
        Kalorien_sollwert = kalorien_sollwert;
    }

    public String User_erstellen(String UserID) {
//Erstellt einen neuen User
        return UserID;
    }


    public void Information_display() {
    }
//ruft Rezepte auf, und gibt aufgerufene Rezepte an GUI um darzustellen


    public String User_aufruf(String UserID) {
//ruft die die Daten des entsprechenden Users auf (aus UserDatenDatei über Userdaten_auslesen())
        return UserID;
    }

    public String User_änderung(String UserID) {
//geänderte User/null(wenn User nicht existiert)
//Funktionsweise: ersetzt alte Userdaten mit neuen, ruft Userdaten_aendern() auf wenn nicht null
        return UserID;
    }


}