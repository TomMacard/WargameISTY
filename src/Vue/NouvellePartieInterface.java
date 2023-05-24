package Vue;

import Model.Plateau;
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
        lancerJeuBouton = new JButton("Lancer la partie");
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

        JLabel titreLabel = new JLabel("Nouvelle Partie");
        titreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panneauContenu.add(titreLabel);

        JLabel aideLabel = new JLabel("Choisissez le nombre de joueurs");
        aideLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panneauContenu.add(aideLabel);

        String[] options = {"2 joueurs", "3 joueurs", "4 joueurs"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        panneauContenu.add(comboBox);
        comboBox.setBounds(590, 400, 150, 50);
        panneauPrincipal.add(comboBox, JLayeredPane.PALETTE_LAYER);

        JButton confirmerBouton = new JButton("Confirmer");
        panneauContenu.add(confirmerBouton);
        confirmerBouton.setBounds(590, 500, 150, 50);
        panneauPrincipal.add(confirmerBouton, JLayeredPane.PALETTE_LAYER);

        panneauContenu.setBounds(0, 0, 1400, 830);  // Set the position and size to match the image
        panneauPrincipal.add(panneauContenu, JLayeredPane.PALETTE_LAYER);

        BufferedImage fiche = null;
        try {
            fiche = ImageIO.read(new File("src/images/wooh.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }


        background = new JLabel(new ImageIcon(fiche));
        //JLabel background = new JLabel(new ImageIcon(fiche));
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
        sl_panneauContenu.putConstraint(SpringLayout.NORTH, lancerJeuBouton, 400, SpringLayout.SOUTH, comboBox);

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

        /*confirmerBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Supprime l'image de fond précédente
                panneauPrincipal.remove(background);
                BufferedImage fiche2 = null;
                try {
                    fiche2 = ImageIO.read(new File("src/images/jdid.png"));
                } catch (IOException exception) {
                    exception.printStackTrace();
                    System.exit(-1);
                }
                background2 = new JLabel(new ImageIcon(fiche2));
                //JLabel background = new JLabel(new ImageIcon(fiche));
                background2.setSize(1400, 830);
                panneauPrincipal.add(background2, JLayeredPane.DRAG_LAYER);

                add(panneauPrincipal, BorderLayout.CENTER);

                panneauContenu.setOpaque(false);
                panneauPrincipal.add(panneauContenu, JLayeredPane.PALETTE_LAYER);


                // Redessine le panneauPrincipal pour s'assurer que les modifications sont visibles
                panneauPrincipal.revalidate();
                panneauPrincipal.repaint();

                String optionSelectionnee = (String) comboBox.getSelectedItem();
                nombreJoueurs = Integer.parseInt(optionSelectionnee.split(" ")[0]);
                creerChampsNomJoueurs();

                titreLabel.setVisible(false);
                comboBox.setVisible(false);
                aideLabel.setVisible(false);
                confirmerBouton.setVisible(false);
                lancerJeuBouton.setVisible(true);
            }
        });*/

        confirmerBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Supprime l'image de fond précédente
                panneauPrincipal.remove(background);
                BufferedImage fiche2 = null;
                try {
                    fiche2 = ImageIO.read(new File("src/images/jdid.png"));
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
                textFieldPanel.setBounds(0, 0, 1400, 830);  // Set the position and size to match the image
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

    private void createChampHexagones() {
        Plateau plateau = new Plateau(VariablesGlobales.X_MAX, VariablesGlobales.Y_MAX, this);
        JPanel champHexagonesPanel = new JPanel();
        champHexagonesPanel.add(plateau);
        champHexagonesPanel.add(boutonRetour);

        cardPanel.add(champHexagonesPanel, "champ_hexagones");

        lancerJeuBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                joueurs = new ArrayList<Joueur>();
                for (JTextField textField : textFields) { // Parcourir tous les JTextField
                    String nomJoueur = textField.getText();
                    String couleurJoueur = ""; // Ajoutez ici la logique pour choisir la couleur du joueur

                    Joueur joueur = new Joueur(new ArrayList<>(), false, nomJoueur, couleurJoueur);
                    joueurs.add(joueur);
                }

                // Afficher la liste des joueurs à chaque ajout
                System.out.println("Liste des joueurs :");
                for (Joueur j : joueurs) {
                    System.out.println(j.getJoueurNom());
                }
            }
        });

    }

    /*private void creerChampsNomJoueurs() {
        supprimerTousChampsNomJoueurs();

        JPanel panneauNomJoueurs = new JPanel(new GridLayout(nombreJoueurs, 1));

        for (int i = 1; i <= nombreJoueurs; i++) {
            JLabel label = new JLabel("Joueur " + i + ":");
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(260, 48));
            textFields.add(textField);

            JPanel panneauTextField = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panneauTextField.add(label);
            panneauTextField.add(textField);

            panneauNomJoueurs.add(panneauTextField);

            textField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String nomJoueur = textField.getText();
                    String couleurJoueur = ""; // Ajoutez ici la logique pour choisir la couleur du joueur

                    Joueur joueur = new Joueur(new ArrayList<>(), false, nomJoueur, couleurJoueur);
                    joueurs.add(joueur);

                    // Afficher la liste des joueurs à chaque ajout
                    System.out.println("Liste des joueurs :");
                    for (Joueur j : joueurs) {
                        System.out.println(j.getJoueurNom());
                    }
                }
            });
        }

        JPanel panneauWrapper = new JPanel(new GridBagLayout());
        panneauWrapper.add(panneauNomJoueurs);

        panneauContenu.setLayout(new BorderLayout());
        panneauContenu.add(panneauWrapper, BorderLayout.CENTER);

        revalidate();
        repaint();
    }*/

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
                    String couleurJoueur = "";

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
}