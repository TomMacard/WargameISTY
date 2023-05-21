package Vue;

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AideInterface extends JPanel {

    private JButton retourButton;

    public AideInterface(CardLayout cardLayout, JPanel cardPanel) {
        initialize(cardLayout, cardPanel);
    }

    public void initialize(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel titreLabel = new JLabel("Aide");
        titreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titreLabel, BorderLayout.NORTH);

        JPanel contenuPanel = new JPanel();
        contenuPanel.setBackground(Color.WHITE);
        contenuPanel.setLayout(new BoxLayout(contenuPanel, BoxLayout.Y_AXIS));

        contenuPanel.add(new JLabel("Bienvenue dans l'aide du jeu."));
        contenuPanel.add(new JLabel("Voici les instructions pour jouer."));
        // Ajoutez d'autres composants d'aide ici

        add(contenuPanel, BorderLayout.CENTER);

        retourButton = new JButton("Retour");
        add(retourButton, BorderLayout.SOUTH);
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "menu");
            }
        });
    }

    public JButton getRetourButton() {
        return retourButton;
    }
}*/
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AideInterface extends JPanel {
    private JButton retourButton;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private MenuPrincipal MENU_PRINCIPAL;

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
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, MENU_PRINCIPAL);
            }
        });
        contentPanel.add(retourButton, gbc);

        add(contentPanel, BorderLayout.CENTER);
    }
}*/


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
