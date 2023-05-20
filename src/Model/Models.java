package Model;

import java.util.List;
import java.util.Queue;


public class Models {

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

    public class Jeu {
        private Plateau jeuPlateau;
        private List<Joueur> jeuJoueurs;
        private List<Unite> jeuUnites;

        public Jeu(Plateau plateau, List<Joueur> joueurs, List<Unite> unites) {
            this.jeuPlateau = plateau;
            this.jeuJoueurs = joueurs;
            this.jeuUnites = unites;
        }

        // Getters
        public Plateau getJeuPlateau() {
            return jeuPlateau;
        }

        public List<Joueur> getJeuJoueurs() {
            return jeuJoueurs;
        }

        public List<Unite> getJeuUnites() {
            return jeuUnites;
        }

        // Setters
        public void setJeuPlateau(Plateau jeuPlateau) {
            this.jeuPlateau = jeuPlateau;
        }

        public void setJeuJoueurs(List<Joueur> jeuJoueurs) {
            this.jeuJoueurs = jeuJoueurs;
        }

        public void setJeuUnites(List<Unite> jeuUnites) {
            this.jeuUnites = jeuUnites;
        }
    }

    public class Tour {
        private int tourActuel;
        private Queue<Joueur> tourListeJoueurs;

        public Tour(int actuel, Queue<Joueur> listeJoueurs) {
            this.tourActuel = actuel;
            this.tourListeJoueurs = listeJoueurs;
        }

        // Getters
        public int getTourActuel() {
            return tourActuel;
        }

        public Queue<Joueur> getTourListeJoueurs() {
            return tourListeJoueurs;
        }

        // Setters
        public void setTourActuel(int tourActuel) {
            this.tourActuel = tourActuel;
        }

        public void setTourListeJoueurs(Queue<Joueur> tourListeJoueurs) {
            this.tourListeJoueurs = tourListeJoueurs;
        }
    }

    public class Joueur {
        private List<Unite> joueurUnites;
        private boolean joueurVictoire;
        private String joueurNom;
        private String joueurCouleur;

        public Joueur(List<Unite> unites, boolean victoire, String nom, String couleur) {
            this.joueurUnites = unites;
            this.joueurVictoire = victoire;
            this.joueurNom = nom;
            this.joueurCouleur = couleur;
        }

        // Getters
        public List<Unite> getJoueurUnites() {
            return joueurUnites;
        }

        public boolean isJoueurVictoire() {
            return joueurVictoire;
        }

        public String getJoueurNom() {
            return joueurNom;
        }

        public String getJoueurCouleur() {
            return joueurCouleur;
        }

        // Setters
        public void setJoueurUnites(List<Unite> joueurUnites) {
            this.joueurUnites = joueurUnites;
        }

        public void setJoueurVictoire(boolean joueurVictoire) {
            this.joueurVictoire = joueurVictoire;
        }

        public void setJoueurNom(String joueurNom) {
            this.joueurNom = joueurNom;
        }

        public void setJoueurCouleur(String joueurCouleur) {
            this.joueurCouleur = joueurCouleur;
        }
    }

    public class Plateau {
        private List<Case> plateauCases;
        private List<Unite> plateauUnites;

        public Plateau(List<Case> cases, List<Unite> unites) {
            this.plateauCases = cases;
            this.plateauUnites = unites;
        }

        // Getters
        public List<Case> getPlateauCases() {
            return plateauCases;
        }

        public List<Unite> getPlateauUnites() {
            return plateauUnites;
        }

        // Setters
        public void setPlateauCases(List<Case> plateauCases) {
            this.plateauCases = plateauCases;
        }

        public void setPlateauUnites(List<Unite> plateauUnites) {
            this.plateauUnites = plateauUnites;
        }
    }





}
