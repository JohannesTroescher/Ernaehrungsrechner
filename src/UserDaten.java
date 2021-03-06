import java.io.Serializable;

public class UserDaten implements Serializable {
    /**
     *  Klassenattribute der Klasse UserDaten
     * @author  J.Bamboschek und J.Hofmann
     * @version 1.1
     */
    private String name= "null";
    private int alter=0;
    private double koerpergroesse=0.0;
    private String geschlecht="null";
    private String trainingsziel="null";
    private double grundbedarf =0;
    private String nahrungspraeferenz="null";
    private double gewicht=0;
    private int UserID;
    static int counter=0;
    /**                     Konstruktor UserDaten
     *                      Erzeugt Objekt vom Typ UserID: Hierbei wird der Grundbedarf direkt, in abhängigkeit des Geschlechts, berechnet
     * @param name          Name des Nutzers
     * @param alter         Alter des Nutzers
     * @param groesse       Groeße des Nutzers [cm]
     * @param geschlecht    Geschlecht Alter des Nutzers ["männlich"/"weiblich"]
     * @param training      Gewünschter Modus: Abnehmen/Muskelaufbau
     * @param nahrung       Gewünsche Nahrungsart: ["normal", "vegetarisch", "vegan"]
     * @param gewicht       Gewicht Alter des Nutzers [kg]
     */
    public UserDaten(String name,int alter,double groesse,String geschlecht, String training,String nahrung,double gewicht)throws Exception{
        this.setName(name);
        this.setAlter(alter);
        this.setKoerpergroesse(groesse);
        this.setGeschlecht(geschlecht);
        this.setTrainingsziel(training);
        this.setGewicht(gewicht);
        if(geschlecht.equalsIgnoreCase("männlich"))
            this.grundbedarf=Math.round(66.47+13.7*gewicht+5*groesse-6.8*alter);
        else if(geschlecht.equalsIgnoreCase("weiblich"))
            this.grundbedarf=Math.round(655.1+9.6*gewicht+1.8*groesse-4.7*alter);
        this.setNahrungspraeferenz(nahrung);
        UserID=counter;
        counter=counter+1;

    }

    /**             To-String Methode
     * @return      Gibt Attribute als String zurück
     */
    @Override
    public String toString(){
        return "User: " + this.getName() + ", " + this.getAlter()+ " Jahre" + ", "+ this.getKoerpergroesse()+ "cm" + ", "+ this.getGeschlecht() + ", "+ this.getTrainingsziel() + ", "+ "Nahrungspraeferenz: "+ this.getNahrungspraeferenz() + ", "+ this.getGewicht()+ "kg";
    }
    /**     Standardkonstruktor:
     *      Setzt alle Werte auf 0 bzw. "null", der Grundbedarf des Patienten wird hierbei nicht berechnet!
     */
    public UserDaten() {
        this.name="null";
        this.alter=0;
        this.koerpergroesse=0.0;
        this.geschlecht="null";
        this.trainingsziel="null";
        this.grundbedarf =0;
        this.nahrungspraeferenz="null";
        this.gewicht=0;
        UserID=counter;
        counter=counter+1;
    }
    /**             Get-Methode für den Namen
     * @return      gibt den Namen zurück
     */
    public String getName() {
        return name;
    }

    /**                 Set-Methode für den Namen
     *                  Setzt das Attribut "name" auf den eingegebenen Wert
     * @param name      Gewünschter Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**         Get-Methode für das Alter
     * @return  Gibt das Alter zurück
     */
    public int getAlter() {
        return alter;
    }

    /**                     Set-Methode für das Alter
     *                      Setzt das Attribut "alter" auf den eingegebenen Wert
     * @param alter         Gewünschter Wert
     * @throws Exception    Wirf Exception, wenn eingabe von "0" oder einem negativen Alter
     */
    public void setAlter(int alter) throws Exception {
        if(alter>0)
            this.alter = alter;
        else
            throw new Exception("Bitte wählen Sie ein gültiges Alter!");
    }

    /**             Get-Methode für die Körpergröße
     * @return      Gibt die Körpergröße zurück
     */
    public double getKoerpergroesse() {
        return koerpergroesse;
    }

    /**                         Set-Methode für die Körpergröße
     *                          Setzt das Attribut "groesse" auf den gewünschten Wert, in [cm]
     * @param koerpergroesse    Gewünschter Wert
     * @throws Exception        Wirft Exception, wenn eingegebene Größe "0" oder negativ ist
     */
    public void setKoerpergroesse(double koerpergroesse) throws Exception{
        if(koerpergroesse>0)
            this.koerpergroesse = koerpergroesse;
        else
            throw new Exception("Bitte wählen Sie eine gültige Körpergröße!");
    }

    /**             Get-Methode für das Geschlecht
     * @return      Gibt das Geschlecht zurück
     */
    public String getGeschlecht() {
        return geschlecht;
    }

