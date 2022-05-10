package model;

import java.util.HashMap;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class CardsDescr extends DeckOfCards {

    // int ID for the random
    // String for Description
    // Runnable for code

    String descr;

    List<CardsDescr> cards = new ArrayList<>();

    public CardsDescr(String descr) {
        this.descr = descr;
    }

    public void newCards() {

        cards.add(new CardsDescr("Advance to LAC"));
        cards.add(new CardsDescr("Advance to Go (Collect 200 chf)"));
        cards.add(new CardsDescr("Advance to Via la Santa. If you pass Go, collect 200 chf"));

        cards.add(new CardsDescr("Credit Suisse error in your favor. Collect 200 chf"));

        cards.add(new CardsDescr("Doctor's fee. Pay 50 chf"));
        cards.add(new CardsDescr("Get Out of Jail Free"));
        cards.add(new CardsDescr("Holiday fund matures. Receive 100 chf"));
        cards.add(new CardsDescr("Go to Jail. Go directly to jail, do not pass Go, do not collect 200 chf"));
        cards.add(new CardsDescr("Pay insurance fees of 100 chf"));
        cards.add(new CardsDescr("Pay USI fees of 40 chf"));
        cards.add(new CardsDescr("You took the best grade of PF2 project. Collect 75 chf"));
        cards.add(new CardsDescr("Advance to Parco Ciani. If you pass Go, collect 200 chf"));

        cards.add(new CardsDescr("Go Back 3 Squares"));
        cards.add(new CardsDescr(
                "Oh no you blow through a red light, you took a fine of 200 chf and go to Jail! (do not pass Go, do not collect 150 chf)"));
        cards.add(new CardsDescr("You have been caugh cheating, pay 50 chf "));
        cards.add(new CardsDescr("Canton of Ticino gives 150 chf to each player"));
        cards.add(new CardsDescr("Pay taxes! 120 chf"));

    }


    public CardsDescr getCell(int pos){
        return cards.get(pos);
    }

    



}
