
package gui.main;
import javax.swing.JPanel;
import gui.panels.PanelMonopoly;
import model.Monopoly;
import model.Player;

import java.awt.CardLayout;


public class CLayoutForGame extends JPanel  {



    public   static int puttana = 0;
    private CardLayout mainFrame  = new CardLayout();

    private GameMain main;
    private Monopoly monopoly = GameMain.monopoly;



    private int turn =0;
    private int numberOfPlayers = monopoly.getNumOfplayer();
    private int skip = 0;

    private Player player;

    private int fase = 0;



    
    public CLayoutForGame(GameMain game) {

    
        super();

        main = game;
        setLayout(mainFrame);

        
        


        // while(GameMain.monopoly.monopolyEND()){

            
            
  
            
            player =  monopoly.getPLayer(turn);
            turn = turn % numberOfPlayers;
            monopoly(monopoly.getPLayer(turn), fase);





        // }
        
        


        

        
        
    }


    public void monopoly(Player player, int i) {
        PanelMonopoly panelMonopoly = new PanelMonopoly(this, player);
        add(panelMonopoly, "1");
        
        mainFrame.show(this, "1");
        
    }   


    public void refresh(){

       System.out.println("POSIXIONE PLA" + monopoly.getListOfPlayer().get(0).getPosition());

    }


    public void nextPage(){

        PanelMonopoly panelMonopolys = new PanelMonopoly(this, player);
        add(panelMonopolys, "2");
        incrementFase();
        // setFase(1);

        // mainFrame.next(this);
        mainFrame.show(this, "2");

    }


    public int getFase() {
        return fase;
    }


    public void incrementFase() {
        fase = fase +1;
    }

    public void setFase(int i){
        fase = i;
    }



    public void passTurn(){
        skip = 1;
    }

    public void resetTurn(){
        skip = 0;
    }



     
}
