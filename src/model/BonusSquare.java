package src.model;

/**
 * This class rapresent the bonus square of the table such as:
 * - Start
 * - Bonus (in future cards)
 * - Malus (in future cards)
 * - Jail
 * -
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class BonusSquare extends Square {

    private final String description;
    private final int money;

    public BonusSquare(String name, String color, String description, int money) {
        super(name, color);
        this.description = description;
        this.money = money;
    }

    public void giveMoney() {

    }

    public void takeMoney() {

    }

    public String getDescription() {
        return description;
    }

}
