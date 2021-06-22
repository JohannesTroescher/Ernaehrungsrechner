import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RechnerProb {
    ArrayList<Rezepte> RezepteAusgabe = new ArrayList<Rezepte>();

    public void Rezeptsortierung(int UserID) throws Exception {
        double upperbound;
        double lowerbound;
        if (Datenbank.UserListe.get(UserID).getNahrungspraeferenz().equalsIgnoreCase("normal")) {
            Datenbank.Rezepte_dateiaufruf_normal();
            if (Datenbank.UserListe.get(UserID).getTrainingsziel().equalsIgnoreCase("Muskelaufbau")) {
                upperbound = Datenbank.UserListe.get(UserID).getGrundbedarf() + 100;
                lowerbound = Datenbank.UserListe.get(UserID).getGrundbedarf();
                for (int i = 0; i < Datenbank.RezepteNormalListe.size(); i++) {
                    if (Datenbank.RezepteNormalListe.get(i).getKalorien() <= upperbound && Datenbank.RezepteNormalListe.get(i).getKalorien() >= lowerbound) {
                        Rezepte copy = new Rezepte(Datenbank.RezepteNormalListe.get(i).getArt(), Datenbank.RezepteNormalListe.get(i).getProteine(), Datenbank.RezepteNormalListe.get(i).getKalorien(), Datenbank.RezepteNormalListe.get(i).getBeschreibung());
                        this.RezepteAusgabe.add(copy);
                    }
                }
            } else if (Datenbank.UserListe.get(UserID).getTrainingsziel().equalsIgnoreCase("Abnehmen")) {
                upperbound = Datenbank.UserListe.get(UserID).getGrundbedarf();
                lowerbound = Datenbank.UserListe.get(UserID).getGrundbedarf() - 100;
                for (int i = 0; i < Datenbank.RezepteNormalListe.size(); i++) {
                    if (Datenbank.RezepteNormalListe.get(i).getKalorien() <= upperbound && Datenbank.RezepteNormalListe.get(i).getKalorien() >= lowerbound) {
                        Rezepte copy = new Rezepte(Datenbank.RezepteNormalListe.get(i).getArt(), Datenbank.RezepteNormalListe.get(i).getProteine(), Datenbank.RezepteNormalListe.get(i).getKalorien(), Datenbank.RezepteNormalListe.get(i).getBeschreibung());
                        this.RezepteAusgabe.add(copy);
                    }
                }

            } else if (Datenbank.UserListe.get(UserID).getNahrungspraeferenz().equalsIgnoreCase("vegetarisch")) {
                Datenbank.Rezepte_dateiaufruf_vegetarisch();
                if (Datenbank.UserListe.get(UserID).getTrainingsziel().equalsIgnoreCase("Muskelaufbau")) {
                    upperbound = Datenbank.UserListe.get(UserID).getGrundbedarf() + 100;
                    lowerbound = Datenbank.UserListe.get(UserID).getGrundbedarf();
                    for (int i = 0; i < Datenbank.RezepteVegetarischListe.size(); i++) {
                        if (Datenbank.RezepteVegetarischListe.get(i).getKalorien() <= upperbound && Datenbank.RezepteVegetarischListe.get(i).getKalorien() >= lowerbound) {
                            Rezepte copy = new Rezepte(Datenbank.RezepteVegetarischListe.get(i).getArt(), Datenbank.RezepteVegetarischListe.get(i).getProteine(), Datenbank.RezepteVegetarischListe.get(i).getKalorien(), Datenbank.RezepteVegetarischListe.get(i).getBeschreibung());
                            this.RezepteAusgabe.add(copy);
                        }
                    }
                } else if (Datenbank.UserListe.get(UserID).getTrainingsziel().equalsIgnoreCase("Abnehmen")) {
                    upperbound = Datenbank.UserListe.get(UserID).getGrundbedarf();
                    lowerbound = Datenbank.UserListe.get(UserID).getGrundbedarf() - 100;
                    for (int i = 0; i < Datenbank.RezepteVegetarischListe.size(); i++) {
                        if (Datenbank.RezepteVegetarischListe.get(i).getKalorien() <= upperbound && Datenbank.RezepteVegetarischListe.get(i).getKalorien() >= lowerbound) {
                            Rezepte copy = new Rezepte(Datenbank.RezepteVegetarischListe.get(i).getArt(), Datenbank.RezepteVegetarischListe.get(i).getProteine(), Datenbank.RezepteVegetarischListe.get(i).getKalorien(), Datenbank.RezepteVegetarischListe.get(i).getBeschreibung());
                            this.RezepteAusgabe.add(copy);
                        }
                    }

                }

            } else if (Datenbank.UserListe.get(UserID).getNahrungspraeferenz().equalsIgnoreCase("vegan")) {
                Datenbank.Rezepte_dateiaufruf_vegan();
                if (Datenbank.UserListe.get(UserID).getTrainingsziel().equalsIgnoreCase("Muskelaufbau")) {
                    upperbound = Datenbank.UserListe.get(UserID).getGrundbedarf() + 100;
                    lowerbound = Datenbank.UserListe.get(UserID).getGrundbedarf();
                    for (int i = 0; i < Datenbank.RezepteVeganListe.size(); i++) {
                        if (Datenbank.RezepteVeganListe.get(i).getKalorien() <= upperbound && Datenbank.RezepteVeganListe.get(i).getKalorien() >= lowerbound) {
                            Rezepte copy = new Rezepte(Datenbank.RezepteVeganListe.get(i).getArt(), Datenbank.RezepteVeganListe.get(i).getProteine(), Datenbank.RezepteVeganListe.get(i).getKalorien(), Datenbank.RezepteVeganListe.get(i).getBeschreibung());
                            this.RezepteAusgabe.add(copy);
                        }
                    }
                } else if (Datenbank.UserListe.get(UserID).getTrainingsziel().equalsIgnoreCase("Abnehmen")) {
                    upperbound = Datenbank.UserListe.get(UserID).getGrundbedarf();
                    lowerbound = Datenbank.UserListe.get(UserID).getGrundbedarf() - 100;
                    for (int i = 0; i < Datenbank.RezepteVeganListe.size(); i++) {
                        if (Datenbank.RezepteVeganListe.get(i).getKalorien() <= upperbound && Datenbank.RezepteVeganListe.get(i).getKalorien() >= lowerbound) {
                            Rezepte copy = new Rezepte(Datenbank.RezepteVeganListe.get(i).getArt(), Datenbank.RezepteVeganListe.get(i).getProteine(), Datenbank.RezepteVeganListe.get(i).getKalorien(), Datenbank.RezepteVeganListe.get(i).getBeschreibung());
                            this.RezepteAusgabe.add(copy);
                        }
                    }

                }

            }
        }
    }
}