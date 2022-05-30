package gui;

import model.Card;
import model.CardsDeck;
import model.JailSquare;
import model.Monopoly;
import model.Player;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;




/**
 * MonopolyCommandsPanel panel that conintas all the comands that a player can
 * do.
 * 
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class MonopolyCommandsPanel extends JPanel implements ActionListener {

    private Dimension dim = new Dimension(130, 80);

    private PopUpPickCardFrame pop;
    private InfoSquareFrame infoFrame;

    private DiceFrame diceFrame;
    private JButton buy = new JButton("BUY");
    private JButton pass = new JButton("PASS");
    private JButton sell = new JButton("SELL");
    private JButton build = new JButton("BUILD");
    private JButton pay = new JButton("PAY FINE");
    private JButton dice = new JButton("TROW DICE");
    private JButton card = new JButton("USE CARD");
    private JButton info = new JButton("INFO SQUARE");

    private JButton perfectDice = new JButton("TRY PERFECT DICE");

    private BonusSquareFrame bonusFrame;

    private JButton cont = new JButton("CONTINUE...");

    private JButton pick = new JButton("PICK CARD");
    private Player player;

    private Monopoly monopoly = GameMain.monopoly;

    private CLayoutForGame main;

    /**
     * Constructor MonopolyCommandsPanel.
     * 
     * @param playerx the player that is playing the game
     * @param mainb   the main panel of the game
     * @param panell  the panel of the game
     */
    public MonopolyCommandsPanel(Player playerx, CLayoutForGame mainb, PanelMonopoly panell) {
        super();
        this.player = playerx;
        main = mainb;

        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        setBackground(GameMain.SFONDO);

        setBorder(GameMain.BLACKLINE);
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 50, 20);
        setLayout(layout);
        setFont(GameMain.COURIER);

        switch (main.getFase()) {

            case 0:
                trowDice();
                System.out.println(main.getFase());
                main.setFase(1);
                break;

            case 1:
                if (player.getTurnsInJail() == -1) {
                    switch (monopoly.getTable().getSquare(player.getPosition()).getColor()) {

                        case "cards":
                            pickCard();
                            break;

                        case "jail":
                            jailSquare();
                            break;

                        case "empty":
                            emptySquare();
                            break;

                        case "goto":
                            jailSquare();
                            break;

                        case "bonus":
                            bonusSquare();
                            // break;
                            // case "malus":
                            // bonusSquare();
                            break;

                        default:
                            if (monopoly.getTable().getPropertySquare(player.getPosition()).getOwner() == null) {
                                propertySquareEmpty();
                                break;
                            } else {
                                propertySquareOwned();
                                System.out.println(monopoly.getTable().getSquare(player.getPosition()).getName());
                                break;

                            }

                    }
                } else {
                    jailSquare();
                }

            default:
                break;

        }

        buy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                if (player.getMoney() >= monopoly.getTable().getSquarePrice(player.getPosition())
                        && monopoly.getTable().getSquareOwner(player.getPosition()) == null) {

                    monopoly.getTable().setSquareOwner(player);
                    player.buyPropertySquare(monopoly.getTable().getPropertySquare(player.getPosition()));
                    player.decreaseMoney(monopoly.getTable().getSquarePrice(player.getPosition()));

                    // main.refreshPAGE();

                } else {
                    System.out.println("non abbastanza soldi");
                }

            }

        });

        info.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                infoFrame = new InfoSquareFrame((MonopolyCommandsPanel) pick.getParent(), player, monopoly);
                infoFrame.setVisible(true);

            }

        });

        sell.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                if (monopoly.getTable().getSquareOwner(player.getPosition()) == player) {

                    player.increaseMoney(monopoly.getTable().getPropertySquare(player.getPosition()).getPriceSell());
                    player.removePropertySquare(monopoly.getTable().getPropertySquare(player.getPosition()));

                    monopoly.getTable().resetOwner(player.getPosition());
                    refresh();

                } else {
                    // TO D
                    System.out.println("NONTUA");
                }

            }

        });

        pass.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                main.passTurn();

            }

        });

        build.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

            }

        });

        pay.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                JailSquare.payFine(player);
                JailSquare.freeFromJail(player);

            }

        });

        cont.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                bonusFrame = new BonusSquareFrame((MonopolyCommandsPanel) pick.getParent(), player);
                bonusFrame.setVisible(true);
                main.passTurn();

            }

        });

        pick.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                CardsDeck deck = new CardsDeck();
                Card card = deck.randomCard();
                System.out.println("CARD: " + card.getDescription());

                deck.playCard(deck.getIndex(), player);

                pop = new PopUpPickCardFrame(card, (MonopolyCommandsPanel) pick.getParent());

                pop.setVisible(true);

                main.passTurn();

            }

        });

        perfectDice.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                if (monopoly.getDice().isPerfectPair()) {
                    JailSquare.freeFromJail(player);
                    main.passTurn();
                    System.out.println("PERFECT DICE");

                } else {
                    JailSquare.decreseDayInJail(player);
                    main.passTurn();
                    System.out.println("NOT PERFECT DICE");
                }

            }

        });

        dice.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                monopoly.throwDice();
                monopoly.setPositionPlayer(player);

                diceFrame = new DiceFrame((MonopolyCommandsPanel) pick.getParent(), monopoly.getDice());
                diceFrame.setVisible(true);

                System.out.println("SI FUNZ " + monopoly.getListOfPlayer().get(0).getPosition());

                if (monopoly.getTable().getColor(player.getPosition()).equals("jail")) {
                    player.setJail(JailSquare.getDays());
                }

                main.nextPage();
                main.incrementFase();

            }

        });

        card.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg) {

                if (JailSquare.checkFreeJailCard(player)) {
                    JailSquare.freeFromJail(player);
                }

            }

        });

        setVisible(true);

    }

    /**
     * TrowDice that make the player roll the dice.
     */
    public void trowDice() {

        dice.setPreferredSize(dim);

        this.add(dice);

    }

    /**
     * JailSquare that make the player go to jail.
     */
    public void bonusSquare() {

        pass.setPreferredSize(dim);
        cont.setPreferredSize(dim);

        this.add(cont);

    }

    /**
     * ProperSquareEmpty thaat make the player do nothing.
     */
    public void propertySquareEmpty() {

        info.setPreferredSize(dim);
        buy.setPreferredSize(dim);
        pass.setPreferredSize(dim);

        // this.add(infoFrame);

        this.add(info);
        this.add(buy);

        this.add(pass);

    }

    /**
     * ProperSquareOwned that activate the comand for buy and sell.
     */
    public void propertySquareOwned() {

        sell.setPreferredSize(dim);

        build.setPreferredSize(dim);

        pass.setPreferredSize(dim);

        this.add(sell);
        this.add(build);
        this.add(pass);

    }

    /**
     * EMptySquare that make the player do nothing.
     */
    public void emptySquare() {

        pass.setPreferredSize(dim);
        this.add(pass);

    }

    /**
     * JailSquare that make the player go to jail.
     */
    public void jailSquare() {

        pay.setPreferredSize(dim);

        perfectDice.setPreferredSize(dim);

        card.setPreferredSize(dim);

        // pass.setPreferredSize(dim);

        this.add(pay);
        this.add(perfectDice);
        this.add(card);

    }

    /**
     * GoToJailSquare that move the player to the jail.
     */
    public void goToJailSquare() {

        pass.setPreferredSize(dim);

        this.add(pass);

    }

    /**
     * PickCard let the player pick a card.
     */
    public void pickCard() {

        pick.setPreferredSize(dim);
        pass.setPreferredSize(dim);

        this.add(pass);
        this.add(pick);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    /**
     * Refresh the panel.
     */
    public void refresh() {
        main.nextPage();
    }

}