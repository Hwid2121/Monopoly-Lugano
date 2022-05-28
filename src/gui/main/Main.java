package gui.main;

import java.awt.EventQueue;


/**
 * DESCRIBE THIS CLASS
 * 
 * @author YOUR_USI_EMAIL
 */

public class Main {

    // add a main method here
    public static void main(String[] args) {
        System.out.println("GUI STARRRRRRRt");

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                System.out.println("creating gui...");

                new GameMain();

            }

        });
    }

}
