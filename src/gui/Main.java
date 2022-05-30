package gui;

import java.awt.EventQueue;


/**
 * in this class we create the main frame of the game gui.
 * 
 * @author Alberto Sardo & Nicolo' Tafta
 * @version 24/05/2022
 */

public class Main {

    



    /**
     * Launch the application.
     */
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
