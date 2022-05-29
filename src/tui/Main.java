package tui;

import java.util.Scanner; // Import the Scanner class

import model.JailSquare;
import model.Monopoly;
import model.Player;
import model.PropertySquare;
import model.cardsDeck;

import model.Card;

/**
 * This is the main of the TUI
 * inside of this class is present the class main and the main for start with
 * the TUI
 * 
 * 
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class Main {

    private Monopoly monopoly = new Monopoly();
    private Scanner input = new Scanner(System.in);

    private int numberOfPlayers = 0;
    private int status = 0;
    private String chf = " chf";
    private String nName = "\nName: ";
    private int skip = 0;
    private int turn = 0;


    /**
     * preGameStatus is the method that manage the pregame of Monopoly.
     * Here will be asked to insert the numberOfPlayers  and then 
     * creating the instance for each player.
     * 
     */
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


    /**
     *  When a player is eliminated will be removed from the monopoly.
     * And the turn will skip.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void elimininationPLAYmain(Player player, Monopoly monopoly) {
        monopoly.playerEliminated(player);
        skip = 1;
    }

    /**
     *  Check if the player is under 0 chf of balance, if true then let the player to sell the properties
     * to cover the debit. If not enough money then will be eliminated.
     * Else will brake.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */public void bankRuptPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("You are in bankrupt, you do not have money");
        System.out.println("You must sell your properties till you balance is positive");

        while (player.getPropertySquareNum() > 0) {

            if (player.getMoney() < 0) {
                PropertySquareSELL(player, monopoly);
            } else {
                System.out.println("You are not in bankrupt now your balance is " + player.getMoney() + chf);
                return;
            }
        }

        System.out.println("Oh no you don't have enough money to cover the debit");
        System.out.println(player.getNickname() + " has been eliminated");

        elimininationPLAYmain(player, monopoly);

    }

    /**
     * When a player is in the square bonus where picking a card then will activate cardsPLAYmain
     * to let the player take the card and active its effect.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */public void cardsPLAYmain(Player player, Monopoly monopoly) {

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

    /**
     *  When a player reach the square gotoPLAYmain will be obbliged to change position
     * and will be moved to the position 30 where is the jail.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */public void gotoPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("Go to the jail! \n");

        player.movePosition(30);
        player.setJail(JailSquare.getDays());
        jailPLAYmain(player, monopoly);

    }

    
    
    
    /**
     *  When a player reach a bonusSquare then will activate the effect of the square
     * if the player go under 0 chf then bankrupt will be activated.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */public void bonusPLAYmain(Player player, Monopoly monopoly) {

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

    /**
     *  When a player reach the jail Square will be in prison and he can escape only if:
     * - pay 55 chf
     * - using the card "free from jail" (if possesed)
     * - trying to do a perfect pair
     * 
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */public void jailPLAYmain(Player player, Monopoly monopoly) {

        if (player.getTurnsInJail() == -1) {
            player.setJail(JailSquare.getDays());

        }

        System.out.println("You are in jail");
        System.out.println("You can escape doing:");
        System.out.println("- [pay] Paying 55 chf now");
        System.out.println("- [c] Using the free from jail card");
        System.out.println("- [t] Trying to do perfect pair ");
        System.out.println("\nAfter 3 turns you must pay the fine");

        String word = input.next();

        System.out.println(monopoly.getPLayer(turn).getMoney());

        if (player.getTurnsInJail() > 0) {

            switch (word) {
                case "pay":
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    monopoly.throwDice();
                    System.out.println("Your dice made: " + monopoly.die1() + " and " + monopoly.die2());
                    System.out.println("Go forward by: " + (monopoly.die1() + monopoly.die2()));

                    if (monopoly.checkbankruptStatus(player)) {
                        System.out.println("\n You do not have enough money to pay the fi");
                        bankRuptPLAYmain(player, monopoly);
                        skip = 1;
                        return;
                    }

                    monopoly.setPositionPlayer(player);
                    System.out.println("You are in the square: "
                            + monopoly.getTable().getSquareName(monopoly.getPLayer(turn).getPosition()));

                    startTurn(player, monopoly);

                    break;

                case "c":
                    if (JailSquare.checkFreeJailCard(player)) {
                        JailSquare.freeFromJail(player);

                        System.out.println("You used the card, you can throw the dice\n ");
                        monopoly.setPositionPlayer(monopoly.getPLayer(turn));
                        System.out.println("You are in the square: "
                                + monopoly.getTable().getSquareName(monopoly.getPLayer(turn).getPosition()));

                        startTurn(player, monopoly);

                        skip = 1;
                        break;

                    } else {
                        System.out.println("\n You don't have the card!\n");
                        break;
                    }
                case "t":

                    monopoly.throwDice();
                    System.out.println("Your dice made: " + monopoly.die1() + " and " + monopoly.die2());
                    if (monopoly.getDice().isPerfectPair()) {
                        JailSquare.freeFromJail(player);
                        System.out.println("You did perfect pair, you gonna forward for " + (monopoly.die1() * 2));

                        // monopoly.setPositionPlayer(monopoly.getPLayer(turn));
                        // System.out.println("You are in the square: "
                        // + monopoly.getTable().getSquareName(monopoly.getPLayer(turn).getPosition()));

                        // startTurn(player, monopoly);
                        gameStatusPLAY();

                        break;

                    }
                    JailSquare.decreseDayInJail(player);
                    System.out.println("You did not do perfect pair, see you next turn!");
                    System.out.println(player.getTurnsInJail() + " turns in jail left");

                    skip = 1;
                    break;

                default:
                    System.out.println("Command not allowed here.\n");
                    jailPLAYmain(player, monopoly);

            }
        }

        else if (player.getTurnsInJail() == 0) {
            System.out.println("You have to pay the fine");
            System.out.println("[p] (for pay the fine)");
            word = input.next();

            switch (word) {
                case "pay":
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    if (monopoly.checkbankruptStatus(player)) {
                        bankRuptPLAYmain(player, monopoly);
                        break;
                    }

                    gameStatusPLAY();

                    break;
                default:
                    System.out.println("invalid Input");

            }
        }

    }

    
    
    
    
    
    /**
     *  When a player reach the emptySquaer will not do nothing and will not be allowed to do 
     * some actions.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void emptyPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("This is an empty square \n You cannot do nothing here");
        System.out.println("[p] (to finish the turn) ");
        System.out.println("[m] (to show your balance)");
        System.out.println("[i] (for all info of the player)");

        String word = input.next();

        switch (word) {

            case "m":
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "i":
                System.out.println(nName + player.getNickname() + "\nMoney: " + player.getMoney()
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

    /**
     *  When a player reach a propertySQuare could have some comands: 
     *  - [b] (for buying the property)
     * - [s] (to sell this property)
     * - [m] (to show your balance)
     * -  [p] (to finish the turn) 
     * - [i] (for all info of the player)
     * - [c] (for show the situation of the other properties of same color)
     * - [h] (for buy house, hotel and more info)
     * - [o] (for see the infos for other players)
     * - [exit] (for close the game)
     * 
     * if the square is owned by another player, then the player will have to pay the rent.
     * 
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void PropertySquarePLAY(Player player, Monopoly monopoly) {
        int position = monopoly.getPLayer(turn).getPosition();

        System.out.println("Write:\n[d] (for the description of the property) ");
        System.out.println("[b] (for buying the property) ");
        System.out.println("[s] (to sell this property) ");
        System.out.println("[p] (to finish the turn) ");
        System.out.println("[m] (to show your balance)");
        System.out.println("[i] (for all info of the player)");
        System.out.println("[c] (for show the situation of the other properties of same color)");
        System.out.println("[h] (for buy house, hotel and more info)");
        System.out.println("[o] (for see the infos for other players)");
        System.out.println("[exit] (for close the game)");
        

        String word = input.next();

        switch (word) {
            case "d":
                System.out.println(nName + monopoly.getTable().getSquare(position).getName() + "\nColor: "
                        + monopoly.getTable().getSquare(position).getColor());
                System.out.println("Owner: " + monopoly.getTable().getSquareOwnerToString(position) + "\nPrice: "
                        + monopoly.getTable().getSquarePrice(position));
                System.out.println("Price tax: " + monopoly.getTable().getSquarePriceTax(position));
                if (monopoly.getTable().getHouse(position).getCounter() <= 4) {
                    System.out.println("House: " + monopoly.getTable().getHouse(position).getCounter());
                }
                else {
                    System.out.println("Hotel: 1");
                }
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
                System.out.println(nName + player.getNickname() + "\nMoney: " + player.getMoney()
                        + "\nProperties: " + player.propertySquaretoString() + "\nPosition: " + player.getPosition());
                break;

            case "o":
                for (Player pl: monopoly.getListOfPlayer()){
                    System.out.println(nName + pl.getNickname() + "\nMoney: " + pl.getMoney()
                        + "\nProperties: " + pl.propertySquaretoString() + "\nPosition: " + pl.getPosition());

                        
                

                }
                break;
            case "p":
                skip = 1;
                break;

            case "h":

                if (monopoly.getTable().getHouse(position).getCounter() == 5) {
                    System.out.println("You already bought the hotel here!");
                } else if (monopoly.getTable().getPropertySquare(position).getHouse().getPrice(1) == 0) {
                    System.out.println("You cannot build here");
                } else if (monopoly.checkOwnerForRent(player)) {
                    hotelBUY(player, monopoly);
                } else {
                    System.out.println("You cannot build hotel here, not your property");
                }

                break;

            case "c":
                System.out.println("You are in square of color:\t" + monopoly.getTable().getSquare(position).getColor());
                for (PropertySquare n : monopoly.getTable().getOtherMonopolySquare(player)) {
                    System.out.println("Name: " + n.getName() + "\t" + " Owner: "
                            + monopoly.getTable().getSquareOwnerToString(n.getPosition()) + "\t" + " Position: "
                            + n.getPosition());
                }
                break;

            case "exit":
                System.out.println("EXIT THE GAME");
                System.exit(0);

            default:
                System.out.println("Command not allowed here.\n\n");
                PropertySquarePLAY(player, monopoly);
        }

    }

    
    
    /**
     *  A player can buy houses and Hotel if own the propertySquare.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void hotelBUY(Player player, Monopoly monopoly) {
        

        System.out.println(
                "Price for build an house: " + monopoly.getTable().getHouse(player.getPosition()).getPrice(6) + chf);

        for (int i = 1; i <= 4; i++) {
            System.out.println("PriceTax with " + i + " house increasing to: "
                    + monopoly.getTable().getHouse(player.getPosition()).getPrice(i) + chf);
        }
        System.out.println("PriceTax with hotel increasing to: "
                + monopoly.getTable().getHouse(player.getPosition()).getPrice(5) + chf);
        System.out.println("For building an Hotel you have to buy 4 houses + building price");

        if (monopoly.getTable().getHouse(player.getPosition()).getCounter() < 5) {
            System.out.println("Your house: " + monopoly.getTable().getHouse(player.getPosition()).getCounter());
        }
        System.out.println("Write:\n");
        System.out.println("[0] For go back");
        System.out.println(
                "[1] For build 1 house at price of " + (monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));
        System.out.println("[2] For build 2 houses at price of "
                + (monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 2);
        System.out.println("[3] For build 3 houses at price of "
                + (monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 3);
        System.out.println("[4] For build 4 houses at price of "
                + (monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 4);

        System.out.println("[5] For build an Hotel at price of "
                + ((5 - monopoly.getTable().getHouse(player.getPosition()).getCounter()))
                        * (monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));

        int word = input.nextInt();

        if (word > 0 && word < 5) {
            if (monopoly.getTable().getHouse(player.getPosition()).checkNumHouses(word)) {
                System.out.println("Building" + word + " house at the price of "
                        + ((monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * word) + chf);
                propertySquareBUILD(player, monopoly, word);
            } else {
                System.out.println(
                        "You have already " + monopoly.getTable().getHouse(player.getPosition()).getCounter() + " house");
                System.out.println("Maybe is the time for buying an hotel with 4 house + "
                        + monopoly.getTable().getHouse(player.getPosition()).getPrice(6));
            }
            return;

        } else if (word == 5) {

            int numhouse = monopoly.getTable().getHouse(player.getPosition()).getCounter();
            System.out.println("You have  " + numhouse + " house");

            if (numhouse < 5) {
                System.out.println("You have to buy " + (4 - numhouse) + " more houses");

                word = 5 - numhouse;

                System.out.println(
                        "Cost: " + (monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * word) + chf);

                propertySquareBUILD(player, monopoly, word);

            } else {
                System.out.println("You have to buy 4 more houses + pay the build fee ");
                System.out.println("Cost: " + (monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * 4) + chf
                        + " + " + (monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) + chf);
                propertySquareBUILD(player, monopoly, (5 - monopoly.getTable().getHouse(player.getPosition()).getCounter())
                        * (monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));
            }
            return;

        } else if (word == 0) {
            return;
        } 
        else {
            System.out.println("Input not valid");
        }

    }

    
    
    
    
    /**
     *  Build in the property of the player the amount of hotel or houses  requested.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */public void propertySquareBUILD(Player player, Monopoly monopoly, int num) {

        int position = player.getPosition();

        int price = monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * num;

        String word;

        if (player.getMoney() >= price) {

            System.out.println("Do you confirm to buy?");
            System.out.println("Your balance will be: " + (player.getMoney() - price));
            System.out.println("[y] for confirm");
            System.out.println("[n] for go back");

            word = input.next();

            switch (word) {

                case "y":

                    if (num >= 1 && num <= 4) {
                        System.out.println("Building " + num + " house...");
                        player.decreaseMoney(price);
                        monopoly.getTable().getHouse(position).buildHouse(num);
                        monopoly.getTable().getPropertySquare(position)
                                .setPriceTax(monopoly.getTable().getHouse(position).getPrice(num));
                        // monopoly.getTable().getPropertySquare(position).increasePriceSell(num);

                    } else {

                        System.out.println("Building your Hotel...");
                        player.decreaseMoney(price);
                        monopoly.getTable().getHouse(position).buildHouse(num);
                        monopoly.getTable().getPropertySquare(position)
                                .setPriceTax(monopoly.getTable().getHouse(position).getPrice(5));
                        // monopoly.getTable().getPropertySquare(position).increasePriceSell();

                    }

                case "n":
                    hotelBUY(player, monopoly);

            }

        } else {
            System.out.println("You don't have enough money to build");
            System.out.println("Your money: " + player.getMoney());
            System.out.println("You need + " + price + "\n");
        }

    }

    
    
    
    
    /**
     *  When the player has enough money and the square is not own by another 
     * player can buy the porpertysquare.
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */public void PropertySquareBUY(Player player, Monopoly monopoly) {

        int position = player.getPosition();
        String inp;
        if (player.getMoney() >= monopoly.getTable().getSquarePrice(position) &&
                monopoly.getTable().getSquareOwner(position) == null)

        {
            System.out.println("Confirm to buy the property?"
                    + monopoly.getTable().getSquareName(position)
                    + "\n Your budget will be "
                    + (player.getMoney() - monopoly.getTable().getSquarePrice(position)));

            System.out.println("Write [y] for the confirm or [n] for return back: ");
            inp = input.next();

            switch (inp) {
                case "y":
                    monopoly.setOwner(player);
                    player.buyPropertySquare(monopoly.getTable().getPropertySquare(position));
                    player.decreaseMoney(monopoly.getTable().getSquarePrice(position));

                    System.out.println("Square has been bought! \n");
                    String color = monopoly.getTable().getColor(position);
                    checkMonopolyProperty(player, monopoly, color);

                case "n":
                    break;
            }

        } else {
            System.out.println("You don't have enough money to buy the property");
            System.out.println("Or the property is not yours");
        }

        // rent to pay

    }



    /**
     *  Check if the propertySquare own by the player 
     * @param player that play in that turn
     * @param monopoly the main class where the game is strutured
     * @param color the color of the square where the player is
     *
     */
    public void checkMonopolyProperty(Player player, Monopoly monopoly, String color) {

        if (monopoly.getTable().getMonopolyColor(player)) {
            System.out.println("\n \n You did monopoly for the color " + color
                    + " now the rent for these property square are doubled \n");
            monopoly.getTable().getMonopolyColor(player);
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

    public void throwDiceTurn(Player player, Monopoly monopoly) {

        monopoly.throwDice();
        System.out.println("Your dice made: " + monopoly.die1() + " and " + monopoly.die2());
        System.out.println("Go forward by: " + (monopoly.die1() + monopoly.die2()));

        monopoly.setPositionPlayer(monopoly.getPLayer(turn));
        System.out.println("You are in the square: "
                + monopoly.getTable().getSquareName(monopoly.getPLayer(turn).getPosition()));

    }

    public void startTurn(Player player, Monopoly monopoly) {

        if (monopoly.checkOwnerForRent(player)) {
            payrent(player, monopoly);
        }

    }

    public void payrent(Player player, Monopoly monopoly) {
        System.out.println(
                "Oh no, this property is owned by: " + monopoly.getTable().getSquareOwnerToString(player.getPosition()));
        System.out.println("You have to pay: " + monopoly.getTable().getSquarePriceTax(player.getPosition()));
        monopoly.getTable().getPropertySquare(player.getPosition()).payrent();
        player.decreaseMoney(monopoly.getTable().getPropertySquare(player.getPosition()).getPriceTax());
    }

    public void gameStatusPLAY() {

        while (monopoly.monopolyEND()) {

            turn = turn % monopoly.getSizeOfPlayers();

            System.out.println(monopoly.getPLayer(turn).getNickname() + " e' il tuo turno! \n");


            if (monopoly.getPLayer(turn).getTurnsInJail() == -1) {

                throwDiceTurn(monopoly.getPLayer(turn), monopoly);
                startTurn(monopoly.getPLayer(turn), monopoly);

            }

            while (skip == 0) {

                switch (monopoly.getTable().getSquare(monopoly.getPLayer(turn).getPosition()).getColor()) {

                    case "cards":
                        cardsPLAYmain(monopoly.getPLayer(turn), monopoly);
                        break;

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
                        break;

                }

            }
            skip = 0;

            turn += 1;

        }

    }

    public void gameStatus() {

        System.out.println("The game start!!!");
        System.out.println(
                "Every player start with 1500 chf \n  If you go bankrupt you lose \n Win the last player with money");

        gameStatusPLAY();

    }

    public void finishStatus() {
        System.out.println("The monopoly of Lugano is " + monopoly.getPLayer(0).getNickname());
        System.exit(0);
        

    }

    public int getStatus() {
        return status;
    }

    public static void main(String[] args) {

        Main game = new Main();


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
