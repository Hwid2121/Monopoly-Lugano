package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import model.Monopoly;

public class GameFrame extends JFrame {

    private GamePanel gamePanel = new GamePanel();
    private Monopoly monopoly = new Monopoly();

    // private final Color = ;

    public GameFrame() {

        GamePanel gamePanel = new GamePanel();
        setTitle("Monopoly");

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        BorderLayout layoutMain = new BorderLayout();
        JPanel playMain = new JPanel(layoutMain);


        pack();
    }

}
