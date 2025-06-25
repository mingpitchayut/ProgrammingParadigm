/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Note;

/**
 *
 * @author HP
 */
public class J5_JavaMethod {
    public static void main(String[] args){
        /*
        A method is a block of code which only runs when it is called.
        You can pass data, known as parameters, into a method.
        Methods are used to perform certain actions, and they are also known as **Function**
        */
        myMethod();
        
        printName("Minggykayeejai");
        printName("PolyloveMingy");
        
        sum(1.5 , 4.214);
        
        checkAge(20);
        checkAge(2);
        
        System.out.println("The sum2 is : " + sum2(2,5));
        
        System.out.println(myMethod(5));
        System.out.println(myMethod(5.5584));
        System.out.println(myMethod(5,6));
        
        System.out.println(plusMethod(5,6));
        System.out.println(plusMethod(5.5 , 6.6));
        
        // Java Scope
        // 1 : Method Scope - inside method where they were declared
        // 2 : Block Scope - use "{}" to declare scoped variables which is accessible by the inside code
        int x = 100;
        System.out.println("This number is declared in method scope : " + x);
        
        {
            int y = 1000;
            System.out.println("This number is declared in Block scope : " + y);
        }
        // You can't access to y --> System.out.println(y);
        
        
        // Recursion 
        double result = sum(10);
        System.out.println(result);
    
    
    }
    
    // To create a method
    static void myMethod(){
    // static - the method belongs to the Main class
    // void - no return value
        System.out.println("Congrats! I have successfully created my own first method!");
    }
    
    // Parameters (inside the parenthesis)
    static void printName(String name){
        System.out.println("My name is " + name);
    }
    
    // Multiple Parameters
    static void sum(double a, double b){
        double sum = a+b;
        System.out.println("Sum = " + sum);
    }
    
    // A method with If...Else
    static void checkAge(int age){
        if (age < 18){
            System.out.println("Access Denied - You are not old enough!");
        }
        else System.out.println("Access Granted - You are welcome!");
    }
    
    // Return : 
    // static int function(parameters){}
    // static float function(parameters){}
    // static bool function(parameters){}
    static int sum2(int a, int b){
        return a+b;
    }
    
    // Method Overloading : multple methods can have the same name with **different parameters**
    static int myMethod(int x){return x;}
    static double myMethod(double y){return y;}
    static double myMethod(double x, double y){return x+y;}
    
    // More example of overloading methods
    // Ex1 : two methods that add numbers of different type
    static int plusMethod(int x, int y){
        return x+y;
    }
    
    static double plusMethod(double x, double y){
        return x+y;
    }
    
    
    // Recursion
    public static double sum(double k){
        if (k > 0){
            return k + sum(k-1);
        }
        else return 0;
    }
    
    
    
    
    
}
