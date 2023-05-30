package Model;
import java.util.List;
import javax.swing.JOptionPane;

public class Jeu {
    private Plateau jeuPlateau;
    private List<Joueur> jeuJoueurs;
    private Joueur jeuJoueurActuel;
    private int compteur;

    public Joueur getJeuJoueurActuel() {
        return jeuJoueurActuel;
    }

    public void setJeuJoueurActuel(Joueur jeuJoueurActuel) {
        this.jeuJoueurActuel = jeuJoueurActuel;
    }


    // Getters
    public Plateau getJeuPlateau() {
        return jeuPlateau;
    }

    public List<Joueur> getJeuJoueurs() {
        return jeuJoueurs;
    }


    // Setters
    public void setJeuPlateau(Plateau jeuPlateau) {
        this.jeuPlateau = jeuPlateau;
    }

    public void setJeuJoueurs(List<Joueur> jeuJoueurs) {
        this.jeuJoueurs = jeuJoueurs;
    }

    public Jeu(Plateau jeuPlateau, List<Joueur> jeuJoueurs) {
        this.jeuPlateau = jeuPlateau;
        this.jeuJoueurs = jeuJoueurs;
        this.jeuJoueurActuel = jeuJoueurs.get(0);
        this.compteur=0;
    }

    public void jeuBouclePrincipale() {
        System.out.println("clic tour suivant");
        if (!jeuConditionVictoire()) {
            System.out.println("pas de gagnant");
            if (compteur==jeuJoueurs.size()-1) {
                compteur=0;
            }
            else {
                compteur++;
            }
            this.jeuJoueurActuel= jeuJoueurs.get(compteur);
            this.jeuPlateau.plateauJoueurActuel=jeuJoueurActuel;
            System.out.println("Joueur actuel mis à jour : " + this.jeuJoueurActuel.getJoueurNom());
            //System.out.println("Joueur actuel mis à jour sur plateau : " + this.jeuPlateau.plateauJoueurActuel.getJoueurNom());
            if (false ) {//jeuJoueurNaPlusDUnites()) {
                System.out.println("Joueur éliminé et ne joue pas : "+this.jeuJoueurActuel.getJoueurNom());
                JOptionPane.showMessageDialog(null,"Joueur éliminé et ne joue pas : "+this.jeuJoueurActuel.getJoueurNom(), "Joueur Eliminé", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                System.out.println("Tour du joueur : "+this.jeuJoueurActuel.getJoueurNom());
                JOptionPane.showMessageDialog(null,"Tour du joueur : "+this.jeuJoueurActuel.getJoueurNom(), "Tour Suivant", JOptionPane.INFORMATION_MESSAGE);
            }
            //regen vie et deplacement
            jeuRegenDeplacement();
        }
        else {
            System.out.println("Jeu Fini");
            JOptionPane.showMessageDialog(null,"Jeu Fini","Jeu Fini", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean jeuConditionVictoire() {

        // a finir
        return false;

    }

    public boolean jeuJoueurNaPlusDUnites() {
        Joueur joueur = this.jeuJoueurActuel;
        boolean perdu = true;
        for (Unite unite : joueur.getJoueurUnites()) {
            if (unite != null) {
                return(false);
            }
        }
        return(true);
    }


    public void jeuRegenDeplacement() {
        for (Joueur joueur : this.jeuJoueurs) {
            for (Unite unite : joueur.joueurUnites) {
                if (unite.getUniteJoueur()==this.jeuJoueurActuel) {
                    if (unite.getUniteDeplacementCourant()==unite.getUnitePotDeplacement()){
                        unite.setUnitePVCourant((int) unite.getUnitePVCourant()*11/10);
                        if (unite.getUnitePVCourant()>unite.getUnitePVmax()) {
                            unite.setUnitePVCourant(unite.getUnitePVmax());
                        }
                    }
                }
                unite.setUniteDeplacementCourant(unite.getUnitePotDeplacement());
            }
        }
    }

}