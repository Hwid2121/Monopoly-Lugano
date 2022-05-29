
package gui;
import javax.swing.JButton;
import javax.swing.JPanel;

import gui.main.CLayout;
import gui.main.CLayoutForGame;
import gui.main.GameMain;
import gui.panels.PanelMonopoly;
import model.Monopoly;
import model.Player;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.ComponentOrientation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.nio.channels.ClosedSelectorException;



public class MonopolyCommandsPanel extends JPanel implements ActionListener{




    
    //Dimension of the command panel
    private Dimension dim = new Dimension(130,80);
    // Border  BLACKLINE = BorderFactory.createLineBorder(GameMain.CREMISI);
    // Font COURIER = new Font("SansSerif", Font.BOLD, 22);

    // JButton button4;
    // JButton button5;


    private Clicklistener click = new Clicklistener();
    private JButton buy = new JButton("BUY");
    private JButton pass = new JButton("PASS");
    private JButton sell = new JButton("SELL");
    private JButton build = new JButton("BUILD");
    private JButton pay = new JButton("PAY FINE");
    private JButton dice = new JButton("TROW DICE");
    private JButton card = new JButton("USE CARD");
    private Player player;

    private Monopoly monopoly = GameMain.monopoly;

    // private  JPanel gridPanel;
    // private JPanel playersPanel;


    private PanelMonopoly main;

    private int skip = 0;
    public MonopolyCommandsPanel(PanelMonopoly maina, Player playerx  ){
        super();
        this.player = playerx;
        main = maina;

        FlowLayout layout  = new FlowLayout(FlowLayout.CENTER,50,20 );
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        setBackground(GameMain.SFONDO);

        setBorder(GameMain. BLACKLINE);
        setLayout(layout);
        setFont(GameMain.COURIER);




        if(main.getFase() == 0){
            trowDice();
            
        } else if( main.getFase() == 1){
            propertySquareOwned();
        }


        // while (skip == 0){

        //     trowDice();
        //     main.refreshplayerStats();



        //     skip =1;
        // }


        buy.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent arg){

                    


            }


        });


        sell.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent arg){




            }


        });


        pass.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent arg){




            }


        });

        build.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent arg){




            }


        });

        pay.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent arg){




            }


        });


        dice.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent arg){


            monopoly.throwDice();
            monopoly.setPositionPlayer(player);

            System.out.println("SI FUNZ " + monopoly.getListOfPlayer().get(0).getPosition());
            main.nextPage();
            main.incrementFase();
            

            // dice.addActionListener(click);
            // close();         
            }


        });


        card.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent arg){




            }


        });



        





        setVisible(true);




        


    }

    public void close(){
       removeAll();
    }



    public void trowDice(){

        
        


        dice.setPreferredSize(dim);

        this.add(dice);


         
    }


    public void propertySquareEMPTY(){
            
           
            buy.setPreferredSize(dim);

           
            pass.setPreferredSize(dim);

 


            this.add(buy);
            this.add(pass);
    
    }


    public void propertySquareOwned(){
            
            sell.setPreferredSize(dim);

            
            build.setPreferredSize(dim);

     
            pass.setPreferredSize(dim);

            this.add(sell);
            this.add(build);
            this.add(pass);

    }



    public void emptySquare(){
         
            pass.setPreferredSize(dim);
        
            this.add(pass);

    }


    public void jailSquare(){

        pay.setPreferredSize(dim);

        dice.setPreferredSize(dim);


        card.setPreferredSize(dim);


        
        pass.setPreferredSize(dim);


        this.add(pay);
        this.add(dice);
        this.add(card);
        this.add(pass);


    }


    public void goToJailSquare(){

        pass.setPreferredSize(dim);

        this.add(pass);

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        // if (e.getSource() == dice)
        // {
        //   this.removeAll();
        //   setVisible(false);
        //   System.out.println("arrivo fino a qua ");
        // }
        
    }


    private class Clicklistener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == dice)
      {
        System.out.println("sono finoa  quaaawdaa");
        // close();
      }
      
      
    }
  }
}





