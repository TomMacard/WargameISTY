package Model;
import Model.VariablesGlobales;
import Vue.NouvellePartieInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

public class Plateau extends JPanel implements MouseListener {
    private int plateauLignes;
    private int plateauColonnes;
    private Color[][] plateauHexColors;
    public Case[][] plateauCases;
    public Unite[][] plateauUnites;
    private HashMap<Color, Image> colorToImage;

    public Plateau(int plateauLignes, int plateauColonnes) {
        this.plateauLignes = plateauLignes;
        this.plateauColonnes = plateauColonnes;
        this.plateauHexColors = new Color[plateauLignes][plateauColonnes];
        this.plateauCases = new Case[plateauLignes][plateauColonnes];
        this.plateauUnites = new Unite[plateauLignes][plateauColonnes];
        colorToImage = new HashMap<>();
        colorToImage.put(Color.RED, new ImageIcon("src/images/foret.png").getImage());
        colorToImage.put(Color.BLUE, new ImageIcon("src/images/mer.png").getImage());
        colorToImage.put(Color.DARK_GRAY, new ImageIcon("src/images/montagne.png").getImage());
        colorToImage.put(Color.YELLOW, new ImageIcon("src/images/desert.png").getImage());
        colorToImage.put(Color.GREEN, new ImageIcon("src/images/plaine.png").getImage());
        
        assignRandomColors();

        plateauAttributionCases();
        //plateauAttributionUnites(jeu);

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = -VariablesGlobales.DECALAGE;  // Adjust these values to position the hexagonal field
        int startY = 0;

        for (int lig = 0; lig < plateauLignes; lig++) {
            for (int col = 0; col < plateauColonnes; col++) {
                int x = startX + col * 30 * 2;
                int y = startY + lig * 30 * 2 + (col % 2) * 30;

                Image image = colorToImage.get(plateauHexColors[lig][col]);
                drawHexagon(g, x, y, 30, image);
            }
        }
    }

    private void drawHexagon(Graphics g, int x, int y, int size, Image image) {
        int[] xPoints = {x, x + size, x + size + size, x + size, x, x - size};
        int[] yPoints = {y, y, y + size, y + size + size, y + size + size, y + size};
        int numPoints = 6;

        int imageX = x-30 ;  // Adjust these values as necessary
        int imageY = y ;

        g.drawImage(image, imageX, imageY, size*3, size*2, this);

        //g.setColor(Color.BLACK);
        //g.drawPolygon(xPoints, yPoints, numPoints);
    }



    @Override
    public Dimension getPreferredSize() {
        int width = plateauColonnes * 41 * 2 + 30 * 2;
        int height = plateauLignes * 30 * 2 + 30;

        return new Dimension(width, height);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()-VariablesGlobales.DECALAGE;
        int y = e.getY();
        
        int col = (int) (x / (30 * 2));
        int lig = (int) ((y - (col % 2) * 30) / (30 * 2));

        if (col < VariablesGlobales.Y_MAX && lig < VariablesGlobales.X_MAX) {
            System.out.println("Case cliquée : "+col+ ", "+lig);
            Case casecliquee = plateauObtenirCase(lig,col);
            if (casecliquee != null) {
                System.out.println(casecliquee.getCaseType());
            }


        }
        //setHexagonColor(lig, col, Color.BLACK);
        
        repaint();
    }

    // Function to set the color of a hexagon at specified coordinates
    public void setHexagonColor(int lig, int col, Color color) {
        if (lig >= 0 && lig < plateauLignes && col >= 0 && col < plateauColonnes) {
            plateauHexColors[lig][col] = color;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    private void assignRandomColors() {
        Random random = new Random();

        for (int lig = 0; lig < plateauLignes; lig++) {
            for (int col = 0; col < plateauColonnes; col++) {
                int colorIndex = random.nextInt(5); // Randomly choose an index from 0 to 4
                plateauHexColors[lig][col] = getColorByIndex(colorIndex);
            }
        }
    }

    private Color getColorByIndex(int index) {
        switch (index) {
            case 0:
                return Color.DARK_GRAY;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.RED;
            default:
                return Color.GRAY;
        }
    }

    public Case plateauObtenirCase(int x, int y) {

        Case tuile=this.plateauCases[x][y];
        return tuile;
    }

    public void plateauAttributionCases() {
        for (int lig = 0; lig < plateauLignes; lig++) {
            for (int col = 0; col < plateauColonnes; col++) {
                Color couleur = this.plateauHexColors[lig][col];
                if (couleur==Color.YELLOW) {
                    this.plateauCases[lig][col]= new caseDesert(true,lig,col);
                }
                else if (couleur==Color.GREEN) {
                    this.plateauCases[lig][col]= new casePlat(true,lig,col);
                }
                else if (couleur==Color.DARK_GRAY) {
                    this.plateauCases[lig][col]= new caseMontagne(true,lig,col);
                }
                else if (couleur==Color.BLUE) {
                    this.plateauCases[lig][col]= new caseMer(false,lig,col);
                }
                else if (couleur==Color.RED) {
                    this.plateauCases[lig][col]= new caseForet(true,lig,col);
                }
            }
        }
    }

    public void plateauAttributionUnites(Jeu jeu) {
        List<Joueur> joueurs = jeu.getJeuJoueurs();
        if (joueurs.size()==2) {
            this.plateauUnites[0][0] = new uniteBassem(0,0, joueurs.get(0));
            this.plateauUnites[1][0] = new uniteTom(1,0, joueurs.get(0));
            this.plateauUnites[0][1] = new uniteMostafa(0,1, joueurs.get(0));
            this.plateauUnites[1][1] = new uniteDhia(0,1, joueurs.get(0));
            this.plateauUnites[1][2] = new uniteFadi(0,1, joueurs.get(0));
            /*
            this.plateauUnites[0][0] = new uniteBassem(0,0, joueurs.get(1));
            this.plateauUnites[1][0] = new uniteTom(1,0, joueurs.get(1));
            this.plateauUnites[1][0] = new uniteMostafa(0,1, joueurs.get(1));
            this.plateauUnites[1][0] = new uniteDhia(0,1, joueurs.get(1));
            this.plateauUnites[1][0] = new uniteFadi(0,1, joueurs.get(1));
             */
        }
        if (joueurs.size()==3) {
            this.plateauUnites[0][0] = new uniteBassem(0, 0, joueurs.get(2));
            this.plateauUnites[1][0] = new uniteTom(1, 0, joueurs.get(2));
            this.plateauUnites[1][0] = new uniteMostafa(0, 1, joueurs.get(2));
            this.plateauUnites[1][0] = new uniteDhia(0, 1, joueurs.get(2));
            this.plateauUnites[1][0] = new uniteFadi(0, 1, joueurs.get(2));
        }
        if (joueurs.size()==4) {
            this.plateauUnites[0][0] = new uniteBassem(0, 0, joueurs.get(3));
            this.plateauUnites[1][0] = new uniteTom(1, 0, joueurs.get(3));
            this.plateauUnites[1][0] = new uniteMostafa(0, 1, joueurs.get(3));
            this.plateauUnites[1][0] = new uniteDhia(0, 1, joueurs.get(3));
            this.plateauUnites[1][0] = new uniteFadi(0, 1, joueurs.get(3));
        }
    }


}