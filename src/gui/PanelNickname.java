package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Player;

/**
 * Inset name of the players.
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PanelNickname extends JPanel {

    private ArrayList<NicknameForm> playersList = new ArrayList<>();
    private PanelPlayers panel;

    /**
     * Inset name of the players.
     * @param panelPlay the panel of the pregame
     */
    public PanelNickname(PanelPlayers panelPlay) {
        super();

        panel = panelPlay;

        int num = GameMain.monopoly.getNumOfplayer();

        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);

        for (int i = 0; i < num; i++) {
            NicknameForm temp = new NicknameForm(i);
            add(temp);
            playersList.add(temp);
            add(Box.createRigidArea(new Dimension(10, 30)));
        }

        JButton button = new JButton("Confirm");
        add(Box.createRigidArea(new Dimension(50, 50)));
        add(button);
        button.setUI(GameMain.BUTTON_STYLE);
        setBackground(GameMain.SFONDO);
        button.setPreferredSize(new Dimension(120, 60));
        button.setMinimumSize(new Dimension(120, 60));

        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int indexAction = 0;
                for (NicknameForm nick : playersList) {
                    GameMain.monopoly.addPlayer(new Player(nick.getFieldText()));
                    System.out.println(GameMain.monopoly.getPLayer(indexAction).getNickname());
                    indexAction += 1;
                }

                panel.endPregame();

            }
        });

    }

}
