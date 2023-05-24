package Vue;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private JFrame frame;
    private MenuPrincipal menuPrincipal;


    public Application() {
        Dimension size = new Dimension(1400, 830);
        menuPrincipal = new MenuPrincipal();
        menuPrincipal.setBorder(BorderFactory.createEmptyBorder());
        menuPrincipal.setApplication(this);
        frame = new JFrame("Wargame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(menuPrincipal, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(size);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

