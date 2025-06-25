package Lecture8;

import javax.swing.*;
import java.awt.*;

public class Component_Properties_Example {
    public static void main(String[] args){
        JFrame frame = new JFrame("Component Properties Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLayout(null);  // Using null for manually positioning

        JLabel label = new JLabel("Hello, GUI!");
        label.setBounds(50,50,200,30);                // Set positioning and Size
        label.setForeground(Color.blue);                                // Set foreground color
        label.setBackground(Color.LIGHT_GRAY);                          // Set background color
        label.setOpaque(true);                                          // Make Background Visible
        label.setFont(new Font("Serif", Font.BOLD, 20));     // Set Font
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));                // Set Cursor
        frame.add(label);

        JTextField textField = new JTextField("Edible Text");
        textField.setBounds(50,100,150,25);
        textField.setEnabled(true);                                     // Enable the text field
        textField.setVisible(true);                                     // Make visible
        frame.add(textField);

        frame.setVisible(true);
    }
}
