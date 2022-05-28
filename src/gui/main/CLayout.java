package gui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.PanelEnd;
import gui.panels.PanelMonopoly;
import gui.panels.PanelPlayers;
import gui.panels.PanelPregame;
import gui.pregame.PanelNickname;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import java.awt.CardLayout;

import model.*;

public class CLayout extends JFrame implements ActionListener {

    private JFrame frame = new JFrame("Monopoly Lugano");
    private JPanel panelCont = new JPanel();
    private JPanel panelPregame = new PanelPregame(this);
    // private JPanel panelPlayers = new PanelPlayers();
    // private JPanel panelMonopoly = new PanelMonopoly();

    private CardLayout mainFrame = new CardLayout();

    private JPanel clayoutforgame = new CLayoutForGame();

    ImageIcon img = new ImageIcon("/home/paperino/Desktop/project-monopoly-dinasty/src/gui/images/icon.png");

    public CLayout() {

        panelCont.setLayout(mainFrame);

        frame.setTitle("Monopoly Lugano");
        frame.setIconImage(img.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        panelCont.add(panelPregame, "1");

        // panelCont.add(panelPlayers, "2");

        // panelCont.add(clayoutforgame, "3");

        mainFrame.show(panelCont, "1");

        frame.add(panelCont);
        frame.pack();
        frame.setVisible(true);
        

    }

    public void switchCard() {

        JPanel panelPlayers = new PanelPlayers(this);
        panelCont.add(panelPlayers, "2");

        mainFrame.next(panelCont);
    }


    public void endPreGame(){

        JPanel panelMonopoly = new PanelMonopoly();
        panelCont.add(panelMonopoly, "3");

        mainFrame.next(panelCont);
        PanelMonopoly.mamma();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // mainFrame.next(panelCont);
    }

}
