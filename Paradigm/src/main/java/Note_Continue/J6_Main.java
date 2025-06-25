package Note_Continue;

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
    }
}
