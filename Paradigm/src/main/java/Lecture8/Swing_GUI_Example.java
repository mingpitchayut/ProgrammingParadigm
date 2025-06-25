package Lecture8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_GUI_Example {
    public static void main(String[] args){
        // Create a Swing JFrame
        JFrame frame = new JFrame("Swing Frame Example");
        frame.setSize(400, 200); // Set Frame Size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the content pane and set its layout
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout()); // Use FlowLayout

        // Create a Swing JButton
        JButton button = new JButton("Click me Swing!");
        contentPane.add(button);    // Add button to the content pane

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Swing Button Clicked!");
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
