package model;

import java.util.ArrayList;
import java.util.List;


public class CardsEXE extends DeckOfCards {


    int cell;
    int ex;


    List<CardsEXE> exe =  new ArrayList<>();

    public CardsEXE(int i, int x){
        
        cell = i;
        ex = x;
    }



    public void newExe() {

        exe.add(new CardsEXE(0, 0));


    }




    public void card1(){
        System.out.println("aa");
    }

     

    


    
}
