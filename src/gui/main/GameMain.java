package gui.main;

import gui.MonopolyCommandsPanel;
import gui.MyButton;
import gui.panels.PanelMonopoly;

import java.awt.Color;
import model.*;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

public class GameMain extends JFrame {

    public final static MyButton BUTTON_STYLE = new MyButton();

    public static final Color SFONDO = new Color(205, 230, 208, 255);
    public static final Color MARRONE = new Color(149, 84, 54, 255);
    public static final Color AZZURRO = new Color(170, 224, 250, 255);
    public static final Color ROSA = new Color(217, 58, 150, 255);
    public static final Color ARANCIONE = new Color(246, 147, 28, 255);
    public static final Color ROSSO = new Color(246, 147, 28, 255);
    public static final Color GIALLO = new Color(251, 243, 3, 255);
    public static final Color VERDE = new Color(31, 178, 90, 255);
    public static final Color BLU = new Color(0, 114, 187, 255);
    public static final Color CREMISI = new Color(192, 43, 77, 255);

    public static final Border blackline = BorderFactory.createLineBorder(GameMain.CREMISI);
    public static final Font courier = new Font("SansSerif", Font.BOLD, 22);

    public static Monopoly monopoly = new Monopoly();

    private CLayout clayout;

    private CLayoutForGame monopolyGUI;

    private int status = 0;

    private CardLayout mainframe = new CardLayout();
    ImageIcon img = new ImageIcon("/home/paperino/Desktop/project-monopoly-dinasty/src/gui/images/icon.png");

    // private JFrame frame = new JFrame("Monopoly Lugano");

    public GameMain() {

        this.setTitle("Monopoly Lugano");
        this.setIconImage(img.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // clayout = new CLayout(this);
        // add(clayout);

        preGame();
        // mainGame();
        this.pack();
        this.setVisible(true);

    }

    public void preGame() {

        clayout = new CLayout(this);
        add(clayout);

        this.pack();

    }

    public void mainGame() {
        monopolyGUI = new CLayoutForGame(this);
        add(monopolyGUI);
        pack();
    }

}
