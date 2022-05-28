package gui;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.JLabel;
import java.awt.GridLayout;
// import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import javax.swing.JButton;
import gui.main.CLayout;
import gui.main.GameMain;
import gui.pregame.PanelNickname;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.Box;
import java.awt.Component;
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
        setBorder(GameMain.blackline);
        
        setFont(GameMain.courier);

        for(Player x: monopoly.getListOfPlayer()){

            add(new PlayerStatPanel(x));
        }




    }

}
