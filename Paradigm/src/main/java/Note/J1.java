/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// package Note;

/**
 *
 * @author MUIC-1409
 */
public class J1{
    public static void main(String[] args){ 
        // Print String
        System.out.println("Hello World!");
        System.out.println("I am learning Java");
        System.out.println("It's not fun at all!");
        
        // Print Numbers
        System.out.println(3);
        System.out.println(456);
        System.out.println(78910);
        
        // Mathematical Calculations inside println()
        System.out.println(1+1);
        System.out.println(1+1==0); // Boolean
        System.out.println(7*4);
        
        // Here is the comment 
        
        // What about multi line comments?
        
        /*
        This
        is
        multi-line
        comments
        */
        
        // Variable Delaration --> String,int, float, char, boolean
     // type variableName = value;
        String name = "Ming";
        System.out.println(name);
        
        int number = 12;
        System.out.println(number);
        
        number = 18;
        System.out.println(number);     // Been changed
        
        // Other types
        int mynum = 5;
        float myfloat = 5.99f;
        char myletter = 'A';
        boolean myBoo = true;
        String myText = "Hehe";
        
        // Print variables
        String firstname = "Pitchayut";
        String lastname = "Ming";
        String fullname = firstname + lastname;
        System.out.println(firstname + lastname);
        System.out.println(fullname);
        
        int x = 2;
        int y = 3;
        System.out.println(x+y);
       
        // Declare many variables
        int x1= 5, y1 = 7, z1 = 1;
        System.out.println(x1+y1+z1);
        
        // Example of handling different data types
        int items = 50;
        float costPerItem = 9.99f;
        float totalCost = items * costPerItem;
        char currency = '$';
        
        System.out.println("Number of items : " + items);
        System.out.println("Cost Per Item : " + costPerItem);
        System.out.println("Total Cost = " + totalCost + currency);
       
    }
}