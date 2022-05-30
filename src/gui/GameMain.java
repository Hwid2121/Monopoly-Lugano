package gui;

import model.Monopoly;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 * Main frame where monopoly is shown.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class GameMain extends JFrame {

    public static final  MyButton BUTTON_STYLE = new MyButton();

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

    public static final Border BLACKLINE = BorderFactory.createLineBorder(GameMain.CREMISI);
    public static final Font COURIER = new Font("SansSerif", Font.BOLD, 22);

    public static Monopoly monopoly = new Monopoly();

    private CLayout clayout = new CLayout(this);

    private JPanel pannello = new JPanel();

    private CardLayout mainframe = new CardLayout();

    private ImageIcon img = new ImageIcon("src/gui/images/icon.png");





    /**
     * Constructor of the main frame.
     */
    public GameMain() {
        super();

        this.setTitle("Monopoly Lugano");
        this.setIconImage(img.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        pannello.setLayout(mainframe);

        pannello.add(clayout, "1");

        this.add(pannello);

        mainframe.show(pannello, "1");

        this.pack();
        this.setVisible(true);

    }

    /**
     * Change the stage of the game with mainGame() card.
     *
     */
    public void mainGame() {
        CLayoutForGame monopolyGUI = new CLayoutForGame(this);
        pannello.add(monopolyGUI, "2");
        mainframe.show(pannello, "2");

    }

}
