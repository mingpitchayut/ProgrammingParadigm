package Note;

import static Note.J6_Classes.myStaticMethod;

public class J6_Main {
    public static void main(String[] args){
        /*
        OOP - Object Oriented Programming
            - Meaning that we create objects that contain both data and methods
        
        Class -> Fruit
        Objects -> Apple, Mango, Banana, etc.
        */
        
        
        J6_Classes myObj1 = new J6_Classes();   // Object 1
        J6_Classes myObj2 = new J6_Classes();   // Object 2
        
        // This is the way we access attributes in classes :
        System.out.println(myObj1.x);
        System.out.println(myObj2.y + myObj1.x);
        
        // We can modify the attribute in a class
        myObj1.x = 40;
        System.out.println(myObj1.x);
        
        // myObj1.z = 500;      <- "You will see that this could not be implemented because of the 'final' declaration"
        
        
        // Print out name and age in a class
        System.out.println("Name : " + myObj1.fname + " " + myObj1.lname);
        System.out.println("Age : " + myObj1.age);
        
        myObj1.myMethod();
        
        // Static vs Public Methods
        myStaticMethod();
        // myPublicMethod();    -> this will create an error
        
        J6_Classes myObj = new J6_Classes();
        myObj.myPublicMethod(); // We need to create an object first and then use "." to access the function
        
        // Ex1 : J6_Classes
        System.out.println("Ex1 : myCar object --------------");
        
        J6_Classes myCar = new J6_Classes();    // Create a myCar object
        myCar.fullThrottle();                   // Call the fullThrottle() method
        myCar.speed(150);                       // Call the speed() method
        
        System.out.println("---------------------------------");
        
        // Now, we better move to the "Java Constructor"
        // It is a special method to initialize objects.
        // It is called when an object of a class is created
        
        
        
    }
}


