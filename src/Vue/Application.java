package Vue;

/*import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private JFrame frame;
    private MenuPrincipal menuPrincipal;


    public Application() {
        Dimension size = new Dimension(1400, 850);

        menuPrincipal = new MenuPrincipal();
        frame = new JFrame("Wargame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(size);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);
        frame.setLayout(new BorderLayout());
        frame.add(menuPrincipal, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1400, 850);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame("Wargame");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(new Dimension(1400, 850));
                    frame.setLayout(new BorderLayout());
                    frame.add(new MenuPrincipal(), BorderLayout.CENTER);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}*/

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private JFrame frame;
    private MenuPrincipal menuPrincipal;

    public Application() {
        Dimension size = new Dimension(1400, 830);

        menuPrincipal = new MenuPrincipal();
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Application application = new Application();
                    application.setSize(new Dimension(1400, 450));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

