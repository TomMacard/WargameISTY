package Controleurs;
import javax.swing.UIManager;

import Model.Tour;
import Vue.MenuPrincipal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class fonctions_de_traitements {

    //incrémenter "tourActuel" quand le joueur appuie sur le boutton "fin de tour"
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String buttonStyle = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(buttonStyle);


        Tour tour = new Tour();
        // ne pas oublier de modifier le code après la création du bouton "fin de tour" au bon endroit(sur le jeu)
        JButton finTour = new JButton("Fin de tour");
        finTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tour.incrementerTour();
                System.out.println("Numéro tour : " + tour.getTourActuel());
            }
        });

        Dimension size = new Dimension(1400, 830);
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setBorder(BorderFactory.createEmptyBorder());


        menuPrincipal.setApplication(null);
        JFrame frame = new JFrame("Wargame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(menuPrincipal, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(size);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
