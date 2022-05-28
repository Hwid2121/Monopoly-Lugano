
package gui.main;
import javax.swing.JPanel;
import gui.panels.PanelMonopoly;
import java.awt.CardLayout;


public class CLayoutForGame extends JPanel  {

    
    private JPanel panelMonopoly = new PanelMonopoly();

    private CardLayout mainFrame  = new CardLayout();


    public CLayoutForGame() {
        super();

        setLayout(mainFrame);
        add(panelMonopoly, "1");
        mainFrame.show(this, "1");
        
    }
    
}
