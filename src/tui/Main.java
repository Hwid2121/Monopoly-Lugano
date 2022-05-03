package tui;
import java.util.Scanner;  // Import the Scanner class

/**
 * DESCRIBE THIS CLASS
 * 
 * @author YOUR_USI_EMAIL
 */
public class Main {
    


    Scanner input = new Scanner(System.in);


    public  int status = 0;




    public  void preGameStatus(){
        this.status = 0;

        System.out.println("Quanti giocatori?");
        






    }

    public  void gameStatus(){
        this.status = 1;
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
