package gui;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import gui.main.GameMain;
import model.Dice;

import java.awt.Font;

public class DicePanel extends JPanel implements ActionListener {

    private JLabel dicenum;
    private JLabel die;
    private DiceFrame parenta;
    private JButton button;
    private Dice dice;
    private Font s = new Font("SansSerif", Font.BOLD, 14);

    private FlowLayout lay = new FlowLayout(FlowLayout.CENTER, 15, 50);

    public DicePanel(DiceFrame buc, Dice dic) {

        super();
        parenta = buc;

        dice = dic;

        setLayout(lay);

        dicenum = new JLabel("Dice TOT: " + dice.getDice());

        die = new JLabel("DIE 1: " + dice.getDie1() + "     DIE 2: " + dice.getDie2());

        dicenum.setFont(s);
        die.setFont(s);
        setBackground(GameMain.SFONDO);

        button = new JButton("CONTINUE");
        button.setForeground(GameMain.CREMISI);
        button.setFont(s);
        add(dicenum);
        add(die);

        add(button);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                parenta.dispose();

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

}
