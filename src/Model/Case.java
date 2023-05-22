package Model;

public class Case {
    private String caseNom;
    private int caseCoutDeplacement;
    private int caseDefense;
    private boolean caseTraversable;
    private int caseX;
    private int caseY;
    private boolean caseImage;

    public Case(String nom, int coutDeplacement, int defense, boolean traversable, int x, int y, boolean image) {
        this.caseNom = nom;
        this.caseCoutDeplacement = coutDeplacement;
        this.caseDefense = defense;
        this.caseTraversable = traversable;
        this.caseX = x;
        this.caseY = y;
        this.caseImage = image;
    }

    // Getters
    public String getCaseNom() {
        return caseNom;
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

    public boolean isCaseImage() {
        return caseImage;
    }

    // Setters
    public void setCaseNom(String caseNom) {
        this.caseNom = caseNom;
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

    public void setCaseImage(boolean caseImage) {
        this.caseImage = caseImage;
    }


}