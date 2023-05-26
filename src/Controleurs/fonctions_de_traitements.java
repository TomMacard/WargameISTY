package Controleurs;
import javax.sound.sampled.*;
import javax.swing.UIManager;


import Vue.MenuPrincipal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class fonctions_de_traitements {

    //incrémenter "tourActuel" quand le joueur appuie sur le boutton "fin de tour"

    private static Clip clip;

    public static void playMusic() {
        try {
            File musicFile = new File("src/music/musicBackground.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String buttonStyle = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(buttonStyle);
        playMusic();

        Dimension size = new Dimension(1400, 830);
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setBorder(BorderFactory.createEmptyBorder());


        menuPrincipal.setApplication(null);
        JFrame frame = new JFrame("Wargame Meilleur Groupe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(menuPrincipal, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(size);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
