package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;


public class NumPlayerFrame extends JFrame implements ActionListener {

    private PanelPregame parentPan;

    public NumPlayerFrame(PanelPregame parentPanel) {

        parentPan = parentPanel;
        JPanel panel = new FormPanel(parentPan, this);

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

        add(label);
        add(panel);

        pack();
        setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        dispose();

        // GameMain.next();

    }

}
