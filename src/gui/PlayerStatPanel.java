package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;




/**
 * PlayersStatPanel where the players are showned:
 * - PlayerName.
 * - PlayerMoney.
 * - PlayerPiece.
 * - PlayerPosition.
 * - PlayerProperties.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PlayerStatPanel extends JPanel {

    private GridBagLayout layout = new GridBagLayout();


    /**
     * Constructor of the PlayerStatPanel.
     * @param player the player that have to be showned.
     */
    public PlayerStatPanel(Player player) {
        super();
        JPanel pieceColorPanel = new PieceColorPanel(player);

        String name = player.getNickname();
        int money = player.getMoney();
        int position = player.getPosition();

        setBackground(GameMain.SFONDO);
        setBorder(GameMain.BLACKLINE);

        setFont(GameMain.COURIER);

        GridBagConstraints gridBagLay = new GridBagConstraints();
        gridBagLay.fill = GridBagConstraints.HORIZONTAL;

        setLayout(layout);

        JLabel nickname = new JLabel("Nickname: " + name);
        nickname.setFont(GameMain.COURIER);
        JLabel cash = new JLabel("Money: " + money);
        cash.setFont(GameMain.COURIER);
        JLabel pos = new JLabel("Position: " + position);
        pos.setFont(GameMain.COURIER);
        JLabel properties = new JLabel("Properties: " + player.propertySquaretoString());
        properties.setFont(GameMain.COURIER);

        gridBagLay.insets = new Insets(10, 0, 10, 50);
        gridBagLay.gridx = 0;
        gridBagLay.gridy = 0;
        gridBagLay.fill = GridBagConstraints.HORIZONTAL;
        add(nickname, gridBagLay);

        gridBagLay.insets = new Insets(10, 0, 10, 50);
        gridBagLay.gridx = 0;
        gridBagLay.gridy = 1;
        gridBagLay.fill = GridBagConstraints.HORIZONTAL;
        add(cash, gridBagLay);

        gridBagLay.insets = new Insets(10, 0, 10, 50);
        gridBagLay.gridx = 0;
        gridBagLay.gridy = 2;
        gridBagLay.fill = GridBagConstraints.HORIZONTAL;
        add(properties, gridBagLay);

        gridBagLay.insets = new Insets(10, 0, 10, 50);
        gridBagLay.gridx = 0;
        gridBagLay.gridy = 3;
        gridBagLay.fill = GridBagConstraints.HORIZONTAL;
        add(pos, gridBagLay);

        gridBagLay.fill = GridBagConstraints.HORIZONTAL;
        gridBagLay.insets = new Insets(10, 0, 10, 50);
        gridBagLay.gridwidth = 2;
        gridBagLay.gridx = 0;
        gridBagLay.gridy = 4;
        add(pieceColorPanel, gridBagLay);

    }

}
