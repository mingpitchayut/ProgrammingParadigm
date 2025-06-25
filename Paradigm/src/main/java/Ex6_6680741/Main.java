// Members :
// 1. Pitchayut Boonporn 6680741

package Ex6_6680741;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try {
            // Set Up Scanner
            Scanner scanner = new Scanner(System.in);

            System.out.print("Target #primes = ");
            int targetPrimes = scanner.nextInt();

            System.out.print("Number of Threads = ");
            int numberOfThreads = scanner.nextInt();

            // Close Scanner
            scanner.close();

            ArrayList<FactorThread> factorThreadArrayList = new ArrayList<FactorThread>();
            for (int i = 0; i<numberOfThreads; i++){
                FactorThread T = new FactorThread("T" + i, targetPrimes);
                factorThreadArrayList.add(T);
                T.start();
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
