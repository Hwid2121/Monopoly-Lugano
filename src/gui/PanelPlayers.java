package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

import model.Monopoly;

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
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import java.awt.TextField;

public class PanelPlayers extends JPanel implements ActionListener {


    private final Dimension PRF_SIZE_IMG = new Dimension(800, 800);
    private final Dimension MIN_SIZE_IMG = new Dimension(200,200);

    private final Dimension PFR_SIZE_BUTTON = new Dimension(200, 50);
    private final Dimension MIN_SIZE_BUTTON = new Dimension(200, 50);
    private final Dimension PFR_SIZE_TEXT = new Dimension(200, 50);
    private final Dimension MIN_SIZE_TEXT = new Dimension(200, 50);

    private JTextField textField = new JTextField();
    private JButton button = new JButton("Submit");

    public PanelPlayers( ) {


        
        BoxLayout laybut = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(laybut);
        
        

        ImageIcon image = new ImageIcon("src/gui/images/monopoly.png");
        Image img = image.getImage();
        

        image = new ImageIcon(img);
        JLabel imagelabel = new JLabel(image);

        imagelabel.setMinimumSize(MIN_SIZE_IMG);
        imagelabel.setPreferredSize(PRF_SIZE_IMG);


        // jb1.setMinimumSize(MIN_SIZE_BUTTON);
        // jb1.setPreferredSize(PFR_SIZE_BUTTON);


        

        // jb1.setUI(GameMain.BUTTON_STYLE);
        // jb1.setBorderPainted(false);



        add(imagelabel);
        add(Box.createVerticalGlue());
        // add(jb1);
        add(Box.createRigidArea(new Dimension(0,70)));

        
        imagelabel.setAlignmentX(CENTER_ALIGNMENT);
        // jb1.setAlignmentX(CENTER_ALIGNMENT);


        setBackground(GameMain.SFONDO);
        Component rigidArea = Box.createRigidArea(new Dimension(0,50));
        add(rigidArea);
        


        button.addActionListener(this);
        button.setUI(GameMain.BUTTON_STYLE);


        
        Component rigidArea_2 = Box.createRigidArea(new Dimension(0,40));
        add(rigidArea_2);
        

        Component rigidArea_1 = Box.createRigidArea(new Dimension(0,400));
        add(rigidArea_1);

        


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        // g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    

    }

    @Override
    public void actionPerformed(ActionEvent e) {
 
        
    }


    


}