package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import gui.main.GameMain;
import model.*;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class PlayerStatPanel extends JPanel {

    // private String name;
    // private int money;
    // // private Piece piece;
    // private int position;
    // private Color color;


    // private PropertySquare propertySquare;

    private GridBagLayout layout = new GridBagLayout();


    


    public PlayerStatPanel(Player player){
        super();
        JPanel  pieceColorPanel = new  PieceColorPanel(player);

        String name = player.getNickname();
        int money = player.getMoney();
        int position = player.getPosition();

        setBackground(GameMain.SFONDO);
        setBorder(GameMain. BLACKLINE);
        
        setFont(GameMain.COURIER);

        // JPanel piece = new PieceColor(player);
        

        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        // c.gridwidth = 100;


        setLayout(layout);



        JLabel nickname = new JLabel("Nickname: " + name);
        nickname.setFont(GameMain.COURIER);
        JLabel cash = new JLabel("Money: " + money);
        cash.setFont(GameMain.COURIER);
        JLabel pos = new JLabel("Position: " + position);
        pos.setFont(GameMain.COURIER);
        // JLabel icon = new JLabel("Color: ");
        // icon.setFont(GameMain.COURIER);



    
        c.insets = new Insets(10,0,30,50); 
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(nickname, c);


        
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,0,30,50); 
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(cash, c);

        // c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,0,30,50); 
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1.0; 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(pos, c);



        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,0,30,50); 
        // c.ipady = 40;      
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 3;
        add(pieceColorPanel, c);



        




        




        

       


    }

}
