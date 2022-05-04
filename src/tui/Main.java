package tui;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;

import model.*;
import model.Monopoly;

/**
 * DESCRIBE THIS CLASS
 * 
 * @author YOUR_USI_EMAIL
 */
public class Main {
    
    ArrayList<Player> listOfPlayers = new ArrayList<Player>();

    Scanner input = new Scanner(System.in);

    public int numberOfPlayers = 0;
    public  int status = 0;

    


    public  void preGameStatus(){
        this.status = 0;

        System.out.println("Quanti giocatori?");
        numberOfPlayers = input.nextInt();

   


        String Nickname = "";
        while(listOfPlayers.size() < numberOfPlayers){

            
            System.out.println("Nickname giocatore " + listOfPlayers.size());
            
            Nickname = input.nextLine();
            if(input.hasNextLine()){
                
                listOfPlayers.add(new Player(Nickname));
            }
            

        }


        System.out.println("Pregame pronto, adesso si gioca!");
        status = 1;



        
    }

    public  void gameStatus(){
        
        System.out.println("Il gioco inizia /n");
        System.out.println("Ogni giocatore inizia con 1500");


        Monopoly monopoly = new Monopoly(listOfPlayers);


        while(monopoly.MonopolyEND()){

            



        }

        status = -1;

        
    }

    public  void finishStatus(){
        this.status = -1;

    }


    public int getStatus(){
        return status;
    }



    
    public static void main(String[] args) {
        

        Main game = new Main();



        // 
        

        switch(game.getStatus()){

            case 0:
                System.out.println("pregame status");
                game.preGameStatus();
            


            case 1:
                System.out.println("Play game  status");
                game.gameStatus();


            case -1:
                System.out.println("Game finished status");
                game.finishStatus();



        }


    }
    
}
