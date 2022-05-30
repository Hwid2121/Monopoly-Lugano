package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * NumplayerFrame frame to inset the number of the players.
 * 
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class NumPlayerFrame extends JFrame implements ActionListener {

    /**
     * Construcotr of the frame NumPlayerFrame.
     * @param parentPanel the parent panel
     */
    public NumPlayerFrame(PanelPregame parentPanel) {
        super();
        PanelPregame parentPan = parentPanel;

        setVisible(false);
        setPreferredSize(new Dimension(500, 150));
        setResizable(false);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(GameMain.CREMISI);
        setUndecorated(true);

        BoxLayout laymain = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
        setLayout(laymain);

        JLabel label = new JLabel("Insert the number of players:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setSize(new Dimension(40, 40));
        JPanel panel = new FormPanel(parentPan, this);
        add(label);
        add(panel);

        pack();
        setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        dispose();

    }

}
