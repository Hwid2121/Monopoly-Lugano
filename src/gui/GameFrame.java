package gui;

import javax.swing.JFrame;





/**
 * GameFrame frame where the game is showned.
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class GameFrame extends JFrame {



    /**
     * Constructor of the GameFrame.
     * 
     */
    public GameFrame() {
        super();

        setTitle("Monopoly");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        pack();
    }

}
