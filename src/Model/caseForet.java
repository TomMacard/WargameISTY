package Model;

import java.awt.*;

public class caseForet extends Case{

    private static final String type = "Foret";
    private static final int coutDeplacement = 2;
    private static final int defense = 90;

    private static final Color couleur = Color.GREEN.darker();
    public caseForet( boolean traversable, int x, int y) {
        super(type, coutDeplacement, defense, traversable, x, y, couleur);
    }

}
