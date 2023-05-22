package Model;

import java.awt.*;

public class caseMer extends Case{
    private static final String type = "Mer";
    private static final int coutDeplacement = 1000;
    private static final int defense = 1;

    private static final Color couleur = Color.BLUE;
    public caseMer( boolean traversable, int x, int y) {
        super(type, coutDeplacement, defense, traversable, x, y, couleur);
    }
}
