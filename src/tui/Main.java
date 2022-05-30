package tui;
import model.JailSquare;
import model.Monopoly;
import model.Player;
import model.PropertySquare;

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

    /**
     * private auxmain.monopoly auxmain.monopoly = new auxmain.monopoly();
     * private Scanner input = new Scanner(System.in);
     * 
     * private int numberOfPlayers = 0;
     * private int status = 0;
     * private String chf = " chf";
     * private String nName = "\nName: ";
     * private int skip = 0;
     * private int turn = 0;
     */
    private String chf = " chf";
    private String nName = "\nName: ";
    private int turn = 0;

    public Main() {
        auxmain = new auxmain();
    }

    public auxmain auxmain;

    /**
     * preGameStatus is the method that manage the pregame of auxmain.monopoly.
     * Here will be asked to insert the numberOfPlayers and then
     * creating the instance for each player.
     * 
     */
    public void preGameStatus() {
        auxmain.preGameStatus();
    }

    /**
     * When a player is eliminated will be removed from the auxmain.monopoly.
     * And the turn will skip.
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void elimininationPLAYmain(Player player, Monopoly monopoly) {
        auxmain.elimininationPLAYmain(player, monopoly);
    }

    /**
     * Check if the player is under 0 chf of balance, if true then let the player to
     * sell the properties
     * to cover the debit. If not enough money then will be eliminated.
     * Else will brake.
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void bankRuptPLAYmain(Player player, Monopoly monopoly) {
        auxmain.bankRuptPLAYmain(player, monopoly);
    }

    /**
     * When a player is in the square bonus where picking a card then will activate
     * cardsPLAYmain
     * to let the player take the card and active its effect.
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void cardsPLAYmain(Player player, Monopoly monopoly) {
        auxmain.cardsPLAYmain(player, monopoly);
    }

    /**
     * When a player reach the square gotoPLAYmain will be obbliged to change
     * position
     * and will be moved to the position 30 where is the jail.
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void gotoPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("Go to the jail! \n");

        player.movePosition(30);
        player.setJail(JailSquare.getDays());
        jailPLAYmain(player, auxmain.monopoly);

    }

    /**
     * When a player reach a bonusSquare then will activate the effect of the square
     * if the player go under 0 chf then bankrupt will be activated.
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void bonusPLAYmain(Player player, Monopoly monopoly) {
        auxmain.bonusPLAYmain(player, monopoly);

    }

    /**
     * When a player reach the jail Square will be in prison and he can escape only
     * if:
     * - pay 55 chf
     * - using the card "free from jail" (if possesed)
     * - trying to do a perfect pair
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void jailPLAYmain(Player player, Monopoly monopoly) {

        if (player.getTurnsInJail() == -1) {
            player.setJail(JailSquare.getDays());

        }

        System.out.println("You are in jail");
        System.out.println("You can escape doing:");
        System.out.println("- [pay] Paying 55 chf now");
        System.out.println("- [c] Using the free from jail card");
        System.out.println("- [t] Trying to do perfect pair ");
        System.out.println("\nAfter 3 turns you must pay the fine");

        String word = auxmain.input.next();

        System.out.println(auxmain.monopoly.getPLayer(turn).getMoney());

        if (player.getTurnsInJail() > 0) {

            switch (word) {
                case "pay":
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    auxmain.monopoly.throwDice();
                    System.out
                            .println("Your dice made: " + auxmain.monopoly.die1() + " and " + auxmain.monopoly.die2());
                    System.out.println("Go forward by: " + (auxmain.monopoly.die1() + auxmain.monopoly.die2()));

                    if (auxmain.monopoly.checkbankruptStatus(player)) {
                        System.out.println("\n You do not have enough money to pay the fi");
                        bankRuptPLAYmain(player, auxmain.monopoly);
                        auxmain.skip = 1;
                        return;
                    }

                    auxmain.monopoly.setPositionPlayer(player);
                    System.out.println("You are in the square: "
                            + auxmain.monopoly.getTable()
                                    .getSquareName(auxmain.monopoly.getPLayer(turn).getPosition()));

                    startTurn(player, auxmain.monopoly);

                    break;

                case "c":
                    if (JailSquare.checkFreeJailCard(player)) {
                        JailSquare.freeFromJail(player);

                        System.out.println("You used the card, you can throw the dice\n ");
                        auxmain.monopoly.setPositionPlayer(auxmain.monopoly.getPLayer(turn));
                        System.out.println("You are in the square: "
                                + auxmain.monopoly.getTable()
                                        .getSquareName(auxmain.monopoly.getPLayer(turn).getPosition()));

                        startTurn(player, auxmain.monopoly);

                        auxmain.skip = 1;
                        break;

                    } else {
                        System.out.println("\n You don't have the card!\n");
                        break;
                    }
                case "t":

                    auxmain.monopoly.throwDice();
                    System.out
                            .println("Your dice made: " + auxmain.monopoly.die1() + " and " + auxmain.monopoly.die2());
                    if (auxmain.monopoly.getDice().isPerfectPair()) {
                        JailSquare.freeFromJail(player);
                        System.out.println(
                                "You did perfect pair, you gonna forward for " + (auxmain.monopoly.die1() * 2));

                        // auxmain.monopoly.setPositionPlayer(auxmain.monopoly.getPLayer(turn));
                        // System.out.println("You are in the square: "
                        // +
                        // auxmain.monopoly.getTable().getSquareName(auxmain.monopoly.getPLayer(turn).getPosition()));

                        // startTurn(player, auxmain.monopoly);
                        gameStatusPLAY();

                        break;

                    }
                    JailSquare.decreseDayInJail(player);
                    System.out.println("You did not do perfect pair, see you next turn!");
                    System.out.println(player.getTurnsInJail() + " turns in jail left");

                    auxmain.skip = 1;
                    break;

                default:
                    System.out.println("Command not allowed here.\n");
                    jailPLAYmain(player, auxmain.monopoly);

            }
        }

        else if (player.getTurnsInJail() == 0) {
            System.out.println("You have to pay the fine");
            System.out.println("[p] (for pay the fine)");
            word = auxmain.input.next();

            switch (word) {
                case "pay":
                    JailSquare.payFine(player);
                    JailSquare.freeFromJail(player);

                    System.out.println("You paid 50 chf, you can throw the dice");

                    if (auxmain.monopoly.checkbankruptStatus(player)) {
                        bankRuptPLAYmain(player, auxmain.monopoly);
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
     * When a player reach the emptySquaer will not do nothing and will not be
     * allowed to do
     * some actions.
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void emptyPLAYmain(Player player, Monopoly monopoly) {
        System.out.println("This is an empty square \n You cannot do nothing here");
        System.out.println("[p] (to finish the turn) ");
        System.out.println("[m] (to show your balance)");
        System.out.println("[i] (for all info of the player)");

        String word = auxmain.input.next();

        switch (word) {

            case "m":
                System.out.println("Your bank have: " + player.getMoney());
                break;

            case "i":
                System.out.println(nName + player.getNickname() + "\nMoney: " + player.getMoney()
                        + "\nProperties: " + player.getPropertySquare() + "\nPosition: " + player.getPosition());

                break;

            case "p":
                auxmain.skip = 1;
                break;

            default:
                System.out.println("Command not allowed here");
                emptyPLAYmain(player, auxmain.monopoly);

        }

    }

    /**
     * When a player reach a propertySQuare could have some comands:
     * - [b] (for buying the property)
     * - [s] (to sell this property)
     * - [m] (to show your balance)
     * - [p] (to finish the turn)
     * - [i] (for all info of the player)
     * - [c] (for show the situation of the other properties of same color)
     * - [h] (for buy house, hotel and more info)
     * - [o] (for see the infos for other players)
     * - [exit] (for close the game)
     * 
     * if the square is owned by another player, then the player will have to pay
     * the rent.
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void propertysquareplay(Player player, Monopoly monopoly) {
        int position = auxmain.monopoly.getPLayer(turn).getPosition();

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

        String word = auxmain.input.next();

        switch (word) {
            case "d":
                System.out.println(nName + auxmain.monopoly.getTable().getSquare(position).getName() + "\nColor: "
                        + auxmain.monopoly.getTable().getSquare(position).getColor());
                System.out
                        .println("Owner: " + auxmain.monopoly.getTable().getSquareOwnerToString(position) + "\nPrice: "
                                + auxmain.monopoly.getTable().getSquarePrice(position));
                System.out.println("Price tax: " + auxmain.monopoly.getTable().getSquarePriceTax(position));
                if (auxmain.monopoly.getTable().getHouse(position).getCounter() <= 4) {
                    System.out.println("House: " + auxmain.monopoly.getTable().getHouse(position).getCounter());
                } else {
                    System.out.println("Hotel: 1");
                }
                break;

            case "b":
                propertysquarebuy(player, auxmain.monopoly);
                break;

            case "s":

                if (player.getPropertySquare().size() < 1) {
                    System.out.println("You do not have properties to sell!");
                    break;
                }

                else {

                    System.out.println("Sell properties status: \n");
                    propertysquaresell(player, auxmain.monopoly);
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
                for (Player pl : auxmain.monopoly.getListOfPlayer()) {
                    System.out.println(nName + pl.getNickname() + "\nMoney: " + pl.getMoney()
                            + "\nProperties: " + pl.propertySquaretoString() + "\nPosition: " + pl.getPosition());

                }
                break;
            case "p":
                auxmain.skip = 1;
                break;

            case "h":

                if (auxmain.monopoly.getTable().getHouse(position).getCounter() == 5) {
                    System.out.println("You already bought the hotel here!");
                } else if (auxmain.monopoly.getTable().getPropertySquare(position).getHouse().getPrice(1) == 0) {
                    System.out.println("You cannot build here");
                } else if (auxmain.monopoly.checkOwnerForRent(player)) {
                    hotelBUY(player, auxmain.monopoly);
                } else {
                    System.out.println("You cannot build hotel here, not your property");
                }

                break;

            case "c":
                System.out.println(
                        "You are in square of color:\t" + auxmain.monopoly.getTable().getSquare(position).getColor());
                for (PropertySquare n : auxmain.monopoly.getTable().getOtherMonopolySquare(player)) {
                    System.out.println("Name: " + n.getName() + "\t" + " Owner: "
                            + auxmain.monopoly.getTable().getSquareOwnerToString(n.getPosition()) + "\t" + " Position: "
                            + n.getPosition());
                }
                break;

            case "exit":
                System.out.println("EXIT THE GAME");
                System.exit(0);

            default:
                System.out.println("Command not allowed here.\n\n");
                propertysquareplay(player, auxmain.monopoly);
        }

    }

    /**
     * A player can buy houses and Hotel if own the propertySquare.
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void hotelBUY(Player player, Monopoly monopoly) {

        System.out.println(
                "Price for build an house: " + auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)
                        + chf);

        for (int i = 1; i <= 4; i++) {
            System.out.println("PriceTax with " + i + " house increasing to: "
                    + auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(i) + chf);
        }
        System.out.println("PriceTax with hotel increasing to: "
                + auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(5) + chf);
        System.out.println("For building an Hotel you have to buy 4 houses + building price");

        if (auxmain.monopoly.getTable().getHouse(player.getPosition()).getCounter() < 5) {
            System.out
                    .println("Your house: " + auxmain.monopoly.getTable().getHouse(player.getPosition()).getCounter());
        }
        System.out.println("Write:\n");
        System.out.println("[0] For go back");
        System.out.println(
                "[1] For build 1 house at price of "
                        + (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));
        System.out.println("[2] For build 2 houses at price of "
                + (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 2);
        System.out.println("[3] For build 3 houses at price of "
                + (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 3);
        System.out.println("[4] For build 4 houses at price of "
                + (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * 4);

        System.out.println("[5] For build an Hotel at price of "
                + ((5 - auxmain.monopoly.getTable().getHouse(player.getPosition()).getCounter()))
                        * (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));

        int word = auxmain.input.nextInt();

        if (word > 0 && word < 5) {
            if (auxmain.monopoly.getTable().getHouse(player.getPosition()).checkNumHouses(word)) {
                System.out.println("Building" + word + " house at the price of "
                        + ((auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) * word) + chf);
                propertySquareBUILD(player, auxmain.monopoly, word);
            } else {
                System.out.println(
                        "You have already " + auxmain.monopoly.getTable().getHouse(player.getPosition()).getCounter()
                                + " house");
                System.out.println("Maybe is the time for buying an hotel with 4 house + "
                        + auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6));
            }
            return;

        } else if (word == 5) {

            int numhouse = auxmain.monopoly.getTable().getHouse(player.getPosition()).getCounter();
            System.out.println("You have  " + numhouse + " house");

            if (numhouse < 5) {
                System.out.println("You have to buy " + (4 - numhouse) + " more houses");

                word = 5 - numhouse;

                System.out.println(
                        "Cost: " + (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * word)
                                + chf);

                propertySquareBUILD(player, auxmain.monopoly, word);

            } else {
                System.out.println("You have to buy 4 more houses + pay the build fee ");
                System.out.println("Cost: "
                        + (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * 4) + chf
                        + " + " + (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)) + chf);
                propertySquareBUILD(player, auxmain.monopoly,
                        (5 - auxmain.monopoly.getTable().getHouse(player.getPosition()).getCounter())
                                * (auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6)));
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
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void propertySquareBUILD(Player player, Monopoly monopoly, int num) {

        int position = player.getPosition();

        int price = auxmain.monopoly.getTable().getHouse(player.getPosition()).getPrice(6) * num;

        String word;

        if (player.getMoney() >= price) {

            System.out.println("Do you confirm to buy?");
            System.out.println("Your balance will be: " + (player.getMoney() - price));
            System.out.println("[y] for confirm");
            System.out.println("[n] for go back");

            word = auxmain.input.next();

            switch (word) {

                case "y":

                    if (num >= 1 && num <= 4) {
                        System.out.println("Building " + num + " house...");
                        player.decreaseMoney(price);
                        auxmain.monopoly.getTable().getHouse(position).buildHouse(num);
                        auxmain.monopoly.getTable().getPropertySquare(position)
                                .setPriceTax(auxmain.monopoly.getTable().getHouse(position).getPrice(num));
                        // auxmain.monopoly.getTable().getPropertySquare(position).increasePriceSell(num);

                    } else {

                        System.out.println("Building your Hotel...");
                        player.decreaseMoney(price);
                        auxmain.monopoly.getTable().getHouse(position).buildHouse(num);
                        auxmain.monopoly.getTable().getPropertySquare(position)
                                .setPriceTax(auxmain.monopoly.getTable().getHouse(position).getPrice(5));
                        // auxmain.monopoly.getTable().getPropertySquare(position).increasePriceSell();

                    }

                case "n":
                    hotelBUY(player, auxmain.monopoly);

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
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     *
     */
    public void propertysquarebuy(Player player, Monopoly monopoly) {

        int position = player.getPosition();
        String inp;
        if (player.getMoney() >= auxmain.monopoly.getTable().getSquarePrice(position) &&
                auxmain.monopoly.getTable().getSquareOwner(position) == null)

        {
            System.out.println("Confirm to buy the property?"
                    + auxmain.monopoly.getTable().getSquareName(position)
                    + "\n Your budget will be "
                    + (player.getMoney() - auxmain.monopoly.getTable().getSquarePrice(position)));

            System.out.println("Write [y] for the confirm or [n] for return back: ");
            inp = auxmain.input.next();

            switch (inp) {
                case "y":
                    auxmain.monopoly.setOwner(player);
                    player.buyPropertySquare(auxmain.monopoly.getTable().getPropertySquare(position));
                    player.decreaseMoney(auxmain.monopoly.getTable().getSquarePrice(position));

                    System.out.println("Square has been bought! \n");
                    String color = auxmain.monopoly.getTable().getColor(position);
                    checkmonopolyProperty(player, auxmain.monopoly, color);

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
     * Check if the propertySquare own by the player
     * 
     * @param player           that play in that turn
     * @param auxmain.monopoly the main class where the game is strutured
     * @param color            the color of the square where the player is
     *
     */
    public void checkmonopolyProperty(Player player, Monopoly monopoly, String color) {

        if (auxmain.monopoly.getTable().getMonopolyColor(player)) {
            System.out.println("\n \n You did auxmain.monopoly for the color " + color
                    + " now the rent for these property square are doubled \n");
            auxmain.monopoly.getTable().getMonopolyColor(player);
        }

    }

    public void propertysquaresell(Player player, Monopoly monopoly) {
        auxmain.propertysquaresell(player, monopoly);

    }

    public void throwDiceTurn(Player player, Monopoly monopoly) {

        auxmain.monopoly.throwDice();
        System.out.println("Your dice made: " + auxmain.monopoly.die1() + " and " + auxmain.monopoly.die2());
        System.out.println("Go forward by: " + (auxmain.monopoly.die1() + auxmain.monopoly.die2()));

        auxmain.monopoly.setPositionPlayer(auxmain.monopoly.getPLayer(turn));
        System.out.println("You are in the square: "
                + auxmain.monopoly.getTable().getSquareName(auxmain.monopoly.getPLayer(turn).getPosition()));

    }

    public void startTurn(Player player, Monopoly monopoly) {

        if (auxmain.monopoly.checkOwnerForRent(player)) {
            payrent(player, auxmain.monopoly);
        }

    }

    public void payrent(Player player, Monopoly monopoly) {
        System.out.println(
                "Oh no, this property is owned by: "
                        + auxmain.monopoly.getTable().getSquareOwnerToString(player.getPosition()));
        System.out.println("You have to pay: " + auxmain.monopoly.getTable().getSquarePriceTax(player.getPosition()));
        auxmain.monopoly.getTable().getPropertySquare(player.getPosition()).payrent();
        player.decreaseMoney(auxmain.monopoly.getTable().getPropertySquare(player.getPosition()).getPriceTax());
    }

    public void gameStatusPLAY() {

        while (auxmain.monopoly.monopolyEND()) {

            turn = turn % auxmain.monopoly.getSizeOfPlayers();

            System.out.println(auxmain.monopoly.getPLayer(turn).getNickname() + " e' il tuo turno! \n");

            if (auxmain.monopoly.getPLayer(turn).getTurnsInJail() == -1) {

                throwDiceTurn(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);
                startTurn(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);

            }

            while (auxmain.skip == 0) {

                switch (auxmain.monopoly.getTable().getSquare(auxmain.monopoly.getPLayer(turn).getPosition())
                        .getColor()) {

                    case "cards":
                        cardsPLAYmain(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);
                        break;

                    case "jail":
                        jailPLAYmain(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);
                        break;

                    case "empty":
                        emptyPLAYmain(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);
                        break;

                    case "goto":
                        gotoPLAYmain(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);
                        break;

                    case "bonus":
                        bonusPLAYmain(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);
                        break;

                    case "malus":
                        bonusPLAYmain(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);
                        break;

                    default:
                        propertysquareplay(auxmain.monopoly.getPLayer(turn), auxmain.monopoly);
                        break;

                }

            }
            auxmain.skip = 0;

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
        System.out.println("The auxmain.monopoly of Lugano is " + auxmain.monopoly.getPLayer(0).getNickname());
        System.exit(0);

    }

    public int getStatus() {
        return auxmain.status;
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
