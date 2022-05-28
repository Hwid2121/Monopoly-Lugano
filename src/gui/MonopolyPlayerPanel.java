package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import gui.main.GameMain;
import model.*;
public class MonopolyPlayerPanel extends JPanel {

    Monopoly monopoly = GameMain.monopoly;
    int numPlayers = monopoly.getNumOfplayer();

    // JPanel statPanel = new PlayerStatPanel();



    GridLayout layout = new GridLayout(numPlayers, 2);

    public MonopolyPlayerPanel (){
        setLayout(layout);

        // setSize(new DimensionUIResource(, height));

        setBackground(GameMain.SFONDO);
        setBorder(GameMain. BLACKLINE);
        
        setFont(GameMain.COURIER);

        for(Player x: monopoly.getListOfPlayer()){

            add(new PlayerStatPanel(x));
        }




    }

}
