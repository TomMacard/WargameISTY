package Vue;

import Model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;


public class NouvellePartieInterface extends JPanel {

    private JButton boutonRetour;
    private CardLayout gestionnaireCartes;
    private JPanel panneauCartes;
    private Application application;
    private JPanel panneauContenu;
    public int nombreJoueurs;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    public List<Joueur> joueurs;
    private List<JTextField> textFields;
    private JButton lancerJeuBouton;
    private JLabel background;
    private JLabel background2;
    private JLabel nomJoueur;
    private JPanel champHexagonesPanel;
    private JLabel imageJeuLabel;
    private JLabel caracteristiqueUnite1;
    private JLabel caracteristiqueUnite2;
    private JLabel caracteristiqueUnite3;
    private JLabel caracteristiqueUnite4;
    private JLabel caracteristiqueUnite5;
    private Jeu jeu;
    private JTextArea textArea_debug;
    private JTextArea textArea;




    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public int getNombreJoueurs() {
        return nombreJoueurs;
    }

    public void setNombreJoueurs(int nombreJoueurs) {
        this.nombreJoueurs = nombreJoueurs;
    }


    public NouvellePartieInterface(CardLayout gestionnaireCartes, JPanel panneauCartes, Application application) {
        this.gestionnaireCartes = gestionnaireCartes;
        this.panneauCartes = panneauCartes;
        this.application = application;
        this.cardLayout = gestionnaireCartes;
        this.cardPanel = panneauCartes;
        textFields = new ArrayList<>();
        lancerJeuBouton = new JButton("Lancer partie");

        initialiser();
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void initialiser() {
        setLayout(new BorderLayout());

        JLayeredPane panneauPrincipal = new JLayeredPane();
        panneauPrincipal.setPreferredSize(new Dimension(1350, 850));

        panneauContenu = new JPanel();
        SpringLayout sl_panneauContenu = new SpringLayout();
        panneauContenu.setLayout(sl_panneauContenu);
        panneauContenu.setOpaque(false);

        JLabel titreLabel = new JLabel("");
        titreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panneauContenu.add(titreLabel);

        JLabel aideLabel = new JLabel("");
        aideLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panneauContenu.add(aideLabel);

        String[] options = {"2 joueurs", "3 joueurs", "4 joueurs"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        panneauContenu.add(comboBox);
        comboBox.setBounds(630, 530, 150, 50);
        panneauPrincipal.add(comboBox, JLayeredPane.PALETTE_LAYER);

        JButton confirmerBouton = new JButton("");
        panneauContenu.add(confirmerBouton);
        confirmerBouton.setBounds(635, 715, 150, 50);
        panneauPrincipal.add(confirmerBouton, JLayeredPane.PALETTE_LAYER);
        confirmerBouton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmerBouton.setOpaque(false);
        confirmerBouton.setContentAreaFilled(false);
        confirmerBouton.setForeground(Color.BLACK);
        confirmerBouton.setBorder(new RoundBtn(25));


        panneauContenu.setBounds(0, 0, 1400, 830);  // Set the position and size to match the image
        panneauPrincipal.add(panneauContenu, JLayeredPane.PALETTE_LAYER);

        BufferedImage fiche = null;
        try {
            fiche = ImageIO.read(new File("src/images/nouvellePartie.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }


        background = new JLabel(new ImageIcon(fiche));
        background.setSize(1400, 830);

        panneauPrincipal.add(background, JLayeredPane.DEFAULT_LAYER);

        add(panneauPrincipal, BorderLayout.CENTER);


        panneauContenu.add(lancerJeuBouton);
        lancerJeuBouton.setVisible(false);
        lancerJeuBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createChampHexagones();
                cardLayout.show(cardPanel, "champ_hexagones");
                joueurs = new ArrayList<Joueur>();
            }
        });

        joueurs = new ArrayList<Joueur>();

        sl_panneauContenu.putConstraint(SpringLayout.HORIZONTAL_CENTER, titreLabel, 0, SpringLayout.HORIZONTAL_CENTER, panneauContenu);
        sl_panneauContenu.putConstraint(SpringLayout.NORTH, titreLabel, 20, SpringLayout.NORTH, panneauContenu);

        sl_panneauContenu.putConstraint(SpringLayout.HORIZONTAL_CENTER, aideLabel, 0, SpringLayout.HORIZONTAL_CENTER, panneauContenu);
        sl_panneauContenu.putConstraint(SpringLayout.NORTH, aideLabel, 40, SpringLayout.SOUTH, titreLabel);

        sl_panneauContenu.putConstraint(SpringLayout.HORIZONTAL_CENTER, comboBox, 0, SpringLayout.HORIZONTAL_CENTER, panneauContenu);
        sl_panneauContenu.putConstraint(SpringLayout.NORTH, comboBox, 20, SpringLayout.SOUTH, aideLabel);

        sl_panneauContenu.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmerBouton, 0, SpringLayout.HORIZONTAL_CENTER, panneauContenu);
        sl_panneauContenu.putConstraint(SpringLayout.NORTH, confirmerBouton, 20, SpringLayout.SOUTH, comboBox);

        sl_panneauContenu.putConstraint(SpringLayout.HORIZONTAL_CENTER, lancerJeuBouton, 0, SpringLayout.HORIZONTAL_CENTER, panneauContenu);
        sl_panneauContenu.putConstraint(SpringLayout.NORTH, lancerJeuBouton, 628, SpringLayout.SOUTH, comboBox);

        lancerJeuBouton.setAlignmentX(Component.CENTER_ALIGNMENT);
        lancerJeuBouton.setOpaque(false);
        lancerJeuBouton.setContentAreaFilled(false);
        lancerJeuBouton.setForeground(Color.BLACK);
        lancerJeuBouton.setBorder(new RoundBtn(25));

        JPanel panneauBouton = new JPanel();
        panneauBouton.setLayout(new BorderLayout());

        lancerJeuBouton.setVisible(false);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String optionSelectionnee = (String) comboBox.getSelectedItem();
            }
        });

        confirmerBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Supprime l'image de fond précédente
                panneauPrincipal.remove(background);
                BufferedImage fiche2 = null;
                try {
                    fiche2 = ImageIO.read(new File("src/images/lancerPartie.png"));
                } catch (IOException exception) {
                    exception.printStackTrace();
                    System.exit(-1);
                }
                background2 = new JLabel(new ImageIcon(fiche2));
                //JLabel background = new JLabel(new ImageIcon(fiche));
                background2.setSize(1400, 830);
                panneauPrincipal.add(background2, JLayeredPane.DEFAULT_LAYER);

                // Créer un nouveau JPanel pour les JTextField et le bouton lancerJeuBouton
                JPanel textFieldPanel = new JPanel(new GridBagLayout());
                textFieldPanel.setOpaque(false);
                textFieldPanel.setBounds(0, 80, 1400, 830);  // Set the position and size to match the image
                panneauPrincipal.add(textFieldPanel, JLayeredPane.POPUP_LAYER);  // Add this to a higher layer

                add(panneauPrincipal, BorderLayout.CENTER);

                String optionSelectionnee = (String) comboBox.getSelectedItem();
                nombreJoueurs = Integer.parseInt(optionSelectionnee.split(" ")[0]);
                creerChampsNomJoueurs(textFieldPanel);  // Pass textFieldPanel as argument

                titreLabel.setVisible(false);
                comboBox.setVisible(false);
                aideLabel.setVisible(false);
                confirmerBouton.setVisible(false);
                lancerJeuBouton.setVisible(true);


                // Redessine le panneauPrincipal pour s'assurer que les modifications sont visibles
                panneauPrincipal.revalidate();
                panneauPrincipal.repaint();
            }
        });


        boutonRetour = new JButton("Retour");
        boutonRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestionnaireCartes.show(panneauCartes, "menu_principal");
            }
        });
        boutonRetour.setBackground(Color.RED);
        panneauContenu.add(boutonRetour, BorderLayout.SOUTH);

        panneauPrincipal.add(panneauBouton, BorderLayout.SOUTH);

        add(panneauPrincipal, BorderLayout.CENTER);

        cardPanel = panneauCartes;
        createChampHexagones();

        panneauBouton.setOpaque(false);

    }

    private void creerChampsNomJoueurs(JPanel textFieldPanel) {
        supprimerTousChampsNomJoueurs();
        joueurs = new ArrayList<>();
        JPanel panneauNomJoueurs = new JPanel(new GridLayout(nombreJoueurs, 1));
        panneauNomJoueurs.setOpaque(false);
        Color[] couleurs = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK};

        for (int i = 1; i <= nombreJoueurs; i++) {
            JLabel label = new JLabel("Joueur " + i + ":");
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(260, 48));
            textFields.add(textField);

            JPanel panneauTextField = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panneauTextField.setOpaque(false); // Assurez-vous que le panneau est transparent
            panneauTextField.add(label);
            panneauTextField.add(textField);
            int indexCouleur = (i - 1) % couleurs.length;
            panneauNomJoueurs.add(panneauTextField);

            textField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String nomJoueur = textField.getText();
                    Color couleurJoueur = couleurs[indexCouleur];

                    Joueur joueur = new Joueur(new ArrayList<>(), false, nomJoueur, couleurJoueur);
                    joueurs.add(joueur);

                    // Désactivez le champ de texte une fois que le joueur a soumis son nom
                    textField.setEnabled(false);
                }
            });
        }

        // Ajoutez le panneau des noms des joueurs au panneau des champs de texte
        textFieldPanel.add(panneauNomJoueurs);

        // Redessinez le panneau des champs de texte pour s'assurer que les modifications sont visibles
        textFieldPanel.revalidate();
        textFieldPanel.repaint();
    }



    private void supprimerTousChampsNomJoueurs() {
        Component[] composants = panneauContenu.getComponents();
        for (Component composant : composants) {
            if (composant instanceof JPanel) {
                panneauContenu.remove(composant);
            }
        }
    }



    private void createChampHexagones() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1400, 830));

        Plateau plateau = new Plateau(VariablesGlobales.X_MAX, VariablesGlobales.Y_MAX, this);
        plateau.setBounds(0, 0, 1400, 830);

        nomJoueur = new JLabel("Tour du joueur 1 ");
        nomJoueur.setFont(new Font("Arial", Font.BOLD, 30));
        nomJoueur.setBounds(955, 4, 370, 80);

        BufferedImage imageJeu = null;
        try {
            imageJeu = ImageIO.read(new File("src/images/barreFinale.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imageJeuLabel = new JLabel(new ImageIcon(imageJeu));
        imageJeuLabel.setBounds(900, 0, 550, 830);

        caracteristiqueUnite1 = new JLabel("  " + uniteBassem.getAttaque()
                + "    " + uniteBassem.getDefense()
                + "    " + uniteBassem.getUnitePVCourant()
                + "    " + uniteBassem.getDeplacement()
                + "    " + uniteBassem.getVision());
        caracteristiqueUnite1.setBounds(1000, 150, 370, 80);
        caracteristiqueUnite1.setFont(new Font("Arial", Font.BOLD, 40));

        caracteristiqueUnite2 = new JLabel("   " + uniteFadi.getAttaque()
                + "     " + uniteFadi.getDefense()
                + "    " + uniteFadi.getPVmax()
                + "    " + uniteFadi.getDeplacement()
                + "    " + uniteFadi.getVision());
        caracteristiqueUnite2.setBounds(1000, 215, 370, 80);
        caracteristiqueUnite2.setFont(new Font("Arial", Font.BOLD, 40));


        caracteristiqueUnite3 = new JLabel("   " + uniteDhia.getAttaque()
                + "     " + uniteDhia.getDefense()
                + "    " + uniteDhia.getPVmax()
                + "   " + uniteDhia.getDeplacement()
                + "   " + uniteDhia.getVision());
        caracteristiqueUnite3.setBounds(1000, 287, 370, 80);
        caracteristiqueUnite3.setFont(new Font("Arial", Font.BOLD, 40));


        caracteristiqueUnite4 = new JLabel("   " + uniteTom.getAttaque()
                + "     " + uniteTom.getDefense()
                + "    " + uniteTom.getPVmax()
                + "    " + uniteTom.getDeplacement()
                + "    " + uniteTom.getVision());
        caracteristiqueUnite4.setBounds(1000, 357, 370, 80);
        caracteristiqueUnite4.setFont(new Font("Arial", Font.BOLD, 40));

        caracteristiqueUnite5 = new JLabel("   " + uniteMostafa.getAttaque()
                + "     " + uniteMostafa.getDefense()
                + "    " + uniteMostafa.getPVmax()
                + "    " + uniteMostafa.getDeplacement()
                + "    " + uniteMostafa.getVision());
        caracteristiqueUnite5.setBounds(1000, 427, 370, 80);
        caracteristiqueUnite5.setFont(new Font("Arial", Font.BOLD, 40));

        JButton FinTour = new JButton("");
        FinTour.setBounds(1080, 700, 190, 90);
        FinTour.setAlignmentX(Component.CENTER_ALIGNMENT);
        FinTour.setOpaque(false);
        FinTour.setContentAreaFilled(false);
        FinTour.setForeground(Color.BLACK);
        FinTour.setBorder(new RoundBtn(25));




        champHexagonesPanel = new JPanel(new BorderLayout());
        champHexagonesPanel.setOpaque(false);
        champHexagonesPanel.add(layeredPane, BorderLayout.CENTER);

        cardPanel.add(champHexagonesPanel, "champ_hexagones");

        Color[] couleurs = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK};

        lancerJeuBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                joueurs = new ArrayList<>();

                for (JTextField textField : textFields) {
                    String nomJoueurText = textField.getText();
                    int indexJoueur = textFields.indexOf(textField);
                    Color couleurJoueur = couleurs[indexJoueur];
                    Joueur joueur = new Joueur(new ArrayList<>(), false, nomJoueurText, couleurJoueur);
                    joueurs.add(joueur);
                    jeu = new Jeu(plateau, joueurs);
                }
                if (!joueurs.isEmpty()) {
                    nomJoueur.setText("Tour du joueur : " + joueurs.get(0).getJoueurNom());
                }
            }
        });

        FinTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jeu != null) {
                    System.out.println("Fin du tour");
                    jeu.jeuBouclePrincipale();
                    nomJoueur.setText("Tour : " + jeu.getJeuJoueurActuel().getJoueurNom());
                    nomJoueur.revalidate();

                } else {
                    System.out.println("Le jeu n'est pas encore commencé !");
                    // Vous pouvez également montrer un message à l'utilisateur ici
                }
            }
        });

        textArea = new JTextArea("This is a JTextArea");
        textArea.setBounds(970, 510, 410, 170);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        CustomOutputStream cos = new CustomOutputStream(textArea);
        PrintStream printStream = new PrintStream(cos);
        System.setOut(printStream);

        layeredPane.add(textArea, JLayeredPane.POPUP_LAYER);


        nomJoueur.setFont(new Font("Arial", Font.BOLD, 30));
        nomJoueur.setBounds(955, 4, 370, 80);

        layeredPane.add(plateau, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(imageJeuLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(nomJoueur, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite1, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite2, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite3, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite4, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite5, JLayeredPane.POPUP_LAYER);
        layeredPane.add(FinTour, JLayeredPane.POPUP_LAYER);


    }

}