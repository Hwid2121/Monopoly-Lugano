package tui;

import java.util.Scanner; // Import the Scanner class

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.text.BreakIterator;
import java.util.ArrayList;

import model.JailSquare;
import model.Monopoly;
import model.Player;
import model.Table;
import model.cardsDeck;

import model.Card;

/**
 * DESCRIBE THIS CLASS
 * 
 * @author YOUR_USI_EMAIL
 */
public class Main {

    ArrayList<Player> listOfPlayers = new ArrayList<Player>();

    Scanner input = new Scanner(System.in);

    private int numberOfPlayers = 0;
    private int status = 0;

    private int skip = 0;
    private int turn = 0;

    // protected boolean nextTurn = false;

    public void preGameStatus() {
        this.status = 0;

        System.out.println("How many players?");

        if (!input.hasNextInt()) {
            System.out.println("You have entered incorrect input! Please enter a number");
            input.nextLine();
            preGameStatus();
        }

        numberOfPlayers = input.nextInt();

        if (numberOfPlayers < 2) {

            System.out.println("Number of player not allowed, insert a number of player greater than 2");
            preGameStatus();
        }

        else {

            while (listOfPlayers.size() < numberOfPlayers) {

                System.out.println("Nickname giocatore " + listOfPlayers.size());

                String Nickname = input.next();
                if (input.hasNextLine()) {

                    listOfPlayers.add(new Player(Nickname));
                }

            }

            System.out.println("Pregame pronto, adesso si gioca!");
            status = 1;

        }
    }

    public void cardsPLAYmain(Player player, Monopoly monopoly) {

        System.out.println("You gonna take a card \n that can be a bonus card or a malus card\n ");
        System.out.println("After the effect the card the pass will be automatically");
        System.out.println("Good luck!\n");

        cardsDeck deck = new cardsDeck();
        System.out.println("[pick] (for picking a card)");
        String word = input.next();

        switch (word) {
            case "pick":
                Card card = deck.randomCard();
                System.out.println("CARD:" + card.getDescription());
                deck.playCard(deck.getIndex(), player);

                System.out.println("next turn");
                skip = 1;
                break;

            default:
                System.out.println("Command not allowed here.\n");
                cardsPLAYmain(player, monopoly);

        }

    }

    public void gotoPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("Go to the jail! \n");

        player.movePosition(30);
        player.setJail(JailSquare.getDays());

