package gui;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Formpanel where inset nickname.
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class FormPanel extends JPanel {

    private JTextField textField;
    private final NumPlayerFrame framea;
    private final PanelPregame frameb;
    private JButton button;

    /**
     * Construcotr of the frame FormPanel.
     * 
     * @param frameB the parent of the parent frame
     * @param frameA the parent frame
     */
    public FormPanel(PanelPregame frameB, NumPlayerFrame frameA) {

        super();
        this.frameb = frameB;
        this.framea = frameA;

        FlowLayout lay = new FlowLayout();
        setLayout(lay);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(GameMain.SFONDO);
        button = new JButton("Submit");
        button.setUI(GameMain.BUTTON_STYLE);
        button.setMinimumSize(new Dimension(100, 40));
        button.setPreferredSize(new Dimension(100, 40));

        textField = new JTextField();

        textField.setPreferredSize(new Dimension(50, 40));
        textField.setAlignmentX(CENTER_ALIGNMENT);
        textField.setFont(new Font("SansSerif", Font.BOLD, 22));

        add(textField);
        add(button);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println("number: " + textField.getText());

                String stringField = textField.getText();
                try {

                    int num = Integer.parseInt(stringField);
                    System.out.println("An integer");
                    GameMain.monopoly.setNumOfPlayers(num);
                    framea.dispose();
                    frameb.swapPanel();

                } catch (NumberFormatException error) {
                    
                    textField.setText("");
                }

            }
        });

    }

}