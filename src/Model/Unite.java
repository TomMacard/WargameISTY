package Model;

public class Unite {
    private int unitePotAttaque;
    private int unitePotDefense;
    private int unitePVmax;
    private int unitePotDeplacement;
    private int uniteVision;
    private int unitePortee;
    private int uniteX;
    private int uniteY;
    private int unitePVCourant;
    private String uniteType;
    private int uniteDeplacementCourant;
    private Joueur uniteJoueur;

    public Unite(int potAttaque, int potDefense, int PVmax, int potDeplacement, int vision, int portee,
                 int x, int y, int PVcourant, String type, Joueur uniteJoueur) {
        this.unitePotAttaque = potAttaque;
        this.unitePotDefense = potDefense;
        this.unitePVmax = PVmax;
        this.unitePotDeplacement = potDeplacement;
        this.uniteVision = vision;
        this.unitePortee = portee;
        this.uniteX = x;
        this.uniteY = y;
        this.unitePVCourant = PVcourant;
        this.uniteType = type;
        this.uniteDeplacementCourant = potDeplacement;
        this.uniteJoueur = uniteJoueur;
    }

    public Joueur getUniteJoueur() {
        return uniteJoueur;
    }

    public void setUniteJoueur(Joueur uniteJoueur) {
        this.uniteJoueur = uniteJoueur;
    }

    // Getters
    public int getUnitePotAttaque() {
        return unitePotAttaque;
    }

    public int getUnitePotDefense() {
        return unitePotDefense;
    }

    public int getUnitePVmax() {
        return unitePVmax;
    }

    public int getUnitePotDeplacement() {
        return unitePotDeplacement;
    }

    public int getUniteVision() {
        return uniteVision;
    }

    public int getUnitePortee() {
        return unitePortee;
    }

    public int getUniteX() {
        return uniteX;
    }

    public int getUniteY() {
        return uniteY;
    }

    public int getUnitePVCourant() {
        return unitePVCourant;
    }

    public String getUniteType() {
        return uniteType;
    }

    public int getUniteDeplacementCourant() {
        return uniteDeplacementCourant;
    }

    // Setters
    public void setUnitePotAttaque(int unitePotAttaque) {
        this.unitePotAttaque = unitePotAttaque;
    }

    public void setUnitePotDefense(int unitePotDefense) {
        this.unitePotDefense = unitePotDefense;
    }

    public void setUnitePVmax(int unitePVmax) {
        this.unitePVmax = unitePVmax;
    }

    public void setUnitePotDeplacement(int unitePotDeplacement) {
        this.unitePotDeplacement = unitePotDeplacement;
    }

    public void setUniteVision(int uniteVision) {
        this.uniteVision = uniteVision;
    }

    public void setUnitePortee(int unitePortee) {
        this.unitePortee = unitePortee;
    }

    public void setUniteX(int uniteX) {
        this.uniteX = uniteX;
    }

    public void setUniteY(int uniteY) {
        this.uniteY = uniteY;
    }

    public void setUnitePVCourant(int unitePVCourant) {
        this.unitePVCourant = unitePVCourant;
    }

    public void setUniteType(String uniteType) {
        this.uniteType = uniteType;
    }

    public void setUniteDeplacementCourant(int uniteDeplacementCourant) {
        this.uniteDeplacementCourant = uniteDeplacementCourant;
    }

    public void reinitialiserDeplacementFinTour() {
        this.uniteDeplacementCourant=this.unitePotDeplacement;
    }

    public Case unitePlateauCase(Plateau plateau) {
        int x=this.getUniteX();
        int y=this.getUniteY();
        Case tuile=plateau.plateauCases[x][y];
        return tuile;
    }

    public void attaqueEtDefense(Unite attaquant, Unite cible, Plateau plateau) {

        // Effectuer l'attaque
        int potentielAttaque = attaquant.getUnitePotAttaque();
        int pvCourant = cible.getUnitePVCourant();
        Case caseCible = cible.unitePlateauCase(plateau);
        int bonusDefense = caseCible.getCaseDefense();

        // Réduire le potentiel de défense de la cible en fonction du potentiel d'attaque de l'attaquant
        pvCourant -= (potentielAttaque * bonusDefense) / 100;
        int resultat = (int) pvCourant;

        // Si le potentiel de défense est négatif ou nul, la cible est détruite
        if (pvCourant <= 0) {
            Joueur joueurProprietaire = getUniteJoueur();
            if (joueurProprietaire != null) {
                joueurProprietaire.getJoueurUnites().remove(cible);
            }
            // Supprimer l'unité du plateau
            if (plateau != null) {
                plateau.plateauUnites[cible.uniteX][cible.uniteY] = (null);
            }
        } else {
            cible.setUnitePVCourant(pvCourant);
        }
    }
}