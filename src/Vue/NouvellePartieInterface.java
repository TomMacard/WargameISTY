package Vue;

import Model.Plateau;
import Model.Unite;
import Model.VariablesGlobales;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import Model.Joueur;
import Model.uniteTom;
import Model.uniteDhia;
import Model.uniteBassem;
import Model.uniteFadi;
import Model.uniteMostafa;


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

                System.out.println("Liste des joueurs :");
                for (Joueur joueur : joueurs) {
                    System.out.println(joueur.getJoueurNom());
                }
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

        //sl_panneauContenu.putConstraint(SpringLayout.HORIZONTAL_CENTER, numeroJoueur, 0, SpringLayout.HORIZONTAL_CENTER, panneauContenu);
        //sl_panneauContenu.putConstraint(SpringLayout.NORTH, numeroJoueur, 628, SpringLayout.SOUTH, comboBox);

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
                // Faites quelque chose avec l'option sélectionnée (par exemple, afficher un message)
                System.out.println("Option sélectionnée : " + optionSelectionnee);
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

        JPanel panneauNomJoueurs = new JPanel(new GridLayout(nombreJoueurs, 1));
        panneauNomJoueurs.setOpaque(false); // Assurez-vous que le panneau est transparent

        for (int i = 1; i <= nombreJoueurs; i++) {
            JLabel label = new JLabel("Joueur " + i + ":");
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(260, 48));
            textFields.add(textField);

            JPanel panneauTextField = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panneauTextField.setOpaque(false); // Assurez-vous que le panneau est transparent
            panneauTextField.add(label);
            panneauTextField.add(textField);

            panneauNomJoueurs.add(panneauTextField);

            textField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String nomJoueur = textField.getText();

                    // Ajoutez la logique pour gérer la couleur du joueur ici
                    // Par exemple, vous pourriez assigner une couleur prédéfinie basée sur l'index du joueur
                    Color couleurJoueur = Color.BLACK;

                    // Ajoutez la logique pour stocker le nom et la couleur du joueur
                    // Par exemple, vous pourriez ajouter le nom et la couleur à des listes
                    Joueur joueur = new Joueur(new ArrayList<>(), false, nomJoueur, couleurJoueur);
                    joueurs.add(joueur);

                    System.out.println("Liste des joueurs :");
                    for (Joueur j : joueurs) {
                        System.out.println(j.getJoueurNom());
                    }

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

        BufferedImage imageJeu = null;
        try {
            imageJeu = ImageIO.read(new File("src/images/barreFinale.png"));
            System.out.println("Image chargée : " + imageJeu);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imageJeuLabel = new JLabel(new ImageIcon(imageJeu));
        imageJeuLabel.setBounds(900, 0, 550, 830);

        if (!joueurs.isEmpty()) {
            nomJoueur = new JLabel("Tour du joueur : " + joueurs.get(0).getJoueurNom());
        } else {
            nomJoueur = new JLabel("Aucun joueur");
        }

        nomJoueur.setFont(new Font("Arial", Font.BOLD, 30));
        nomJoueur.setBounds(955, 4, 370, 80);

        caracteristiqueUnite1 = new JLabel("  " + uniteBassem.getAttaque()
                + "    " + uniteBassem.getDefense()
                + "    " + uniteBassem.getPVmax()
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


        layeredPane.add(plateau, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(imageJeuLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(nomJoueur, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite1, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite2, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite3, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite4, JLayeredPane.POPUP_LAYER);
        layeredPane.add(caracteristiqueUnite5, JLayeredPane.POPUP_LAYER);
        layeredPane.add(FinTour, JLayeredPane.POPUP_LAYER);

        champHexagonesPanel = new JPanel(new BorderLayout());
        champHexagonesPanel.setOpaque(false);
        champHexagonesPanel.add(layeredPane, BorderLayout.CENTER);

        cardPanel.add(champHexagonesPanel, "champ_hexagones");

        lancerJeuBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                joueurs = new ArrayList<>();
                for (JTextField textField : textFields) {
                    String nomJoueur = textField.getText();
                    Color couleurJoueur = Color.RED;
                    Joueur joueur = new Joueur(new ArrayList<>(), false, nomJoueur, couleurJoueur);
                    joueurs.add(joueur);
                }

                System.out.println("Liste des joueurs :");
                for (Joueur j : joueurs) {
                    System.out.println(j.getJoueurNom());
                }
                if (!joueurs.isEmpty()) {
                    nomJoueur.setText("Tour du joueur : " + joueurs.get(0).getJoueurNom());
                    System.out.println("Tour du joueur : " + joueurs.get(0).getJoueurNom());
                }
            }
        });
    }
}