        jailPLAYmain(player, monopoly);

    }

    public void malusPLAYmain(Player player) {

    }

    public void parkPLAYmain(Player player) {
        System.out.println("You are in the park");

    }

    // public void companyPLAYmain(Player player) {

    // }

    public void jailPLAYmain(Player player, Monopoly monopoly) {

        player.setJail(JailSquare.getDays());

        System.out.println("You are in jail");
        System.out.println("You can escape doing:");
        System.out.println("- \"Pay\" Paying 55 chf now");
        System.out.println("- \"Card\"  Using the free from jail card");
        System.out.println("- \"throw\" Trying to do perfect pair ");
        System.out.println("After 3 turn you must pay 50 chf");

        String word = input.next();

        if (player.getTurnsInJail() != 0) {
            switch (word) {
                case ("Pay"):
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    monopoly.throwDice();
                    monopoly.setPositionPlayer(player);

                    startTurn(player, monopoly);

                    break;

                case ("Card"):
                    if (JailSquare.checkFreeJailCard(player)) {
                        JailSquare.freeFromJail(player);

                        System.out.println("You used the card, you can throw the dice\n ");
                        monopoly.setPositionPlayer(listOfPlayers.get(turn));
                        System.out.println("You are in the square: "
                                + monopoly.table.getSquareName(listOfPlayers.get(turn).getPosition()));

                        startTurn(player, monopoly);

                        skip = 1;
                        break;

                    } else {
                        System.out.println("\n You don't have the card!\n");
                        break;
                    }
                case ("throw"):

                    monopoly.throwDice();
                    System.out.println("Your dice made: " + monopoly.die1() + " and " + monopoly.die2());
                    if (monopoly.dice.getPerfectPair()) {
                        JailSquare.freeFromJail(player);
                        System.out.println("You did perfect pair, you gonna forward for " + (monopoly.die1() * 2));

                        monopoly.setPositionPlayer(listOfPlayers.get(turn));
                        System.out.println("You are in the square: "
                                + monopoly.table.getSquareName(listOfPlayers.get(turn).getPosition()));

                        startTurn(player, monopoly);

                        skip = 1;
                        break;

                    } else {
                        System.out.println("You did not do perfect pair, see you next turn!");
                        player.setJail(player.getTurnsInJail() - 1);
                        skip = 1;
                        break;
                    }

                default:
                    System.out.println("Command not allowed here.\n");
                    jailPLAYmain(player, monopoly);

            }
        }

        else {
            System.out.println("You have to pay the fine");
            word = input.next();

            switch (word) {
                case ("Pay"):
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    monopoly.throwDice();
                    monopoly.setPositionPlayer(player);

                    startTurn(player, monopoly);

                    break;
                default:
                    System.out.println("invalid Input");

            }
        }

    }

    public void emptyPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("This is an empty square \n You cannot do nothing here");
        System.out.println("Pass (to finish the turn) ");
        System.out.println("Money (to show your balance)");
        System.out.println("[info] for information about player");

        String word = input.next();

        switch (word) {

            case ("Money"):
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "info":
                System.out.println("\nName: " + player.getNickname() + "\nMoney: " + player.getMoney()
                        + "\nProperties: " + player.getProperties() + "\nPosition: " + player.getPosition());

                break;

            case "pass":
                skip = 1;
                break;

            default:
                System.out.println("Command not allowed here");
                emptyPLAYmain(player, monopoly);

        }

    }

    public void PropertySquarePLAY(Player player, Monopoly monopoly) {
        int position = listOfPlayers.get(turn).getPosition();

        System.out.println("Write: Description (for the description of the property) ");
        System.out.println("Buy (for buying the property) ");
        System.out.println("Sell (to sell this property) ");
        System.out.println("pass (to finish the turn) ");
        System.out.println("Money (to show your balance)");
        System.out.println("info (for all info of the player)");

        String inp;
        String word = input.next();

        switch (word) {
            case "Description":
                System.out.println("\n \n" + monopoly.propertyDescr(listOfPlayers.get(turn)));
                break;

            case "Buy":

                if ((player.getMoney() >= monopoly.table.getSquarePrice(position) &&
                        (monopoly.table.getSquareOwner(position) == "")))

                {
                    System.out.println("Confirm to buy the property?"
                            + monopoly.table.getSquareName(position)
                            + "\n Your budget will be "
                            + (player.getMoney() - monopoly.table.getSquarePrice(position)));

                    System.out.println("Write \"yes\" for the confirm or \"no\" for return back: ");
                    inp = input.next();

                    switch (inp) {
                        case "yes":
                            monopoly.setOwner(player);
                            player.buyProperty(monopoly.table.getSquare(position).getName());
                            player.decreaseMoney(monopoly.table.getSquarePrice(position));

                            System.out.println("Square has been bought! \n");

                        case "no":
                            break;
                    }

                    // monopoly.table.checkMonopolyProperty();

                } else
                    System.out.println("You don't have enough money to buy the property");
                break;

            case "Sell":

                // if (player.getNickname() == monopoly.table.getSquareOwner(position)) {
                // System.out.println("Are you sure to sell: " +
                // monopoly.table.getSquareName(position)
                // + " for " + monopoly.table.getSquarePrice(position) +
                // " Write:\n \"yes\" for selling \"no\" for return back");

                // inp = input.next();

                // switch (inp) {

                // case "yes":

                // }

                // }

                break;

            case "Money":
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "info":
                System.out.println("\nName: " + player.getNickname() + "\nMoney: " + player.getMoney()
                        + "\nProperties: " + player.getProperties() + "\nPosition: " + player.getPosition());
                break;

            case "Mortgage":
                if (((monopoly.table.getSquareOwner(position) == player.getNickname()))) {

                    System.out.println("Are you sure to mortgage your property?");
                }

            case "pass":
                skip = 1;
                break;

            //
            //
            case "j":
                cardsDeck deck = new cardsDeck();
                deck.playCard(7, player);

            default:
                System.out.println("Command not allowed here.\n\n");
                PropertySquarePLAY(player, monopoly);
        }

    }

    public void throwDiceTurn(Player player, Monopoly monopoly) {

        monopoly.throwDice();
        System.out.println("Your dice made: " + monopoly.die1() + " and " + monopoly.die2());
        System.out.println("Go forward by: " + (monopoly.die1() + monopoly.die2()));

        monopoly.setPositionPlayer(listOfPlayers.get(turn));
        System.out.println("You are in the square: "
                + monopoly.table.getSquareName(listOfPlayers.get(turn).getPosition()));

    }

    public void startTurn(Player player, Monopoly monopoly) {
        // if (listOfPlayers.get(turn).getTurnsInJail() == 0) {
        // monopoly.throwDice();
        // System.out.println("Your dice made: " + monopoly.die1() + " and " +
        // monopoly.die2());
        // System.out.println("Go forward by: " + (monopoly.die1() + monopoly.die2()));

        // monopoly.setPositionPlayer(listOfPlayers.get(turn));
        // System.out.println("You are in the square: " +
        // monopoly.table.getSquareName(listOfPlayers.get(turn).getPosition()));

        Player realOwner = monopoly.checkOwnerForRent(listOfPlayers.get(turn).getNickname(), listOfPlayers,
                listOfPlayers.get(turn).getPosition());

        if (realOwner != null) {

            System.out.println("Oh no! this property is owned by " + realOwner.getNickname()
                    + "\n You have to pay: "
                    + monopoly.table.getSquarePriceTax(listOfPlayers.get(turn).getPosition()));
            realOwner.increaseMoney(monopoly.table.getSquarePriceTax(listOfPlayers.get(turn).getPosition()));
            listOfPlayers.get(turn)
                    .decreaseMoney(monopoly.table.getSquarePriceTax(listOfPlayers.get(turn).getPosition()));

        }
    }

    public void gameStatus() {

        Monopoly monopoly = new Monopoly(listOfPlayers);

        System.out.println("Il gioco inizia!!!");
        System.out.println("Ogni giocatore inizia con 1500 chf \n");

        while (monopoly.MonopolyEND()) {

            turn = turn % numberOfPlayers;

            System.out.println(listOfPlayers.get(turn).getNickname() + " e' il tuo turno! \n");

            if (listOfPlayers.get(turn).getTurnsInJail() == -1) {
                startTurn(listOfPlayers.get(turn), monopoly);
                throwDiceTurn(listOfPlayers.get(turn), monopoly);
            }

            while (skip == 0) {

                switch (monopoly.table.getSquare(listOfPlayers.get(turn).getPosition()).getColor()) {

                    case "cards":
                        cardsPLAYmain(listOfPlayers.get(turn), monopoly);
                        break;

                    // case "park":
                    // parkPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;

                    // case "company":
                    // companyPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;

                    case "jail":
                        jailPLAYmain(listOfPlayers.get(turn), monopoly);
                        break;

                    case "empty":
                        emptyPLAYmain(listOfPlayers.get(turn), monopoly);
                        break;

                    case "goto":
                        gotoPLAYmain(listOfPlayers.get(turn), monopoly);
                        break;

                    default:
                        PropertySquarePLAY(listOfPlayers.get(turn), monopoly);

                }

            }
            skip = 0;

            turn += 1;

        }

    }

    public void finishStatus() {
        this.status = -1;

    }

    public int getStatus() {
        return status;
    }

    public static void main(String[] args) {

        Main game = new Main();

        //

        switch (game.getStatus()) {

            case 0:
                System.out.println("pregame status");
                game.preGameStatus();

            case 1:
                System.out.println("Play game  status");
                game.gameStatus();

            case -1:
                System.out.println("Game finished status");
                game.finishStatus();
                System.exit(0);

        }

    }

}
