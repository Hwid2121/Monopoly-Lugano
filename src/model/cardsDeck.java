package model;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Hashtable;

import java.util.Random;


public class cardsDeck {
    


   

    List<Card> cards = new ArrayList<>();

    Random rand = new Random();
    

    int index;


    public cardsDeck(){
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





    public  int getRandomNum(){
        index = rand.nextInt(cards.size());
        return index;
    }

    public Card randomCard(){
        getRandomNum();
        Card card = cards.get(index);
        return card;
    }




    public void playCard(Card card , Player player){
        
        int i = index;
        
        
        switch(i){
            case 0:
            card.card0(player);
            case 1:
            card.card1(player);
            case 2:
            card.card2(player);
            case 3:
            card.card3(player);
            case 4:
            card.card4(player);
            case 5:
            card.card5(player);
            case 6:
            card.card6(player);
            case 7:
            card.card7(player);
            case 8:
            card.card8(player);
            case 9:
            card.card9(player);
            case 10:
            card.card10(player);
            case 11:
            card.card11(player);
            case 12:
            card.card12(player);
            case 13:
            card.card13(player);
            case 14:
            card.card14(player);
        }



    }








}
