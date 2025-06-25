// Members :
// 1. Pitchayut Boonporn 6680741

package Ex6_6680741;
import java.util.*;
import java.io.*;

public class FactorThread extends Thread {
    private PrintWriter out;
    private ArrayList<Integer> allPrimes;
    private int target;

    // Constructor
    public FactorThread(String name, int targetPrimes){
        super(name);
        this.target = targetPrimes;
        this.allPrimes = new ArrayList<Integer>();
    }

    // Overridden run()
    public void run(){
        /*
            Create PrintWriter object to write result to a separate file

            Execute steps 1-3 in loop until #primes = target:
            1.   Random a value v in range [100, 500] and find all its positive factors
                  (i.e. Integers that divide it with 0 remainder)
            2.   If v is a prime : print round number, v, current #primes to file as in demo
            3.   If v is not a prime : print round number, v, its factors to file as in demo

            After the loop, print thread name, #rounds, all primes (sorted in increasing order)
            to the screen
        */

        try {
            // Get the thread's name
            String threadName = Thread.currentThread().getName();
            // Create a PrintWriter object
            String path = "src/main/java/Ex6_6680741/";
            out = new PrintWriter(path + threadName + ".txt");

            int roundsCompleted = 0;
            int primesFoundByThisThread = 0;
            Random random = new Random();       // For gen random numbers

            while (primesFoundByThisThread < target){
                roundsCompleted++;
                int randomizedNumber = random.nextInt(100,501);        // Gen from 100-500

                out.printf("Round : %2d >> %d", roundsCompleted, randomizedNumber);

                // Case 1: randomizedNumber is prime
                if (isPrime(randomizedNumber)){
                    primesFoundByThisThread++;              //++numberOfPrimes
                    allPrimes.add(randomizedNumber);        // Add (primeNumber) to ArrayList allPrimes<>
                    out.printf(" = prime %12s = %s\n", "#primes", primesFoundByThisThread);   // save the amount of primes
                }
                // Case 2: randomizedNumber is not a prime
                else {
                    ArrayList<Integer> factorsArrayL = getFactors(randomizedNumber);
                    out.printf(" %20s = %s \n", "factors" ,factorsArrayL);
                }
            }
            // Close the out (PrintWriter object)
            out.close();

            // Sort primes (increasing by default)
            Collections.sort(allPrimes);

            // Print out (Sys.out) to the screen
            System.out.printf("Thread " + threadName + " finishes in %3d rounds,  primes = %s \n", roundsCompleted, allPrimes);

        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    // Helper Methods

    // isPrime(num) method
    private boolean isPrime(int num){
        if (num <= 1) return false;
        // Check square root of num
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;     // if num can be divisible by i (2,3,4,...), it means that it can't be a "Prime"
        }
        return true;
    }

    // getFactors(num) method
    private ArrayList<Integer> getFactors(int num){
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 1; i<= num; i++){
            if (num % i == 0) factors.add(i);
        }
        return factors;
    }

}
