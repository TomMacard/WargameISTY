package Model;
import Model.VariablesGlobales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

        this.plateauUnites = null;

        colorToImage = new HashMap<>();
        colorToImage.put(Color.RED, new ImageIcon("src/images/foret3.png").getImage());
        colorToImage.put(Color.BLUE, new ImageIcon("src/images/riviere3.png").getImage());
        colorToImage.put(Color.DARK_GRAY, new ImageIcon("src/images/montagne3.png").getImage());
        colorToImage.put(Color.YELLOW, new ImageIcon("src/images/desert3.png").getImage());
        colorToImage.put(Color.GREEN, new ImageIcon("src/images/plaine3.png").getImage());
        //colorToImage.put(Color.RED, new ImageIcon("src/images/foret31.png").getImage());
        
        assignRandomColors();

        plateauAttributionCases();

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = -VariablesGlobales.DECALAGE;  // Adjust these values to position the hexagonal field
        int startY = 0;

        for (int row = 0; row < plateauLignes; row++) {
            for (int col = 0; col < plateauColonnes; col++) {
                int x = startX + col * 30 * 2;
                int y = startY + row * 30 * 2 + (col % 2) * 30;

                Image image = colorToImage.get(plateauHexColors[row][col]);
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

        // Determine which hexagon was clicked based on the mouse coordinates
        // Perform any desired actions or update the hexagon state accordingly
        // For example, you can calculate the row and column based on the 30 and coordinates
        int col = (int) (x / (30 * 2));
        int row = (int) ((y - (col % 2) * 30) / (30 * 2));

        if (col < VariablesGlobales.Y_MAX && row < VariablesGlobales.X_MAX) {
            System.out.println("Case cliquée : "+col+ ", "+row);

            Color clickedColor = plateauHexColors[row][col];
            System.out.println("Couleur: " + clickedColor);

            Case casecliquee = plateauObtenirCase(row,col);

            if (casecliquee != null) {
                System.out.println(casecliquee.getCaseType());
            }


        }




        // Set the color of the clicked hexagon to a chosen color
        //setHexagonColor(row, col, Color.BLACK);

        // Repaint the panel to reflect the updated color
        repaint();
    }

    // Function to set the color of a hexagon at specified coordinates
    public void setHexagonColor(int row, int col, Color color) {
        if (row >= 0 && row < plateauLignes && col >= 0 && col < plateauColonnes) {
            plateauHexColors[row][col] = color;
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

        for (int row = 0; row < plateauLignes; row++) {
            for (int col = 0; col < plateauColonnes; col++) {
                int colorIndex = random.nextInt(5); // Randomly choose an index from 0 to 4
                plateauHexColors[row][col] = getColorByIndex(colorIndex);
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
        for (int row = 0; row < plateauLignes; row++) {
            for (int col = 0; col < plateauColonnes; col++) {
                Color couleur = this.plateauHexColors[row][col];
                if (couleur==Color.YELLOW) {
                    this.plateauCases[row][col]= new caseDesert(true,row,col);
                }
                else if (couleur==Color.GREEN) {
                    this.plateauCases[row][col]= new casePlat(true,row,col);
                }
                else if (couleur==Color.DARK_GRAY) {
                    this.plateauCases[row][col]= new caseMontagne(true,row,col);
                }
                else if (couleur==Color.BLUE) {
                    this.plateauCases[row][col]= new caseMer(false,row,col);
                }
                else if (couleur==Color.RED) {
                    this.plateauCases[row][col]= new caseForet(true,row,col);
                }




            }
        }
    }


}