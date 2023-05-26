package Model;

public class uniteTom extends Unite{

    public static final int Attaque = 7;
    public static final int Defense = 4;
    public static final int PVmax = 12;
    public static final int Deplacement = 6;
    public static final int vision = 4;
    public static final int portee = 1;
    public static final String type = "TOM";


    public uniteTom( int x, int y, Joueur uniteJoueur) {
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
