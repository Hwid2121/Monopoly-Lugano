package gui;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Card;

public class PopUpPickCardPanel extends JPanel implements ActionListener {

    private JLabel desc;
    final private PopUpPickCardFrame framea;
    private JButton button;
    private Font SansSerif  = new Font("SansSerif", Font.BOLD, 14);

    public PopUpPickCardPanel(MonopolyCommandsPanel frameB, PopUpPickCardFrame frameA, Card card) {

        super();
        this.framea = frameA;

        BoxLayout lay = new BoxLayout(this, BoxLayout.Y_AXIS);

        setLayout(lay);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(GameMain.SFONDO);

        button = new JButton("CONTINUE");
        button.setForeground(GameMain.CREMISI);
        button.setFont(SansSerif);
        button.setMinimumSize(new Dimension(120, 40));
        button.setPreferredSize(new Dimension(120, 40));

        desc = new JLabel(card.getDescription());
        desc.setFont(SansSerif);
        desc.setAlignmentX(Component.CENTER_ALIGNMENT);
        // button.setAlignmentX(Component.CENTER_ALIGNMENT);
        // desc.
        add(desc);
        add(Box.createRigidArea(new Dimension(0, 70)));
        add(button);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEve) {

                framea.dispose();

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}
