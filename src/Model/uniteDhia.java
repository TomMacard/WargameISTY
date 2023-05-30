package Model;

public class uniteDhia extends Unite{

    private static final int Attaque = 6;
    private static final int Defense = 1;
    private static final int PVmax = 11;
    private static final int Deplacement = 12;
    private static final int vision = 4;
    private static final int portee = 1;
    private static final String type = "DHIA";


    public uniteDhia( int x, int y, Joueur uniteJoueur) {
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
