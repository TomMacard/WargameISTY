package Model;

public class uniteBassem extends Unite{

    private static final int Attaque = 10;
    private static final int Defense = 1;
    private static final int PVmax = 10;
    private static final int Deplacement = 6;
    private static final int vision = 6;
    private static final int portee = 4;
    private static final String type = "BASSEM";


    public uniteBassem( int x, int y, Joueur uniteJoueur) {
        super( Attaque, Defense, PVmax, Deplacement, vision, portee, x, y, PVmax, type, uniteJoueur);
    }
}
