public class UserDaten {
    private String name= "null";
    private int alter=0;
    private double koerpergroesse=0.0;
    private String geschlecht="null";						//"männlich" oder "weiblich"
    private String trainingsziel="null";					//"Muskelaufbau" oder "Abnehmen"
    private double grundbedarf =0;
    private String nahrungspraeferenz="null";				//"normal", "vegetarisch" oder "vegan"
    private double gewicht=0;
    private long UserID=0;

    public UserDaten(String name,int alter,double groesse,String geschlecht, String training, int kalorien,String nahrung,double gewicht) {
        this.setName(name);
        try {
            this.setAlter(alter);
        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            this.setKoerpergroesse(groesse);
        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            this.setGeschlecht(geschlecht);
        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            this.setTrainingsziel(training);
        }catch(Exception e) {
            e.printStackTrace();
        }
        try{
            this.setGewicht(gewicht);
        } catch(Exception e){
            e.printStackTrace();
        }
        if(geschlecht=="männlich")
            this.grundbedarf=66.47+13.7*gewicht+5*groesse-6.8*alter;
        else if(geschlecht=="weiblich")
            this.grundbedarf=655.1+9.6*gewicht+1.8*groesse-4.7*alter;
        try {
            this.setNahrungspraeferenz(nahrung);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public UserDaten() {
        this.name="null";
        this.alter=0;
        this.koerpergroesse=0.0;
        this.geschlecht="null";
        this.trainingsziel="null";
        this.grundbedarf =0;
        this.nahrungspraeferenz="null";
        this.gewicht=0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAlter() {
        return alter;
    }
    public void setAlter(int alter) throws Exception {
        if(alter>0)
            this.alter = alter;
        else
            throw new Exception("Bitte wählen Sie ein gültiges Alter!");
    }
    public double getKoerpergroesse() {
        return koerpergroesse;
    }
    public void setKoerpergroesse(double koerpergroesse) throws Exception{
        if(koerpergroesse>0)
            this.koerpergroesse = koerpergroesse;
        else
            throw new Exception("Bitte wählen Sie eine gültige Körpergröße!");
    }
    public String getGeschlecht() {
        return geschlecht;
    }
    public void setGeschlecht(String geschlecht)throws Exception {				// Angabe des Geschlechts als "männlich" und "weiblich"?!
        if(geschlecht=="männlich"||geschlecht=="weiblich")
            this.geschlecht = geschlecht;
        else
            throw new Exception("Bitte wählen Sie ein Geschlecht (\"männlich\" oder \"weiblich\")!");
    }
    public String getTrainingsziel() {
        return trainingsziel;
    }
    public void setTrainingsziel(String trainingsziel) throws Exception {
        if(trainingsziel=="Muskelaufbau" ||trainingsziel=="Abnehmen")
            this.trainingsziel = trainingsziel;
        else
            throw new Exception("Bitte wählen Sie, ob sie Muskeln aufbauen oder abnehmen möchten!");
    }
    public double getGrundbedarf() {
        return grundbedarf;
    }
    public void setGewicht(double gewicht) throws Exception {
        if (gewicht > 1)
            this.gewicht = gewicht;
        else
            throw new Exception("Bitte geben Sie ein gültiges Gewicht ein!");
    }
    public double getGewicht(){
        return this.gewicht;
        }
    public void setGrundbedarf(int grundbedarf) throws Exception {
        if(grundbedarf >=0)
            this.grundbedarf = grundbedarf;
        else
            throw new Exception("Es dürfen keine negativen Werte angegeben werden!");
    }
    public String getNahrungspraeferenz() {
        return nahrungspraeferenz;
    }
    public void setNahrungspraeferenz(String nahrungspraeferenz) throws Exception{
        if(nahrungspraeferenz=="normal" ||nahrungspraeferenz=="vegetarisch"||nahrungspraeferenz=="vegan")
            this.nahrungspraeferenz = nahrungspraeferenz;
        else
            throw new Exception("Bitte geben Sie an, ob sie sich \"normal\", \"vegetarisch\" oder \"vegan\" ernähren!");
    }

}

