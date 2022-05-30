package gui;

import model.Card;

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


/**
 * PopUpPickCardPanel panel that show a popup for pick a card.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PopUpPickCardPanel extends JPanel implements ActionListener {

    private PopUpPickCardFrame framea;
    private Font sansSerif = new Font("SansSerif", Font.BOLD, 14);

    /**
     * Construcotr of the frame PopUpPickCardFrame.
     * 
     * @param frameB the parent of the parent frame
     * @param frameA the parent frame
     * @param card   the card
     */
    public PopUpPickCardPanel(MonopolyCommandsPanel frameB, PopUpPickCardFrame frameA, Card card) {

        super();
        this.framea = frameA;

        BoxLayout lay = new BoxLayout(this, BoxLayout.Y_AXIS);

        setLayout(lay);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(GameMain.SFONDO);

        JButton button = new JButton("CONTINUE");
        button.setForeground(GameMain.CREMISI);
        button.setFont(sansSerif);
        button.setMinimumSize(new Dimension(120, 40));
        button.setPreferredSize(new Dimension(120, 40));

        JLabel desc = new JLabel(card.getDescription());
        desc.setFont(sansSerif);
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
