package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class PanelPregame extends JPanel {

    private final Dimension PRF_SIZE_IMG = new Dimension(800, 800);
    private final Dimension MIN_SIZE_IMG = new Dimension(200,200);

    private final Dimension PFR_SIZE_BUTTON = new Dimension(200, 50);
    private final Dimension MIN_SIZE_BUTTON = new Dimension(200, 50);


    private final MyButton BUTTON_STYLE = new MyButton();

    public PanelPregame() {

        JButton jb1 = new JButton("Play!");
        JButton jb2 = new JButton("Rules");
        JButton jb3 = new JButton("Exit");

        jb3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("EXIT THE GAME");
            System.exit(0);
            }
        });

        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            PanelPlayers playbutton = new PanelPlayers();
            }
        });

        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            PanelRules rulesbutton = new PanelRules();
            }
        });

        
        BoxLayout laybut = new BoxLayout(this, BoxLayout.Y_AXIS);
        // GridLayout laybut = new GridLayout(3,1);
        setLayout(laybut);
        
        

        ImageIcon image = new ImageIcon("src/gui/images/monopoly.png");
        Image img = image.getImage();
        // Image img = image.getImage();

        
        image = new ImageIcon(img);
        JLabel imagelabel = new JLabel(image);

        imagelabel.setMinimumSize(MIN_SIZE_IMG);
        imagelabel.setPreferredSize(PRF_SIZE_IMG);


        jb1.setMinimumSize(MIN_SIZE_BUTTON);
        jb1.setPreferredSize(PFR_SIZE_BUTTON);

        jb2.setMinimumSize(MIN_SIZE_BUTTON);
        jb2.setPreferredSize(PFR_SIZE_BUTTON);

        jb3.setMinimumSize(MIN_SIZE_BUTTON);
        jb3.setPreferredSize(PFR_SIZE_BUTTON);


        

        jb1.setUI(BUTTON_STYLE);
        jb2.setUI(BUTTON_STYLE);
        jb3.setUI(BUTTON_STYLE);



        add(imagelabel);
        add(Box.createVerticalGlue());
        add(jb1);
        add(Box.createRigidArea(new Dimension(0,50)));
        add(jb2);
        add(Box.createRigidArea(new Dimension(0,50)));
        add(jb3);
        add(Box.createRigidArea(new Dimension(0,400)));

        
        imagelabel.setAlignmentX(CENTER_ALIGNMENT);
        jb1.setAlignmentX(CENTER_ALIGNMENT);
        jb2.setAlignmentX(CENTER_ALIGNMENT);
        jb3.setAlignmentX(CENTER_ALIGNMENT);


        setBackground(CLayout.SFONDO);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        // g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    

    }

}
