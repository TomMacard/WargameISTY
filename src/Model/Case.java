package Model;

import java.awt.*;

public class Case {
    private String caseType;
    private int caseCoutDeplacement;
    private int caseDefense;
    private boolean caseTraversable;
    private int caseX;
    private int caseY;
    private Color caseCouleur;

    public Case(String type, int coutDeplacement, int defense, boolean traversable, int x, int y, Color couleur) {
        this.caseType = type;
        this.caseCoutDeplacement = coutDeplacement;
        this.caseDefense = defense;
        this.caseTraversable = traversable;
        this.caseX = x;
        this.caseY = y;
        this.caseCouleur = couleur;
    }

    // Getters
    public String getCaseType() {
        return caseType;
    }

    public int getCaseCoutDeplacement() {
        return caseCoutDeplacement;
    }

    public int getCaseDefense() {
        return caseDefense;
    }

    public boolean isCaseTraversable() {
        return caseTraversable;
    }

    public int getCaseX() {
        return caseX;
    }

    public int getCaseY() {
        return caseY;
    }

    public Color getCaseCouleur() {
        return caseCouleur;
    }

    // Setters
    public void setCaseType(String caseNom) {
        this.caseType = caseNom;
    }

    public void setCaseCoutDeplacement(int caseCoutDeplacement) {
        this.caseCoutDeplacement = caseCoutDeplacement;
    }

    public void setCaseDefense(int caseDefense) {
        this.caseDefense = caseDefense;
    }

    public void setCaseTraversable(boolean caseTraversable) {
        this.caseTraversable = caseTraversable;
    }

    public void setCaseX(int caseX) {
        this.caseX = caseX;
    }

    public void setCaseY(int caseY) {
        this.caseY = caseY;
    }

    public void setCaseCouleur(Color caseCouleur) {
        this.caseCouleur = caseCouleur;
    }

    public void caseVoisins(Case casecliquee) {

        int x = casecliquee.getCaseX();
        int y = casecliquee.getCaseY();
        // Check and highlight the left neighbor
        if (x - 1 >= 0) {
            // Highlight the left neighbor tile
        }
        // Check and highlight the right neighbor
        if (x + 1 < VariablesGlobales.X_MAX) {
            // Highlight the right neighbor tile
        }
        // Check and highlight the top-left and top-right neighbors
        if (y % 2 == 0) {
            if (y - 1 >= 0 && x - 1 >= 0) {
                // Highlight the top-left neighbor tile
            }
            if (y - 1 >= 0 && x + 1 < VariablesGlobales.X_MAX) {
                // Highlight the top-right neighbor tile
            }
        } else {
            // Check and highlight the bottom-left and bottom-right neighbors
            if (y + 1 < VariablesGlobales.Y_MAX && x - 1 >= 0) {
                // Highlight the bottom-left neighbor tile
            }
            if (y + 1 < VariablesGlobales.Y_MAX && x + 1 < VariablesGlobales.X_MAX) {
                // Highlight the bottom-right neighbor tile
            }
        }
    }


}