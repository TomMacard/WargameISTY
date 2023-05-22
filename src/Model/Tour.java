package Model;

import java.util.Queue;

public class Tour {
    private int tourActuel;
    private Queue<Joueur> tourListeJoueurs;

    public Tour(int actuel, Queue<Joueur> listeJoueurs) {
        this.tourActuel = actuel;
        this.tourListeJoueurs = listeJoueurs;
    }

    // Getters
    public int getTourActuel() {
        return tourActuel;
    }

    public Queue<Joueur> getTourListeJoueurs() {
        return tourListeJoueurs;
    }

    // Setters
    public void setTourActuel(int tourActuel) {
        this.tourActuel = tourActuel;
    }

    public void setTourListeJoueurs(Queue<Joueur> tourListeJoueurs) {
        this.tourListeJoueurs = tourListeJoueurs;
    }

    public Tour() {
        tourActuel = 0; // Initialisation de  "tourActuel" à 0
    }
    public void incrementerTour() {
        tourActuel++; // Incrémente "tourActuel"
    }

}