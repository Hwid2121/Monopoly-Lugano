package gui;

import java.awt.EventQueue;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import model.*;

/**
 * DESCRIBE THIS CLASS
 * 
 * @author YOUR_USI_EMAIL
 */

public class Main {



    // add a main method here
    public static void main(String[] args) {
        System.out.println("GUI STARRRRRRRt");
        

        
    
    

        

        EventQueue.invokeLater(new Runnable() {
            

            public void run() {
                System.out.println("creating gui...");
                
                new GameMain();
                
               

                

                
                
 


                
        }




                
            

        });
    }

}
