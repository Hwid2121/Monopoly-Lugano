
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * this class rapresent the table composed by the square and wher ethe player
 * will play
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Table {

    static private final int sizeTable = 40;

    Square[] cell = new Square[sizeTable];

    public Table() {
        newtable();
    }

    public void newtable() {
        cell[0] = new BonusSquare("Start", "bonus", "The start for every player.", 200);

        cell[1] = new PropertySquare(60, 2, "Via Zurigo", "brown", 30, 1, 50, 10,30,90,160, 250);

        cell[2] = new BonusSquare("Pick a card!", "cards", "pick a card and discover if it's good or not", -1);

        cell[3] = new PropertySquare(60, 2, "Via Giuseppe Bagutti", "brown", 30, 3, 50,20,60,180,320,450);

        cell[4] = new BonusSquare("Income Tax", "malus", "Income tax you have to pay 200", 200);

        cell[5] = new PropertySquare(200, 2, "Parco Florida", "park", 100, 5, 0,0,0,0,0,0);

        cell[6] = new PropertySquare(100, 6, "Via la Santa", "azure", 50, 6, 50, 30,90,270,400,550);

        cell[7] = new BonusSquare("Casino' Lugano", "bonus", "You won at blackjack you gain  75 chf", 75);

        cell[8] = new PropertySquare(100, 6, "Convento dei Cappuccini", "azure", 50, 8, 50, 30,90,270,400,550);

        cell[9] = new PropertySquare(120, 8, "Via delle Aie", "azure", 60, 9, 50, 40,100,300,450,600);

        cell[10] = new BonusSquare("Go to the jail!", "goto", "now you go to the jail!", -1);

        cell[11] = new PropertySquare(140, 10, "Viale Cassarate", "pink", 70, 11,70,50,150,450,625,750);

        cell[12] = new PropertySquare(150, 66, "Centrale Elettrica AIL", "company", 75, 12,0,0,0,0,0,0);

        cell[13] = new PropertySquare(140, 10, "Via delle Rose", "pink", 70, 13, 70,50,150,450,625,750);

        cell[14] = new PropertySquare(160, 12, "Piazza Molino Nuovo", "pink", 80, 14, 100, 60,180,500,700,900);

        cell[15] = new PropertySquare(200, 25, "Parco San Grato ", "park", 100, 15, 0,0,0,0,0,0);

        cell[16] = new PropertySquare(180, 14, "Lugano Arte e Cultura (LAC)", "orange", 90, 16, 100, 70,200,550,750,950);

        cell[17] = new BonusSquare("USI Campus West", "bonus", "You the best Student free schoolarship of 100 chf",
                100);

        cell[18] = new PropertySquare(180, 14, "Via Maggio", "orange", 90, 18, 100,70,200,550,750,950);

        cell[19] = new PropertySquare(200, 16, "Chiesa Santa Maria degli Angeli", "orange", 100, 19,100,80,220,600,800,1000);

        cell[20] = new BonusSquare("Empty square, do nothing", "empty", "Nothing, square only to sit in peace", 0);

        cell[21] = new PropertySquare(220, 18, "Piazzale Stazione ", "red", 110, 21, 110, 90,250,700,875,1050);

        cell[22] = new BonusSquare("Pick a card", "cards", "Pick a card and discover if it's good or not",
                120);

        cell[23] = new PropertySquare(220, 18, "Corso Elvezia", "red", 110, 23, 150,90,250,700,875,1050);

        cell[24] = new PropertySquare(240, 20, "Lido", "red", 120, 24, 150,100,300,750,925,1100);

        cell[25] = new PropertySquare(200, 25, "Parco San Michele", "park", 100, 25,0,0,0,0,0,0);

        cell[26] = new PropertySquare(260, 22, "Viale Serafino Balestra", "yellow", 130, 26, 150,110,330,800,975,1150);

        cell[27] = new PropertySquare(260, 22, "Lido di Lugano", "yellow", 130, 27, 150,110,330,800,975,1150);

        cell[28] = new PropertySquare(150, 66, "Universita' di Lugano", "company", 75, 28,0,0,0,0,0,0);

        cell[29] = new PropertySquare(280, 24, "Via Nassa", "yellow", 140, 29, 150,120,360,850,1025, 1200);

        cell[30] = new JailSquare("Penitenziario lo Stampino!", "jail");

        cell[31] = new PropertySquare(300, 26, "Riva Paradiso", "green", 150, 31, 200, 130,390,900,1100,1275);

        cell[32] = new PropertySquare(300, 26, "Via alla Vetta", "green", 150, 32, 200,130,390,900,1100, 1275);

        cell[33] = new BonusSquare("USI Campus East", "bonus", "You the best Student free schoolarship of 150 chf",
                150);

        cell[34] = new PropertySquare(320, 28, "Riva Vincenzo Vela", "green", 160, 34, 200, 150,450,1000,1200,1400);

        cell[35] = new PropertySquare(200, 25, "Parco Ciani", "park", 100, 35,0,0,0,0,0,0);

        cell[36] = new BonusSquare("Bar Oops", "malus", "You spent a lot of money in drinks, pay the bill of 200 chf",
                200);

        cell[37] = new PropertySquare(350, 35, "Via Pessina", "blue", 175, 37, 200,175,500,1100,1300,1500);

        cell[38] = new BonusSquare("Dogana Chiasso!", "malus",
                "You brought to much food, you have been caugh and pay 100 chf of fine",
                100);

        cell[39] = new PropertySquare(400, 50, "Piazza della Riforma", "blue", 200, 39, 200,200,600,1400,1700,2000);

    }

    public Square getSquare(int pos) {
        return cell[pos];
    }

    public String getSquareName(int pos) {
        return this.getSquare(pos).getName();
    }

    public int getSquarePrice(int pos) {
        Object obj = this.getSquare(pos);
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            return s.getPrice();
        }
        return 0;
    }


    public House getHouse(int pos){

        Object obj = this.getSquare(pos);
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;

            return s.getHouse();
        }
        return null;

    }

    public int getSquarePriceTax(int pos) {
        Object obj = this.getSquare(pos);
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;

            return s.getPriceTax();
        }
        return 0;
    }

    public static int getSizeofTable() {
        return sizeTable;
    }

    public String getDescriptionProperty(int pos) {
        return "Name: " + getSquareName(pos) + "\n" + "Price: " + getSquarePrice(pos) + "\n" + "Rent value: "
                + getSquarePriceTax(pos) + "\n Owner: " + getSquareOwner(pos).getNickname() + "\n";

    }

    public Player getSquareOwner(int pos) {
        Object obj = this.getSquare(pos);
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            return s.getOwner();
        }
        return null;
    }

    public String getSquareOwnerToString(int pos) {

        if (getSquareOwner(pos) == null)
            return "";
        return getSquareOwner(pos).getNickname();
    }

    public void setSquareOwner(Player player) {
        Object obj = this.getSquare(player.getPosition());
        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            s.changeOwner(player);
        }

    }

    public int getSquareBonusPrice(Player player) {
        Object obj = this.getSquare(player.getPosition());
        if (obj instanceof BonusSquare) {
            BonusSquare s = (BonusSquare) obj;
            return s.getMoney();
        }
        return -1;

    }

    public String getSquareBonusDescr(int pos) {
        Object obj = this.getSquare(pos);
        if (obj instanceof BonusSquare) {
            BonusSquare s = (BonusSquare) obj;
            return s.getDescription();
        }
        return "";

    }

    public PropertySquare getPropertySquare(int pos) {
        Object obj = this.getSquare(pos);

        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            return s;
        }
        return new PropertySquare(0, 0, "o", "o", 0, -1,0,0,0,0,0,0);

    }

    // public boolean getMonopolySquare(Player player){

    // if (player.getPropertySquare().size() < 1){
    // return false;
    // } else{

    // ArrayList<String> a = new ArrayList<String>();
    // for(PropertySquare property: player.getPropertySquare()){
    // a.add(property.getColor());
    // }
    // Collections.sort(a);

    // int counter = 1;
    // String color = a.get(0);
    // for(int i =1; i< player.getPropertySquare().size(); i++){

    // }
    // }

    // }

    public boolean getMonopolyColor(Player player) {

        int counter = 0;
        String color = getPropertySquare(player.getPosition()).getColor();
        for (PropertySquare pr : player.getPropertySquare()) {
            if (pr.getColor() == color)
                counter++;
        }

        if (((color == "brown" || color == "blue" || color == "company") && counter == 2)
                || (color == "red" || color == "azure" || color == "pink" || color == "orange" || color == "yellow"
                        || color == "green") && counter == 3
                ||
                (color == "park") && counter == 4) {

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

    public ArrayList<PropertySquare> getOtherMonopolySquare(Player player) {

        String color = getPropertySquare(player.getPosition()).getColor();

        ArrayList<PropertySquare> list = new ArrayList<PropertySquare>();

        for (Square pr : cell) {

            Object obj = pr;

            if (obj instanceof PropertySquare) {
                PropertySquare s = (PropertySquare) obj;

                if (s.getColor() == color)
                    list.add(s);

            }
        }

        return list;

    }

    public String getColor(int i) {

        return getSquare(i).getColor();
    }

    // public boolean getMono(int i){
    // return getPropertySquare(i).getMonopolyColor();
    // }

    public void resetOwner(int pos) {

        Object obj = this.getSquare(pos);

        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            s.resetOwner();

        }
    }
}

