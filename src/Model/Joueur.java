package Model;

import java.awt.*;
import java.util.List;

public class Joueur {
    public List<Unite> joueurUnites;
    private boolean joueurVictoire;
    private String joueurNom;
    private Color joueurCouleur;

    public Joueur(List<Unite> unites, boolean victoire, String nom, Color couleur) {
        this.joueurUnites = unites;
        this.joueurVictoire = victoire;
        this.joueurNom = nom;
        this.joueurCouleur = couleur;
    }

    // Getters
    public List<Unite> getJoueurUnites() {
        return joueurUnites;
    }

    public boolean isJoueurVictoire() {
        return joueurVictoire;
    }

    public String getJoueurNom() {
        return joueurNom;
    }

    public Color getJoueurCouleur() {
        return joueurCouleur;
    }

    // Setters
    public void setJoueurUnites(List<Unite> joueurUnites) {
        this.joueurUnites = joueurUnites;
    }

    public void setJoueurVictoire(boolean joueurVictoire) {
        this.joueurVictoire = joueurVictoire;
    }

    public void setJoueurNom(String joueurNom) {
        this.joueurNom = joueurNom;
    }

    public void setJoueurCouleur(Color joueurCouleur) {
        this.joueurCouleur = joueurCouleur;
    }
}
