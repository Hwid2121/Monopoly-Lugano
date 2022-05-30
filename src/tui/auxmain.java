package tui;
import java.util.Scanner; // Import the Scanner class
import model.JailSquare;
import model.Monopoly;
import model.Player;
import model.cardsDeck;
import model.Card;
/**
 * This is the auxiliary main of the TUI created for refactoring.
 * inside of this class is present the class main and the main for start with
 * the TUI
 * 
 * 
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 29/05/2022
 */
public class auxmain {

    public Monopoly monopoly = new Monopoly();
    public Scanner input = new Scanner(System.in);
    public int status = 0;
    public int skip = 0;
    private String chf = " chf";

    public void preGameStatus(){

        System.out.println("How many players?");

        if (!input.hasNextInt()) {
            System.out.println("You have entered incorrect input! Please enter a number");
            input.nextLine();
            preGameStatus();
            return;
        }

        int numberOfPlayers = input.nextInt();

        if (numberOfPlayers < 2) {

            System.out.println("Number of player not allowed, insert a number of player greater than 2");
            preGameStatus();
            return;
        }

        else {

            while (monopoly.getSizeOfPlayers() < numberOfPlayers) {

                System.out.println("Nickname player " + (monopoly.getSizeOfPlayers() + 1));

                String Nickname = input.next();
                if (input.hasNextLine()) {

                    monopoly.addPlayer(new Player(Nickname));
                }

            }

            System.out.println("Pregame ready, now let's play!");
            status = 1;

        }

    }
    
    public void elimininationPLAYmain(Player player, Monopoly monopoly2) {
        monopoly.playerEliminated(player);
        skip = 1;
    }

    public void bankRuptPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("You are in bankrupt, you do not have money");
        System.out.println("You must sell your properties till you balance is positive");

        while (player.getPropertySquareNum() > 0) {

            if (player.getMoney() < 0) {
                propertysquaresell(player, monopoly);
            } else {
                System.out.println("You are not in bankrupt now your balance is " + player.getMoney() + chf);
                return;
            }
        }

        System.out.println("Oh no you don't have enough money to cover the debit");
        System.out.println(player.getNickname() + " has been eliminated");

        elimininationPLAYmain(player, monopoly);


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

                System.out.println("next turn\n\n");
                skip = 1;
                return;

            default:
                System.out.println("Command not allowed here.\n");
                cardsPLAYmain(player, monopoly);

        }

        if (monopoly.checkbankruptStatus(player)) {
            bankRuptPLAYmain(player, monopoly);
            skip = 1;
            return;
        }

    }

    public void propertysquaresell(Player player, Monopoly monopoly) {

        int num = player.getPropertySquare().size();
        System.out.println("You have " + num + " properties");

        for (int i = 0; i <= num - 1; i++) {
            System.out.println("[" + i + "]" + " for sell " + player.getPropertySquare().get(i).getName()
                    + " at price sell: " + player.getPropertySquare().get(i).getPriceSell());
        }
        int word = input.nextInt();

        while (num != -420) {

            System.out.println("[-1] for go back");

            if (word >= 0 && word <= num - 1) {

                int pos = player.getPropertySquare().get(word).getPosition();

                player.sellPropertySquare(word, player.getPropertySquare().get(word));

                monopoly.getTable().resetOwner(pos);

                System.out.println("\n Property sold");
                num = -420;

            } else if (word == -1) {
                return;

            } else {
                System.out.println("Index not valid");
                word = input.nextInt();
            }

        }


    }

    public void bonusPLAYmain(Player player, Monopoly monopoly) {
        int price = monopoly.getTable().getSquareBonusPrice(player);

        System.out.println(monopoly.getTable().getSquareBonusDescr(player.getPosition()));

        if (monopoly.getTable().getSquare(player.getPosition()).getColor().equals("bonus")) {

            player.increaseMoney(price);
        } else {
            player.decreaseMoney(price);
            if (monopoly.checkbankruptStatus(player)) {
                bankRuptPLAYmain(player, monopoly);
                skip = 1;
                return;
            }

        }
        skip = 1;
    }
}
