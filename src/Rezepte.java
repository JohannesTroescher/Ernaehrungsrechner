public class Rezepte {

    private String art="null";

    public Rezepte(String art) {
        try {
            this.setArt(art);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Rezepte() {
        this.art="null";
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art)throws Exception {
        if(art=="normal" ||art=="vegetarisch"||art=="vegan")
            this.art = art;
        else
            throw new Exception("Bitte geben Sie einen gültigen Rezepttyp an!");
    }
}
