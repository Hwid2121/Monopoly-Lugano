package gui.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.MonopolyCommandsPanel;
import gui.MonopolyGridPanel;
import gui.MonopolyPlayerPanel;
import gui.main.GameMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMonopoly extends JPanel {


    // private final Dimension PRF_SIZE_IMG = new Dimension(800, 800);
    // private final Dimension MIN_SIZE_IMG = new Dimension(200, 200);


    private static JPanel monopolyGridPanel;
    private GameMain main;
     
    public PanelMonopoly(GameMain game) {


        main = game;
        
        JButton button1 = new JButton("NORTH");
        JButton button2 = new JButton("END-LINE");


       

    
 
    










        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });


        int width = getWidth();
        int heigh = getHeight();
        
        monopolyGridPanel = new MonopolyGridPanel();
        JPanel monopolyPlayerPanel = new MonopolyPlayerPanel();
        JPanel monopolyCommandsPanel = new MonopolyCommandsPanel();

        BorderLayout mainLay = new BorderLayout(0,0);
        monopolyGridPanel.setPreferredSize(new Dimension(1000,1000));
        monopolyPlayerPanel.setPreferredSize(new Dimension(920, 800));
        monopolyCommandsPanel.setPreferredSize(new Dimension(width, 136));


        // monopolyGridPanel.minimumSize(new Dimension(1000,1000));
        setLayout(mainLay);


        
        // System.out.println(this);

        add(monopolyGridPanel, BorderLayout.CENTER);
        add(monopolyPlayerPanel, BorderLayout.LINE_END);
        add(monopolyCommandsPanel, BorderLayout.PAGE_END);

    }


        public static void mamma(){
            System.out.println("heigh" + monopolyGridPanel.getHeight());
            System.out.println("width" + monopolyGridPanel.getWidth());

                        // System.out.println("heigh total" + this.getHeight());
        }



}
