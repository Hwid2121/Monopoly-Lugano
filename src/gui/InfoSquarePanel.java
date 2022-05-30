package gui;

import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import gui.main.GameMain;
import gui.panels.PanelPregame;
import model.Card;
import model.Monopoly;
import model.Player;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;

public class InfoSquarePanel extends JPanel implements ActionListener {

    private GridLayout lay = new GridLayout(3, 5, 2, 2);

    private JLabel name;

    private JLabel color;

    private JLabel price;

    private JLabel priceTax;
    private JLabel priceSell;
    // private JLabel bh;
    private JLabel priceh1;
    private JLabel owner;
    private JLabel priceh2;
    private JLabel priceh3;
    private JLabel priceh4;
    private JLabel priceHotel;
    private JLabel priceBuilding;

    private JButton button;

    // * @param price of the propertySquare
    // * @param priceTax of the propertySquare
    // * @param name of the propertySquare
    // * @param color of the propertySquare, used as an ID of the square
    // * @param priceSell of the propertySquare
    // * @param bh building price for the propertySquare
    // * @param p1 pricetax for 1 house
    // * @param p2 pricetax for 2 houses
    // * @param p3 pricetax for 3 houses
    // * @param p4 pricetax for 4 houses
    // * @param ph pricetax for an Hotel
    // *

    private Font s = new Font("SansSerif", Font.BOLD, 12);
    private InfoSquareFrame frame;
    private Monopoly monopoly;
    
    public InfoSquarePanel(Player player, InfoSquareFrame framea, Monopoly monopolya) {
        super();

        monopoly = monopolya;
        this.frame = framea;

        setLayout(lay);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(GameMain.SFONDO);

        name = new JLabel("NAME: " + monopoly.getTable().getSquare(player.getPosition()).getName());
        color = new JLabel("COLOR: " + monopoly.getTable().getSquare(player.getPosition()).getColor());
        price = new JLabel(
                "PRICE: " + monopoly.getTable().getPropertySquare(player.getPosition()).getPrice() + "");
        priceTax = new JLabel("PRICE TAX: "
                + monopoly.getTable().getPropertySquare(player.getPosition()).getPriceTax() + "");
        priceSell = new JLabel("PRICE SELL: "
                + monopoly.getTable().getPropertySquare(player.getPosition()).getPriceSell() + "");

        owner = new JLabel("OWNER: "
                + monopoly.getTable().getSquareOwnerToString(player.getPosition()));

        priceh1 = new JLabel("PRICE TAX FOR 1 HOUSE: "
                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(1) + "");
        priceh2 = new JLabel("PRICE TAX FOR 2 HOUSE: "
                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(2) + "");
        priceh3 = new JLabel("PRICE TAX FOR 3 HOUSE: "
                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(3) + "");
        priceh4 = new JLabel("PRICE TAX FOR 4 HOUSE: "
                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(4) + "");
        priceHotel = new JLabel("PRICE TAX FOR HOTEL: "
                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(5) + "");
        priceBuilding = new JLabel("PRICE FOR BUILD: "
                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(6) + "");

        button = new JButton("CLOSE");
        // button.setUI(GameMain.BUTTON_STYLE);
        button.setForeground(GameMain.CREMISI);
        button.setFont(s);
        button.setMinimumSize(new Dimension(50, 15));
        button.setPreferredSize(new Dimension(50, 15));

        name.setFont(s);
        color.setFont(s);
        price.setFont(s);
        priceTax.setFont(s);
        priceSell.setFont(s);
        owner.setFont(s);
        priceh1.setFont(s);
        priceh2.setFont(s);
        priceh3.setFont(s);
        priceh4.setFont(s);
        priceHotel.setFont(s);
        priceBuilding.setFont(s);
        
        name.setHorizontalTextPosition(JLabel.CENTER);
        color.setHorizontalTextPosition(JLabel.CENTER);
        price.setHorizontalTextPosition(JLabel.CENTER);
        priceTax.setHorizontalTextPosition(JLabel.CENTER);
        priceSell.setHorizontalTextPosition(JLabel.CENTER);

        owner.setHorizontalTextPosition(JLabel.CENTER);
        priceh1.setHorizontalTextPosition(JLabel.CENTER);
        priceh2.setHorizontalTextPosition(JLabel.CENTER);
        priceh3.setHorizontalTextPosition(JLabel.CENTER);
        priceh4.setHorizontalTextPosition(JLabel.CENTER);
        priceHotel.setHorizontalTextPosition(JLabel.CENTER);
        priceBuilding.setHorizontalTextPosition(JLabel.CENTER);
            

        add(name);
        add(color);
        add(price);
        add(priceTax);
        add(priceSell);
        add(owner);
        add(priceh1);
        add(priceh2);
        add(priceh3);
        add(priceh4);
        add(priceHotel);
        add(priceBuilding);
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                // String s = textField.getText();

                    frame.dispose();
                    // frameb.swapPanel();

                    




            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // frame.dispose();
    }

}
