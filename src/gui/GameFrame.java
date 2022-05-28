package gui;
import javax.swing.JFrame;
import java.awt.BorderLayout;


public class GameFrame extends JFrame {

    // private final Color = ;

    public GameFrame() {

        setTitle("Monopoly");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        BorderLayout layoutMain = new BorderLayout();
        pack();
    }

}
