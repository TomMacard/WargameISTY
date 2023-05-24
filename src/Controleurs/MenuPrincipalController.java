package Controleurs;

import Vue.MenuPrincipal;

public class MenuPrincipalController {

    private MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }

    public void nouvellePartie() {
        // Code pour démarrer une nouvelle partie
        System.out.println("Nouvelle partie");
    }

    public void reprendrePartie() {
        // Code pour reprendre une partie enregistrée
        System.out.println("Reprendre partie");
    }

    public void aide() {
        // Code pour afficher l'aide du jeu
        System.out.println("Aide");
    }

    public void quitter() {
        // Code pour quitter le jeu
        System.out.println("Quitter");
        System.exit(0);
    }
}