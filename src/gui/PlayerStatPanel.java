package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import gui.main.GameMain;
import model.*;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class PlayerStatPanel extends JPanel {

    private GridBagLayout layout = new GridBagLayout();

    public PlayerStatPanel(Player player) {
        super();
        JPanel pieceColorPanel = new PieceColorPanel(player);

        String name = player.getNickname();
        int money = player.getMoney();
        int position = player.getPosition();

        setBackground(GameMain.SFONDO);
        setBorder(GameMain.BLACKLINE);

        setFont(GameMain.COURIER);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        setLayout(layout);

        JLabel nickname = new JLabel("Nickname: " + name);
        nickname.setFont(GameMain.COURIER);
        JLabel cash = new JLabel("Money: " + money);
        cash.setFont(GameMain.COURIER);
        JLabel pos = new JLabel("Position: " + position);
        pos.setFont(GameMain.COURIER);
        JLabel properties = new JLabel("Properties: " + player.propertySquaretoString());
        properties.setFont(GameMain.COURIER);

        c.insets = new Insets(10, 0, 10, 50);
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(nickname, c);

        c.insets = new Insets(10, 0, 10, 50);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(cash, c);

        c.insets = new Insets(10, 0, 10, 50);
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(properties, c);

        c.insets = new Insets(10, 0, 10, 50);
        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(pos, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 10, 50);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 4;
        add(pieceColorPanel, c);

    }

}
