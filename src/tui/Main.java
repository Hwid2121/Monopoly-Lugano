package tui;

import java.util.Scanner; // Import the Scanner class

import java.util.ArrayList;

import model.JailSquare;
import model.Monopoly;
import model.Player;
import model.PropertySquare;
import model.Table;
import model.cardsDeck;

import model.Card;

/**
 * DESCRIBE THIS CLASS
 * 
 * @author YOUR_USI_EMAIL
 */
public class Main {

    // ArrayList<Player> listOfPlayers = new ArrayList<Player>();
    Monopoly monopoly = new Monopoly();
    private Scanner input = new Scanner(System.in);

    private int numberOfPlayers = 0;
    private int status = 0;

    private int skip = 0;
    private int turn = 0;

    

    public void preGameStatus() {
        

        System.out.println("How many players?");

        if (!input.hasNextInt()) {
            System.out.println("You have entered incorrect input! Please enter a number");
            input.nextLine();
            preGameStatus();
            return;
        }

        numberOfPlayers = input.nextInt();

        

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

    public void elimininationPLAYmain(Player player, Monopoly monopoly) {
        monopoly.playerEliminated(player);
        skip = 1;
    }


    public void bankRuptPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("You are in bankrupt, you do not have money");
        System.out.println("You must sell your properties till you balance is positive");


        while (player.getPropertySquareNum() > 0) {

            if (player.getMoney() < 0) {
                PropertySquareSELL(player, monopoly);
            } else {
                System.out.println("You are not in bankrupt now your balance is " + player.getMoney() + " chf");
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
                return;
            }

        }
        skip = 1;

    }

