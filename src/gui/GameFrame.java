package gui;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Square;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLClientInfoException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import model.Monopoly;

public class GameFrame extends  JFrame {


    private GamePanel gamePanel = new GamePanel();
    private Monopoly monopoly  = new Monopoly();

    

    // private final Color = ;

    public GameFrame() {



        GamePanel gamePanel = new GamePanel();
        setTitle("Monopoly");


        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        
        BorderLayout layoutMain= new BorderLayout();
        JPanel playMain = new JPanel(layoutMain); 






         





        // GridLayout layoutMonopoly = new GridLayout(10,10);
        // JPanel monopolyPanel = new JPanel(layoutMonopoly);
        


        

        // for(Square sq: monopoly.getTable().getCell()){

        //     monopolyPanel.add(new JButton(sq.getName()));

        // }

        // playMain.add(monopolyPanel, BorderLayout.CENTER);



        




        // JPanel playerPanel = new JPanel();
        // playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        // for (int i =0; i< 8; i++){
        //     playerPanel.add(new JLabel("player" + i));
        // }
        // playMain.add(playerPanel, BorderLayout.EAST);
        // add(playMain);



        // FlowLayout commandLayout = new FlowLayout();
        // JPanel commandPlay = new JPanel(commandLayout);
        // commandPlay.add(new JButton("Nino"));
        // commandPlay.add(new JButton("tino"));
        // commandPlay.add(new JButton("mino"));
        // commandPlay.add(new JButton("gino"));

        // playMain.add(commandPlay, BorderLayout.SOUTH);
        
        pack();
    }
    
}
