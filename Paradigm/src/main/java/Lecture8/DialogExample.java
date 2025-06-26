package Lecture8

// Dialog Java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog_Example {
    public static void main(String[] args){
        JFrame frame = new JFrame("Main App Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JButton showDialogButton = new JFrame("Show Modal Dialog");
        frame.add(showDialogButton);

        showDialogButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // Create a modal JDialog
                JDialog dialog = new JDialog(frame, "Modal Dialog", true);  // true makes it modal
                dialog.setSize(300, 150);
                dialog.setLayout(new FlowLayout());
                dialog.add(new JLabel("This is a modal dialog. You can't interact with the main frame."));
                dialog.setLocationRelativeTo(frame);    // Center dialog relative to frame
                dialog.setVisible(true);
            }
        });

        frame.setVisible(true);

    }
}