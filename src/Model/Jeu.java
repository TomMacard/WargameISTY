package Model;

import java.util.List;

public class Jeu {
    private Plateau jeuPlateau;
    private List<Joueur> jeuJoueurs;
    private List<Unite> jeuUnites;

    public Jeu(List<Joueur> joueurs) {
        this.jeuJoueurs = joueurs;
    }

    // Getters
    public Plateau getJeuPlateau() {
        return jeuPlateau;
    }

    public List<Joueur> getJeuJoueurs() {
        return jeuJoueurs;
    }

    public List<Unite> getJeuUnites() {
        return jeuUnites;
    }

    // Setters
    public void setJeuPlateau(Plateau jeuPlateau) {
        this.jeuPlateau = jeuPlateau;
    }

    public void setJeuJoueurs(List<Joueur> jeuJoueurs) {
        this.jeuJoueurs = jeuJoueurs;
    }

    public void setJeuUnites(List<Unite> jeuUnites) {
        this.jeuUnites = jeuUnites;
    }
}