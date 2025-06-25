/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex3_6680741;

// Customer Class : This class must not be changed!
public class Customer{
    int ID;
    protected int totalPrice;
    public Customer(int id) { ID = id;}         // Constructor
    public int getID() { return ID; }
    public void printCustomer() { /* override this in child class */ }
    public void calculatePrice() { /* override this in child class */ }
    
}




