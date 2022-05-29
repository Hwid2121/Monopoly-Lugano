package gui;

import javax.swing.JPanel;

import gui.main.GameMain;
import model.Player;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ImageIcon;

import javax.swing.Timer;
import javax.swing.text.Position;

import model.*;

public class MonopolyGridPanel extends JPanel  implements ActionListener{


    
    private int casella;
    
    // private movement move = new movement(); 

    private Timer timer;
	private int xVelocity = 1;
	private int yVelocity = 1;
	private int x = 909 ;
    // 909
	private int y = 808 ;
    // 909
    private int step;
	private Position pos;

    private GridPosition gridpos = new GridPosition();

    private Monopoly monopoly = GameMain.monopoly;

    
    private Player player;


    //background image.
    private Image backgroundImage;

    public MonopolyGridPanel(Player playerz) {
        super();
        backgroundImage = new ImageIcon("src/gui/images/monopolygrid1000.png").getImage();
        this.player = playerz;

        // setStep(2);
        // timer = new Timer(5, this);
		// timer.start();
        // player.setPosition(5);
        
       
        

    }








    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D pan = (Graphics2D) g;


        pan.drawImage(backgroundImage,0 ,0 , null);

        
        // pan.fillOval(x, , arg2, arg3);


        for (Player player: monopoly.getListOfPlayer()){


            pan.setPaint(player.getPiece().getColor());
            pan.fillOval(gridpos.getPosition(player.getPosition()).getX(), gridpos.getPosition(player.getPosition()).getY(), 30, 30);


        }




    }



    // public void setPlayerPosition(Player player){
            
    //     casella = player.getPosition();

    // }

    public void setStep(int i){


    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        

        // while()
       
    }


    








}
