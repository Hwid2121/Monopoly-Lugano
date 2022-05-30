package gui.main;

import java.awt.EventQueue;


/**
 * in this class we create the main frame of the game gui.
 * 
 * @author Alberto Sardo & Nicolo' Tafta
 */

public class Main {

    
    public static void main(String[] args) {
        System.out.println("GUI STARRRRRRRT");

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                System.out.println("creating gui...");

                new GameMain();

            }

        });
    }

}
