package Model;

public class uniteFadi extends Unite{

    private static final int Attaque = 5;
    private static final int Defense = 9;
    private static final int PVmax = 15;
    private static final int Deplacement = 4;
    private static final int vision = 3;
    private static final int portee = 5;
    private static final String type = "FADI";


    public uniteFadi( int x, int y, int PVcourant, Joueur uniteJoueur) {
        super( Attaque, Defense, PVmax, Deplacement, vision, portee, x, y, PVcourant, type, uniteJoueur);
    }
}
