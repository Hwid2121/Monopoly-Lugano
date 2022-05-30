package gui;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;




/**
 * My button class.
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class MyButton extends BasicButtonUI {





    /**
     * Constructor of the MyButton.
     * @param  graphicsVar the graphics variable
     * @param componentJ the component
     */
    @Override
    public void paint(Graphics graphicsVar, JComponent componentJ) {
        AbstractButton buttonAbs = (AbstractButton) componentJ;

        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Font courierFont = new Font("SansSerif", Font.BOLD, 22);

        graphicsVar.setFont(courierFont);

        buttonAbs.setBorder(raisedbevel);

        buttonAbs.setFont(courierFont);

        buttonAbs.setForeground(GameMain.CREMISI);

        buttonAbs.setVisible(true);
        super.paint(graphicsVar, componentJ);

    }
}