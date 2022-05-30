package gui;

import javax.swing.JFrame;

public class GameFrame extends JFrame {


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
