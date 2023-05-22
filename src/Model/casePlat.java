package Model;
import Controleurs.fonctions_de_traitements;
import java.awt.*;

import static java.lang.Boolean.TRUE;

public class casePlat extends Case{
    private static final String type = "Plaine";
    private static final int coutDeplacement = 1;
    private static final int defense = 100;

    private static final Color couleur = Color.GREEN;
    public casePlat( boolean traversable, int x, int y) {
        super(type, coutDeplacement, defense, traversable, x, y, couleur);
    }
}
