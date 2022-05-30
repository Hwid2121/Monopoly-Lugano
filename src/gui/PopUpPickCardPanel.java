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
import model.Card;

import java.awt.Dimension;
import java.awt.Font;

public class PopUpPickCardPanel extends JPanel implements ActionListener {

    private JLabel desc;
    final private PopUpPickCardFrame framea;
    private JButton button;
    private Font s = new Font("SansSerif", Font.BOLD, 14);

    public PopUpPickCardPanel(MonopolyCommandsPanel frameB, PopUpPickCardFrame frameA, Card card) {

        super();
        this.framea = frameA;

        BoxLayout lay = new BoxLayout(this, BoxLayout.Y_AXIS);

        setLayout(lay);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(GameMain.SFONDO);

        button = new JButton("CONTINUE");
        button.setForeground(GameMain.CREMISI);
        button.setFont(s);
        button.setMinimumSize(new Dimension(120, 40));
        button.setPreferredSize(new Dimension(120, 40));

        desc = new JLabel(card.getDescription());
        desc.setFont(s);
        desc.setAlignmentX(Component.CENTER_ALIGNMENT);
        // button.setAlignmentX(Component.CENTER_ALIGNMENT);
        // desc.
        add(desc);
        add(Box.createRigidArea(new Dimension(0, 70)));
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
