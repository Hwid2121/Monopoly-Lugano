
package model;

import java.util.ArrayList;

/**
 * The table is composed by Squares that can be:
 * - BonusSquare
 * - PropertySquare
 * 
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Table {

    static private final int SIZETABLE = 40;
    private String bonus = "Bonus";
    private String azure = "azure";
    private String park = "park";
    private String pink = "pink";
    private String orange = "orange";
    private String red = "red";
    private String yellow = "yellow";
    private String green = "green";

    private Square[] cell = new Square[SIZETABLE];

    /**
     * Constructor of the class Table.
     * Constructor that call the method newtable() where are stored all the Squares
     * of monopoly game.
     */
    public Table() {
        newtable();
    }

    /**
     * Method newtable() is the composer of the monopoly table where are stored all
     * the
     * Squares of the game.
     * The Array of Square, composed by child Classes:
     * - BonusSquare
     * - PropertySquare
     * 
     * 40 Square.
     * 
     */
    public void newtable() {
        cell[0] = new BonusSquare("Start", bonus, "Collect 200.- salary as you pass", 200);

        cell[1] = new PropertySquare(60, 2, "Via Zurigo", "brown", 30, 1, 50, 10, 30, 90, 160, 250);

        cell[2] = new BonusSquare("Pick a card!", "cards", "pick a card and discover if it's good or not", -1);

        cell[3] = new PropertySquare(60, 2, "Via Giuseppe Bagutti", "brown", 30, 3, 50, 20, 60, 180, 320, 450);

        cell[4] = new BonusSquare("Income Tax", "malus", "Income tax you have to pay 200", 200);

        cell[5] = new PropertySquare(200, 25, "Parco Florida", park, 100, 5, 0, 0, 0, 0, 0, 0);

        cell[6] = new PropertySquare(100, 6, "Via la Santa", azure, 50, 6, 50, 30, 90, 270, 400, 550);

        cell[7] = new BonusSquare("Casino' Lugano", "bonus", "You won at blackjack you gain  75 chf", 75);

        cell[8] = new PropertySquare(100, 6, "Convento dei Cappuccini", azure, 50, 8, 50, 30, 90, 270, 400, 550);

        cell[9] = new PropertySquare(120, 8, "Via delle Aie", azure, 60, 9, 50, 40, 100, 300, 450, 600);

        cell[10] = new BonusSquare("Go to the jail!", "goto", "now you go to the jail!", -1);

        cell[11] = new PropertySquare(140, 10, "Viale Cassarate", pink, 70, 11, 70, 50, 150, 450, 625, 750);

        cell[12] = new PropertySquare(150, 66, "Centrale Elettrica AIL", "company", 75, 12, 0, 0, 0, 0, 0, 0);

        cell[13] = new PropertySquare(140, 10, "Via delle Rose", pink, 70, 13, 70, 50, 150, 450, 625, 750);

        cell[14] = new PropertySquare(160, 12, "Piazza Molino Nuovo", pink, 80, 14, 100, 60, 180, 500, 700, 900);

        cell[15] = new PropertySquare(200, 25, "Parco San Grato ", park, 100, 15, 0, 0, 0, 0, 0, 0);

        cell[16] = new PropertySquare(180, 14, "Lugano Arte e Cultura (LAC)", orange, 90, 16, 100, 70, 200, 550, 750,
                950);

        cell[17] = new BonusSquare("USI Campus West", "bonus", "You the best Student free schoolarship of 100 chf",
                100);

        cell[18] = new PropertySquare(180, 14, "Via Maggio", orange, 90, 18, 100, 70, 200, 550, 750, 950);

        cell[19] = new PropertySquare(200, 16, "Chiesa Santa Maria degli Angeli", orange, 100, 19, 100, 80, 220, 600,
                800, 1000);

        cell[20] = new BonusSquare("Empty square, do nothing", "empty", "Nothing, square only to sit in peace", 0);

        cell[21] = new PropertySquare(220, 18, "Piazzale Stazione ", red, 110, 21, 110, 90, 250, 700, 875, 1050);

        cell[22] = new BonusSquare("Pick a card", "cards", "Pick a card and discover if it's good or not",
                120);

        cell[23] = new PropertySquare(220, 18, "Corso Elvezia", red, 110, 23, 150, 90, 250, 700, 875, 1050);

        cell[24] = new PropertySquare(240, 20, "Lido", red, 120, 24, 150, 100, 300, 750, 925, 1100);

        cell[25] = new PropertySquare(200, 25, "Parco San Michele", park, 100, 25, 0, 0, 0, 0, 0, 0);

        cell[26] = new PropertySquare(260, 22, "Viale Serafino Balestra", yellow, 130, 26, 150, 110, 330, 800, 975,
                1150);

        cell[27] = new PropertySquare(260, 22, "Lido di Lugano", yellow, 130, 27, 150, 110, 330, 800, 975, 1150);

        cell[28] = new PropertySquare(150, 66, "Universita' di Lugano", "company", 75, 28, 0, 0, 0, 0, 0, 0);

        cell[29] = new PropertySquare(280, 24, "Via Nassa", yellow, 140, 29, 150, 120, 360, 850, 1025, 1200);

        cell[30] = new JailSquare("Penitenziario lo Stampino!", "jail");

        cell[31] = new PropertySquare(300, 26, "Riva Paradiso", green, 150, 31, 200, 130, 390, 900, 1100, 1275);

        cell[32] = new PropertySquare(300, 26, "Via alla Vetta", green, 150, 32, 200, 130, 390, 900, 1100, 1275);

        cell[33] = new BonusSquare("USI Campus East", "bonus", "You the best Student free schoolarship of 150 chf",
                150);

        cell[34] = new PropertySquare(320, 28, "Riva Vincenzo Vela", green, 160, 34, 200, 150, 450, 1000, 1200, 1400);

        cell[35] = new PropertySquare(200, 25, "Parco Ciani", park, 100, 35, 0, 0, 0, 0, 0, 0);

        cell[36] = new BonusSquare("Bar Oops", "malus", "You spent a lot of money in drinks, pay the bill of 200 chf",
                200);

        cell[37] = new PropertySquare(350, 35, "Via Pessina", "blue", 175, 37, 200, 175, 500, 1100, 1300, 1500);

        cell[38] = new BonusSquare("Dogana Chiasso!", "malus",
                "You brought to much food, you have been caugh and pay 100 chf of fine",
                100);

        cell[39] = new PropertySquare(400, 50, "Piazza della Riforma", "blue", 200, 39, 200, 200, 600, 1400, 1700,
                2000);

    }

    /**
     * Get the Square at position pos into the array cell.
     * 
     * @param pos for the index
     * @return the Square at index pos
     */
    public Square getSquare(int pos) {

        return cell[pos];
    }

    /**
     * Get the name of Square at position pos.
     * 
     * @param pos for the index
     * @return the name of the square
     * 
     */
    public String getSquareName(int pos) {
        return this.getSquare(pos).getName();
    }

    /**
     * Get the Square price if the Square is a propertySquare.
     * 
     * 
     * @param pos for the index
     * @return the price if it is a propertySquare else 0
     * 
     */
    public int getSquarePrice(int pos) {
        Object obj = this.getSquare(pos);
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            return s.getPrice();
        }
        return 0;
    }

    /**
     * Get the array house if the Square is a propertySquare.
     * 
     * 
     * @param pos for the index of Square
     * @return the array House if it is a propertySquare else null
     * 
     */
    public House getHouse(int pos) {

        Object obj = this.getSquare(pos);
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;

            return s.getHouse();
        }
        return null;

    }

    /**
     * Get the price of the Square if it is a propertySquare.
     * 
     * @param pos for the index of the Square in the Table
     * @return the price of Square if it is a propertySquare else 0
     * 
     */
    public int getSquarePriceTax(int pos) {
        Object obj = this.getSquare(pos);
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;

            return s.getPriceTax();
        }
        return 0;
    }

    /**
     * Get the size of the table.
     * 
     * @return the value of the SIZETABLE
     */
    public static int getSizeofTable() {
        return SIZETABLE;
    }

    /**
     * Get the Owner of the propertySquare.
     * 
     * @param for the index of the Square in the Table
     * @return the Owner of the Square if it is a propertySquare else null
     * 
     */
    public Player getSquareOwner(int pos) {
        Object obj = this.getSquare(pos);
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            return s.getOwner();
        }
        return null;
    }

    /**
     * Get the nickname of the owner of the propertySquare.
     * 
     * @return the nickname of the owner
     * @param pos for the index of the Square in the table
     */
    public String getSquareOwnerToString(int pos) {

        if (getSquareOwner(pos) == null) {
            return "";
        }
        return getSquareOwner(pos).getNickname();
    }

    /**
     * Set the Owner of the propertySquare.
     * 
     * @param player for setting the player as owner
     * @return true if the die1 and die2 are the same number, false otherwise.
     */
    public void setSquareOwner(Player player) {
        Object obj = this.getSquare(player.getPosition());
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            s.changeOwner(player);
        }

    }

    /**
     * Get the price of the BonusSquare.
     * 
     * @return the price of the Square if it is a bonusSquare else return -1
     * @param player for take the position and take it as index in Table
     * 
     */
    public int getSquareBonusPrice(Player player) {
        Object obj = this.getSquare(player.getPosition());
        if (obj instanceof BonusSquare) {
            BonusSquare s = (BonusSquare) obj;
            return s.getMoney();
        }
        return -1;

    }

    /**
     * Get the decription of the BonusSquare.
     * 
     * @return the description if the Square at index pos is a BonusSquare
     *         else return ""
     * @param pos for the index in the table
     */
    public String getSquareBonusDescr(int pos) {
        Object obj = this.getSquare(pos);
        if (obj instanceof BonusSquare) {
            BonusSquare s = (BonusSquare) obj;
            return s.getDescription();
        }
        return "";

    }

    public Square[] getCell() {
        return cell;
    }

    /**
     * Get the propertySquare at index pos in the table.
     * 
     * @return the Square at index pos if it is a propertySquare else
     *         return null
     * @param pos for index in the table
     */
    public PropertySquare getPropertySquare(int pos) {
        Object obj = this.getSquare(pos);

        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            return s;
        }
        return null;

    }

    /**
     * Check if the player did a monopoly. If the player bough all the property with
     * the
     * same color. Then the price of them will double.
     * Diffrent monopoly color for each group of color:
     * - 2 squares for the Brown, blue and company.
     * - 3 squares for red, azure, pink, orange, yellow
     * - 4 for Squares park
     * 
     * @return true if the player did monopoly color, false otherwise
     * @param player for check its properties
     */
    public boolean getMonopolyColor(Player player) {

        int counter = 0;
        String color = getPropertySquare(player.getPosition()).getColor();
        for (PropertySquare pr : player.getPropertySquare()) {
            if (pr.getColor() == color) {
                counter++;
            }
        }

        if ("brown".equals(color) || "blue".equals(color) || "company".equals(color) && counter == 2
                || ("red".equals(color) || "azure".equals(color) || "pink".equals(color) || "orange".equals(color)
                        || "yellow".equals(color)
                        || "green".equals(color)) && counter == 3
                ||
                ("park".equals(color)) && counter == 4) {
            for (Square pr : cell) {

                Object obj = pr;

                if (obj instanceof PropertySquare) {
                    PropertySquare s = (PropertySquare) obj;
                    s.setPriceTaxMonopoly();

                }
            }
            return true;

        }
        return false;
    }

    /**
     * Check if the color of the Square where the player is that momemnt can be
     * the same of other propertySquare owned by the player.
     * Method usefull for the monopoly color.
     * 
     * @param player where to check the positon and the list of the propertySquare
     * @return listofpropertysquare of the player
     * 
     */
    public ArrayList<PropertySquare> getOtherMonopolySquare(Player player) {

        String color = getPropertySquare(player.getPosition()).getColor();

        ArrayList<PropertySquare> list = new ArrayList<PropertySquare>();

        for (Square pr : cell) {

            Object obj = pr;

            if (obj instanceof PropertySquare) {
                PropertySquare s = (PropertySquare) obj;

                if (s.getColor() == color) {

                    list.add(s);
                }

            }
        }

        return list;

    }

    /**
     * Get the color of the Square at inde i in the table.
     * 
     * @param index for the index of the Square in the table
     * @return the color of the Square at index I on the table
     */
    public String getColor(int index) {

        return getSquare(index).getColor();
    }

    /**
     * Call the method ressetOwner for the proeprtySquare at index pos in the table.
     * 
     * @param pos for the index of the Square in the table
     */
    public void resetOwner(int pos) {

        Object obj = this.getSquare(pos);

        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            s.resetOwner();

        }
    }
}
