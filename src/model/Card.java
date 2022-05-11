package model;

import java.util.HashMap;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class Card  {

    // int ID for the random
    // String for Description
    // Runnable for code

    String descr;

    

    public Card(String descr) {
        this.descr = descr;
    }


    public String getDescription(){
        return this.descr;
    }




    public void card0(Player player){

    
        player.setPosition(16);
    }

    public void card1(Player player){
        player.increaseMoney(200);
        player.setPosition(0);

    }

    public void card2(Player player){
        if (player.getPosition() > 6){
            player.increaseMoney(200);
        }
        player.setPosition(6);
    }

    public void card3(Player player){
        player.increaseMoney(200);
    }

    public void card4(Player player){
        player.decreaseMoney(50);
    }

    public void card5(Player player){
        // free from jail card
    }

    public void card6(Player player){
        player.increaseMoney(100);
    }

    public void card7(Player player){
        // card go to jail and don't receive money

        if(player.getPosition() > 30){
           player.decreaseMoney(200);
        }
        player.setPosition(30);

    }


    public void card8(Player player){
        player.decreaseMoney(100);
    }

    public void card9(Player player){
        player.decreaseMoney(40);
    }

    public void card10(Player player){
        player.increaseMoney(75);
    }


    public void card11(Player player){

        if (player.getPosition() > 35 ){
            player.increaseMoney(200);
        }
        player.setPosition(35);
    }


    public void card12(Player player){
        player.decreaseMoney(200);
    }

    public void card13(Player player){
        player.decreaseMoney(50);
    }

    public void card14(Player player){
        player.decreaseMoney(120);
    }





    

    




}
