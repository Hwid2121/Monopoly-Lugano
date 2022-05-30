package gui.pregame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.main.GameMain;

import java.awt.Color;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Font;

import java.awt.Dimension;

/**
 * NicknameFOrm where inser the nicknames of the players.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class NicknameForm extends JPanel {

    private JTextField textField;

    public NicknameForm(int indexForm) {
        super();

        setBackground(GameMain.SFONDO);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gridBagLayout = new GridBagConstraints();
        gridBagLayout.fill = GridBagConstraints.HORIZONTAL;

        setLayout(layout);

        JLabel label = new JLabel("Player " + indexForm + ": ");
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setForeground(GameMain.CREMISI);

        gridBagLayout.gridx = 1;
        gridBagLayout.gridy = 0;
        add(label, gridBagLayout);

        textField = new JTextField();

        textField.setMinimumSize(new Dimension(100, 40));
        textField.setPreferredSize(new Dimension(100, 40));
        textField.setFont(new Font("SansSerif", Font.BOLD, 22));
        textField.setForeground(GameMain.CREMISI);
        textField.setBackground(Color.white);

        gridBagLayout.gridx = 2;
        gridBagLayout.gridy = 0;

        add(textField, gridBagLayout);

        setVisible(true);

    }

    public String getFieldText() {
        return this.textField.getText();
    }

}
