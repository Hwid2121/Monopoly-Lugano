
package gui.main;
import javax.swing.JPanel;
import gui.panels.PanelMonopoly;
import java.awt.CardLayout;


public class CLayoutForGame extends JPanel  {

    private CardLayout mainFrame  = new CardLayout();

    private GameMain main;
    public CLayoutForGame(GameMain game) {

    
        super();

        main = game;
        setLayout(mainFrame);

        
        comand();

        mainFrame.show(this, "dice");
        

        
        
    }


    public void comand() {
        PanelMonopoly panelMonopoly = new PanelMonopoly(main);
        add(panelMonopoly, "dice");
        mainFrame.show(this, "dice");
    }
    
}