// public void setMononopolyColor(Player player, String color){
// int counter=0;

// int size = player.getPropertySquare().size()-1 ;

// for (int i=0; (i < size); i++){

// if(getColor(i) == color && getMono(i) == false){
// getPropertySquare(i).setMononopolyColor();
// getPropertySquare(i).setPriceTax(getPropertySquare(i).getPriceTax() *2);
// counter +=1;
// }}
// }

/**
 * start (+200)
 * Via la Santa
 * bonus
 * Via Zurigo
 * malus (-200)
 * Parco Florida
 * Via Giuseppe Bagutti
 * bonus
 * Convento dei Cappucini
 * Via delle Aie
 * Penitenziario Lo Stampino
 * Viale Cassarate
 * Via delle Rose
 * Parco Tassino
 * Piazza Molino Nuovo
 * Lugano Arte e Cultura (LAC)
 * Via Maggio
 * bonus
 * Piazzale Stazione
 * Giardino Belvedere
 * NULL (do nothing)
 * Chiesa Santa Maria degli Angeli
 * bonus/malus
 * Lido di Lugano
 * Corso Elvezia
 * Viale Serafino Balestra
 * Piazza della Riforma
 * Via Nassa
 * Riva Paradiso
 * Via alla Vetta
 * GO back TO JAIL
 * Riva Vincenzo Vela
 * Via Riviera
 * bonus
 * Viale Castagnola
 * Parco San Michele
 * bonus/malus
 * Villa Favorita
 * malus (-100)
 * Parco Ciani
 * 
 * 
 */
