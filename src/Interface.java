public class Interface {
    /**
     * Klassenattribute der Klasse Interface
     */
    private double Kalorien_sollwert;
    private String Rezeptvorschläge;

    /**
     * Konstruktor der Klasse Interface
     *
     * @param kalorien_sollwert Sollwert der Kalorien
     * @param rezeptvorschläge  Rezeptvorschläge aus externer Datei
     */
    public Interface(double kalorien_sollwert, String rezeptvorschläge) {
        this.Kalorien_sollwert = kalorien_sollwert;
        this.Rezeptvorschläge = rezeptvorschläge;
    }

    /**
     * Standardkonstruktor der Klasse Interface
     */
    public Interface() {
    }

    /**
     * Get Methode für die Rezeptvorschläge
     *
     * @return Rezeptvorschläge                   gibt die passenden Rezeptvorschläge zurück
     */
    public String getRezeptvorschläge() {
        return Rezeptvorschläge;
    }

    /**
     * Set Methode für die Rezeptvorschläge
     *
     * @param rezeptvorschläge setzt Rezeptvorschläge auf eienen bestimmten Wert
     */
    public void setRezeptvorschläge(String rezeptvorschläge) {
        Rezeptvorschläge = rezeptvorschläge;
    }

    /**
     * Get Methode für den Kalorien_sollwert
     *
     * @return Kalorien_sollwert  gibt den Kaloriensollwert zurück
     */
    public double getKalorien_sollwert() {
        return Kalorien_sollwert;
    }

    /**
     * Set Methode für den Kaloriensollwert
     *
     * @param kalorien_sollwert Setzt den Kaloriensollwert auf einen bestimmten Wert
     */
    public void setKalorien_sollwert(double kalorien_sollwert) {
        Kalorien_sollwert = kalorien_sollwert;
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
    public void User_erstellen(String name, int alter, double groesse, String geschlecht, String training, String nahrung, double gewicht) {
        try {
            UserDaten User = new UserDaten(name, alter, groesse, geschlecht, training, nahrung, gewicht);
            Datenbank.UserListe.add(User);
        }catch (Exception e) {
            e.printStackTrace();

        }
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
        if (Datenbank.UserListe.size()>=UserID)
            return Datenbank.UserListe.get(UserID);
        else
            throw new Exception ("Der gewünschte User existiert nicht!");
    }

    /**
     * Funktionsweise: ersetzt alte Userdaten mit neuen, ruft Userdaten_aendern() auf wenn nicht null
     *
     *
     * @return geänderte UserID
     * @throws Exception Wirft Exception, wenn UserID nicht vorhanden
     */
   // public int User_änderung() throws Exception {
     // if (Datenbank.UserListe.get(UserID) != 0) {

      //} else
       //  throw new Exception("UserID existiert nicht");
    //}
}