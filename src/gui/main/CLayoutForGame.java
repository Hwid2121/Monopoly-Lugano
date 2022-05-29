
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
    
    public CLayoutForGame(GameMain game) {

    
        super();

        main = game;
        setLayout(mainFrame);

        
        player =  monopoly.getPLayer(turn);


        // while(GameMain.monopoly.monopolyEND()){

            
            // monopoly.getPLayer(turn);
            turn = turn % numberOfPlayers;



            monopoly(monopoly.getPLayer(turn));


       


        // }
        


        

        
        
    }


    public void monopoly(Player player) {
        PanelMonopoly panelMonopoly = new PanelMonopoly(this, player);
        add(panelMonopoly, "monopoly");
        
        mainFrame.show(this, "monopoly");
        
    }   


    public void refresh(){


        monopoly(player);
       System.out.println("POSIXIONE PLA" + monopoly.getListOfPlayer().get(0).getPosition());
    }


    public void nextPage(){

        PanelMonopoly panelMonopoly = new PanelMonopoly(this, player);
        add(panelMonopoly, "monopoly");
        // mainFrame.
    }


    // public void finishGame(){
    //     end
    // }

     
}