    /**                     Set-Methode für das Geschlecht
     *                      Setzt das Attribut "geschlecht" auf den gewünschten Wert
     * @param geschlecht    Gewünschter Wert
     * @throws Exception    Wirft Exception, wenn das gewünschte Geschlecht nicht "männlich" oder "weiblich" ist
     */
    public void setGeschlecht(String geschlecht)throws Exception {

        if(geschlecht.equalsIgnoreCase("männlich")||geschlecht.equalsIgnoreCase("weiblich"))
            this.geschlecht = geschlecht;
        else
            throw new Exception("Bitte wählen Sie ein Geschlecht (\"männlich\" oder \"weiblich\")!");
    }

    /**             Get-Methode für das Trainingsziel
     * @return      Gibt Trainingsziel zurück
     */
    public String getTrainingsziel() {
        return trainingsziel;
    }

    /**                         Set-Methode für das Trainingsziel
     *                          Setzt das Attribut "trainingsziel" auf den gewünschten Wert
     * @param trainingsziel     Das gewünschte Trainingsziel
     * @throws Exception        Wirf Exception, wenn das Trainingsziel nicht "Muskelaufbau" oder "Abnehmen" ist
     */
    public void setTrainingsziel(String trainingsziel) throws Exception {
        if(trainingsziel.equalsIgnoreCase("Muskelaufbau")||trainingsziel.equalsIgnoreCase("Abnehmen"))
            this.trainingsziel = trainingsziel;
        else
            throw new Exception("Bitte wählen Sie, ob sie Muskeln aufbauen oder abnehmen möchten!");
    }

    /**                     Set-Methode für das Gewicht
     *                      Setzt das Attribut "gewicht" auf gewünschten Wert, in [kg]
     * @param gewicht       Gewünschtes Gewicht
     * @throws Exception    Wirft Exception, wenn das Gewicht "0" oder negativ ist
     */
    public void setGewicht(double gewicht) throws Exception {
        if (gewicht > 0)
            this.gewicht = gewicht;
        else
            throw new Exception("Bitte geben Sie ein gültiges Gewicht ein!");
    }

    /**             Get-Methode für das Gewicht
     * @return      Gibt das Gewicht zurück
     */
    public double getGewicht(){
        return this.gewicht;
        }
    /**             Get-Methode für Grundbedarf
     * @return      Gibt den Grundbedarf zurück
     */
    public double getGrundbedarf() {
        return grundbedarf;
    }

    /**                     Set-Methode für Grundbedarf, damit dieser nachträglich geändert werden kann
     *                      Wird bei der erzeugung eines Objektes mit dem Standardkonstruktor benötigt, um den Grundbedarf festzulegen
     *                      Das Attribut "grundbedarf" wird auf den gewünschten Wert gesetzt
     * @param grundbedarf   Der gewünschte Grundbedarf
     * @throws Exception    Wirft Exception, wenn der Grundbedarf "0" oder negativ ist
     */
    public void setGrundbedarf(double grundbedarf) throws Exception {
        if(grundbedarf >0)
            this.grundbedarf = grundbedarf;
        else
            throw new Exception("Es dürfen keine negativen Werte angegeben werden!");
    }

    /**             Get-Methode für Nahrungspräferenz
     * @return      Gibt die Nahrungspräferenz zurück
     */
    public String getNahrungspraeferenz() {
        return nahrungspraeferenz;
    }

    /**                             Set-Methode für die Nahrungspräferenz
     *                              Setzt das Attribut "nahrungspraeferenz" auf den gewünschten Wert
     * @param nahrungspraeferenz    Die gewünschte Nahrungsart
     * @throws Exception            Wirft Exception, wenn die Nahrungspräferenz nicht "normal", "vegetarisch" oder "vegan" ist.
     */
    public void setNahrungspraeferenz(String nahrungspraeferenz) throws Exception{
        if(nahrungspraeferenz.equalsIgnoreCase("normal")||nahrungspraeferenz.equalsIgnoreCase("vegetarisch")||nahrungspraeferenz.equalsIgnoreCase("vegan"))
            this.nahrungspraeferenz = nahrungspraeferenz;
        else
            throw new Exception("Bitte geben Sie an, ob sie sich \"normal\", \"vegetarisch\" oder \"vegan\" ernähren!");
    }

    /**             Get-Methode für die individuelle UserID
     * @return      Gibt UserID zurück
     */
    public int getUserID(){
        return UserID;
    }

    /**                     Set-Methode für User-ID
     *                      Setzt das Attribut "UserID" auf den gewünschten Wert
     *                      Wird benötigt, damit bei Änderung eines Users seine alte User-ID beibehalten
     *                      werden kann, sowie der counter wieder reduziert wird, da bei jeder "Änderung"
     *                      eines Users ein neuer User erstellt wird, und der Speicherplatz des alten Users
     *                      innerhalb der Datenbank überschrieben wird (vgl. Datenbank "UserDaten_aendern")
     * @param UserID        Gewünschter Wert
     * @throws Exception    Wirft Exception, bei Eingabe von negativen Zahlenwerten
     */
    public void setUserID(int UserID)throws Exception{
        if(UserID>=0) {
            this.UserID = UserID;
            counter =counter- 1;
        }else
            throw new Exception("Negative UserID nicht gestattet!");
    }
}

