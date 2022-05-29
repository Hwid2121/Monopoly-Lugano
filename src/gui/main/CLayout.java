package gui.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import gui.panels.PanelPlayers;
import gui.panels.PanelPregame;
import java.awt.CardLayout;



public class CLayout extends JPanel implements ActionListener {

    // private JFrame frame = new JFrame("Monopoly Lugano");
    // private JPanel panelCont = new JPanel();
    //private JPanel panelPregame;
    // private JPanel panelPlayers = new PanelPlayers();
    // private JPanel panelMonopoly = new PanelMonopoly();

    private CardLayout mainFrame = new CardLayout();

    // private JPanel clayoutforgame = new CLayoutForGame();

    private GameMain main;
    // ImageIcon img = new ImageIcon("/src/gui/images/icon.png");

    public CLayout(GameMain game) {
        super();
        main = game;

        this.setLayout(mainFrame);
        JPanel panelPregame = new PanelPregame(this);
        // frame.setTitle("Monopoly Lugano");
        // frame.setIconImage(img.getImage());

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.add(panelPregame, "1");
        mainFrame.show(this, "1");

        // frame.add(panelCont);
        // frame.pack();
        // frame.setVisible(true);
        

    }

    public void switchCard() {

        JPanel panelPlayers = new PanelPlayers(this);
        this.add(panelPlayers, "2");

        mainFrame.next(this);
    }


    public void endPreGame(){


        // main.setStatus(1)

        // JPanel panelMonopoly = new PanelMonopoly();
        // panelCont.add(panelMonopoly, "3");

        // mainFrame.next(panelCont);
        // PanelMonopoly.mamma();
        // System.out.println("heigh tot" + panelMonopoly.getHeight());
        // System.out.println("width tot" + panelMonopoly.getWidth());
        // this.dispose();
        this.setVisible(false); 
        

        // main.setStatus(1);

        main.mainGame();
        



    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // mainFrame.next(panelCont);
    }

}
