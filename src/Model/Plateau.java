package Model;
import Model.VariablesGlobales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Plateau extends JPanel implements MouseListener {
    private int rows;
    private int columns;
    private int hexSize;
    private Color[][] hexColors;

    public Plateau(int rows, int columns, int hexSize) {
        this.rows = rows;
        this.columns = columns;
        this.hexSize = hexSize;
        this.hexColors = new Color[rows][columns];
        assignRandomColors();

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = 0;  // Adjust these values to position the hexagonal field
        int startY = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int x = startX + col * hexSize * 2;
                int y = startY + row * hexSize * 2 + (col % 2) * hexSize;

                Color color = hexColors[row][col] != null ? hexColors[row][col] : Color.WHITE;
                drawHexagon(g, x, y, hexSize, color);
            }
        }
    }

    private void drawHexagon(Graphics g, int x, int y, int size, Color color) {
        int[] xPoints = {x, x + size, x + size + size, x + size, x, x - size};
        int[] yPoints = {y, y, y + size, y + size + size, y + size + size, y + size};
        int numPoints = 6;

        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, numPoints);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, numPoints);
    }

    @Override
    public Dimension getPreferredSize() {
        int width = columns * hexSize * 2 + hexSize * 2;
        int height = rows * hexSize * 2 + hexSize;

        return new Dimension(width, height);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // Determine which hexagon was clicked based on the mouse coordinates
        // Perform any desired actions or update the hexagon state accordingly
        // For example, you can calculate the row and column based on the hexSize and coordinates
        int col = (int) (x / (hexSize * 2));
        int row = (int) ((y - (col % 2) * hexSize) / (hexSize * 2));

        // Set the color of the clicked hexagon to a chosen color
        setHexagonColor(row, col, Color.RED);

        // Repaint the panel to reflect the updated color
        repaint();
    }

    // Function to set the color of a hexagon at specified coordinates
    public void setHexagonColor(int row, int col, Color color) {
        if (row >= 0 && row < rows && col >= 0 && col < columns) {
            hexColors[row][col] = color;
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

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int colorIndex = random.nextInt(5); // Randomly choose an index from 0 to 4
                hexColors[row][col] = getColorByIndex(colorIndex);
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
                return Color.GREEN.darker();
            default:
                return Color.GRAY;
        }
    }
}