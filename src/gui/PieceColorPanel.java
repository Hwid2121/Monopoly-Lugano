package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import gui.main.GameMain;

import java.awt.BorderLayout;
import model.*;
public class PieceColorPanel extends JPanel {


    private BorderLayout layout =  new BorderLayout(1,0);
    

    public PieceColorPanel(Player player){

        setLayout(layout);
        setBackground(GameMain.SFONDO);
        // setSize(new DimensionUIResource(100, 100));

        JPanel piece = new PieceColor(player);
        

        JLabel icon = new JLabel("Color: ");
        icon.setFont(GameMain.courier);


        add(icon, BorderLayout.CENTER);
        // piece.setAlignmentY(getAlignmentY());
        add(piece, BorderLayout.LINE_END);


        setVisible(true);

    }

}
