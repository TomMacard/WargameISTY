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

    public void lancerJeu(int numberOfPlayers) {
        // Code pour lancer le jeu avec le nombre de joueurs sélectionné
        // Utilisez la variable numberOfPlayers pour initialiser le jeu avec le bon nombre de joueurs
        System.out.println("Lancer le jeu avec " + numberOfPlayers + " joueurs");
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

