package gui;


import model.Monopoly;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * This class rappresents the Monopoly End Game panel.
 * 
 *
 * @author taftan@usi.ch & sardoa@usi.ch
 * @version 28/05/2022
 */

public class PanelEnd extends JPanel {
    private Monopoly monopoly;

    /**
     * PanelEnd constructor.
     * 
     */
    public PanelEnd() {
        super();
        String nick = monopoly.getListOfPlayer().get(0).getNickname();
        makeUI(nick);
    }

    private void makeUI(String nick) {

        setBackground(new Color(205, 230, 208, 255));
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(new Color(205, 230, 208, 255));

        JLabel label = new JLabel(nick + " is the winner!");
        label.setFont(new Font("SansSerif", Font.BOLD, 22));

        // b.setBackground(new Color(205, 230, 208, 255));
        label.setForeground(new Color(246, 147, 28, 255));
        main.add(label, BorderLayout.CENTER);

        add(main);

    }
}
