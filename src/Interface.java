public class Interface {

    private int Kalorien_sollwert;
    private String Rezeptvorschläge;

    public Interface (){

    }

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
