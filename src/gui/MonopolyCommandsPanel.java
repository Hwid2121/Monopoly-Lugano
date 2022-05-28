package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import gui.main.GameMain;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.Border;
import java.awt.ComponentOrientation;
import javax.swing.BorderFactory;


public class MonopolyCommandsPanel extends JPanel {




    JButton button1 = new JButton("Trow the dice");

    Dimension dim = new Dimension(130,100);
    Border blackline = BorderFactory.createLineBorder(GameMain.CREMISI);
    Font courier = new Font("SansSerif", Font.BOLD, 22);

    // JButton button4;
    // JButton button5;

    public MonopolyCommandsPanel(){


        FlowLayout layout  = new FlowLayout(FlowLayout.CENTER,10,50 );
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        setBackground(GameMain.SFONDO);

        setBorder(blackline);
        setLayout(layout);
        setFont(courier);

        button1.setPreferredSize(dim);




        this.add(button1);




        setVisible(true);




        


    }


}
