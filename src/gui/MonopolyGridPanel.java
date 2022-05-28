package gui;

import javax.swing.JPanel;

import gui.main.GameMain;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class MonopolyGridPanel extends JPanel {


    Image backgroundImage;

    public MonopolyGridPanel() {
        backgroundImage = new ImageIcon("/home/paperino/Desktop/project-monopoly-dinasty/src/gui/images/monopolygrid1000.png").getImage();

        

    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D pan = (Graphics2D) g;


        // Image img = backgroundImage.getScaledInstance(924  , 1664, Image.SCALE_SMOOTH);
        pan.drawImage(backgroundImage,0 ,0 , null);

        pan.setPaint(GameMain.AZZURRO);
        pan.fillOval(10,10 , 30, 30);

        
    }





}
