package gui;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Monopoly;
import model.Player;

/**
 * 
 * InfoSquarePanel panel that show a popup for pick a card.
 */
public class InfoSquarePanel extends JPanel implements ActionListener {

        private GridLayout lay = new GridLayout(3, 5, 2, 2);

        private JLabel name;

        private JLabel color;

        private JLabel price;

        private JLabel priceTax;
        private JLabel priceSell;
        private JLabel priceh1;
        private JLabel owner;
        private JLabel priceh2;
        private JLabel priceh3;
        private JLabel priceh4;
        private JLabel priceHotel;
        private JLabel priceBuilding;

        private JButton button;

        private Font sansSerif = new Font("SansSerif", Font.BOLD, 12);
        private InfoSquareFrame frame;
        private Monopoly monopoly;



        /**
         * Construcotr of the frame InfoSquareFrame.
         * 
         * @param player the player
         * @param framea parent  frame
         * @param monopolya the game
         */
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
                                "PRICE: " + monopoly.getTable().getPropertySquare(player.getPosition()).getPrice()
                                                + "");
                priceTax = new JLabel("PRICE TAX: "
                                + monopoly.getTable().getPropertySquare(player.getPosition()).getPriceTax() + "");
                priceSell = new JLabel("PRICE SELL: "
                                + monopoly.getTable().getPropertySquare(player.getPosition()).getPriceSell() + "");

                owner = new JLabel("OWNER: "
                                + monopoly.getTable().getSquareOwnerToString(player.getPosition()));

                priceh1 = new JLabel("PRICE TAX FOR 1 HOUSE: "
                                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(1)
                                + "");
                priceh2 = new JLabel("PRICE TAX FOR 2 HOUSE: "
                                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(2)
                                + "");
                priceh3 = new JLabel("PRICE TAX FOR 3 HOUSE: "
                                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(3)
                                + "");
                priceh4 = new JLabel("PRICE TAX FOR 4 HOUSE: "
                                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(4)
                                + "");
                priceHotel = new JLabel("PRICE TAX FOR HOTEL: "
                                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(5)
                                + "");
                priceBuilding = new JLabel("PRICE FOR BUILD: "
                                + monopoly.getTable().getPropertySquare(player.getPosition()).getHouse().getPrice(6)
                                + "");

                button = new JButton("CLOSE");
                button.setForeground(GameMain.CREMISI);
                button.setFont(sansSerif);
                button.setMinimumSize(new Dimension(50, 15));
                button.setPreferredSize(new Dimension(50, 15));

                name.setFont(sansSerif);
                color.setFont(sansSerif);
                price.setFont(sansSerif);
                priceTax.setFont(sansSerif);
                priceSell.setFont(sansSerif);
                owner.setFont(sansSerif);
                priceh1.setFont(sansSerif);
                priceh2.setFont(sansSerif);
                priceh3.setFont(sansSerif);
                priceh4.setFont(sansSerif);
                priceHotel.setFont(sansSerif);
                priceBuilding.setFont(sansSerif);

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
                        public void actionPerformed(ActionEvent eGet) {

                                frame.dispose();

                        }
                });
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
        }

}
