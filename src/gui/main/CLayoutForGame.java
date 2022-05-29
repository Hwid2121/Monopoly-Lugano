
package gui.main;
import javax.swing.JPanel;
import gui.panels.PanelMonopoly;
import model.Monopoly;
import model.Player;

import java.awt.CardLayout;


public class CLayoutForGame extends JPanel  {

    private CardLayout mainFrame  = new CardLayout();

    private GameMain main;
    private Monopoly monopoly = GameMain.monopoly;



    private int turn =0;
    private int numberOfPlayers = monopoly.getNumOfplayer();
    private int skip = 0;

    private Player player;

    int fase =0;
    
    public CLayoutForGame(GameMain game) {

    
        super();

        main = game;
        setLayout(mainFrame);

        
        


        // while(GameMain.monopoly.monopolyEND()){

            
            
  
            
            player =  monopoly.getPLayer(turn);
            turn = turn % numberOfPlayers;
            monopoly(monopoly.getPLayer(turn), fase);

            


// 
        // }
        
        


        

        
        
    }


    public void monopoly(Player player, int i) {
        PanelMonopoly panelMonopoly = new PanelMonopoly(this, player, fase);
        add(panelMonopoly, "1");
        
        mainFrame.show(this, "1");
        
    }   


    public void refresh(){

       System.out.println("POSIXIONE PLA" + monopoly.getListOfPlayer().get(0).getPosition());

    }


    public void nextPage(){

        PanelMonopoly panelMonopoly = new PanelMonopoly(this, player, fase);
        add(panelMonopoly, "2");
        mainFrame.next(this);
    }




     
}
