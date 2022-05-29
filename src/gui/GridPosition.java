package gui;

import java.util.Hashtable;

import gui.main.GameMain;
import model.*;
public class GridPosition {


    private Hashtable<Position, Square> grid = new Hashtable<Position, Square>();

    private Monopoly monopoly = GameMain.monopoly;

    public GridPosition(){


    }



    public void setGrid(){

        grid.put(new Position(909,909), monopoly.getTable().getSquare(0));
        grid.put(new Position(800, 909), monopoly.getTable().getSquare(1));
        grid.put(new Position(720, 909), monopoly.getTable().getSquare(2));
        grid.put(new Position(640, 909), monopoly.getTable().getSquare(3));
        grid.put(new Position(565, 909), monopoly.getTable().getSquare(4));
        grid.put(new Position(485, 909), monopoly.getTable().getSquare(5));
        grid.put(new Position(410, 909), monopoly.getTable().getSquare(6));
        grid.put(new Position(330, 909), monopoly.getTable().getSquare(7));
        grid.put(new Position(250, 909), monopoly.getTable().getSquare(8));
        grid.put(new Position(170 , 909), monopoly.getTable().getSquare(9));
        grid.put(new Position(65, 909), monopoly.getTable().getSquare(10));
        grid.put(new Position(65, 808), monopoly.getTable().getSquare(11));
        grid.put(new Position(65, 720), monopoly.getTable().getSquare(12));
        grid.put(new Position(65, 640), monopoly.getTable().getSquare(13));
        grid.put(new Position(65, 565), monopoly.getTable().getSquare(14));
        grid.put(new Position(65, 485), monopoly.getTable().getSquare(15));
        grid.put(new Position(65, 410), monopoly.getTable().getSquare(16));
        grid.put(new Position(65, 330), monopoly.getTable().getSquare(17));
        grid.put(new Position(65, 250), monopoly.getTable().getSquare(18));
        grid.put(new Position(65, 170), monopoly.getTable().getSquare(19));
        grid.put(new Position(65, 65), monopoly.getTable().getSquare(20));
        grid.put(new Position(170, 65), monopoly.getTable().getSquare(21));
        grid.put(new Position(250, 65), monopoly.getTable().getSquare(22));
        grid.put(new Position(330, 65), monopoly.getTable().getSquare(23));
        grid.put(new Position(410, 65), monopoly.getTable().getSquare(24));
        grid.put(new Position(485, 65), monopoly.getTable().getSquare(25));
        grid.put(new Position(565, 65), monopoly.getTable().getSquare(26));
        grid.put(new Position(640, 65), monopoly.getTable().getSquare(27));
        grid.put(new Position(720, 65), monopoly.getTable().getSquare(28));
        grid.put(new Position(800, 65), monopoly.getTable().getSquare(29));
        grid.put(new Position(909, 65), monopoly.getTable().getSquare(30));
        grid.put(new Position(909, 170), monopoly.getTable().getSquare(31));
        grid.put(new Position(909, 250), monopoly.getTable().getSquare(32));
        grid.put(new Position(909, 330), monopoly.getTable().getSquare(33));

        grid.put(new Position(909, 410), monopoly.getTable().getSquare(34));
        grid.put(new Position(909, 485), monopoly.getTable().getSquare(35));
        grid.put(new Position(909, 565), monopoly.getTable().getSquare(36));
        grid.put(new Position(909, 640), monopoly.getTable().getSquare(37));
        grid.put(new Position(909, 720), monopoly.getTable().getSquare(38));
        grid.put(new Position(909, 808), monopoly.getTable().getSquare(39));



    }






    
}
