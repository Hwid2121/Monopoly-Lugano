package model;

/**
 * This class rapresent the bonus square of the table such as.
 * - Start
 * - Bonus (in future cards)
 * - Malus (in future cards)
 * - Jail
 * -
 *
 * @author taftan@usi.ch sardoa@usi.ch
 * @version 28/04/2022
 */
public class BonusSquare extends Square {

    private final String description;
    private final int money;

    /**
     * Constructor of the class BonusSquare child of the Square class.
     * 
     * @param name        the name of the bonus square that come from the parent
     *                    class
     * @param color       the color of the bonus square that come from the parent
     *                    class
     * @param description the description of the bonus square
     * @param money       the money that will use the bonus square to the player
     */
    public BonusSquare(String name, String color, String description, int money) {
        super(name, color);
        this.description = description;
        this.money = money;
    }

    /**
     * Increase the money of the player by the money of the money of the bonus
     * square.
     * 
     * @param player for apply the effect of the card
     */
    public void giveMoney(Player player) {
        player.increaseMoney(this.getMoney());

    }

    /**
     * Decrease the money of the player by the money of the money of the bonus
     * square.
     * 
     * @param player for apply the effect of the card
     */
    public void takeMoney(Player player) {
        player.decreaseMoney(this.getMoney());
    }

    /**
     * Get the description of the bonussquare.
     * 
     * @return the description of the bonusSquare
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the money of the bonusSquare.
     * 
     * @return the money of the bonusSquare
     */
    public int getMoney() {
        return money;
    }

}
