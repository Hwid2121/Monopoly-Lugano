
package gui;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import gui.main.GameMain;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.Border;
import java.awt.ComponentOrientation;
import javax.swing.BorderFactory;


public class MonopolyCommandsPanel extends JPanel {




    

    Dimension dim = new Dimension(130,80);
    // Border  BLACKLINE = BorderFactory.createLineBorder(GameMain.CREMISI);
    // Font COURIER = new Font("SansSerif", Font.BOLD, 22);

    // JButton button4;
    // JButton button5;

    public MonopolyCommandsPanel(){

        // setSize(new Dimension(600,300));
        FlowLayout layout  = new FlowLayout(FlowLayout.CENTER,50,20 );
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        setBackground(GameMain.SFONDO);

        setBorder(GameMain. BLACKLINE);
        setLayout(layout);
        setFont(GameMain.COURIER);

        // trowDice();


        propertySquareEMPTY();


        setVisible(true);




        


    }




    public void trowDice(){

        JButton button1 = new JButton("Trow the dice");
        
        button1.setPreferredSize(dim);

        this.add(button1);


         
    }


    public void propertySquareEMPTY(){
            
            JButton buy = new JButton("BUY");
            buy.setPreferredSize(dim);

            JButton pass = new JButton("PASS");
            pass.setPreferredSize(dim);

 


            this.add(buy);
            this.add(pass);
    
    }


    public void propertySquareOwned(){
            JButton sell = new JButton("SELL");
            sell.setPreferredSize(dim);

            JButton build = new JButton("BUILD");
            build.setPreferredSize(dim);

            JButton pass = new JButton("PASS");
            pass.setPreferredSize(dim);

            this.add(sell);
            this.add(build);
            this.add(pass);

    }



    public void emptySquare(){
            JButton pass = new JButton("PASS");
            pass.setPreferredSize(dim);
        
            this.add(pass);

    }


    public void jailSquare(){

        JButton pay = new JButton("PAY FINE");
        pay.setPreferredSize(dim);

        JButton dice = new JButton("TROW DICE");
        dice.setPreferredSize(dim);

        JButton card = new JButton("USE CARD");
        card.setPreferredSize(dim);


        JButton pass = new JButton("PASS");
        pass.setPreferredSize(dim);


        this.add(pay);
        this.add(dice);
        this.add(card);
        this.add(pass);


    }


    public void goToJailSquare(){

        JButton pass = new JButton("PASS");
        pass.setPreferredSize(dim);

        this.add(pass);

    }




}
