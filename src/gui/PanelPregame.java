package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * PanelPregame the first panel that the user will
 * see.
 * User can exit or play.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PanelPregame extends JPanel {

    private final Dimension prfsizeimg = new Dimension(800, 800);
    private final Dimension minsizeimg = new Dimension(200, 200);

    private final Dimension pfrsizebutton = new Dimension(200, 50);
    private final Dimension minsizebutton = new Dimension(200, 50);

    private CLayout parentFrame;

    /**
     * Constructor of the PanelPregame.
     * @param frame the parent frame
     */
    public PanelPregame(CLayout frame) {
        super();

        parentFrame = frame;

        JButton jb1 = new JButton("Play!");
        JButton jb3 = new JButton("Exit");

        jb3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("EXIT THE GAME");
                System.exit(0);
            }
        });

        final JFrame numPlayeFrame = new NumPlayerFrame(this);
        numPlayeFrame.setLocationRelativeTo(null);
        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                numPlayeFrame.setVisible(true);

            }

        });

        BoxLayout laybut = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(laybut);

        ImageIcon image = new ImageIcon("src/gui/images/monopoly.png");
        Image img = image.getImage();

        image = new ImageIcon(img);
        JLabel imagelabel = new JLabel(image);

        imagelabel.setMinimumSize(minsizeimg);
        imagelabel.setPreferredSize(prfsizeimg);

        jb1.setMinimumSize(minsizebutton);
        jb1.setPreferredSize(pfrsizebutton);

        jb3.setMinimumSize(minsizebutton);
        jb3.setPreferredSize(pfrsizebutton);

        jb1.setUI(GameMain.BUTTON_STYLE);
        jb3.setUI(GameMain.BUTTON_STYLE);

        add(imagelabel);
        add(Box.createVerticalGlue());
        add(jb1);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(jb3);
        add(Box.createRigidArea(new Dimension(0, 400)));

        imagelabel.setAlignmentX(CENTER_ALIGNMENT);
        jb1.setAlignmentX(CENTER_ALIGNMENT);
        jb3.setAlignmentX(CENTER_ALIGNMENT);

        setBackground(GameMain.SFONDO);

    }

    @Override
    protected void paintComponent(Graphics graphicVAR) {
        super.paintComponent(graphicVAR);
        graphicVAR.setColor(Color.RED);
        graphicVAR.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

    }

    /**
     * Swap the panel.
     */
    public void swapPanel() {

        parentFrame.switchCard();

    }

}
