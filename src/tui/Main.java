package tui;

import model.JailSquare;
import model.Monopoly;
import model.Player;
import model.PropertySquare;

public RefactorMain RefactorMain;

/**
 * This is the main of the TUI
 * inside of this class is present the class main and the main for start with
 * the TUI.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class Main {


    private String chf = " chf";
    private String nName = "\nName: ";
    private int turn = 0;




    /**
     * This is the main of the TUI
     * 
     */
    public Main() {
        RefactorMain = new RefactorMain();
    }

    /**
     * preGameStatus is the method that manage the pregame of RefactorMain.monopoly.
     * Here will be asked to insert the numberOfPlayers and then
     * creating the instance for each player.
     * 
     */
    public void preGameStatus() {
        RefactorMain.preGameStatus();
    }

    /**
     * When a player is eliminated will be removed from the RefactorMain.monopoly.
     * And the turn will skip.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void elimininationPlaymain(Player player, Monopoly monopoly) {
        RefactorMain.elimininationPlaymain(player, monopoly);
    }

    /**
     * Check if the player is under 0 chf of balance, if true then let the player to
     * sell the properties
     * to cover the debit. If not enough money then will be eliminated.
     * Else will brake.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void bankRuptPlaymain(Player player, Monopoly monopoly) {
        RefactorMain.bankRuptPlaymain(player, monopoly);
    }

    /**
     * When a player is in the square bonus where picking a card then will activate
     * cardsPlaymain
     * to let the player take the card and active its effect.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void cardsPlaymain(Player player, Monopoly monopoly) {
        RefactorMain.cardsPlaymain(player, monopoly);
    }

    /**
     * When a player reach the square gotoPLAYmain will be obbliged to change
     * position
     * and will be moved to the position 30 where is the jail.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void gotoPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("Go to the jail! \n");

        player.movePosition(30);
        player.setJail(JailSquare.getDays());
        jailPlaymain(player, RefactorMain.monopoly);

    }

    /**
     * When a player reach a bonusSquare then will activate the effect of the square
     * if the player go under 0 chf then bankrupt will be activated.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void bonusPlaymain(Player player, Monopoly monopoly) {
        RefactorMain.bonusPlaymain(player, monopoly);

    }

    /**
     * When a player reach the jail Square will be in prison and he can escape only
     * if:
     * - pay 55 chf
     * - using the card "free from jail" (if possesed)
     * - trying to do a perfect pair
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void jailPlaymain(Player player, Monopoly monopoly) {

        if (player.getTurnsInJail() == -1) {
            player.setJail(JailSquare.getDays());

        }

        System.out.println("You are in jail");
        System.out.println("You can escape doing:");
        System.out.println("- [pay] Paying 55 chf now");
        System.out.println("- [c] Using the free from jail card");
        System.out.println("- [t] Trying to do perfect pair ");
        System.out.println("\nAfter 3 turns you must pay the fine");

        String word = RefactorMain.input.next();

        System.out.println(RefactorMain.monopoly.getPLayer(turn).getMoney());

        if (player.getTurnsInJail() > 0) {

            switch (word) {
                case "pay":
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    RefactorMain.monopoly.throwDice();
                    System.out
                            .println("Your dice made: " + RefactorMain.monopoly.die1() + " and "
                                    + RefactorMain.monopoly.die2());
                    System.out
                            .println("Go forward by: " + (RefactorMain.monopoly.die1() + RefactorMain.monopoly.die2()));

                    if (RefactorMain.monopoly.checkbankruptStatus(player)) {
                        System.out.println("\n You do not have enough money to pay the fi");
                        bankRuptPlaymain(player, RefactorMain.monopoly);
                        RefactorMain.skip = 1;
                        return;
                    }

                    RefactorMain.monopoly.setPositionPlayer(player);
                    System.out.println("You are in the square: " +
                            RefactorMain.monopoly.getTable()
                                    .getSquareName(RefactorMain.monopoly.getPLayer(turn).getPosition()));

                    startTurn(player, RefactorMain.monopoly);

                    break;

                case "c":
                    if (JailSquare.checkFreeJailCard(player)) {
                        JailSquare.freeFromJail(player);

                        System.out.println("You used the card, you can throw the dice\n ");
                        RefactorMain.monopoly.setPositionPlayer(RefactorMain.monopoly.getPLayer(turn));
                        System.out.println("You are in the square: " +
                                RefactorMain.monopoly.getTable()
                                        .getSquareName(RefactorMain.monopoly.getPLayer(turn).getPosition()));

                        startTurn(player, RefactorMain.monopoly);

                        RefactorMain.skip = 1;
                        break;

                    } else {
                        System.out.println("\n You don't have the card!\n");
                        break;
                    }
                case "t":

                    RefactorMain.monopoly.throwDice();
                    System.out
                            .println("Your dice made: " + RefactorMain.monopoly.die1() + " and "
                                    + RefactorMain.monopoly.die2());
                    if (RefactorMain.monopoly.getDice().isPerfectPair()) {
                        JailSquare.freeFromJail(player);
                        System.out.println(
                                "You did perfect pair, you gonna forward for " + (RefactorMain.monopoly.die1() * 2));

                        // RefactorMain.monopoly.setPositionPlayer(RefactorMain.monopoly.getPLayer(turn));
                        // System.out.println("You are in the square: "
                        // +
                        // RefactorMain.monopoly.getTable().getSquareName(RefactorMain.monopoly.getPLayer(turn).getPosition()));

                        // startTurn(player, RefactorMain.monopoly);
                        gameStatusPlay();

                        break;

                    }
                    JailSquare.decreseDayInJail(player);
                    System.out.println("You did not do perfect pair, see you next turn!");
                    System.out.println(player.getTurnsInJail() + " turns in jail left");

                    RefactorMain.skip = 1;
                    break;

                default:
                    System.out.println("Command not allowed here.\n");
                    jailPlaymain(player, RefactorMain.monopoly);

            }
        } else if (player.getTurnsInJail() == 0) {
            System.out.println("You have to pay the fine");
            System.out.println("[p] (for pay the fine)");
            word = RefactorMain.input.next();

            switch (word) {
                case "pay":
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    if (RefactorMain.monopoly.checkbankruptStatus(player)) {
                        bankRuptPlaymain(player, RefactorMain.monopoly);
                        break;
                    }

                    gameStatusPlay();

                    break;
                default:
                    System.out.println("invalid Input");

            }
        }

    }

    /**
     * When a player reach the emptySquaer will not do nothing and will not be
     * allowed to do
     * some actions.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void emptyPlaymain(Player player, Monopoly monopoly) {
        System.out.println("This is an empty square \n You cannot do nothing here");
        System.out.println("[p] (to finish the turn) ");
        System.out.println("[m] (to show your balance)");
        System.out.println("[i] (for all info of the player)");

        String word = RefactorMain.input.next();

        switch (word) {

            case "m":
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "i":
                System.out.println(nName + player.getNickname() + "\nMoney: " + player.getMoney() 
                +   "\nProperties: " + player.getPropertySquare() + "\nPosition: " + player.getPosition());

                break;

            case "p":
                RefactorMain.skip = 1;
                break;

            default:
                System.out.println("Command not allowed here");
                emptyPlaymain(player, RefactorMain.monopoly);

        }

    }

    /**
     * When a player reach a propertySQuare could have some comands.
     * - [b] (for buying the property)
     * - [s] (to sell this property)
     * - [m] (to show your balance)
     * - [p] (to finish the turn)
     * - [i] (for all info of the player)
     * - [c] (for show the situation of the other properties of same color)
     * - [h] (for buy house, hotel and more info)
     * - [o] (for see the infos for other players)
     * - [exit] (for close the game)
     * if the square is owned by another player, then the player will have to pay
     * the rent.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void propertysquareplay(Player player, Monopoly monopoly) {
        int position = RefactorMain.monopoly.getPLayer(turn).getPosition();

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

        String word = RefactorMain.input.next();

        switch (word) {
            case "d":
                System.out
                        .println(nName + RefactorMain.monopoly.getTable().getSquare(position).getName() + "\nColor: " 
                        +   RefactorMain.monopoly.getTable().getSquare(position).getColor());
                System.out
                        .println("Owner: " + RefactorMain.monopoly.getTable().getSquareOwnerToString(position)
                                + "\nPrice: " 
                                +   RefactorMain.monopoly.getTable().getSquarePrice(position));
                System.out.println("Price tax: " + RefactorMain.monopoly.getTable().getSquarePriceTax(position));
                if (RefactorMain.monopoly.getTable().getHouse(position).getCounter() <= 4) {
                    System.out.println("House: " + RefactorMain.monopoly.getTable().getHouse(position).getCounter());
                } else {
                    System.out.println("Hotel: 1");
                }
                break;

            case "b":
                propertysquarebuy(player, RefactorMain.monopoly);
                break;

            case "s":

                if (player.getPropertySquare().size() < 1) {
                    System.out.println("You do not have properties to sell!");
                    break;
                } else {

                    System.out.println("Sell properties status: \n");
                    propertysquaresell(player, RefactorMain.monopoly);
                    break;
                }

            case "m":
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "i":
                System.out.println(nName + player.getNickname() + "\nMoney: " + player.getMoney() 
                +   "\nProperties: " + player.propertySquaretoString() + "\nPosition: " + player.getPosition());
                break;

            case "o":
                for (Player pl : RefactorMain.monopoly.getListOfPlayer()) {
                    System.out.println(nName + pl.getNickname() + "\nMoney: " + pl.getMoney() 
                    +   "\nProperties: " + pl.propertySquaretoString() + "\nPosition: " + pl.getPosition());

                }
                break;
            case "p":
                RefactorMain.skip = 1;
                break;

            case "h":

                if (RefactorMain.monopoly.getTable().getHouse(position).getCounter() == 5) {
                    System.out.println("You already bought the hotel here!");
                } else if (RefactorMain.monopoly.getTable().getPropertySquare(position).getHouse().getPrice(1) == 0) {
                    System.out.println("You cannot build here");
                } else if (RefactorMain.monopoly.checkOwnerForRent(player)) {
                    hotelBUY(player, RefactorMain.monopoly);
                } else {
                    System.out.println("You cannot build hotel here, not your property");
                }

                break;

            case "c":
                System.out.println(
                        "You are in square of color:\t"
                                + RefactorMain.monopoly.getTable().getSquare(position).getColor());
                for (PropertySquare n : RefactorMain.monopoly.getTable().getOtherMonopolySquare(player)) {
                    System.out.println("Name: " + n.getName() + "\t" + " Owner: " 
                    +   RefactorMain.monopoly.getTable().getSquareOwnerToString(n.getPosition()) + "\t"
                            + " Position: " 
                            +   n.getPosition());
                }
                break;

            case "exit":
                System.out.println("EXIT THE GAME");
                System.exit(0);

            default:
                System.out.println("Command not allowed here.\n\n");
                propertysquareplay(player, RefactorMain.monopoly);
        }

    }

    /**
     * A player can buy houses and Hotel if own the propertySquare.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void hotelBUY(Player player, Monopoly monopoly) {

        System.out.println(
                "Price for build an house: "
                        + RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) 
                        +   chf);

        for (int i = 1; i <= 4; i++) {
            System.out.println("PriceTax with " + i + " house increasing to: " 
            +   RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(i) + chf);
        }
        System.out.println("PriceTax with hotel increasing to: " 
        +   RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(5) + chf);
        System.out.println("For building an Hotel you have to buy 4 houses + building price");

        if (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter() < 5) {
            System.out
                    .println("Your house: "
                            + RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter());
        }
        System.out.println("Write:\n");
        System.out.println("[0] For go back");
        System.out.println(
                "[1] For build 1 house at price of " 
                +   (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));
        System.out.println("[2] For build 2 houses at price of " 
        +   (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 2);
        System.out.println("[3] For build 3 houses at price of " 
        +   (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 3);
        System.out.println("[4] For build 4 houses at price of " 
        +   (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 4);

        System.out.println("[5] For build an Hotel at price of " 
        +   ((5 - RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter())) 
        *   (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));

        int word = RefactorMain.input.nextInt();

        if (word > 0 && word < 5) {
            if (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).checkNumHouses(word)) {
                System.out.println("Building" + word + " house at the price of " +
                        ((RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * word) + chf);
                propertySquareBuild(player, RefactorMain.monopoly, word);
            } else {
                System.out.println(
                        "You have already "
                                + RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter() 
                                +   " house");
                System.out.println("Maybe is the time for buying an hotel with 4 house + " 
                +   RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6));
            }
            return;

        } else if (word == 5) {

            int numhouse = RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter();
            System.out.println("You have  " + numhouse + " house");

            if (numhouse < 5) {
                System.out.println("You have to buy " + (4 - numhouse) + " more houses");

                word = 5 - numhouse;

                System.out.println(
                        "Cost: " + (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * word)
                                +
                                chf);

                propertySquareBuild(player, RefactorMain.monopoly, word);

            } else {
                System.out.println("You have to buy 4 more houses + pay the build fee ");
                System.out.println("Cost: " 
                +   (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * 4) + chf 
                        +   " + " + (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) + chf);
                propertySquareBuild(player, RefactorMain.monopoly,
                        (5 - RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter()) 
                        *   (RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));
            }
            return;

        } else if (word == 0) {
            return;
        } else {
            System.out.println("Input not valid");
        }

    }

    /**
     * Build in the property of the player the amount of hotel or houses requested.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     * @param num      the number of houses or hotel to build
     *
     */
    public void propertySquareBuild(Player player, Monopoly monopoly, int num) {

        int position = player.getPosition();

        int price = RefactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * num;

        String word;

        if (player.getMoney() >= price) {

            System.out.println("Do you confirm to buy?");
            System.out.println("Your balance will be: " + (player.getMoney() - price));
            System.out.println("[y] for confirm");
            System.out.println("[n] for go back");

            word = RefactorMain.input.next();

            switch (word) {

                case "y":

                    if (num >= 1 && num <= 4) {
                        System.out.println("Building " + num + " house...");
                        player.decreaseMoney(price);
                        RefactorMain.monopoly.getTable().getHouse(position).buildHouse(num);
                        RefactorMain.monopoly.getTable().getPropertySquare(position)
                                .setPriceTax(RefactorMain.monopoly.getTable().getHouse(position).getPrice(num));
                        // RefactorMain.monopoly.getTable().getPropertySquare(position).increasePriceSell(num);

                    } else {

                        System.out.println("Building your Hotel...");
                        player.decreaseMoney(price);
                        RefactorMain.monopoly.getTable().getHouse(position).buildHouse(num);
                        RefactorMain.monopoly.getTable().getPropertySquare(position)
                                .setPriceTax(RefactorMain.monopoly.getTable().getHouse(position).getPrice(5));
                        // RefactorMain.monopoly.getTable().getPropertySquare(position).increasePriceSell();

                    }

                case "n":
                    hotelBUY(player, RefactorMain.monopoly);

                    break;

                default:
                    System.out.println("Input not valid");
                    break;

            }

        } else {
            System.out.println("You don't have enough money to build");
            System.out.println("Your money: " + player.getMoney());
            System.out.println("You need + " + price + "\n");
        }

    }

    /**
     * When the player has enough money and the square is not own by another
     * player can buy the porpertysquare.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void propertysquarebuy(Player player, Monopoly monopoly) {

        int position = player.getPosition();
        String inp;
        if (player.getMoney() >= RefactorMain.monopoly.getTable().getSquarePrice(position)
                && RefactorMain.monopoly.getTable().getSquareOwner(position) == null)

        {
            System.out.println("Confirm to buy the property?" +
                    RefactorMain.monopoly.getTable().getSquareName(position) 
                    +   "\n Your budget will be " 
                    +   (player.getMoney() - RefactorMain.monopoly.getTable().getSquarePrice(position)));

            System.out.println("Write [y] for the confirm or [n] for return back: ");
            inp = RefactorMain.input.next();

            switch (inp) {
                case "y":
                    RefactorMain.monopoly.setOwner(player);
                    player.buyPropertySquare(RefactorMain.monopoly.getTable().getPropertySquare(position));
                    player.decreaseMoney(RefactorMain.monopoly.getTable().getSquarePrice(position));

                    System.out.println("Square has been bought! \n");
                    String color = RefactorMain.monopoly.getTable().getColor(position);
                    checkmonopolyProperty(player, RefactorMain.monopoly, color);

                case "n":
                    break;

                default:
                    System.out.println("Input not valid");
                    break;
            }

        } else {
            System.out.println("You don't have enough money to buy the property");
            System.out.println("Or the property is not yours");
        }

    }

    /**
     * Check if the propertySquare own by the player
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     * @param color    the color of the square where the player is
     *
     */
    public void checkmonopolyProperty(Player player, Monopoly monopoly, String color) {

        if (RefactorMain.monopoly.getTable().getMonopolyColor(player)) {
            System.out.println("\n \n You did RefactorMain.monopoly for the color " + color 
            +   " now the rent for these property square are doubled \n");
            RefactorMain.monopoly.getTable().getMonopolyColor(player);
        }

    }

    /**
     * Sell the porperty square of the player.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void propertysquaresell(Player player, Monopoly monopoly) {
        RefactorMain.propertysquaresell(player, monopoly);

    }

    /**
     * Let the player roll the dice.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void throwDiceTurn(Player player, Monopoly monopoly) {

        RefactorMain.monopoly.throwDice();
        System.out.println("Your dice made: " + RefactorMain.monopoly.die1() + " and " + RefactorMain.monopoly.die2());
        System.out.println("Go forward by: " + (RefactorMain.monopoly.die1() + RefactorMain.monopoly.die2()));

        RefactorMain.monopoly.setPositionPlayer(RefactorMain.monopoly.getPLayer(turn));
        System.out.println("You are in the square: " +
                RefactorMain.monopoly.getTable().getSquareName(RefactorMain.monopoly.getPLayer(turn).getPosition()));

    }

    /**
     * Start the turn.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     */
    public void startTurn(Player player, Monopoly monopoly) {

        if (RefactorMain.monopoly.checkOwnerForRent(player)) {
            payrent(player, RefactorMain.monopoly);
        }

    }

    /**
     * Payrent of the player.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     */
    public void payrent(Player player, Monopoly monopoly) {
        System.out.println(
                "Oh no, this property is owned by: " 
                +   RefactorMain.monopoly.getTable().getSquareOwnerToString(player.getPosition()));
        System.out.println(
                "You have to pay: " + RefactorMain.monopoly.getTable().getSquarePriceTax(player.getPosition()));
        RefactorMain.monopoly.getTable().getPropertySquare(player.getPosition()).payrent();
        player.decreaseMoney(RefactorMain.monopoly.getTable().getPropertySquare(player.getPosition()).getPriceTax());
    }

    /**
     * gameStatusPlay the main method of the class.
     */
    public void gameStatusPlay() {

        while (RefactorMain.monopoly.monopolyEND()) {

            turn = turn % RefactorMain.monopoly.getSizeOfPlayers();

            System.out.println(RefactorMain.monopoly.getPLayer(turn).getNickname() + " e' il tuo turno! \n");

            if (RefactorMain.monopoly.getPLayer(turn).getTurnsInJail() == -1) {

                throwDiceTurn(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);
                startTurn(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);

            }

            while (RefactorMain.skip == 0) {

                switch (RefactorMain.monopoly.getTable().getSquare(RefactorMain.monopoly.getPLayer(turn).getPosition())
                        .getColor()) {

                    case "cards":
                        cardsPlaymain(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);
                        break;

                    case "jail":
                        jailPlaymain(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);
                        break;

                    case "empty":
                        emptyPlaymain(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);
                        break;

                    case "goto":
                        gotoPLAYmain(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);
                        break;

                    case "bonus":
                        bonusPlaymain(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);
                        break;

                    case "malus":
                        bonusPlaymain(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);
                        break;

                    default:
                        propertysquareplay(RefactorMain.monopoly.getPLayer(turn), RefactorMain.monopoly);
                        break;

                }

            }
            RefactorMain.skip = 0;

            turn += 1;

        }
    }

    /**
     * Gamestaus for the player that play in the game.
     */
    public void gameStatus() {

        System.out.println("The game start!!!");
        System.out.println(
                "Every player start with 1500 chf \n  If you go bankrupt you lose \n Win the last player with money");

        gameStatusPlay();

    }

    /**
     * Finish the state of player.
     */
    public void finishStatus() {
        System.out.println("The monopoly of Lugano is " + RefactorMain.monopoly.getPLayer(0).getNickname());
        System.exit(0);

    }

    /**
     * Get the status.
     * 
     * @return the status
     */
    public int getStatus() {
        return RefactorMain.status;
    }

    /**
     * Run the game.
     * 
     * @param args the command line arguments
     */
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

            default:
                System.out.println("Error status");
                break;

        }

    }

}