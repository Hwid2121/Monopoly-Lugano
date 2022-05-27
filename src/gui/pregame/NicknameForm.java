package gui.pregame;

import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.colorchooser.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.text.LabelView;

import gui.main.GameMain;
import model.Monopoly;

import java.awt.Color;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.prefs.BackingStoreException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.image.BufferedImage;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import java.awt.TextField;

public class NicknameForm extends JPanel {

    private JTextField textField;

    public NicknameForm(int i) {

        setBackground(GameMain.SFONDO);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        setLayout(layout);

        JLabel label = new JLabel("Player " + i + ": ");
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setForeground(GameMain.CREMISI);
        // label.setPreferredSize(new Dimension(50,40));

        c.gridx = 1;
        c.gridy = 0;
        // c.weightx = 0.1;
        add(label, c);

        textField = new JTextField();

        textField.setMinimumSize(new Dimension(100, 40));
        textField.setPreferredSize(new Dimension(100, 40));
        textField.setFont(new Font("SansSerif", Font.BOLD, 22));
        textField.setForeground(GameMain.CREMISI);
        textField.setBackground(Color.white);

        c.gridx = 2;
        c.gridy = 0;
        // c.gridwidth = 2;
        // c.weightx = 5;
        add(textField, c);

        setVisible(true);

    }

    public String getFieldText() {
        return this.textField.getText();
    }

}
