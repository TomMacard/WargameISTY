package Model;

public class uniteMostafa extends Unite{

    private static final int Attaque = 8;
    private static final int Defense = 3;
    private static final int PVmax = 12;
    private static final int Deplacement = 6;
    private static final int vision = 4;
    private static final int portee = 1;
    private static final String type = "MOSTAFA";


    public uniteMostafa( int x, int y, Joueur uniteJoueur) {
        super( Attaque, Defense, PVmax, Deplacement, vision, portee, x, y, PVmax, type, uniteJoueur);
    }
}
