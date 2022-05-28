package gui;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class MonopolyGridPanel extends JPanel {


    Image backgroundImage;

    public MonopolyGridPanel() {
        backgroundImage = new ImageIcon("/home/paperino/Desktop/project-monopoly-dinasty/src/gui/images/monopolygrid2.png").getImage();


        // ImageResizer.resize(backgroundImage, outputImagePath2, percent);

        
        

    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        Image img = backgroundImage.getScaledInstance(1000  , 1000, Image.SCALE_AREA_AVERAGING);
        g2D.drawImage(img,0 ,0 , null);
    }

}
