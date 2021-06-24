import java.awt.*;
import java.awt.event.*;

public class Gui extends Frame
{
    private TextField f1,f2,f3;
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
        panel.setLayout(new GridLayout(3,2, 10, 10));

        f1 = new TextField("0",10);
        f1.selectAll();
        panel.add(new Label(" Name"));
        panel.add(f1);

        f2 = new TextField("0",10);
        panel.add(new Label(" Alter"));
        panel.add(f2);

        f3 = new TextField("0",10);
        panel.add(new Label(" Gewicht"));
        panel.add(f3);
        add(panel);
        setVisible(true);
    }
}

