package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This the container for the cards.
 * All the cards are added in the array with its description
 * and it will be used for the random cards in the monopoly game.
 * Through the name of the card the effect will start thanks the method play
 * card.
 * 
 * @author taftan@usi.ch & sardoa@usi.ch
 * @version 24/04/2022
 * 
 */
public class cardsDeck {

    private List<Card> cards = new ArrayList<>();

    private Random rand = new Random();

    int index;

    public cardsDeck() {
        newCards();
    }

    public void newCards() {

        cards.add(new Card("Advance to LAC"));
        cards.add(new Card("Advance to Go (Collect 200 chf)"));
        cards.add(new Card("Advance to Via la Santa. If you pass Go, collect 200 chf"));

        cards.add(new Card("Credit Suisse error in your favor. Collect 200 chf"));

        cards.add(new Card("Doctor's fee. Pay 50 chf"));

        cards.add(new Card("Get Out of Jail Free"));

        cards.add(new Card("Holiday fund matures. Receive 100 chf"));

        cards.add(new Card("Go to Jail. Go directly to jail, do not pass Go, do not collect 200 chf"));

        cards.add(new Card("Pay insurance fees of 100 chf"));

        cards.add(new Card("Pay USI fees of 40 chf"));

        cards.add(new Card("You took the best grade of PF2 project. Collect 75 chf"));

        cards.add(new Card("Advance to Parco Ciani. If you pass Go, collect 200 chf"));

        cards.add(new Card(
                "Oh no you blow through a red light, you took a fine of 200 chf "));
        cards.add(new Card("You have been caugh cheating, pay 50 chf "));

        cards.add(new Card("Pay taxes! 120 chf"));

    }

    public void getRandomNum() {
        index = rand.nextInt(cards.size());
    }

    public Card randomCard() {
        getRandomNum();
        Card card = cards.get(index);
        return card;
    }

    public int getIndex() {
        return index;
    }

    public void playCard(int index, Player player) {
        this.index = index;

        switch (index) {
            case 0:
                Card.card0(player);
                break;
            case 1:
                Card.card1(player);
                break;
            case 2:
                Card.card2(player);
                break;
            case 3:
                Card.card3(player);
                break;
            case 4:
                Card.card4(player);
                break;
            case 5:
                Card.card5(player);
                break;
            case 6:
                Card.card6(player);
                break;
            case 7:
                Card.card7(player);
                break;
            case 8:
                Card.card8(player);
                break;
            case 9:
                Card.card9(player);
                break;
            case 10:
                Card.card10(player);
                break;
            case 11:
                Card.card11(player);
                break;
            case 12:
                Card.card12(player);
                break;
            case 13:
                Card.card13(player);
                break;
            case 14:
                Card.card14(player);
                break;
        }

    }

}
