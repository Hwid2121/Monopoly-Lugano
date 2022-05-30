package gui;

import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import gui.main.GameMain;
import java.awt.Dimension;
import java.awt.Font;

public class EmptySquarePopUpPanel extends JPanel implements ActionListener {

    final private EmptySquarePopUpFrame framea;
    private JButton button;
    private Font s = new Font("SansSerif", Font.BOLD, 14);

    public EmptySquarePopUpPanel(MonopolyCommandsPanel frameB, EmptySquarePopUpFrame pare) {

        super();
        this.framea = pare;

        BoxLayout lay = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(lay);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(GameMain.SFONDO);

        button = new JButton("PASS");
        button.setForeground(GameMain.CREMISI);
        button.setFont(s);
        button.setMinimumSize(new Dimension(120, 40));
        button.setPreferredSize(new Dimension(120, 40));

        JLabel desc = new JLabel("EMPTY SQUARE, NOTHING TO DO HERE!");
        desc.setFont(s);
        desc.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(desc);
        add(Box.createRigidArea(new Dimension(0, 45)));

        add(button);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                framea.dispose();

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}
