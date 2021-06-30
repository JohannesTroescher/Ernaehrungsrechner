import java.awt.*;
import java.awt.event.*;

public class Gui extends Frame
{
    private TextField f1,f2,f3,f4;
    public class Fensterereignisse extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

    public void Fenster()
    {
        setTitle("Ernährungsrechner");
        setSize(720,440);
        addWindowListener(new Fensterereignisse());
        setLayout(new FlowLayout());
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(4,2,10,10));

        f1 = new TextField("0",20);
        panel.add(new Label(" Name"));
        panel.add(f1);

        f2 = new TextField("0",2);
        panel.add(new Label(" Alter"));
        panel.add(f2);

        f3 = new TextField("0",3);
        panel.add(new Label(" Gewicht"));
        panel.add(f3);

        f4 = new TextField("0",3);
        panel.add(new Label(" Größe"));
        panel.add(f4);
        add(panel);
        setVisible(true);

        Choice choice1 = new Choice();
        choice1.addItem("weiblich");
        choice1.addItem("männlich");
        this.add(choice1);

        Choice choice2 = new Choice();
        choice2.addItem("Normal");
        choice2.addItem("Vegetarisch");
        choice2.addItem("Vegan");
        this.add(choice2);

        Choice choice3 = new Choice();
        choice3.addItem("Abnehmen");
        choice3.addItem("Muskelaufbau");
        this.add(choice3);
    }
}