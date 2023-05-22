package Model;

import java.awt.*;

public class caseDesert extends Case{

    private static final String type = "Desert";
    private static final int coutDeplacement = 2;
    private static final int defense = 80;

    private static final Color couleur = Color.YELLOW;
    public caseDesert( boolean traversable, int x, int y) {
        super(type, coutDeplacement, defense, traversable, x, y, couleur);
    }
}
