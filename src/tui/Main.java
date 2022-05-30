package tui;

import model.JailSquare;
import model.Monopoly;
import model.Player;
import model.PropertySquare;


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
    private String nameTap = "\nameTap: ";
    private int turn = 0;

    /**
     * This is the main of the TUI.
     * 
     */
    public Main() {
        refactorMain = new RefactorMain();
    }

    public RefactorMain refactorMain;

    /**
     * preGameStatus is the method that manage the pregame of RefactorMain.monopoly.
     * Here will be asked to insert the numberOfPlayers and then
     * creating the instance for each player.
     * 
     */
    public void preGameStatus() {
        refactorMain.preGameStatus();
    }

    /**
     * When a player is eliminated will be removed from the refactorMain.monopoly.
     * And the turn will skip.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void elimininationPlaymain(Player player, Monopoly monopoly) {
        refactorMain.elimininationPlaymain(player, monopoly);
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
        refactorMain.bankRuptPlaymain(player, monopoly);
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
        refactorMain.cardsPlaymain(player, monopoly);
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
        jailPlaymain(player, refactorMain.monopoly);

    }

    /**
     * When a player reach a bonusSquare then will activate the effect of the square.
     * if the player go under 0 chf then bankrupt will be activated.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void bonusPlaymain(Player player, Monopoly monopoly) {
        refactorMain.bonusPlaymain(player, monopoly);

    }

    /**
     * When a player reach the jail Square will be in prison and he can escape only.
     * if.
     * - pay 55 chf
     * - using the card "free from jail" (if possesed).
     * - trying to do a perfect pair.
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

        String word = refactorMain.input.next();

        System.out.println(refactorMain.monopoly.getPLayer(turn).getMoney());

        if (player.getTurnsInJail() > 0) {

            switch (word) {
                case "pay":
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    refactorMain.monopoly.throwDice();
                    System.out
                            .println("Your dice made: " + refactorMain.monopoly.die1() + " and "
                                    + refactorMain.monopoly.die2());
                    System.out
                            .println("Go forward by: " + (refactorMain.monopoly.die1() + refactorMain.monopoly.die2()));

                    if (refactorMain.monopoly.checkbankruptStatus(player)) {
                        System.out.println("\n You do not have enough money to pay the fi");
                        bankRuptPlaymain(player, refactorMain.monopoly);
                        refactorMain.skip = 1;
                        return;
                    }

                    refactorMain.monopoly.setPositionPlayer(player);
                    System.out.println("You are in the square: " 
                    +   refactorMain.monopoly.getTable()
                                    .getSquareName(refactorMain.monopoly.getPLayer(turn).getPosition()));

                    startTurn(player, refactorMain.monopoly);

                    break;

                case "c":
                    if (JailSquare.checkFreeJailCard(player)) {
                        JailSquare.freeFromJail(player);

                        System.out.println("You used the card, you can throw the dice\n ");
                        refactorMain.monopoly.setPositionPlayer(refactorMain.monopoly.getPLayer(turn));
                        System.out.println("You are in the square: " 
                        +   refactorMain.monopoly.getTable()
                                        .getSquareName(refactorMain.monopoly.getPLayer(turn).getPosition()));

                        startTurn(player, refactorMain.monopoly);

                        refactorMain.skip = 1;
                        break;

                    } else {
                        System.out.println("\n You don't have the card!\n");
                        break;
                    }
                case "t":

                    refactorMain.monopoly.throwDice();
                    System.out
                            .println("Your dice made: " + refactorMain.monopoly.die1() + " and "
                                    + refactorMain.monopoly.die2());
                    if (refactorMain.monopoly.getDice().isPerfectPair()) {
                        JailSquare.freeFromJail(player);
                        System.out.println(
                                "You did perfect pair, you gonna forward for " + (refactorMain.monopoly.die1() * 2));

                        // refactorMain.monopoly.setPositionPlayer(refactorMain.monopoly.getPLayer(turn));
                        // System.out.println("You are in the square: "
                        // +
                        // refactorMain.monopoly.getTable().getSquareName(refactorMain.monopoly.getPLayer(turn).getPosition()));

                        // startTurn(player, refactorMain.monopoly);
                        gameStatusPlay();

                        break;

                    }
                    JailSquare.decreseDayInJail(player);
                    System.out.println("You did not do perfect pair, see you next turn!");
                    System.out.println(player.getTurnsInJail() + " turns in jail left");

                    refactorMain.skip = 1;
                    break;

                default:
                    System.out.println("Command not allowed here.\n");
                    jailPlaymain(player, refactorMain.monopoly);

            }
        } else if (player.getTurnsInJail() == 0) {
            System.out.println("You have to pay the fine");
            System.out.println("[p] (for pay the fine)");
            word = refactorMain.input.next();

            switch (word) {
                case "pay":
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    if (refactorMain.monopoly.checkbankruptStatus(player)) {
                        bankRuptPlaymain(player, refactorMain.monopoly);
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

        String word = refactorMain.input.next();

        switch (word) {

            case "m":
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "i":
                System.out.println(nameTap + player.getNickname() + "\nMoney: " + player.getMoney()
                        + "\nProperties: " + player.getPropertySquare() + "\nPosition: " + player.getPosition());

                break;

            case "p":
                refactorMain.skip = 1;
                break;

            default:
                System.out.println("Command not allowed here");
                emptyPlaymain(player, refactorMain.monopoly);

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
        int position = refactorMain.monopoly.getPLayer(turn).getPosition();

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

        String word = refactorMain.input.next();

        switch (word) {
            case "d":
                System.out
                        .println(nameTap + refactorMain.monopoly.getTable().getSquare(position).getName() + "\nColor: "
                                + refactorMain.monopoly.getTable().getSquare(position).getColor());
                System.out
                        .println("Owner: " + refactorMain.monopoly.getTable().getSquareOwnerToString(position)
                                + "\nPrice: "
                                + refactorMain.monopoly.getTable().getSquarePrice(position));
                System.out.println("Price tax: " + refactorMain.monopoly.getTable().getSquarePriceTax(position));
                if (refactorMain.monopoly.getTable().getHouse(position).getCounter() <= 4) {
                    System.out.println("House: " + refactorMain.monopoly.getTable().getHouse(position).getCounter());
                } else {
                    System.out.println("Hotel: 1");
                }
                break;

            case "b":
                propertysquarebuy(player, refactorMain.monopoly);
                break;

            case "s":

                if (player.getPropertySquare().size() < 1) {
                    System.out.println("You do not have properties to sell!");
                    break;
                } else {

                    System.out.println("Sell properties status: \n");
                    propertysquaresell(player, refactorMain.monopoly);
                    break;
                }

            case "m":
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "i":
                System.out.println(nameTap + player.getNickname() + "\nMoney: " + player.getMoney()
                        + "\nProperties: " + player.propertySquaretoString() + "\nPosition: " + player.getPosition());
                break;

            case "o":
                for (Player pl : refactorMain.monopoly.getListOfPlayer()) {
                    System.out.println(nameTap + pl.getNickname() + "\nMoney: " + pl.getMoney()
                            + "\nProperties: " + pl.propertySquaretoString() + "\nPosition: " + pl.getPosition());

                }
                break;
            case "p":
                refactorMain.skip = 1;
                break;

            case "h":

                if (refactorMain.monopoly.getTable().getHouse(position).getCounter() == 5) {
                    System.out.println("You already bought the hotel here!");
                } else if (refactorMain.monopoly.getTable().getPropertySquare(position).getHouse().getPrice(1) == 0) {
                    System.out.println("You cannot build here");
                } else if (refactorMain.monopoly.checkOwnerForRent(player)) {
                    hotelBUY(player, refactorMain.monopoly);
                } else {
                    System.out.println("You cannot build hotel here, not your property");
                }

                break;

            case "c":
                System.out.println(
                        "You are in square of color:\t"
                                + refactorMain.monopoly.getTable().getSquare(position).getColor());
                for (PropertySquare n : refactorMain.monopoly.getTable().getOtherMonopolySquare(player)) {
                    System.out.println("Name: " + n.getName() + "\t" + " Owner: "
                            + refactorMain.monopoly.getTable().getSquareOwnerToString(n.getPosition()) + "\t"
                            + " Position: "
                            + n.getPosition());
                }
                break;

            case "exit":
                System.out.println("EXIT THE GAME");
                System.exit(0);

            default:
                System.out.println("Command not allowed here.\n\n");
                propertysquareplay(player, refactorMain.monopoly);
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
                        + refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)
                        + chf);

        for (int i = 1; i <= 4; i++) {
            System.out.println("PriceTax with " + i + " house increasing to: "
                    + refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(i) + chf);
        }
        System.out.println("PriceTax with hotel increasing to: "
                + refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(5) + chf);
        System.out.println("For building an Hotel you have to buy 4 houses + building price");

        if (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter() < 5) {
            System.out
                    .println("Your house: "
                            + refactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter());
        }
        System.out.println("Write:\n");
        System.out.println("[0] For go back");
        System.out.println(
                "[1] For build 1 house at price of "
                        + (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));
        System.out.println("[2] For build 2 houses at price of "
                + (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 2);
        System.out.println("[3] For build 3 houses at price of "
                + (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 3);
        System.out.println("[4] For build 4 houses at price of "
                + (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 4);

        System.out.println("[5] For build an Hotel at price of "
                + ((5 - refactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter()))
                        * (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));

        int word = refactorMain.input.nextInt();

        if (word > 0 && word < 5) {
            if (refactorMain.monopoly.getTable().getHouse(player.getPosition()).checkNumHouses(word)) {
                System.out.println("Building" + word + " house at the price of " 
                +   ((refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * word) + chf);
                propertySquareBuild(player, refactorMain.monopoly, word);
            } else {
                System.out.println(
                        "You have already "
                                + refactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter()
                                + " house");
                System.out.println("Maybe is the time for buying an hotel with 4 house + "
                        + refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6));
            }
            return;

        } else if (word == 5) {

            int numhouse = refactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter();
            System.out.println("You have  " + numhouse + " house");

            if (numhouse < 5) {
                System.out.println("You have to buy " + (4 - numhouse) + " more houses");

                word = 5 - numhouse;

                System.out.println(
                        "Cost: " + (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * word)
                                +
                                chf);

                propertySquareBuild(player, refactorMain.monopoly, word);

            } else {
                System.out.println("You have to buy 4 more houses + pay the build fee ");
                System.out.println("Cost: "
                        + (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * 4) + chf
                        + " + " + (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) + chf);
                propertySquareBuild(player, refactorMain.monopoly,
                        (5 - refactorMain.monopoly.getTable().getHouse(player.getPosition()).getCounter())
                                * (refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));
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

        int price = refactorMain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * num;

        String word;

        if (player.getMoney() >= price) {

            System.out.println("Do you confirm to buy?");
            System.out.println("Your balance will be: " + (player.getMoney() - price));
            System.out.println("[y] for confirm");
            System.out.println("[n] for go back");

            word = refactorMain.input.next();

            switch (word) {

                case "y":

                    if (num >= 1 && num <= 4) {
                        System.out.println("Building " + num + " house...");
                        player.decreaseMoney(price);
                        refactorMain.monopoly.getTable().getHouse(position).buildHouse(num);
                        refactorMain.monopoly.getTable().getPropertySquare(position)
                                .setPriceTax(refactorMain.monopoly.getTable().getHouse(position).getPrice(num));
                        // refactorMain.monopoly.getTable().getPropertySquare(position).increasePriceSell(num);

                    } else {

                        System.out.println("Building your Hotel...");
                        player.decreaseMoney(price);
                        refactorMain.monopoly.getTable().getHouse(position).buildHouse(num);
                        refactorMain.monopoly.getTable().getPropertySquare(position)
                                .setPriceTax(refactorMain.monopoly.getTable().getHouse(position).getPrice(5));
                        // refactorMain.monopoly.getTable().getPropertySquare(position).increasePriceSell();

                    }

                case "n":
                    hotelBUY(player, refactorMain.monopoly);

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
        if (player.getMoney() >= refactorMain.monopoly.getTable().getSquarePrice(position)
                && refactorMain.monopoly.getTable().getSquareOwner(position) == null)

        {
            System.out.println("Confirm to buy the property?" +
                    refactorMain.monopoly.getTable().getSquareName(position)
                    + "\n Your budget will be "
                    + (player.getMoney() - refactorMain.monopoly.getTable().getSquarePrice(position)));

            System.out.println("Write [y] for the confirm or [n] for return back: ");
            inp = refactorMain.input.next();

            switch (inp) {
                case "y":
                    refactorMain.monopoly.setOwner(player);
                    player.buyPropertySquare(refactorMain.monopoly.getTable().getPropertySquare(position));
                    player.decreaseMoney(refactorMain.monopoly.getTable().getSquarePrice(position));

                    System.out.println("Square has been bought! \n");
                    String color = refactorMain.monopoly.getTable().getColor(position);
                    checkmonopolyProperty(player, refactorMain.monopoly, color);

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

        if (refactorMain.monopoly.getTable().getMonopolyColor(player)) {
            System.out.println("\n \n You did refactorMain.monopoly for the color " + color
                    + " now the rent for these property square are doubled \n");
            refactorMain.monopoly.getTable().getMonopolyColor(player);
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
        refactorMain.propertysquaresell(player, monopoly);

    }

    /**
     * Let the player roll the dice.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     *
     */
    public void throwDiceTurn(Player player, Monopoly monopoly) {

        refactorMain.monopoly.throwDice();
        System.out.println("Your dice made: " + refactorMain.monopoly.die1() + " and " + refactorMain.monopoly.die2());
        System.out.println("Go forward by: " + (refactorMain.monopoly.die1() + refactorMain.monopoly.die2()));

        refactorMain.monopoly.setPositionPlayer(refactorMain.monopoly.getPLayer(turn));
        System.out.println("You are in the square: " 
        +   refactorMain.monopoly.getTable().getSquareName(refactorMain.monopoly.getPLayer(turn).getPosition()));

    }

    /**
     * Start the turn.
     * 
     * @param player   that play in that turn
     * @param monopoly the main class where the game is strutured
     */
    public void startTurn(Player player, Monopoly monopoly) {

        if (refactorMain.monopoly.checkOwnerForRent(player)) {
            payrent(player, refactorMain.monopoly);
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
                        + refactorMain.monopoly.getTable().getSquareOwnerToString(player.getPosition()));
        System.out.println(
                "You have to pay: " + refactorMain.monopoly.getTable().getSquarePriceTax(player.getPosition()));
        refactorMain.monopoly.getTable().getPropertySquare(player.getPosition()).payrent();
        player.decreaseMoney(refactorMain.monopoly.getTable().getPropertySquare(player.getPosition()).getPriceTax());
    }

    /**
     * gameStatusPlay the main method of the class.
     */
    public void gameStatusPlay() {

        while (refactorMain.monopoly.monopolyEND()) {

            turn = turn % refactorMain.monopoly.getSizeOfPlayers();

            System.out.println(refactorMain.monopoly.getPLayer(turn).getNickname() + " e' il tuo turno! \n");

            if (refactorMain.monopoly.getPLayer(turn).getTurnsInJail() == -1) {

                throwDiceTurn(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);
                startTurn(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);

            }

            while (refactorMain.skip == 0) {

                switch (refactorMain.monopoly.getTable().getSquare(refactorMain.monopoly.getPLayer(turn).getPosition())
                        .getColor()) {

                    case "cards":
                        cardsPlaymain(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);
                        break;

                    case "jail":
                        jailPlaymain(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);
                        break;

                    case "empty":
                        emptyPlaymain(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);
                        break;

                    case "goto":
                        gotoPLAYmain(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);
                        break;

                    case "bonus":
                        bonusPlaymain(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);
                        break;

                    case "malus":
                        bonusPlaymain(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);
                        break;

                    default:
                        propertysquareplay(refactorMain.monopoly.getPLayer(turn), refactorMain.monopoly);
                        break;

                }

            }
            refactorMain.skip = 0;

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
        System.out.println("The monopoly of Lugano is " + refactorMain.monopoly.getPLayer(0).getNickname());
        System.exit(0);

    }

    /**
     * Get the status.
     * 
     * @return the status
     */
    public int getStatus() {
        return refactorMain.status;
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

        }

    }

}