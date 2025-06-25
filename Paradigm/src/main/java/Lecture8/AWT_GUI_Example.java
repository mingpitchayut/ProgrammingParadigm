package Lecture8;
// Java supports 2 GUI toolkits : AWT and Swing
// This class will teach you about AWT(Abstract Windowing Toolkit)

/*
AWT (Abstract Windowing Toolkit): This is Java's original GUI toolkit.
    AWT components are "heavyweight," meaning they rely on the underlying operating system's (OS) native GUI components.
    This can lead to different looks and behaviors across various operating systems
*/

// Core Concept :
        // GUI applications are event-driven, meaning they respond to user actions (events)
        // such as button clicks, mouse movements, or keyboard input.

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWT_GUI_Example{
    public static void main(String[] args){
        // Create an AWT frame
        Frame frame = new Frame("AWT Frame Example ");
        frame.setSize(400,150); // Set Frame Size
        frame.setLayout(new FlowLayout());  // Set Layout Manager

        // Create an AWT button
        Button button = new Button("Click Me AWT!");
        frame.add(button);  // Add buton to the frame

        // Make the frame visible
        frame.setVisible(true);

        // Add a WindowListener to handle the close button
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

}
