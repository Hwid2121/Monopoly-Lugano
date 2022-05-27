package gui.pregame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.colorchooser.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ScrollBarUI;

import org.junit.runners.ParentRunner;

import gui.main.GameMain;
import gui.panels.PanelPlayers;
import model.Monopoly;
import model.Player;

import java.awt.Color;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.imageio.ImageIO;
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

        // button.setBackground(GameMain.);
        // PanelPlayers topFrame = (PanelPlayers) SwingUtilities.getRootPane(this);

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
