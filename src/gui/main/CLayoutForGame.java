
package gui.main;
import javax.swing.JPanel;
import gui.panels.PanelMonopoly;
import java.awt.CardLayout;


public class CLayoutForGame extends JPanel  {

    
    private JPanel panelMonopoly;

    private CardLayout mainFrame  = new CardLayout();

    private GameMain main;
    public CLayoutForGame(GameMain game) {


        main = game;
        setLayout(mainFrame);

        panelMonopoly = new PanelMonopoly(main);
        add(panelMonopoly, "1");
        mainFrame.show(this, "1");
        // System.out.println("il problema quia");
        // mainFrame.next(this);

        
        
    }
    
}
