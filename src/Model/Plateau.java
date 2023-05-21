package Model;

import java.util.List;

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
