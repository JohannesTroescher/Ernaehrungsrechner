import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    private Datenbank db;
    private Rechner rechner;

    private JPanel Ernaehrungsrechner;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton bestaetigenButton;
    private JLabel uberschrift;
    private JLabel name;
    private JLabel alter;
    private JLabel gewicht;
    private JLabel grosse;
    private JLabel geschlecht;
    private JLabel ernaehrungsart;
    private JLabel trainingsziel;
    private JLabel userbereitsvorhanden;
    private JLabel kalorienverbrauch;

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
                    System.out.println((String) comboBox3.getSelectedItem());
                    UserDaten userDaten = new UserDaten(textField1.getText(),
                            Integer.parseInt(textField2.getText()), Double.parseDouble(textField4.getText()),
                            (String) comboBox1.getSelectedItem(), (String) comboBox3.getSelectedItem(),
                            (String) comboBox2.getSelectedItem(), Double.parseDouble(textField3.getText()));
                    db.Userdaten_einlesen(userDaten);
                    System.out.println(Datenbank.UserListe.get(0));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                //    public UserDaten(String name,int alter,double groesse,String geschlecht, String training,String nahrung,double gewicht)throws Exception{
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gui");
        Gui demo = new Gui();
        frame.setContentPane(demo.Ernaehrungsrechner);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        demo.setup();
    }

    public void setup() {
        db = new Datenbank();
        rechner = new Rechner();
    }

}
