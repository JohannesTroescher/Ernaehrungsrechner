public class Runner {
    public static void main(String[] args) {
        UserDaten Dieter= new UserDaten("Dieter Müller",36,1.87,"männlich","Muskelaufbau","normal",80);
        UserDaten Marianne= new UserDaten("Marianne Müller",35,1.87,"weiblich","Abnehmen","normal",50);
    System.out.println(Dieter.getGrundbedarf());
    System.out.println(Marianne.getGrundbedarf());
    System.out.println("Counter Daten: "+UserDaten.counter);
    }
}
