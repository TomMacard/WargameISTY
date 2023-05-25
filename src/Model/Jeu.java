package Model;
import java.util.List;
import javax.swing.JOptionPane;

public class Jeu {
    private Plateau jeuPlateau;
    private List<Joueur> jeuJoueurs;
    private Joueur jeuJoueurActuel;

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
    }

    public void jeuBouclePrincipale() {
        while (!jeuConditionVictoire()) {
            for (int i = 0; i < this.jeuJoueurs.size(); i++) {
                this.jeuJoueurActuel= jeuJoueurs.get(i % this.jeuJoueurs.size());
                if (jeuJoueurNaPlusDUnites()) {
                    System.out.println("Joueur éliminé et ne joue pas : "+this.jeuJoueurActuel.getJoueurNom());
                    JOptionPane.showMessageDialog(null,"Joueur éliminé et ne joue pas : "+this.jeuJoueurActuel.getJoueurNom(), "Joueur Eliminé", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    while (1==1) {
                        System.out.println("Tour du joueur : "+this.jeuJoueurActuel.getJoueurNom());
                        JOptionPane.showMessageDialog(null,"Tour du joueur : "+this.jeuJoueurActuel.getJoueurNom(), "Tour Suivant", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            //regen vie
            //regen point d deplacement
        }
        System.out.println("Jeu Fini");
        JOptionPane.showMessageDialog(null,"Jeu Fini","Jeu Fini", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean jeuConditionVictoire() {

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
    //Jeu jeu = new Jeu()

}