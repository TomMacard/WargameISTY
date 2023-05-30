package Model;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Unite {
    private int unitePotAttaque;
    private int unitePotDefense;
    private int unitePVmax;
    private int unitePotDeplacement;
    private int uniteVision;
    private int unitePortee;
    private int uniteX;
    private int uniteY;
    private static int unitePVCourant;
    private String uniteType;
    private int uniteDeplacementCourant;
    private Joueur uniteJoueur;private List<Runnable> observers = new ArrayList<>();

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
        uniteJoueur.joueurUnites.add(this);
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

    public static int getUnitePVCourant() {
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
        notifyObservers();
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

    public void addObserver(Runnable observer) {
        observers.add(observer);
    }

    public void removeObserver(Runnable observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (Runnable observer : observers) {
            observer.run();
        }
    }

    public void attaqueEtDefense(Unite cible, Plateau plateau) {

        // Effectuer l'attaque
        int potentielAttaque = this.getUnitePotAttaque();
        int pvCourant = cible.getUnitePVCourant();
        Case caseCible = cible.unitePlateauCase(plateau);
        int bonusDefense = caseCible.getCaseDefense();

        String msg=null;

        // Réduire le potentiel de défense de la cible en fonction du potentiel d'attaque de l'attaquant
        pvCourant -= (potentielAttaque * bonusDefense) / 100;
        int resultat = (int) pvCourant;
        System.out.println("Le PV restant est : " + pvCourant);

        // Si le potentiel de défense est négatif ou nul, la cible est détruite
        if (pvCourant <= 0) {
            Joueur joueurProprietaire = getUniteJoueur();
            if (joueurProprietaire != null) {
                joueurProprietaire.getJoueurUnites().remove(cible);
            }
            // Supprimer l'unité du plateau
            if (plateau != null) {
                plateau.plateauUnites[cible.uniteX][cible.uniteY] = (null);
                msg ="Attaque : "+this.getUniteType()+" a eliminé "+ cible.getUniteType();
            }
        }
        else {
            cible.setUnitePVCourant(pvCourant);
            msg ="Attaque : "+this.getUniteType()+" a attaqué "+ cible.getUniteType()+" et enlevé "+(potentielAttaque * bonusDefense) / 100+" PV. PV Restant : "+cible.getUnitePVCourant();
        }
        JOptionPane.showMessageDialog(null,msg, "Attaque Effectuée", JOptionPane.INFORMATION_MESSAGE);
    }


    public void UniteDeplacementElementaire( int destinationX, int destinationY, Plateau plateau) {
        int uniteX = this.getUniteX();
        int uniteY = this.getUniteY();
        Case caseDestination = plateau.plateauCases[destinationX][destinationY] ;
        Unite unitedepart=  plateau.plateauUnites[uniteX][uniteY];
        Unite uniteDestination = plateau.plateauUnites[destinationX][destinationY];
        int potentielDeplacement= this.getUniteDeplacementCourant();
        int coutDeplacement= caseDestination.getCaseCoutDeplacement();
        if (potentielDeplacement<coutDeplacement){
            JOptionPane.showMessageDialog(null, "deplacement impossible: Vous n'avez pas assez de potentiel de deplacement", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else if (uniteDestination!=null) {
            if (uniteDestination.getUniteJoueur()!=this.getUniteJoueur()){
                unitedepart.attaqueEtDefense(uniteDestination,plateau);
                potentielDeplacement-=coutDeplacement;
                setUniteDeplacementCourant(potentielDeplacement);
            }
            else if (uniteDestination.getUniteJoueur()==this.getUniteJoueur() ){
                JOptionPane.showMessageDialog(null, "deplacement impossible: il y a votre unité sur cette case", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            setUniteX(destinationX);
            setUniteY(destinationY);
            potentielDeplacement-=coutDeplacement;
            setUniteDeplacementCourant(potentielDeplacement);
            plateau.plateauMouvement(uniteX,uniteY,destinationX,destinationY);
        }
        System.out.println("Le déplacement restant est : " + getUniteDeplacementCourant());
    }
}