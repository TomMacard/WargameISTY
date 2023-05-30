package Model;
import Vue.NouvellePartieInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

public class Plateau extends JPanel implements MouseListener {
    private NouvellePartieInterface nouvellePartieInterface;
    private int plateauLignes;
    private int plateauColonnes;
    private Color[][] plateauHexColors;
    public Case[][] plateauCases;
    public Unite[][] plateauUnites;
    private HashMap<Color, Image> colorToImage;
    public Joueur plateauJoueurActuel;

    public Joueur getPlateauJoueurActuel() {
        return plateauJoueurActuel;
    }

    public void setPlateauJoueurActuel(Joueur plateauJoueurActuel) {
        this.plateauJoueurActuel = plateauJoueurActuel;
    }

    public Plateau(int plateauLignes, int plateauColonnes, NouvellePartieInterface nouvellePartieInterface) {
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
        this.nouvellePartieInterface = nouvellePartieInterface;
        this.plateauJoueurActuel =null;

        assignRandomColors();
        plateauAttributionCases();
        plateauAttributionUnites(nouvellePartieInterface.getJoueurs());

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = -VariablesGlobales.DECALAGE;  // Adjust these values to position the hexagonal field
        int startY = 0;

        //fonction de coloriage des unités et du joueur correspondant

        for (int lig = 0; lig < plateauLignes; lig++) {
            for (int col = 0; col < plateauColonnes; col++) {
                int x = startX + col * 30 * 2;
                int y = startY + lig * 30 * 2 + (col % 2) * 30;

                Color color = plateauHexColors[lig][col] != null ? plateauHexColors[lig][col] : Color.WHITE;
                Image image = colorToImage.get(plateauHexColors[lig][col]);
                drawHexagon(g,x,y,30, image);


                if (plateauUnites[lig][col]!=null) {
                    //check pour 1 unité

                    //check le type d'unité
                    ImageIcon icon = new ImageIcon("src/images/mer.png");
                    if (plateauUnites[lig][col].getUniteType()=="TOM") {
                        icon = new ImageIcon("src/images/uniteTom.png");
                    }
                    else if (plateauUnites[lig][col].getUniteType()=="BASSEM") {
                        icon = new ImageIcon("src/images/uniteBassem.png");
                    }
                    else if (plateauUnites[lig][col].getUniteType()=="MOSTAFA") {
                        icon = new ImageIcon("src/images/uniteMostafa.png");
                    }
                    else if (plateauUnites[lig][col].getUniteType()=="DHIA") {
                        icon = new ImageIcon("src/images/uniteDhia.png");
                    }
                    else if (plateauUnites[lig][col].getUniteType()=="FADI") {
                        icon = new ImageIcon("src/images/uniteFadi.png");
                    }

                    //recupere couleur
                    g.setColor(plateauUnites[lig][col].getUniteJoueur().getJoueurCouleur());
                    //dessin sur le tableau
                    Image iconeUnite = icon.getImage();
                    g.fillOval(x-8, y+5, 50, 50);
                    g.drawImage(iconeUnite, x, y+10, 40, 40, this);
                }

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
        int width = plateauColonnes *30 * 2 + 30 * 2;
        int height = plateauLignes * 30 * 2 + 30;

        return new Dimension(width, height);
    }

    MouseEvent premierClic = null;
    MouseEvent deuxiemeClic = null;
    Unite unitecliquee = null;
    Unite unitecliquee2=null;
    Case casecliquee = null;
    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX()-VariablesGlobales.DECALAGE;
        int y = e.getY();
        
        int col = (int) (x / (30 * 2));
        int lig = (int) ((y - (col % 2) * 30) / (30 * 2));

        if (col < VariablesGlobales.Y_MAX && lig < VariablesGlobales.X_MAX) {
            if (premierClic == null) {

                casecliquee = plateauObtenirCase(lig, col);
                unitecliquee = plateauObtenirUnite(lig, col);
                //System.out.println("TOUR DU JOUEUR : "+this.plateauJoueurActuel.getJoueurNom());

                if (unitecliquee!=null) {// && unitecliquee.getUniteJoueur()==this.plateauJoueurActuel) {
                    premierClic = e;
                    System.out.println("1er clic");
                    //System.out.println("TOUR DU JOUEUR : "+this.plateauJoueurActuel.getJoueurNom());

                }
            }
            else if (deuxiemeClic == null ) {
                deuxiemeClic = e;
                System.out.println("2eme clic");
                Case casecliquee2 = plateauObtenirCase(lig, col);
                Unite unitecliquee2 = plateauObtenirUnite(lig,col);
                System.out.println(casecliquee.caseVoisins(casecliquee2));

                if (unitecliquee != null) {
                    if (casecliquee.caseVoisins(casecliquee2)) { //unitecliquee.getUniteJoueur()== )
                        //System.out.println("tentative déplacement");
                        int xarrivee = casecliquee2.getCaseX();
                        int yarrivee = casecliquee2.getCaseY();
                        unitecliquee.UniteDeplacementElementaire(xarrivee, yarrivee, this);
                        System.out.println("Deplacement effectué");
                        unitecliquee = null;
                        casecliquee = null;
                    }
                    else if (unitecliquee.getUnitePortee()>1 && unitecliquee2!=null && unitecliquee2.getUniteJoueur()!=unitecliquee.getUniteJoueur()) {
                        unitecliquee.attaqueEtDefense(unitecliquee2,this);
                    }
                }
                premierClic = null;
                deuxiemeClic = null;
            }

            /*


            //Debug
            System.out.println("==========");
            String msg="";
            if (casecliquee != null) {
                msg=msg+"Nom Case  : "+casecliquee.getCaseType()+" Coord case: "+casecliquee.getCaseX()+ ", "+casecliquee.getCaseY()+"\n";
            }
            if (unitecliquee != null) {
                msg=msg+"Nom Unité : "+unitecliquee.getUniteType()+" Nom Joueur: "+unitecliquee.getUniteJoueur().getJoueurNom();
            }
            if (unitecliquee == null) {
                msg=msg+"Pas d'unités sur cette Case";
            }
            System.out.println(msg);
            System.out.println("==========");
            //fin Debug */

        }
        //setHexagonColor(lig, col, Color.BLACK);
        repaint();
    }

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

    public Unite plateauObtenirUnite(int x, int y) {

        Unite unite=this.plateauUnites[x][y];
        return unite;
    }
    //fonction qui pose les case sur le plateau
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
    //fonction qui pose et attribue les unités sur le plateau
    public void plateauAttributionUnites(List<Joueur> joueurs) {
        if (joueurs.size()>=2) {
            this.plateauUnites[0][0] = new uniteBassem(0,0, joueurs.get(0));
            this.plateauUnites[1][0] = new uniteTom(1,0, joueurs.get(0));
            this.plateauUnites[0][1] = new uniteMostafa(0,1, joueurs.get(0));
            this.plateauUnites[1][1] = new uniteDhia(1,1, joueurs.get(0));
            this.plateauUnites[1][2] = new uniteFadi(1,2, joueurs.get(0));

            this.plateauUnites[12][15] = new uniteBassem(12,15, joueurs.get(1));
            this.plateauUnites[11][15] = new uniteTom(11,15, joueurs.get(1));
            this.plateauUnites[12][14] = new uniteMostafa(12,14, joueurs.get(1));
            this.plateauUnites[12][13] = new uniteDhia(12,13, joueurs.get(1));
            this.plateauUnites[11][14] = new uniteFadi(11,14, joueurs.get(1));

            if (joueurs.size()>=3) {
                this.plateauUnites[0][14] = new uniteBassem(0, 14, joueurs.get(2));
                this.plateauUnites[0][15] = new uniteTom(0, 15, joueurs.get(2));
                this.plateauUnites[1][14] = new uniteMostafa(1, 14, joueurs.get(2));
                this.plateauUnites[0][13] = new uniteDhia(0, 13, joueurs.get(2));
                this.plateauUnites[1][15] = new uniteFadi(1, 15, joueurs.get(2));
            }
            if (joueurs.size()==4) {
                this.plateauUnites[12][0] = new uniteBassem(12, 0, joueurs.get(3));
                this.plateauUnites[12][1] = new uniteTom(12, 1, joueurs.get(3));
                this.plateauUnites[11][0] = new uniteMostafa(11, 0, joueurs.get(3));
                this.plateauUnites[11][1] = new uniteDhia(11, 1, joueurs.get(3));
                this.plateauUnites[12][2] = new uniteFadi(12, 2, joueurs.get(3));
            }
        }

    }

    //fonction qui teleporte une unité sur le plateau (pas de verification + il faut set les coords de l'unité à part)
    public void plateauMouvement(int x1,int y1, int x2, int y2) {
        Unite uniteadeplacer = this.plateauUnites[x1][y1];
        this.plateauUnites[x1][y1]=null;
        this.plateauUnites[x2][y2]=uniteadeplacer;
    }




}