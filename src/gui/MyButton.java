package gui;

import java.awt.Graphics;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;
import gui.main.GameMain;
import java.awt.Font;
import javax.swing.border.Border;

public class MyButton extends BasicButtonUI {
    @Override
    public void paint(Graphics graphicsVar, JComponent componentJ) {
        AbstractButton buttonAbs = (AbstractButton) componentJ;

        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Font COURIER = new Font("SansSerif", Font.BOLD, 22);

        graphicsVar.setFont(COURIER);

        buttonAbs.setBorder(raisedbevel);

        buttonAbs.setFont(COURIER);

        buttonAbs.setForeground(GameMain.CREMISI);

        buttonAbs.setVisible(true);
        super.paint(graphicsVar, componentJ);

    }
}