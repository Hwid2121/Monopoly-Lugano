package gui;

import java.awt.*;

import javax.swing.*;

import gui.main.GameMain;
import model.Player;

import java.awt.event.*;
import javax.swing.*;

public class movement extends JPanel implements ActionListener{



	Timer timer;
	int xVelocity = 1;
	int yVelocity = 1;
	int x = 0;
	int y = 0;
	
	public movement(){
        super();

        // setBackground( getParent().getBackground());
		this.setPreferredSize(new Dimension(1000,1000));
		// this.setBackground(Color.black);
		// enemy = new ImageIcon("enemy.png").getImage();
        // enemy = new PieceColor(new Player("isa"));

		//backgroundImage = new ImageIcon("space.png").getImage();
		timer = new Timer(10, this);
		timer.start();
        // setOpaque(true);
        // setBackground(new Color(0,0,0,0));
        // setBackground(Color.);
        // timer.start();

	}

	public void paint(Graphics g) {
		
		// super.paint(g); // paint background
        
        
		Graphics2D map = (Graphics2D) g;
        
        
        
		
		//g2D.drawImage(backgroundImage, 0, 0, null);
		// g2D.drawImage(enemy, x, y, null);
        
        map.setPaint(Color.RED);
        map.fillOval(x, y, 50, 50);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0) {
		// 	xVelocity = xVelocity * -1;
		// // }
		x = x + xVelocity;
      
		repaint();
        // timer.start();
	}




}