package gui.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.main.CLayout;
import gui.main.GameMain;
import gui.pregame.PanelNickname;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.Box;
import java.awt.Component;

/**
 * Panel Players is the panel where nickname of the players have to be
 * inserted.
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PanelPlayers extends JPanel implements ActionListener {

    private final Dimension prfsizeimg = new Dimension(800, 800);
    private final Dimension minsizeimg = new Dimension(200, 200);

    private PanelNickname panelNick = new PanelNickname(this);

    private CLayout parentFrame;

    public PanelPlayers(CLayout frame) {
        super();
        parentFrame = frame;

        BoxLayout laybut = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(laybut);

        ImageIcon image = new ImageIcon("src/gui/images/monopoly.png");
        Image img = image.getImage();

        image = new ImageIcon(img);
        JLabel imagelabel = new JLabel(image);

        imagelabel.setMinimumSize(minsizeimg);
        imagelabel.setPreferredSize(prfsizeimg);

        add(imagelabel);

        add(Box.createVerticalGlue());

        add(Box.createRigidArea(new Dimension(0, 70)));

        imagelabel.setAlignmentX(CENTER_ALIGNMENT);

        setBackground(GameMain.SFONDO);
        Component rigidArea = Box.createRigidArea(new Dimension(0, 50));
        add(rigidArea);

        add(panelNick);

        Component rigidArea_2 = Box.createRigidArea(new Dimension(0, 40));
        add(rigidArea_2);

        Component rigidArea_1 = Box.createRigidArea(new Dimension(0, 400));
        add(rigidArea_1);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * End of the Pregame phase.
     */
    public void endPregame() {
        parentFrame.endPreGame();
    }

}