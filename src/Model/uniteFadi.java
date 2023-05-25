package Model;

public class uniteFadi extends Unite{

    private static final int Attaque =7;
    private static final int Defense = 6;
    private static final int PVmax = 16;
    private static final int Deplacement = 4;
    private static final int vision = 3;
    private static final int portee = 1;
    private static final String type = "FADI";


    public uniteFadi( int x, int y, Joueur uniteJoueur) {
        super( Attaque, Defense, PVmax, Deplacement, vision, portee, x, y, PVmax, type, uniteJoueur);
    }
}
