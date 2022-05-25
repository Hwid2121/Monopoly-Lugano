package gui;
import java.awt.Graphics;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class MyButton extends BasicButtonUI {
    @Override 
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();


        Font courier = new Font ("Courier", Font.PLAIN, 12); 
        // Font system = new Font ("System", Font.BOLD, 16); 
        // Font helvetica = new Font ("Helvetica", Font.BOLD, 18);  

        // // g.setFont (courier);  
        // c.setFont(new Font("Helvetica", Font.BOLD, 20));
        // g.setFont(new Font("Helvetica", Font.BOLD, 20));

        // g.setColor(Color.GREEN);

        g.setFont(courier);

        
        // b.setBackground(Color.GREEN);
        b.setFont(courier);
        b.setForeground(Color.BLACK);
        b.setVisible(true);
        

        super.paint(g, c);



        // c.setColor(Color.BLACK);

        
    
        
        // b.setVisible(true);



        
    }
}