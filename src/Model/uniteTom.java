package Model;

public class uniteTom extends Unite{

    private static final int Attaque = 5;
    private static final int Defense = 1;
    private static final int PVmax = 10;
    private static final int Deplacement = 5;
    private static final int vision = 9;
    private static final int portee = 5;
    private static final String type = "TOM";


    public uniteTom( int x, int y, Joueur uniteJoueur) {
        super( Attaque, Defense, PVmax, Deplacement, vision, portee, x, y, PVmax, type, uniteJoueur);
    }
}
