package Note;

public class J6_Classes {
    // These are the attributes in this class
    int x = 5;      
    int y = 2;
    
    // In case we don't want it to be modified, we use : "final" 
    final int z = 3;
    
    // Multiple Attributes 
    String fname = "Ming";
    String lname = "lovepoly";
    int age = 20;
    
    /*
    Other than that, 
        We can insert a method(function) in a class,
            so we can access and use a method from a class as well
    */
    public void myMethod(){
        System.out.println("Hello " + fname);
    }
    
    /*
    Static vs Public
        Static method - it can be accessed without creating an object of the class
        Public method - it can only be accessed by objects
    */
    
    static void myStaticMethod(){
        System.out.println("Static Methods can be called without creating objects!");
    }
    
    public void myPublicMethod(){
        System.out.println("Public Methods must be called by creating objects");
    }
    
    // Below are the example of using public method : Ex1
    public void fullThrottle(){
        System.out.println("This car is going as fast as it can!");
    }
    public void speed(int maxSpeed){
        System.out.println("Max Speed is : " + maxSpeed);
    }
    
    // Class Constructor
    public J6_Classes(){
        System.out.println("Constructor is being called here!");
    }
    
    
    
}



