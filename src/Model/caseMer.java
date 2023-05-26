package Model;

import java.awt.*;

public class caseMer extends Case{
    private static final String type = "Mer";
    private static final int coutDeplacement = 9;
    private static final int defense = 100;

    private static final Color couleur = Color.BLUE;
    public caseMer( boolean traversable, int x, int y) {
        super(type, coutDeplacement, defense, traversable, x, y, couleur);
    }
}
