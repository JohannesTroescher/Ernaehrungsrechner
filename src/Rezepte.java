public class Rezepte {

    private String art="null";
    private double kalorien=0;

    public Rezepte(String art,double kalorien) {
        try {
            this.setArt(art);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            this.setKalorien(kalorien);
        } catch(Exception e){
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
    public void setKalorien(double Kalorien) throws Exception{
        if(kalorien>1)
            this.kalorien=kalorien;
        else
            throw new Exception("Bitte geben Sie einen gültigen Kalorienwert an!");
    }
    public double getKalorien(){
        return this.kalorien;
    }
}
