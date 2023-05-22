package Vue;

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
    private int numberOfPlayers;



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

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

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
                numberOfPlayers = Integer.parseInt(selectedOption.split(" ")[0]);
                createPlayerNameFields();

                titleLabel.setVisible(false);
                comboBox.setVisible(false);
                titleLabel.setVisible(false);
                confirmerButton.setVisible(false);
                titleLabel2.setVisible(true);
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

        JPanel playerNamePanel = new JPanel(new GridLayout(numberOfPlayers, 1));

        for (int i = 1; i <= numberOfPlayers; i++) {
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


    /*private void createPlayerNameFields() {
        removeAllPlayerNameFields();

        JPanel playerNamePanel = new JPanel(new GridLayout(numberOfPlayers, 1));

        for (int i = 1; i <= numberOfPlayers; i++) {
            JLabel label = new JLabel("Joueur " + i + ":");
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(260, 48));

            JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            textFieldPanel.add(label);
            textFieldPanel.add(textField);

            playerNamePanel.add(textFieldPanel);
        }

        contentPanel.add(playerNamePanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }*/



    private void removeAllPlayerNameFields() {
        Component[] components = contentPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                contentPanel.remove(component);
            }
        }
    }

}