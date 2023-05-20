package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;




public class MenuPrincipal extends JPanel implements ActionListener {


    private JButton nouvellePartieButton;
    private JButton reprendrePartieButton;
    private JButton aideButton;
    private JButton quitterButton;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private static final String MENU_PRINCIPAL = "menu_principal";
    private static final String AIDE_PANEL = "aide_panel";
    private AideInterface aideInterface;



    public MenuPrincipal() {
        initialize();
        cardLayout.show(cardPanel, MENU_PRINCIPAL);
    }

    public void initialize() {

        this.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel, BorderLayout.CENTER);
        aideInterface = new AideInterface(cardLayout, cardPanel);

        setLayout(new BorderLayout());

        /*Dimension size = new Dimension(1400, 850);
        JFrame frame = new JFrame("Wargame");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(size);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);*/


        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBackground(Color.WHITE);


        BufferedImage imagefond = null;
        try {
            imagefond = ImageIO.read(new File("C:/Users/Lenovo/Downloads/WARGAME/WargameISTY/src/images/arpl.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        CustomPanel panel = new CustomPanel(imagefond.getScaledInstance(1400, 850, imagefond.SCALE_SMOOTH)) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1400, 850);
            }
        };
        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel background = new JLabel(new ImageIcon(imagefond));
        this.add(background);
        background.setLayout(new FlowLayout());

        JPanel menuPrincipalPanel = new JPanel();
        menuPrincipalPanel.setLayout(new BorderLayout());


        nouvellePartieButton = new JButton("");
        nouvellePartieButton.setBounds(200,200,400,90);
        nouvellePartieButton.setBorder(new RoundBtn(25));
        nouvellePartieButton.setPreferredSize(new Dimension(540, 52));
        nouvellePartieButton.setBackground(new Color(199, 110, 37));
        nouvellePartieButton.setForeground(Color.BLACK);
        nouvellePartieButton.setFont(new Font("Arial", Font.BOLD, 20));
        nouvellePartieButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nouvellePartieButton.setOpaque(false);
        nouvellePartieButton.setContentAreaFilled(false);
        panel.add(nouvellePartieButton);

        reprendrePartieButton = new JButton("");
        reprendrePartieButton.setBounds(300,200,400,90);
        reprendrePartieButton.setBorder(new RoundBtn(25));
        reprendrePartieButton.setPreferredSize(new Dimension(540, 52));
        reprendrePartieButton.setBackground(new Color(199, 110, 37));
        reprendrePartieButton.setForeground(Color.BLACK);
        reprendrePartieButton.setFont(new Font("Arial", Font.BOLD, 20));
        reprendrePartieButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        reprendrePartieButton.setOpaque(false);
        reprendrePartieButton.setContentAreaFilled(false);
        panel.add(reprendrePartieButton);


        aideButton = new JButton("");
        aideButton.setBounds(300,200,400,90);
        aideButton.setBorder(new RoundBtn(25));
        aideButton.setPreferredSize(new Dimension(540, 52));
        aideButton.setBackground(new Color(199, 110, 37));
        aideButton.setForeground(Color.BLACK);
        aideButton.setFont(new Font("Arial", Font.BOLD, 20));
        aideButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aideButton.setOpaque(false);
        aideButton.setContentAreaFilled(false);
        panel.add(aideButton);

        quitterButton = new JButton("");
        quitterButton.setBounds(300,200,400,90);
        quitterButton.setBorder(new RoundBtn(25));
        quitterButton.setPreferredSize(new Dimension(540, 52));
        quitterButton.setBackground(new Color(155, 0, 0));
        quitterButton.setForeground(Color.BLACK);
        quitterButton.setFont(new Font("Arial", Font.BOLD, 20));
        quitterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitterButton.setOpaque(false);
        quitterButton.setContentAreaFilled(false);
        panel.add(quitterButton);

        sl_panel.putConstraint(SpringLayout.NORTH, nouvellePartieButton, 433, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, nouvellePartieButton, 440, SpringLayout.WEST, panel);

        sl_panel.putConstraint(SpringLayout.WEST, reprendrePartieButton, 0, SpringLayout.WEST, nouvellePartieButton);
        sl_panel.putConstraint(SpringLayout.SOUTH, reprendrePartieButton, 151, SpringLayout.NORTH, nouvellePartieButton);

        sl_panel.putConstraint(SpringLayout.WEST, aideButton, 0, SpringLayout.WEST, reprendrePartieButton);
        sl_panel.putConstraint(SpringLayout.SOUTH, aideButton, 145, SpringLayout.NORTH, reprendrePartieButton);

        sl_panel.putConstraint(SpringLayout.WEST, quitterButton, 0, SpringLayout.WEST, aideButton);
        sl_panel.putConstraint(SpringLayout.SOUTH, quitterButton, 146, SpringLayout.NORTH, aideButton);

        // Ajout de l'écouteur d'événements pour les boutons
        nouvellePartieButton.addActionListener(e -> System.out.println("Nouvelle partie"));
        reprendrePartieButton.addActionListener(e -> System.out.println("Reprendre partie"));
        aideButton.addActionListener(e -> System.out.println("aide"));
        quitterButton.addActionListener(e -> System.exit(0));

        /*frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);*/
        cardPanel = new JPanel(cardLayout) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1400, 850);
            }
        };
        add(cardPanel, BorderLayout.CENTER);
        aideInterface = new AideInterface(cardLayout, cardPanel);


        cardPanel.add(aideInterface, AIDE_PANEL);

        aideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, AIDE_PANEL);
            }
        });

        menuPanel.add(panel);
        cardPanel.add(menuPanel, MENU_PRINCIPAL);



    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nouvellePartieButton) {
            // Code pour démarrer une nouvelle partie
            System.out.println("Nouvelle partie");
        } else if (e.getSource() == reprendrePartieButton) {
            // Code pour reprendre une partie enregistrée
            System.out.println("Reprendre partie");
        } else if (e.getSource() == aideButton) {
            // Code pour afficher l'aide du jeu
            System.out.println("aide");

            cardLayout.show(cardPanel, "aide");
            //mainFrame.showAidePanel();
        } else if (e.getSource() == quitterButton) {
            // Code pour quitter le jeu
            System.out.println("Quitter");
            System.exit(0);
        }

    }

}

