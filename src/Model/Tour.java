package Model;
import java.util.ArrayList;
import java.util.Queue;


/*
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


    private boolean attendreClicFinTour(){boolean resultat; return resultat;} // evenement qui retourne oui si on appui sur fin tour et non sinon

    public void TourGestionTourParTour(List<Joueur> joueurs){ // c'est la fonction qui va gerer un seul tour: un tour c'est lorsque tous les joueurs jouent une fois
        int joueurCourant=0;
        while (joueurCourant<=joueurs.size()){     // on parcour la taille de la liste pour prendre tous les joueur
            Joueur joueurActuel = joueurs.get(joueurCourant); // recuperer le premier joueur de la liste de joueurs
            while (!= attendreClicFinTour){
                ceQueVeutFaireLeJoueurActuel(); // ce qu'il le joueur veux faire
            }
            if (attendreClicFinTour){
                joueurCourant+=1;    // si le joueur appui sur fin tour on passe au joueur suivant
            }

        }

    }
    public void deroulementDuJeu(){
        int nbrToursJoues=0;
        while(!conditionFinJeu()){     // si conditions de victoire non etablis on appelle la fonction de gesytion d'un seul tour et on inctemente a chaque tour joue
            TourGestionTourParTour(ListeJoueurs);
            nbrToursJoues+=1
        }
        if (conditionFinJeu()){    // si conditions de victoire etablis
            annonceVictoire();
            system.out.println("Jeu terminé, le joueur ...... à gagné après " + nbrToursJoues + " tours");
        }
    }

    public boolean conditionFinJeu(){

        return false;
    }

}

 */