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

import javax.swing.Action;
import javax.swing.ImageIcon;

import javax.swing.Timer;
import javax.swing.text.Position;

public class MonopolyGridPanel extends JPanel  implements ActionListener{


    
    private int casella;
    
    private movement move = new movement(); 

    private Timer timer;
	private int xVelocity = 1;
	private int yVelocity = 1;
	private int x = 909 ;
    // 909
	private int y = 808 ;
    // 909
    private int step;
	private Position pos;



    Image backgroundImage;

    public MonopolyGridPanel() {
        backgroundImage = new ImageIcon("/home/paperino/Desktop/project-monopoly-dinasty/src/gui/images/monopolygrid1000.png").getImage();
        // timer  = new Timer();
        // add(move);

        // setStep(2);
        // timer = new Timer(5, this);
		// timer.start();
        
       
        

    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D pan = (Graphics2D) g;


        pan.drawImage(backgroundImage,0 ,0 , null);


        pan.setPaint(GameMain.AZZURRO);
        pan.fillOval(x,y , 30, 30);


    }



    public void setPlayerPosition(Player player){
            
        casella = player.getPosition();

    }

    public void setStep(int i){
        // step = 45*i;

        // step = i * -76;
        //  -61 - 15
        step = i * 76;
        step = step - 30;

    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        


        
        if(y== 61 && x <  909){
            
            if (x != step){
                // step = step - x;
                xVelocity = 1;
                x = x + xVelocity;
                repaint();
            }
        } 

        if(x == 909 && y < 909){
           
            if (y != step){
                // step = step - y;
                yVelocity = 1;
                y = y + yVelocity;
                repaint();
            }
        }



        if( y == 909  && x > 61)
        {
            
            if(x != step){
                // step = step - x;
                xVelocity = -1;
                x = x + xVelocity;
                repaint();
            }
        }

        if ( x == 61 && y > 61){
            // step = step - y;
            if(y != step){
                // step = step - x;
                yVelocity = -1;
                y = y + yVelocity;
                repaint();
            }
        }

        





        



		// repaint();
    }








}
