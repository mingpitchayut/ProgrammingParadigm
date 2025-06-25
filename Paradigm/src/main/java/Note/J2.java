/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// package Note;

/**
 *
 * @author MUIC-1409
 */
public class J2 {
    public static void main(String[] args){
        /*
        There are 2 Java Casting Types
            1. Widening Casting (Automatically) - converting a smaller type to a larger type size
                byte -> short -> char -> int -> long -> float -> double
            
            2. Narrowing Casting (Manually) - converting a larger type to a smaller size type
                double -> float -> long -> int -> char -> short -> byte
        
        */
        
        // Widening Casting
        int myInt = 9;
        double myDouble = myInt; // Automatically casting: int to double
        
        System.out.println(myInt);
        System.out.println(myDouble);
        
        // Narrowing Casting
        double myDouble1 = 9.78d;
        int myInt1 = (int) myDouble1; // Manually casting: double to int
        
        System.out.println(myDouble1);  // Output : 9.78
        System.out.println(myInt1);     // Output : 9
        
        // Real Life Example
        int maxScore = 500;
        int userScore = 499;
        
        float percentage = (float) userScore / maxScore * 100.0f;
        System.out.println("User's percentage is " + percentage);
        
        
        
        // Java Assignment Operators
        int x = 10;
        x += 5;
        System.out.println(x);
        
        // Strings
        String greeting = "Hello";
        
        // length() method
        String txt = "ABCDEFG";
        System.out.println("The length of the txt string is : " + txt.length());
        
        // More String Methods : toUpperCase() and toLowerCase()
        txt = "Hello World!";
        System.out.println(txt.toUpperCase());
        System.out.println(txt.toLowerCase());
        
        // Finding a Character in a String
        
        // indexOf() method
        String text = "Please tell me where 'Ming' occurs!";
        System.out.println(text.indexOf("Ming"));       // Output 22
        System.out.println("I na hee".indexOf("na"));   // Output 2
        
        // String Concatenation (+)
        String firstName = "Pitchayut";
        String lastName = "Ming";
        System.out.println(firstName + " " + lastName);
        
        // Or we can use concat() method to concatenate 2 strings
        System.out.println(firstName.concat(" " + lastName));
        System.out.println(firstName.concat(lastName)); // Attached

        
        
        // Java Numbers and Strings
        
        // We can add numbers and strings altogether
        String x2 = "10";
        int y2 = 20;
        String z2 = x2+y2;
        System.out.println(z2); // Output : 1020
        
        // Strings - Special Characters
        String txt1 = "We are the so-called \"Ming\" from MUIC";
        System.out.println(txt1);
        
        txt1 = "We are the so-called \'Ming\' from MUIC";
        System.out.println(txt1);
        
        
    }
}
