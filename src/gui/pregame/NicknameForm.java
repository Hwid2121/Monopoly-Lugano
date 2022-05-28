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

public class NicknameForm extends JPanel {

    private JTextField textField;

    public NicknameForm(int i) {
        super();

        setBackground(GameMain.SFONDO);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        setLayout(layout);

        JLabel label = new JLabel("Player " + i + ": ");
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setForeground(GameMain.CREMISI);

        c.gridx = 1;
        c.gridy = 0;
        add(label, c);

        textField = new JTextField();

        textField.setMinimumSize(new Dimension(100, 40));
        textField.setPreferredSize(new Dimension(100, 40));
        textField.setFont(new Font("SansSerif", Font.BOLD, 22));
        textField.setForeground(GameMain.CREMISI);
        textField.setBackground(Color.white);

        c.gridx = 2;
        c.gridy = 0;

        add(textField, c);

        setVisible(true);

    }

    public String getFieldText() {
        return this.textField.getText();
    }

}
