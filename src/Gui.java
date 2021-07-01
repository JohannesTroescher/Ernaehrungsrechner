import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    private Datenbank db;
    private Rechner rechner;

    private JPanel Ernährungsrechner;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton bestätigenButton;
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
        String box1[] = {"Weiblich","Männlich","Divers"};
        String box2[] = {"Normal","Vegetarisch","Vegan"};
        String box3[] = {"Abnehmen","Muskelaufbau"};
        bestätigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserDaten userDaten = new UserDaten(textField1.getText(),
                            Integer.parseInt(textField2.getText()), Double.parseDouble(textField3.getText()),
                            textField4.getText(), (String) comboBox1.getSelectedItem(),
                            (String) comboBox2.getSelectedItem(), (Double) comboBox3.getSelectedItem());
                    db.Userdaten_einlesen(userDaten);
                    System.out.println(Datenbank.UserListe.indexOf(0));
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
        frame.setContentPane(demo.Ernährungsrechner);
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
