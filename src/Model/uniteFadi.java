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
    public static int getAttaque() {
        return Attaque;
    }

    public static int getDefense() {
        return Defense;
    }

    public static int getPVmax() {
        return PVmax;
    }

    public static int getDeplacement() {
        return Deplacement;
    }

    public static int getVision() {
        return vision;
    }

    public static int getPortee() {
        return portee;
    }

    public String getType() {
        return type;
    }
}
