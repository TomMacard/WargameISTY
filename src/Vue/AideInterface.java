/*package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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

        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("src/images/background..png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        CustomPanel panel = new CustomPanel(backgroundImage.getScaledInstance(1400, 830, Image.SCALE_SMOOTH)) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1400, 830);
            }
        };

        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        panel.add(background);
        background.setLayout(new FlowLayout());

        JPanel aidePanel = new JPanel();
        aidePanel.setLayout(new BorderLayout());

        retourButton = new JButton("Retour");
        retourButton.setBorder(new RoundBtn(25));
        retourButton.setPreferredSize(new Dimension(540, 52));
        retourButton.setBackground(new Color(199, 110, 37));
        retourButton.setForeground(Color.BLACK);
        retourButton.setFont(new Font("Arial", Font.BOLD, 20));
        retourButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aidePanel.add(retourButton);

        // Définir les contraintes pour les composants
        //sl_panel.putConstraint(SpringLayout.NORTH, retourButton, 416, SpringLayout.NORTH, panel);
        //sl_panel.putConstraint(SpringLayout.WEST, retourButton, 440, SpringLayout.WEST, panel);

        sl_panel.putConstraint(SpringLayout.HORIZONTAL_CENTER, retourButton, 0, SpringLayout.HORIZONTAL_CENTER, aidePanel);
        sl_panel.putConstraint(SpringLayout.SOUTH, retourButton, -20, SpringLayout.SOUTH, aidePanel);


        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "menu_principal");
            }
        });


        aidePanel.add(retourButton, BorderLayout.SOUTH);
        panel.add(aidePanel);

        add(panel, BorderLayout.CENTER);
    }
}
*/

package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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

        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("src/images/wooh.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }



        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setSize(1350, 850);  // Set the size of the JLabel to match the image

        retourButton = new JButton("");
        //retourButton.setBorder(new RoundBtn(25));
        retourButton.setPreferredSize(new Dimension(140, 52));
        //retourButton.setBackground(new Color(30, 31, 34));
        //retourButton.setForeground(Color.BLACK);
        //retourButton.setFont(new Font("Arial", Font.BOLD, 20));
        retourButton.setOpaque(false);
        retourButton.setContentAreaFilled(false);

        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "menu_principal");
            }
        });

        JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flowPanel.setOpaque(false);  // Make the panel transparent
        flowPanel.add(retourButton);
        flowPanel.setBounds(540, 760, 170, 52);  // Set the position and size of the panel

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1400, 850));  // Set the preferred size to match the image

        // Add the background label to the default layer
        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);

        // Add the panel containing the button to the palette layer (above the default layer)
        layeredPane.add(flowPanel, JLayeredPane.PALETTE_LAYER);

        add(layeredPane, BorderLayout.CENTER);
    }

}
