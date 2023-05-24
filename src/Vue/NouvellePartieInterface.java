package Vue;

import Model.Plateau;
import Model.VariablesGlobales;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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

        JPanel panneauPrincipal = new JPanel(new BorderLayout());

        panneauContenu = new JPanel();
        SpringLayout sl_panneauContenu = new SpringLayout();
        panneauContenu.setLayout(sl_panneauContenu);

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

        JButton confirmerBouton = new JButton("Confirmer");
        panneauContenu.add(confirmerBouton);

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


        panneauPrincipal.add(panneauContenu, BorderLayout.CENTER);

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
                String optionSelectionnee = (String) comboBox.getSelectedItem();
                nombreJoueurs = Integer.parseInt(optionSelectionnee.split(" ")[0]);
                creerChampsNomJoueurs();

                titreLabel.setVisible(false);
                comboBox.setVisible(false);
                aideLabel.setVisible(false);
                confirmerBouton.setVisible(false);
                lancerJeuBouton.setVisible(true);


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

    private void creerChampsNomJoueurs() {
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