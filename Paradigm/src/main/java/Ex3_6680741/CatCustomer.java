/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex3_6680741;

public class CatCustomer extends Customer{
    //  weight and hair type (short hair or long hair).
    double weight;
    int hairType;
    String hairType_str;
    
    // Constructor
    public CatCustomer(int i, double w, int h){
        super(i);
        weight = w;
        hairType = h;
        // Hair Type in String
        if (hairType == 0) {
            hairType_str = "short";
        }
        else hairType_str = "long";
    }
    
    // printCustomer
    public void printCustomer(){
        System.out.printf("Customer %3d (Cat)   >> Weight = %.1f, Hair = %s \n", ID, weight, hairType_str);
    }
    public void calculatePrice(){
        int price = 0;
        // Case 0 : Short hair
        if (hairType == 0){
            // Weight
            if (weight < 5) price = 600;
            else if (weight <= 10) price = 700;
            else price = 800;
        }
        // Case 1 : Long hair
        else {
            // Weight
            if (weight < 5) price = 750;
            else if (weight <= 10) price = 850;
            else price = 1100;
        }
        System.out.printf("Customer %3d (Cat)   >> Total Price = %d \n", ID, price);
    }
}

