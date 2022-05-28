package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMonopoly extends JPanel {


    // private final Dimension PRF_SIZE_IMG = new Dimension(800, 800);
    // private final Dimension MIN_SIZE_IMG = new Dimension(200, 200);


    static JPanel monopolyGridPanel;
     
    public PanelMonopoly() {

        JButton button1 = new JButton("NORTH");
        JButton button2 = new JButton("END-LINE");


       

    
 
    










        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });



        monopolyGridPanel = new MonopolyGridPanel();
        JPanel monopolyPlayerPanel = new MonopolyPlayerPanel();
        JPanel monopolyCommandsPanel = new MonopolyCommandsPanel();

        BorderLayout mainLay = new BorderLayout(10, 10);
        setLayout(mainLay);


        
        // System.out.println(this);

        add(monopolyGridPanel, BorderLayout.CENTER);

        add(monopolyPlayerPanel, BorderLayout.LINE_END);
        add(monopolyCommandsPanel, BorderLayout.PAGE_END);

    }


        public static void mamma(){
            System.out.println("heigh" + monopolyGridPanel.getHeight());
            System.out.println("width" + monopolyGridPanel.getWidth());
        }



}
