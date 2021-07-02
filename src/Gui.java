import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klassenattribute der Klasse Gui
 *
 * @author J. Kusmat, F.Hahn
 * @version 2.0
 */
public class Gui {

    private UserDaten activeUser;
    private Rechner rechner;

    private JPanel Ernaehrungsrechner;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JButton bestaetigenButton;
    private JLabel uberschrift;
    private JLabel name;
    private JLabel alter;
    private JLabel grosse;
    private JLabel gewicht;
    private JLabel geschlecht;
    private JLabel ernaehrungsart;
    private JLabel trainingsziel;
    private JLabel userbereitsvorhanden;
    private JLabel kalorienverbrauch;
    private JButton bestaetigenButton2;
    private JLabel textField7;
    private JLabel gesamtkalorien;
    private JTextArea tollerezepte;
    private JButton berechnebutton;

    public Gui() {

        comboBox1.addItem("Weiblich");
        comboBox1.addItem("Männlich");
        comboBox1.addItem("Divers");

        comboBox2.addItem("Normal");
        comboBox2.addItem("Vegetarisch");
        comboBox2.addItem("Vegan");

        comboBox3.addItem("Abnehmen");
        comboBox3.addItem("Muskelaufbau");

        bestaetigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    activeUser = new UserDaten(textField1.getText(),
                            Integer.parseInt(textField2.getText()), Double.parseDouble(textField4.getText()),
                            (String) comboBox1.getSelectedItem(), (String) comboBox3.getSelectedItem(),
                            (String) comboBox2.getSelectedItem(), Double.parseDouble(textField3.getText()));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                Datenbank.Userdaten_einlesen(activeUser);
                Datenbank.saveUserListe(Datenbank.UserListe);
                textField7.setText("Deine UserID lautet: " + Datenbank.UserListe.indexOf(activeUser));

                rezepte();
            }
        });

        bestaetigenButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println(textField5.getText());
                    activeUser = Datenbank.UserListe.get(Integer.parseInt(textField5.getText()));
                    System.out.println(activeUser);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                rezepte();
            }
        });

        berechnebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rechner.setKalorienverbrauch(Double.parseDouble(textField6.getText()));
                    gesamtkalorien.setText(rechner.Rechneroperation(Datenbank.UserListe.indexOf(activeUser)) + " kcal");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public void rezepte() {
        String nahrung = activeUser.getNahrungspraeferenz();
        if (activeUser.getTrainingsziel().equalsIgnoreCase("Muskelaufbau")) {
            switch (nahrung) {
                case "Normal":
                    tollerezepte.setText(Rechner.RezepteNormalProteinhaltig.toString());
                    break;
                case "Vegetarisch":
                    tollerezepte.setText(Rechner.RezepteVegetarischProteinhaltig.toString());
                    break;
                case "Vegan":
                    tollerezepte.setText(Rechner.RezepteVeganProteinhaltig.toString());
                    break;
                default:
                    break;
            }
        } else {
            switch (nahrung) {
                case "Normal":
                    tollerezepte.setText(Rechner.RezepteNormalProteinarm.toString());
                    break;
                case "Vegetarisch":
                    tollerezepte.setText(Rechner.RezepteVegetarischProteinarm.toString());
                    break;
                case "Vegan":
                    tollerezepte.setText(Rechner.RezepteVeganProteinarm.toString());
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Ernährungsrechner");
        Gui demo = new Gui();
        frame.setContentPane(demo.Ernaehrungsrechner);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Datenbank.loadUserListe();
        demo.rechner = new Rechner();
        demo.rechner.RezeptsortierungNormal();
        demo.rechner.RezeptsortierungVegan();
        demo.rechner.RezeptsortierungVegetarisch();
    }
}