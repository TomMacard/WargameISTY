/*package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NouvellePartieInterface extends JPanel {

    private JButton retourButton;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Application application;
    private GridBagConstraints gbc;
    private JPanel contentPanel;
    private int NouvellePartieInterfacenombreJoueurs;



    public NouvellePartieInterface(CardLayout cardLayout, JPanel cardPanel, Application application) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        this.application = application;
        initialize();
    }

    public void setApplication(Application application) {
        this.application = application;
    }


    public void initialize() {

        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());

        contentPanel = new JPanel();
        SpringLayout sl_contentPanel = new SpringLayout();
        contentPanel.setLayout(sl_contentPanel);

        JLabel titleLabel = new JLabel("Nouvelle Partie");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel);

        JLabel titleLabel2 = new JLabel("Nouvelle Partie");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel2);
        titleLabel2.setVisible(false);

        JLabel helpLabel = new JLabel("Choisissez le nombre de joueurs");
        helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(helpLabel);

        String[] options = {"2 joueurs", "3 joueurs", "4 joueurs"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        contentPanel.add(comboBox);

        JButton confirmerButton = new JButton("Confirmer");
        contentPanel.add(confirmerButton);

        JButton lancerJeuBouton = new JButton("Lancer la partie");
        contentPanel.add(confirmerButton);

        sl_contentPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER, titleLabel, 0, SpringLayout.HORIZONTAL_CENTER, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, contentPanel);

        sl_contentPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER, titleLabel2, 0, SpringLayout.HORIZONTAL_CENTER, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, titleLabel2, 20, SpringLayout.NORTH, contentPanel);

        sl_contentPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER, helpLabel, 0, SpringLayout.HORIZONTAL_CENTER, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, helpLabel, 40, SpringLayout.SOUTH, titleLabel);

        sl_contentPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER, comboBox, 0, SpringLayout.HORIZONTAL_CENTER, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, comboBox, 20, SpringLayout.SOUTH, helpLabel);

        sl_contentPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmerButton, 0, SpringLayout.HORIZONTAL_CENTER, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, confirmerButton, 20, SpringLayout.SOUTH, comboBox);

        sl_contentPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER, lancerJeuBouton, 0, SpringLayout.HORIZONTAL_CENTER, contentPanel);
        sl_contentPanel.putConstraint(SpringLayout.NORTH, lancerJeuBouton, 100, SpringLayout.SOUTH, comboBox);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        lancerJeuBouton.setVisible(false);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                // Faites quelque chose avec l'option sélectionnée (par exemple, afficher un message)
                System.out.println("Option sélectionnée : " + selectedOption);
            }
        });



        confirmerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                NouvellePartieInterfacenombreJoueurs = Integer.parseInt(selectedOption.split(" ")[0]);
                createPlayerNameFields();

                titleLabel.setVisible(false);
                comboBox.setVisible(false);
                titleLabel.setVisible(false);
                confirmerButton.setVisible(false);
                titleLabel2.setVisible(true);
                lancerJeuBouton.setVisible(true);
            }
        });


        retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "menu_principal");
            }
        });
        retourButton.setBackground(Color.RED);
        buttonPanel.add(retourButton, BorderLayout.SOUTH);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void createPlayerNameFields() {
        removeAllPlayerNameFields();

        JPanel playerNamePanel = new JPanel(new GridLayout(NouvellePartieInterfacenombreJoueurs, 1));

        for (int i = 1; i <= NouvellePartieInterfacenombreJoueurs; i++) {
            JLabel label = new JLabel("Joueur " + i + ":");
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(260, 48));

            JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            textFieldPanel.add(label);
            textFieldPanel.add(textField);

            playerNamePanel.add(textFieldPanel);
        }

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.add(playerNamePanel);

        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(wrapperPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }


    private void removeAllPlayerNameFields() {
        Component[] components = contentPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                contentPanel.remove(component);
            }
        }
    }

}*/

package Vue;

import Model.Plateau;
import Model.VariablesGlobales;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NouvellePartieInterface extends JPanel {

    private JButton boutonRetour;
    private CardLayout gestionnaireCartes;
    private JPanel panneauCartes;
    private Application application;
    private JPanel panneauContenu;
    private int nombreJoueurs;
    private JPanel cardPanel;
    private CardLayout cardLayout;



    public NouvellePartieInterface(CardLayout gestionnaireCartes, JPanel panneauCartes, Application application) {
        this.gestionnaireCartes = gestionnaireCartes;
        this.panneauCartes = panneauCartes;
        this.application = application;
        this.cardLayout = gestionnaireCartes;
        this.cardPanel = panneauCartes;
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

        JButton lancerJeuBouton = new JButton("Lancer la partie");
        panneauContenu.add(lancerJeuBouton);
        lancerJeuBouton.setVisible(false);
        lancerJeuBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createChampHexagones();
                cardLayout.show(cardPanel, "champ_hexagones");
            }
        });

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
        panneauBouton.add(boutonRetour, BorderLayout.SOUTH);

        panneauPrincipal.add(panneauBouton, BorderLayout.SOUTH);

        add(panneauPrincipal, BorderLayout.CENTER);

        cardPanel = panneauCartes;
        createChampHexagones();
    }

    private void createChampHexagones() {
        Plateau plateau = new Plateau(VariablesGlobales.X_MAX, VariablesGlobales.Y_MAX);
        JPanel champHexagonesPanel = new JPanel();
        champHexagonesPanel.add(plateau);
        champHexagonesPanel.add(boutonRetour);

        cardPanel.add(champHexagonesPanel, "champ_hexagones");
    }

    private void creerChampsNomJoueurs() {
        supprimerTousChampsNomJoueurs();

        JPanel panneauNomJoueurs = new JPanel(new GridLayout(nombreJoueurs, 1));

        for (int i = 1; i <= nombreJoueurs; i++) {
            JLabel label = new JLabel("Joueur " + i + ":");
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(260, 48));

            JPanel panneauTextField = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panneauTextField.add(label);
            panneauTextField.add(textField);

            panneauNomJoueurs.add(panneauTextField);
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
