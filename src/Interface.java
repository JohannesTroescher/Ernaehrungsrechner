public class Interface {
    /**
     * Klassenattribute der Klasse Interface
     */
    private int Kalorien_sollwert;
    private String Rezeptvorschläge;

    /**                     Konstruktor Interface identisch mit UserDaten?
     * @param name          Name des Nutzers
     * @param alter         Alter des Nutzers
     * @param groesse       Groeße des Nutzers
     * @param geschlecht    Geschlecht Alter des Nutzers
     * @param training      Gewünschter Modus: Abnehmen/Muskelaufbau
     * @param nahrung       Gewünsche Nahrungsart: normal, vegetarisch, vegan
     * @param gewicht       Gewicht Alter des Nutzers
     */
    public Interface (String name,int alter,double groesse,String geschlecht, String training,String nahrung,double gewicht){}

    /**
     * Standardkonstruktor der Klasse Interface
     */
    public Interface(){}

    public String User_erstellen(String UserID){
//Erstellt einen neuen User
        return UserID;
    }

    public void Information_display(){}
//ruft Rezepte auf, und gibt aufgerufene Rezepte an GUI um darzustellen

    public String User_aufruf(String UserID){
//ruft die die Daten des entsprechenden Users auf (aus UserDatenDatei über Userdaten_auslesen())
        return UserID;
    }

    public String User_änderung(String UserID){
//geänderte User/null(wenn User nicht existiert)
//Funktionsweise: ersetzt alte Userdaten mit neuen, ruft Userdaten_aendern() auf wenn nicht null
        return UserID;
    }

}
