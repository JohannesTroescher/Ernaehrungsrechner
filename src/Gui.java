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

    public Gui()
    {
        setTitle("Ernährungsrechner");
        setSize(720,720);
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
        setVisible(true);

        f4 = new TextField("0",3);
        panel.add(new Label(" Größe"));
        panel.add(f4);
        add(panel);
        setVisible(true);

        Choice choice = new Choice();
        choice.addItem("weiblich");
        choice.addItem("männlich");
        this.add(choice);

    }
}

