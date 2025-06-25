package Ex1_6680741;

import java.util.*; // import Scanner

/**
 *
 * @author Pitchayut Boonporn 6680741
 */
public class NewMain {
    // Main
    public static void main(String[] args){
        // Implement scanner as scan
        Scanner scan = new Scanner(System.in);
        
        boolean check = true;
        // Start iteration 
        while (check == true){
            // print out "Enter N = " and then keep it as N (using scan.nextInt())
            System.out.println("Enter N (0 or Negative to quit) = "); int N = scan.nextInt();
        
            if (N <= 0) {
                System.out.println("\nThank You!");
                check = false;
            }
            else {
                // Use calculate(N) fucntion
                System.out.printf("Estimated PI = %f \n\n", calculate(N));
            }
        }
        
        
    }
    
    public static double calculate(int N){
        int hits = 0;
        for (int i = 0; i < N; i++){
            double x = Math.random();
            double y = Math.random();
            if ( (x*x + y*y) <= 1 ) hits++;
        }
        
        double pi = 4.0 * hits/N;
        return pi;
    }
}