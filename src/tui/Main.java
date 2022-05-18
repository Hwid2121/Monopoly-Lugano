package tui;

import java.util.Scanner; // Import the Scanner class

import javax.swing.plaf.metal.MetalBorders.PaletteBorder;
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

                System.out.println("Nickname player " + listOfPlayers.size());

                String Nickname = input.next();
                if (input.hasNextLine()) {

                    listOfPlayers.add(new Player(Nickname));
                }

            }

            System.out.println("Pregame ready, now let's play!");
            status = 1;

        }
    }

    public void elimininationPLAYmain(Player player, Monopoly monopoly) {
        monopoly.playerEliminated(listOfPlayers, player);
        numberOfPlayers -=1;
    }

    public void bankRuptPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("You are in bankrupt, you do not have money");
        System.out.println("You must sell your properties till you balance is positive");

        boolean ok = false;

        while (!ok) {

            while (player.getPropertySquareNum() > 0) {

                if (player.getMoney() < 0) {
                    PropertySquareSELL(player, monopoly);
                } else {
                    System.out.println("You are not in bankrupt now your balance is " + player.getMoney() + " chf");
                    ok = true;
                    break;
                }
            }

            System.out.println("Oh no you don't have enough money to cover the debit");
            System.out.println(player.getNickname() + "has been eliminated");

            elimininationPLAYmain(player, monopoly);
            ok = true;

        }

    }

    public void cardsPLAYmain(Player player, Monopoly monopoly) {

        System.out.println("You gonna take a card \n that can be a bonus card or a malus card\n ");
        System.out.println("After the effect the card the pass will be automatically");
        System.out.println("Good luck!\n");

        cardsDeck deck = new cardsDeck();
        System.out.println("[pi] (for picking a card)");
        String word = input.next();

        switch (word) {
            case "pi":
                Card card = deck.randomCard();
                System.out.println("CARD:" + card.getDescription());
                deck.playCard(deck.getIndex(), player);

                if (monopoly.checkbankruptStatus(player)) {
                    bankRuptPLAYmain(player, monopoly);
                    skip = 1;
                }

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

    public void bonusPLAYmain(Player player, Monopoly monopoly) {

        int price = monopoly.table.getSquareBonusPrice(player);

        System.out.println(monopoly.table.getSquareBonusDescr(player.getPosition()));

        if (monopoly.table.getSquare(player.getPosition()).getColor() == "bonus") {

            player.increaseMoney(price);
        } else {
            player.decreaseMoney(price);
            if (monopoly.checkbankruptStatus(player)) {
                bankRuptPLAYmain(player, monopoly);
                skip = 1;
            }

        }
        skip = 1;

    }

    public void jailPLAYmain(Player player, Monopoly monopoly) {

        player.setJail(JailSquare.getDays());

        System.out.println("You are in jail");
        System.out.println("You can escape doing:");
        System.out.println("- [pay] Paying 55 chf now");
        System.out.println("- [crd] Using the free from jail card");
        System.out.println("- [tr] Trying to do perfect pair ");
        System.out.println("After 3 turn you must pay 50 chf");

        String word = input.next();

        if (player.getTurnsInJail() > 0) {
            switch (word) {
                case ("pay"):
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");
                    if (monopoly.checkbankruptStatus(player)) {
                        bankRuptPLAYmain(player, monopoly);
                        skip = 1;
                    }

                    monopoly.throwDice();

                    monopoly.setPositionPlayer(player);
                    System.out.println("You are in the square: "
                            + monopoly.table.getSquareName(listOfPlayers.get(turn).getPosition()));

                    startTurn(player, monopoly);

                    break;

                case ("crd"):
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
                case ("tr"):

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
                case ("pay"):
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");
                    
                    if (monopoly.checkbankruptStatus(player)) {
                        bankRuptPLAYmain(player, monopoly);
                        skip = 1;
                    }

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
        System.out.println("[p] (to finish the turn) ");
        System.out.println("[m] (to show your balance)");
        System.out.println("[i] (for all info of the player)");

        String word = input.next();

        switch (word) {

            case ("m"):
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "i":
                System.out.println("\nName: " + player.getNickname() + "\nMoney: " + player.getMoney()
                        + "\nProperties: " + player.getPropertySquare() + "\nPosition: " + player.getPosition());

                break;

            case "p":
                skip = 1;
                break;

            default:
                System.out.println("Command not allowed here");
                emptyPLAYmain(player, monopoly);

        }

    }

    public void PropertySquarePLAY(Player player, Monopoly monopoly) {
        int position = listOfPlayers.get(turn).getPosition();

        System.out.println("Write: [d] (for the description of the property) ");
        System.out.println("[b] (for buying the property) ");
        System.out.println("[s] (to sell this property) ");
        System.out.println("[p] (to finish the turn) ");
        System.out.println("[m] (to show your balance)");
        System.out.println("[i] (for all info of the player)");

        String inp;
        String word = input.next();

        switch (word) {
            case "d":
                System.out.println("\n \n" + monopoly.propertyDescr(listOfPlayers.get(turn)) + ""
                        + monopoly.table.getSquare(position));
                break;

            case "b":

                if ((player.getMoney() >= monopoly.table.getSquarePrice(position) &&
                        (monopoly.table.getSquareOwner(position) == "")))

                {
                    System.out.println("Confirm to buy the property?"
                            + monopoly.table.getSquareName(position)
                            + "\n Your budget will be "
                            + (player.getMoney() - monopoly.table.getSquarePrice(position)));

                    System.out.println("Write [Y] for the confirm or [N] for return back: ");
                    inp = input.next();

                    switch (inp) {
                        case "Y":
                            monopoly.setOwner(player);
                            player.buyPropertySquare(monopoly.table.getPropertySquare(position));
                            player.decreaseMoney(monopoly.table.getSquarePrice(position));

                            System.out.println("Square has been bought! \n");

                            String color = monopoly.table.getColor(position);
                            if (monopoly.table.getMonopolyColor(player, color)) {
                                System.out.println(
                                        "You did monopoly, with color " + color + " the rent price tax is double now");
                                // monopoly.table.setMononopolyColor(player, color);
                            }

                        case "N":
                            break;
                    }

                } else
                    System.out.println("You don't have enough money to buy the property");
                break;

            case "s":

                if (player.getPropertySquare().size() < 1) {
                    System.out.println("You do not have properties to sell!");
                    break;
                }

                else {

                    System.out.println("Sell properties status: \n");
                    PropertySquareSELL(player, monopoly);
                    break;
                }

            case "m":
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "i":
                System.out.println("\nName: " + player.getNickname() + "\nMoney: " + player.getMoney()
                        + "\nProperties: " + player.propertySquaretoString() + "\nPosition: " + player.getPosition());
                break;

            // case "Mortgage":
            // if (((monopoly.table.getSquareOwner(position) == player.getNickname()))) {

            // System.out.println("Are you sure to mortgage your property?");
            // }

            case "p":
                skip = 1;
                break;

            default:
                System.out.println("Command not allowed here.\n\n");
                PropertySquarePLAY(player, monopoly);
        }

    }

    public void PropertySquareSELL(Player player, Monopoly monopoly) {

        int num = player.getPropertySquare().size();
        System.out.println("You have " + num + " properties");

        for (int i = 0; i <= num - 1; i++) {
            System.out.println("[" + i + "]" + " for sell " + player.getPropertySquare().get(i).getName()
                    + " at price sell: " + player.getPropertySquare().get(i).getPriceSell());
        }

        int word = input.nextInt();

        while (num != -420) {

            if (word >= 0 && word <= num - 1) {

                int pos = player.getPropertySquare().get(word).getPosition();

                player.sellPropertySquare(word, player.getPropertySquare().get(word));

                monopoly.table.resetOwner(pos);

                System.out.println("\n Property sold");
                num = -420;

            } else {
                System.out.println("Index not valid");
                word = input.nextInt();
            }

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

                    if (monopoly.checkbankruptStatus(player)) {
                        bankRuptPLAYmain(player, monopoly);
                        skip = 1;
                    }
        }
    }

    public void gameStatus() {

        Monopoly monopoly = new Monopoly(listOfPlayers);

        System.out.println("The game start!!!");
        System.out.println(
                "Every player start with 1500 chf \n  If you go bankrupt you lose \n Win the last player with money");

        while (monopoly.MonopolyEND()) {

            turn = turn % numberOfPlayers;

            System.out.println(listOfPlayers.get(turn).getNickname() + " e' il tuo turno! \n");

            if (listOfPlayers.get(turn).getTurnsInJail() == -1) {

                throwDiceTurn(listOfPlayers.get(turn), monopoly);
                startTurn(listOfPlayers.get(turn), monopoly);

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

                    case "bonus":
                        bonusPLAYmain(listOfPlayers.get(turn), monopoly);

                    case "malus":
                        bonusPLAYmain(listOfPlayers.get(turn), monopoly);
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
