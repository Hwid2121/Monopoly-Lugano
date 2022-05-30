package gui;

import model.Card;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * PopuuPickcardFrame frame that show a popup for pick a card.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PopUpPickCardFrame extends JFrame implements ActionListener {

    /**
     * Construcotr of the frame PopUpPickCardFrame.
     * @param card the card
     * @param parentPanel the parent panel
     */
    public PopUpPickCardFrame(Card card, MonopolyCommandsPanel parentPanel) {

        super();


        

        setVisible(false);
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);

        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.SFONDO);
        BoxLayout laymain = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        setLayout(laymain);
        setUndecorated(true);

        JLabel label = new JLabel("CARD: ");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setSize(new Dimension(40, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        MonopolyCommandsPanel parentPan = parentPanel;
        JPanel panel = new PopUpPickCardPanel(parentPan, this, card);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(label);
        add(panel);

        pack();

    }





    
    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}
