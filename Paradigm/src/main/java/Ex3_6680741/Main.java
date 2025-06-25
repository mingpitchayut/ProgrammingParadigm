/*
Members : 
Pitchayut Boonporn 6680741
Napat Wanavejkul 6680024
 */

package Ex3_6680741;

import java.util.*;
//import java.io.*;

public class Main {
    public static void main(String[] args){
        
        // Get Input
        Scanner txtScan = new Scanner(System.in);
        
        System.out.print("Enter the number of users : ");
        int no_user = txtScan.nextInt();
        System.out.println("The number of users is now set to " + no_user + "\n");
        
        /*
        
        Requirements : 
         
            Random rand = new Random();     
            int x = rand.nextInt(0,100);            // Random int from 0-99
            double y = rand.nextDouble(0,100);      // Random Double from 0-99 
            boolean z = rand.nextBoolean();         // Random Bool

            1. Type of customer : 
            2. ID (runs on 1, 2, 3, ...)
            3. For Human Customer -> random spa options and set at least 1 to TRUE
            4. For Cat Customer -> random weight (a double 3-20 kg) and hair type
        */
        
        
        // Create an array with random attributes
        
        Random rand = new Random();
        Customer[] users = new Customer[no_user];       // Allocate
        
        for (int i = 0; i < no_user; i++){
            int customerType = rand.nextInt(0,2);       // Random int from 0-1 (Human : 0, Cat : 1)
            
            // Case 0 : Human 
            if (customerType == 0) {
                boolean[] spa = new boolean[4];         // [face, body, hand, foot]
                int trueCount = 0;
                for (int j = 0; j < 4; j++){
                    spa[j] = rand.nextBoolean();        // eg. [true, true, false, false]
                    if (spa[j] == true) trueCount++;
                }
                
                // Case trueCount = 0 :
                if (trueCount == 0){
                    int rand1_4 = rand.nextInt(1,5);    // random 1-4
                    spa[rand1_4] = true;
                }
                
                // Save in HumanCustomer
                users[i] = new HumanCustomer(i, spa);
            }
            // Case 1 : Cat
            else {  
                double weight = rand.nextDouble(3,21);  // Random 3-20
                int hairType = rand.nextInt(0,2);      // Random 0-1   : 0 -> Short hair, 1 -> Long hair
                
                // Save in CatCustomer
                users[i] = new CatCustomer(i, weight, hairType);
            }
        }
        
        // Print all customers in Reverse order
        int i;
        System.out.println("=== All Customers in Reverse Order ===");
        for (i = no_user-1; i >= 0; i--){
            users[i].printCustomer();
        }
        
        // Print human customers' total price
        System.out.println("\n=== Human Customer ===");
        for (i = 0; i < no_user; i++){
            if (users[i] instanceof HumanCustomer){
                users[i].calculatePrice();
            }
        }
        
        // Print cat customers' total price
        System.out.println("\n=== Cat Customer ===");
        for (i = 0; i < no_user; i++){
            if (users[i] instanceof CatCustomer){
                users[i].calculatePrice();
            }
        }
        
    }
}

