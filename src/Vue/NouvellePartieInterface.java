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

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel titleLabel = new JLabel("Nouvelle Partie");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel, gbc);

        JLabel helpLabel = new JLabel("Choisissez le nombre de joueurs");
        helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(helpLabel, gbc);

        String[] options = {"2 joueurs", "3 joueurs", "4 joueurs"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        contentPanel.add(comboBox, gbc);

        JButton confirmerButton = new JButton("Confirmer");
        contentPanel.add(confirmerButton, gbc);


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
                int numberOfPlayers = Integer.parseInt(selectedOption.split(" ")[0]);
                application.lancerJeu(numberOfPlayers);
            }
        });



        retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "menu_principal");
            }
        });
        contentPanel.add(retourButton, gbc);

        add(contentPanel, BorderLayout.CENTER);
    }
}
