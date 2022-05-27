package gui;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics2D;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.colorchooser.*;
import javax.swing.plaf.ButtonUI;

import java.awt.Color;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.image.BufferedImage;

import model.*;

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
