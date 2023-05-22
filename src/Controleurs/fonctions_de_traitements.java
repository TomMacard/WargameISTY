package Controleurs;

import Model.Tour;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fonctions_de_traitements {

    //incrémenter "tourActuel" quand le joueur appuie sur le boutton "fin de tour"
    public static void main(String[] args) {
        Tour tour = new Tour();
        // ne pas oublier de modifier le code après la création du bouton "fin de tour" au bon endroit(sur le jeu)
        JButton finTour = new JButton("Fin de tour");
        finTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tour.incrementerTour();
                System.out.println("Numéro tour : " + tour.getTourActuel());
            }
        });
    }
}
