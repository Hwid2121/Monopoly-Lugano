package gui;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Square;
import model.Table;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

import model.Monopoly;

public class GamePanel extends JPanel implements Runnable {

    private static final int X_LEN = 100;
    private static final int Y_LEN = 100;

    // private SquareCell[] cell = new SquareCell[Table.getSizeofTable()];

    public GamePanel() {
        GridLayout layoutMonopoly = new GridLayout(10, 10);
        JPanel monopolyPanel = new JPanel(layoutMonopoly);

    }

    public void newSquare() {

    }

    public void paint(Graphics g) {

    }

    public void draw(Graphics g) {

    }

    public void run() {

    }

    public class AL extends KeyAdapter {

    }

}
