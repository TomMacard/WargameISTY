package Model;

import java.awt.*;

public class caseMontagne extends Case{
    private static final String type = "Montagne";
    private static final int coutDeplacement = 3;
    private static final int defense = 40;

    private static final Color couleur = Color.DARK_GRAY;
    public caseMontagne( boolean traversable, int x, int y) {
        super( type, coutDeplacement, defense, traversable, x, y, couleur);
    }
}
