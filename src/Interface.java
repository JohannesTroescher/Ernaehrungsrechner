/**
 * Klasse Interface
 *
 * @author J. Kusmat, F.Hahn
 * @version 2.0
 */
public class Interface {


    /**
     * Standardkonstruktor der Klasse Interface
     */
    public Interface() {
    }

    /**
     * @param name       Name des Benutzers
     * @param alter      Alter des Benutzers
     * @param groesse    Körpergröße des Benutzers
     * @param geschlecht Geschlecht des Benutzers
     * @param training   Trainingsziel des Benutzers
     * @param nahrung    Ernährungsart: Normal, Vegetarisch oder Vegan
     * @param gewicht    Körpergewicht des Benutzers
     * @return User
     */
    public void User_erstellen(String name, int alter, double groesse, String geschlecht, String training, String nahrung, double gewicht) throws Exception {
        UserDaten User = new UserDaten(name, alter, groesse, geschlecht, training, nahrung, gewicht);
        Datenbank.Userdaten_einlesen(User);
    }

    /**
     * ruft Rezepte auf, und gibt aufgerufene Rezepte an GUI um darzustellen
     */

    public void Information_display() {
    }

    /**
     * ruft die die Daten des entsprechenden Users auf (aus UserDatenDatei über Userdaten_auslesen()
     *
     * @param UserID UserID des "Users"
     * @return UserID
     */
    public UserDaten User_aufruf(int UserID) throws Exception {
        if (Datenbank.UserListe.size() >= UserID)
            return Datenbank.UserListe.get(UserID);
        else
            throw new Exception("Der gewünschte User existiert nicht!");
    }

    /**
     * Funktionsweise: ersetzt alte Userdaten mit neuen, ruft Userdaten_aendern() auf wenn nicht null
     *
     * @return geänderte UserID
     * @throws Exception Wirft Exception, wenn UserID nicht vorhanden
     */
    public void User_aenderung(int UserID, String name, int alter, double groesse, String geschlecht, String training, String nahrung, double gewicht) throws Exception {
        try {
            UserDaten newuser = new UserDaten(name, alter, groesse, geschlecht, training, nahrung, gewicht);
            Datenbank.Userdaten_aendern(UserID, newuser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}