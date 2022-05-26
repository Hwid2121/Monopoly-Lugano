package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.colorchooser.*;
import java.awt.Color;
import javax.swing.SwingUtilities;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.CardLayout;


public class CLayout extends JFrame implements ActionListener {

    private JFrame frame = new JFrame("Monopoly Lugano");

    private JPanel panelCont = new JPanel();
    private JPanel panelPregame = new PanelPregame();
    private JPanel panelPlayers = new PanelPlayers();
    private JPanel panelMonopoly = new PanelMonopoly();
    private JPanel panelEnd = new PanelEnd();
    private CardLayout mainFrame = new CardLayout();



    public final static MyButton BUTTON_STYLE = new MyButton();


    public static final Color SFONDO = new Color(205,230,208,255);
    public static final Color MARRONE = new Color(149,84,54,255);
    public static final Color AZZURRO = new Color (170,224,250,255);
    public static final Color ROSA = new Color (217,58,150,255);
    public static final Color ARANCIONE = new Color (246,147,28,255);
    public static final Color ROSSO = new Color (246,147,28,255);
    public static final Color GIALLO = new Color (251,243,3,255);
    public static final Color VERDE = new Color (31,178,90,255);
    public static final Color BLU = new Color (0,114,187,255);
    public static final Color CREMISI = new Color (192,43,77,255);

    ImageIcon img = new ImageIcon("/home/paperino/Desktop/project-monopoly-dinasty/src/gui/images/icon.png");



    public CLayout() {
        panelCont.setLayout(mainFrame);
        

        
        frame.setTitle("Monopoly Lugano");
        frame.setIconImage(img.getImage());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 




        panelCont.add(panelPregame, "1");
        panelCont.add(panelPlayers, "2");
        panelCont.add(panelMonopoly, "3");
        panelCont.add(panelEnd, "4");



        mainFrame.show(panelCont, "1");




        frame.add(panelCont);
        frame.pack();
        frame.setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent arg0) {
        mainFrame.next(panelCont);
    }
    

}

