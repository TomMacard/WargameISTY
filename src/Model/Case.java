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

    public boolean caseVoisins(Case caseArrivee) {
        int x1 = this.getCaseX();
        int y1 = this.getCaseY();
        int x2 = caseArrivee.getCaseX();
        int y2 = caseArrivee.getCaseY();

        if (x1 - 1 == x2 && y1 == y2) {
            return true;
        }
        if (x1 + 1 == x2 && y1 == y2) {
            return true;
        }
        if (y1 % 2 == 0) {
            if (x1 - 1 == x2 && y1 - 1 == y2) {
                return true;
            }
            if (x1 == x2 && y1 - 1 == y2) {
                return true;
            }
        } else {
            if (x1 == x2 && y1 + 1 == y2) {
                return true;
            }
            if (x1 - 1 == x2 && y1 + 1 == y2) {
                return true;
            }
        }
        return false;
    }


}