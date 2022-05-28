package gui.pregame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.main.GameMain;
import gui.panels.PanelPlayers;
import model.Player;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.Box;

public class PanelNickname extends JPanel {

    private int num;
    private ArrayList<NicknameForm> playersList = new ArrayList<>();
    private PanelPlayers panel;
    
    public PanelNickname(PanelPlayers pan) {

         panel = pan;

        System.out.println("Numero di giocatoei in panelNick " + GameMain.monopoly.getNumOfplayer());

        num = GameMain.monopoly.getNumOfplayer();

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
            public void actionPerformed(ActionEvent e) {
                

                int i = 0;
                for (NicknameForm x : playersList) {
                    GameMain.monopoly.addPlayer(new Player(x.getFieldText()));
                    System.out.println(GameMain.monopoly.getPLayer(i).getNickname());
                    i++;
                }

                panel.endPregame();
               

            }
        });

    }

}
