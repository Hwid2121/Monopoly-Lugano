package gui;
import java.awt.Graphics;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.border.Border;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;

public class RoundedBorder implements Border {

    private int radius;



    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }





}