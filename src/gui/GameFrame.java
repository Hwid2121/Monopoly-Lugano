package gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class GameFrame extends  JFrame {



    public GameFrame() {


        setTitle("Monopoly");

        BorderLayout layoutMain= new BorderLayout();
        JPanel playMain = new JPanel(layoutMain);



        GridLayout layoutMonopoly = new GridLayout(10,10);
        JPanel monopolyPanel = new JPanel(layoutMonopoly);
        for (int i=0; i< 100; i++){
            monopolyPanel.add(new JButton("i "+i));

            // if (i<10 || i%10==1 || ) monopolyPanel.add(new JButton("mamma" + i));




        }
        playMain.add(monopolyPanel, BorderLayout.CENTER);


        
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        for (int i =0; i< 8; i++){
            playerPanel.add(new JLabel("player" + i));
        }
        playMain.add(playerPanel, BorderLayout.EAST);
        add(playMain);



        FlowLayout commandLayout = new FlowLayout();
        JPanel commandPlay = new JPanel(commandLayout);
        commandPlay.add(new JButton("Nino"));
        commandPlay.add(new JButton("tino"));
        commandPlay.add(new JButton("mino"));
        commandPlay.add(new JButton("gino"));

        playMain.add(commandPlay, BorderLayout.SOUTH);
        
        pack();
    }
    
}
