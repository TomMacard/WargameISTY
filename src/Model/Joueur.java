package Model;

import java.util.List;

public class Joueur {
    public List<Unite> joueurUnites;
    private boolean joueurVictoire;
    private String joueurNom;
    private String joueurCouleur;

    public Joueur(List<Unite> unites, boolean victoire, String nom, String couleur) {
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

    public String getJoueurCouleur() {
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

    public void setJoueurCouleur(String joueurCouleur) {
        this.joueurCouleur = joueurCouleur;
    }
}
