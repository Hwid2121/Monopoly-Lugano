package gui;

import java.awt.Graphics;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;
import gui.main.GameMain;
import java.awt.Font;
import javax.swing.border.Border;


public class MyButton extends BasicButtonUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();

        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Font courier = new Font("SansSerif", Font.BOLD, 22);

        g.setFont(courier);

        b.setBorder(raisedbevel);

        b.setFont(courier);

        b.setForeground(GameMain.CREMISI);

        b.setVisible(true);
        super.paint(g, c);

    }
}