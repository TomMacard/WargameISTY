import Model.Models;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("hello Bassem !");
    }

/*

    /////// Fonction qui reprend une ancienne parite/////////

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public static void chargerPartie(final String saveName) {
    final File saveFile = new File("./" + saveName);
    try {
        FileReader load = new FileReader(saveFile);
        int x, y;
        try {
            // Lecture du plateau
            for (y = 0; y < MAPLIGNE; y++) {
                for (x = 0; x < MAPCOLONNE; x++) {
                    map[y][x].setType(load.read());
                }
            }
            // Lecture des joueurs
            int playerCount = load.read();
            listeJoueurs = new ArrayList<>();
            for (int i = 0; i < playerCount; i++) {
                int pseudoLength = load.read();
                StringBuilder pseudo = new StringBuilder();
                for (int j = 0; j < pseudoLength; j++) {
                    pseudo.append((char) load.read());
                }
                Joueur joueur = new Joueur(i + 1, pseudo.toString()); // on utilise i+1 pour le numéro du joueur
                joueur.setListeUnite(new ArrayList<>());
                int unitCount = load.read();
                for (int j = 0; j < unitCount; j++) {
                    int typeUnite = load.read();
                    int attaque = load.read();
                    int defense = load.read();
                    int pv = load.read();
                    int pvMax = load.read();
                    int ptDeDeplacement = load.read();
                    int ptDeDeplacementMax = load.read();
                    int vision = load.read();
                    int porte = load.read();
                    x = load.read();
                    y = load.read();
                    int equipe = joueur.getNumeroJoueur();
                    Unite unite = new Unite(typeUnite, attaque, defense, pv, ptDeDeplacement, vision, porte, x, y, equipe);
                    joueur.getListeUnite().add(unite);
                }
                listeJoueurs.add(joueur);
            }
            turn = load.read();
        } finally {
            load.close();
        }
    } catch (IOException e) {
        System.out.println("Erreur lors de la lecture du fichier");
    }
}
*/
}
