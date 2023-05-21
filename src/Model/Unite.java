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
    private String uniteDeplacementCourant;

    public Unite(int potAttaque, int potDefense, int PVmax, int potDeplacement, int vision, int portee,
                 int x, int y, int PVcourant, String type, String deplacementCourant) {
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
        this.uniteDeplacementCourant = deplacementCourant;
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

    public String getUniteDeplacementCourant() {
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

    public void setUniteDeplacementCourant(String uniteDeplacementCourant) {
        this.uniteDeplacementCourant = uniteDeplacementCourant;
    }
}
