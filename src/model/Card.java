package model;

/**
 * This class rapresent the card contained in the deck.
 * In this class the methods rapresents an effect of each card
 * called by the card number.
 * 
 * @author taftan@usi.ch & sardoa@usi.ch
 * @version 28/04/2022
 */
public class Card {

      /**
     * Constructor of the class Card.
     * 
     * @param descr the description
     */
    private String descr;

    public Card(String descr) {
        this.descr = descr;
    }

    /**
     * Get the description of the card.
     * 
     * @return the description
     */
    public String getDescription() {
        return this.descr;
    }

    /**
     * This is the card0 and move the position of the player to square 16.
     * 
     * @param player for apply the effect of the card
     */
    public static void card0(Player player) {

        player.movePosition(16);
    }

    /**
     * This is the card1 increase the money by 200 and move the position in square
     * 0.
     * 
     * @param player for apply the effect of the card
     */
    public static void card1(Player player) {
        player.increaseMoney(200);
        player.movePosition(0);

    }

    /**
     * This is the card2 if the position is after the square 6 give the money of the
     * start then 200
     * else no money given
     * and move th positin to pos 6 in any way.
     * 
     * 
     * @param player for apply the effect of the card
     */
    public static void card2(Player player) {
        if (player.getPosition() > 6) {
            player.increaseMoney(200);
        }
        player.movePosition(6);
    }

    /**
     * This is the card3 increase the money of the player by 200 .
     * 
     * @param player for apply the effect of the card
     */
    public static void card3(Player player) {
        player.increaseMoney(200);
    }

    /**
     * This is the card4 decrease the moeny of the player by 50.
     * 
     * @param player for apply the effect of the card
     */
    public static void card4(Player player) {
        player.decreaseMoney(50);
    }

    /**
     * This is the card5 add the card "Get out of the jail free" in the deck of the
     * player.
     * 
     * @param player for apply the effect of the card
     */
    public static void card5(Player player) {
        // free from jail card

        player.addCardToDeck(new Card("Get Out of Jail Free"));

    }

    /**
     * This is the card6 increse the money of the player by 100.
     * 
     * @param player for apply the effect of the card
     */
    public static void card6(Player player) {
        player.increaseMoney(100);
    }

    /**
     * This is the card7 move the position of the player on the 30 and set the
     * player in the jail by the day
     * of the jail square.
     * 
     * @param player for apply the effect of the card
     */
    public static void card7(Player player) {

        player.movePosition(30);

        player.setJail(JailSquare.getDays());

    }

    /**
     * This is the card8 decrease the money of the player by 100.
     * 
     * @param player for apply the effect of the card
     */
    public static void card8(Player player) {
        player.decreaseMoney(100);
    }

    /**
     * This is the card9 decrease the moeny of the player by 40.
     * 
     * @param player for apply the effect of the card
     */
    public static void card9(Player player) {
        player.decreaseMoney(40);
    }

    /**
     * This is the card10 increase the money of the player by 75.
     * 
     * @param player for apply the effect of the card
     */
    public static void card10(Player player) {
        player.increaseMoney(75);
    }

    /**
     * This is the card11 if the player is already more than 35 then increase his
     * money by 200
     * and finally move the position of the player in square 35.
     * 
     * @param player for apply the effect of the card
     */
    public static void card11(Player player) {

        if (player.getPosition() > 35) {
            player.increaseMoney(200);
        }
        player.movePosition(35);
    }

    /**
     * This is the card12 decrease the money of the player by 200.
     * 
     * @param player for apply the effect of the card
     */
    public static void card12(Player player) {
        player.decreaseMoney(200);
    }

    /**
     * This is the card13 decrease the money of the player by 50.
     * 
     * @param player for apply the effect of the card
     */
    public static void card13(Player player) {
        player.decreaseMoney(50);
    }

    /**
     * This is the card14 decrease the money of the player by 120.
     * 
     * @param player for apply the effect of the card
     */
    public static void card14(Player player) {
        player.decreaseMoney(120);
    }

}
