package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AideInterface extends JPanel {
    private JButton retourButton;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public AideInterface(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        initialize();
    }

    public void initialize() {
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel titleLabel = new JLabel("Aide");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel, gbc);

        JLabel helpLabel = new JLabel("Voici l'aide du jeu...");
        helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(helpLabel, gbc);

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
