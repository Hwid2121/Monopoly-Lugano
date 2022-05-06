package tui;

import java.util.Scanner; // Import the Scanner class
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
    public int status = 0;

    public int skip = 0;
    public int turn = 0;

    public void preGameStatus() {
        this.status = 0;

        System.out.println("Quanti giocatori?");
        numberOfPlayers = input.nextInt();

        while (listOfPlayers.size() < numberOfPlayers) {

            System.out.println("Nickname giocatore " + listOfPlayers.size());

            String Nickname = input.next();
            if (input.hasNextLine()) {

                listOfPlayers.add(new Player(Nickname));
            }

        }

        System.out.println("Pregame pronto, adesso si gioca!");
        status = 1;

    }

    protected boolean nextTurn = false;

    public void bonusPLAYmain(Player player) {

    }

    public void malusPLAYmain(Player player) {

    }

    public void parkPLAYmain(Player player) {

    }

    public void companyPLAYmain(Player player) {

    }

    public void jailPLAYmain(Player player) {

    }

    public void emptyPLAYmain(Player player) {

    }

    public void gotoPLAYmain(Player player) {

    }

    public void PropertySquarePLAY(Player player, Monopoly monopoly) {

        System.out.println("You are in a property'");
        System.out.println("Write: Description (for the description of the property) ");
        System.out.println("Buy (for buying the property) ");
        System.out.println("Sell (to sell this property) ");
        System.out.println("Pass (to finish the turn) ");

        String word = input.next();

        switch (word) {
            case "Description":
                System.out.println("\n \n" + monopoly.propertyDescr(listOfPlayers.get(turn)));
                break;

            case "Buy":

                if (player.getMoney() > monopoly.table.getSquarePrice(listOfPlayers.get(turn).getPosition())) {
                    System.out.println("Confirm to buy the property?"
                            + monopoly.table.getSquareName(listOfPlayers.get(turn).getPosition())
                            + "\n Your budget will be "
                            + (monopoly.table.getSquarePrice(listOfPlayers.get(turn).getPosition())
                                    + player.getMoney()));

                } else
                    System.out.println("You don't have enough money to buy the property");

                System.out.println("");
            case "Sell":

            case "pass":
                skip = 1;
        }

    }

    public void gameStatus() {

        Monopoly monopoly = new Monopoly(listOfPlayers);

        System.out.println("Il gioco inizia!!!");
        System.out.println("Ogni giocatore inizia con 1500 chf ");

        while (monopoly.MonopolyEND()) {

            turn = turn % numberOfPlayers;

            System.out.println(listOfPlayers.get(turn).getNickname() + " e' il tuo turno!");

            monopoly.throwDice();
            System.out.println("I tuoi dadi hanno fatto " + monopoly.die1() + " e " + monopoly.die2());
            System.out.println("Avanzi di " + (monopoly.die1() + monopoly.die2()));

            monopoly.setPositionPlayer(listOfPlayers.get(turn));
            System.out.println("Sei arrivato alla casella: "
                    + monopoly.table.getSquareName(listOfPlayers.get(turn).getPosition()));

            while (skip == 0) {
                switch (monopoly.table.getSquare(listOfPlayers.get(turn).getPosition()).getColor()) {

                    // case "bonus":
                    // bonusPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;
                    // case "malus":
                    // malusPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;
                    // case "park":
                    // parkPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;
                    // case "company":
                    // companyPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;
                    // case "jail":
                    // jailPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;
                    // case "empty":
                    // emptyPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;
                    // case "goto":
                    // gotoPLAYmain(listOfPlayers.get(turn), monopoly);
                    // break;

                    default:
                        PropertySquarePLAY(listOfPlayers.get(turn), monopoly);
                }
            }

            turn += 1;

            if (turn >= 2) {
                break;
            }
            // break;

        }

    }

    public void finishStatus() {
        this.status = -1;

    }

    public int getStatus() {
        return status;
    }

    public static void main(String[] args) {

        Main game = new Main();

        //

        switch (game.getStatus()) {

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