    public void jailPLAYmain(Player player, Monopoly monopoly) {

        player.setJail(JailSquare.getDays());

        System.out.println("You are in jail");
        System.out.println("You can escape doing:");
        System.out.println("- [pay] Paying 55 chf now");
        System.out.println("- [c] Using the free from jail card");
        System.out.println("- [t] Trying to do perfect pair ");
        System.out.println("After 3 turn you must pay 50 chf");

        String word = input.next(); 

        System.out.println(monopoly.getPLayer(turn).getMoney());

        if (player.getTurnsInJail() > 0) {

            

            switch (word) {
                case ("pay"):
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");
                    

                    monopoly.throwDice();

                    if (monopoly.checkbankruptStatus(player)) {
                        System.out.println("\n You do not have enough money to pay the fi");
                        bankRuptPLAYmain(player, monopoly);
                        skip = 1;
                        return;
                    }



                    monopoly.setPositionPlayer(player);
                    System.out.println("You are in the square: "
                            + monopoly.table.getSquareName(monopoly.getPLayer(turn).getPosition()));

                    startTurn(player, monopoly);

                    break;

                case ("c"):
                    if (JailSquare.checkFreeJailCard(player)) {
                        JailSquare.freeFromJail(player);

                        System.out.println("You used the card, you can throw the dice\n ");
                        monopoly.setPositionPlayer(monopoly.getPLayer(turn));
                        System.out.println("You are in the square: "
                                + monopoly.table.getSquareName(monopoly.getPLayer(turn).getPosition()));

                        startTurn(player, monopoly);

                        skip = 1;
                        break;

                    } else {
                        System.out.println("\n You don't have the card!\n");
                        break;
                    }
                case ("t"):

                    monopoly.throwDice();
                    System.out.println("Your dice made: " + monopoly.die1() + " and " + monopoly.die2());
                    if (monopoly.dice.getPerfectPair()) {
                        JailSquare.freeFromJail(player);
                        System.out.println("You did perfect pair, you gonna forward for " + (monopoly.die1() * 2));

                        monopoly.setPositionPlayer(monopoly.getPLayer(turn));
                        System.out.println("You are in the square: "
                                + monopoly.table.getSquareName(monopoly.getPLayer(turn).getPosition()));

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
        int position = monopoly.getPLayer(turn).getPosition();

        System.out.println("Write:\n [d] (for the description of the property) ");
        System.out.println("[b] (for buying the property) ");
        System.out.println("[s] (to sell this property) ");
        System.out.println("[p] (to finish the turn) ");
        System.out.println("[m] (to show your balance)");
        System.out.println("[i] (for all info of the player)");

        String word = input.next();

        switch (word) {
            case "d":
                System.out.println("\nName: " + monopoly.table.getSquare(position).getName() + "\n Color: " + monopoly.table.getSquare(position).getColor());
                System.out.println("Owner: " + monopoly.table.getSquareOwnerToString(position)+ "\nPrice: " + monopoly.table.getSquarePrice(position) );
                System.out.println("Price tax: "+ monopoly.table.getSquarePriceTax(position) );
                break;

            case "b":
                PropertySquareBUY(player, monopoly);
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

    public void PropertySquareBUY(Player player, Monopoly monopoly) {

        int position = player.getPosition();
        String inp;
        if ((player.getMoney() >= monopoly.table.getSquarePrice(position) &&
                (monopoly.table.getSquareOwner(position) == null)))

        {
            System.out.println("Confirm to buy the property?"
                    + monopoly.table.getSquareName(position)
                    + "\n Your budget will be "
                    + (player.getMoney() - monopoly.table.getSquarePrice(position)));

            System.out.println("Write [y] for the confirm or [n] for return back: ");
            inp = input.next();

            switch (inp) {
                case "y":
                    monopoly.setOwner(player);
                    player.buyPropertySquare(monopoly.table.getPropertySquare(position));
                    player.decreaseMoney(monopoly.table.getSquarePrice(position));

                    System.out.println("Square has been bought! \n");
                    String color = monopoly.table.getColor(position);
                    checkMonopolyProperty(player, monopoly, color);

                case "n":
                    break;
            }

        } else
            System.out.println("You don't have enough money to buy the property");
    }

    public void checkMonopolyProperty(Player player, Monopoly monopoly, String color) {

        if(monopoly.table.getMonopolyColor(player)){
            System.out.println("\n \n You did monopoly for the color "+ color + " now the rent for these property square are doubled \n");
            monopoly.table.getMonopolyColor(player);
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

        monopoly.setPositionPlayer(monopoly.getPLayer(turn));
        System.out.println("You are in the square: "
                + monopoly.table.getSquareName(monopoly.getPLayer(turn).getPosition()));

    }

    public void startTurn(Player player, Monopoly monopoly) {
        
        if(monopoly.checkOwnerForRent(player)){
            payrent(player, monopoly);
        }

    }


    public void payrent(Player player, Monopoly monopoly){

        monopoly.table.getPropertySquare(player.getPosition()).payrent();
        player.decreaseMoney(monopoly.table.getPropertySquare(player.getPosition()).getPriceTax());
    }




    public void gameStatus() {

        

        System.out.println("The game start!!!");
        System.out.println(
                "Every player start with 1500 chf \n  If you go bankrupt you lose \n Win the last player with money");

        while (monopoly.MonopolyEND()) {

            turn = turn % monopoly.getSizeOfPlayers();



            System.out.println(monopoly.getPLayer(turn).getNickname() + " e' il tuo turno! \n");

            if (monopoly.getPLayer(turn).getTurnsInJail() == -1) {

                throwDiceTurn(monopoly.getPLayer(turn), monopoly);
                startTurn(monopoly.getPLayer(turn), monopoly);

            }

            while (skip == 0) {

                switch (monopoly.table.getSquare(monopoly.getPLayer(turn).getPosition()).getColor()) {

                    case "cards":
                        cardsPLAYmain(monopoly.getPLayer(turn), monopoly);
                        break;

                    // case "park":
                    // parkPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;

                    // case "company":
                    // companyPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;

                    case "jail":
                        jailPLAYmain(monopoly.getPLayer(turn), monopoly);
                        break;

                    case "empty":
                        emptyPLAYmain(monopoly.getPLayer(turn), monopoly);
                        break;

                    case "goto":
                        gotoPLAYmain(monopoly.getPLayer(turn), monopoly);
                        break;

                    case "bonus":
                        bonusPLAYmain(monopoly.getPLayer(turn), monopoly);
                        break;

                    case "malus":
                        bonusPLAYmain(monopoly.getPLayer(turn), monopoly);
                        break;

                    default:
                        PropertySquarePLAY(monopoly.getPLayer(turn), monopoly);

                }

            }
            skip = 0;

            turn += 1;

        }

    }

    public void finishStatus() {
        System.out.println("The monopoly of Lugano is " + monopoly.getPLayer(0).getNickname());
        System.exit(0);
        // System.out.println("Do you want play again?");
        // System.out.println("[y] for play again \n [n] for exit");
        // String word = input.next();

        // switch (word) {
        //     case "y":
        //         status = 0;
        //     case "n":
        //         System.out.println("See You :)");
                
        //         break;
        //     default:
        //         System.out.println("Input not valid");
        // }

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
                

        }

    }

}
