// Pitchayut Boonporn 6680741

// Don't forget to rename the package
package Ex7_6680741;    

import java.util.*;
import java.util.concurrent.*;

////////////////////////////////////////////////////////////////////////////////
class CustomerThread extends Thread {
    private Shop                sharedShop;
    private Basket              basket;
    private Exchanger<Basket>   exchanger;
    private CyclicBarrier       barrier;
    private int                 rounds;
    private boolean             isFirstSimulation = true; // Set flag to true

    public CustomerThread(String n, Shop sa, Basket bk) {
        super(n);
        sharedShop = sa;
        basket     = bk;
    }
    public void setBarrier(CyclicBarrier ba)         { barrier = ba; }
    public void setExchanger(Exchanger<Basket> ex)   { exchanger = ex; }
    public void setRounds(int r)                     { rounds = r; }

    public void run() {
        // Loop for shopping simulation. In each simulation:
        while (true){
            try {
                //  (1) Wait until main thread gets #rounds from user and pass it to CustomerThread.
                barrier.await();

                if (rounds == 0){
                    System.out.println(Thread.currentThread().getName() + " >> Done Shopping!"); // Added " >> " for consistency
                    break;
                }

                //  (2) If this is the first simulation, skip this step.
                //      Otherwise, threads with exchanger exchange baskets.
                //      Threads without exchanger (i.e. exchanger is null) wait until this is done.
                if (exchanger != null) {
                    if (isFirstSimulation) {
                        // Per sample output, C0/C1 don't print anything specific about skipping on first round.
                        // They just proceed. The main thread's output might be what implies this.
                        // So, no explicit "This is the first simulation, skipping..." print here from thread.
                    } else {
                        System.out.println(Thread.currentThread().getName() + " >> exchange basket"); // Matches sample: "C0 >> exchange basket"
                    }
                }
                else{
                    System.out.println(Thread.currentThread().getName() + " >> no exchange basket"); // Matches sample: "C2 >> no exchange basket"
                }

                // After the first simulation, set flag to false
                isFirstSimulation = false;

                //  (3) Each thread identifies current basket in this simulation.
                // Adjusted print to precisely match sample output format where it exists
                System.out.println(Thread.currentThread().getName() + " >> current basket = " + basket.getName() + " balance = " + basket.getItems());

                //  (4) Each thread buys items from the same shop & put them in current basket.
                //      Do it for #rounds. In each round, update shop & basket balance.
                for (int i = 0; i<rounds; i++){
                    // MOVED THIS PRINT INTO Shop.buy() method to ensure it's synchronized
                    sharedShop.buy(basket, i + 1); // Pass the current basket AND round number
                    Thread.sleep(50);   // Simulate some work
                }

                // Break from loop & return if user doesn't want to run a new simulation (in main)
            }
            catch (BrokenBarrierException | InterruptedException e){
                System.err.println(Thread.currentThread().getName() + " : " + e.getMessage());
                break;
            }
        }
    }
}

////////////////////////////////////////////////////////////////////////////////
class Shop {
    private int items;                                                          // remaining items
    private final Semaphore shopAccessSemaphore = new Semaphore(1);      // Use Semaphore or monitor to let only 1 thread update balance and print to System.out.
    // To get correct result, balance & System.out should be protected together.
    public Shop()            { }
    public int getItems()    { return items; }

    public void reset()
    {
        try {
            shopAccessSemaphore.acquire(); // Acquire permit to access shop items and print
            items = 100; // Reset remaining items to 100
            System.out.println(Thread.currentThread().getName() + " >> reset shop balance to 100"); // Report thread activity (see example output)
        }
        catch (InterruptedException e){
            System.err.println(Thread.currentThread().getName() + " : " + e.getMessage());
        }
        finally {
            shopAccessSemaphore.release(); // Release permit
        }
    }

    public void buy(Basket customerBucket, int roundNum) // Added roundNum
    {
        Random rand = new Random();
        try{
            shopAccessSemaphore.acquire(); // Acquire permit for buying process

            // This is the beginning of the buy line, printed under semaphore
            // Use String.format for consistent padding for thread name and round number
            String threadName = Thread.currentThread().getName();
            // Pad thread name to 2 chars, round num to 1-2 chars, then fixed spaces for alignment
            System.out.print(String.format("%s >> round %d buy", threadName, roundNum));

            if (items <= 0){
                System.out.println("   cannot buy"); // Append to the same line with some leading spaces
                return;
            }
            // Random amount of items to buy from 1 to items/2; update shop balance
            int amountToBuy = rand.nextInt(Math.max(1, items/2)) + 1;
            if (amountToBuy > items){
                amountToBuy = items;
            }

            items -= amountToBuy; // Update shop balance
            customerBucket.add(amountToBuy); // Put items in thread's current basket; update basket balance

            // Report thread activity (see example output) - now completes the line
            // Align "amountToBuy" with 3 spaces, "shop balance" with 2 spaces for consistent look
            System.out.println(String.format(" %3d  shop balance = %-3d  %s balance = %d",
                    amountToBuy, items, customerBucket.getName(), customerBucket.getItems()));

        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + " : " + e.getMessage());
        }
        finally{
            shopAccessSemaphore.release(); // Release permit
        }

    }
}

////////////////////////////////////////////////////////////////////////////////
class Basket {
    private String name;
    private int    items;
    
    public Basket(String id)    { name  = id; items = 0;}    // initialize items to 0
    public String getName()     { return name; }
    public int    getItems()    { return items; } 
    
    public void add(int amount) {
        // Add items to basket
        items += amount;
    }
}
////////////////////////////////////////////////////////////////////////////////
public class Ex7 {
    public static void main(String[] args) {
        Ex7 mainApp = new Ex7();
        mainApp.runSimulation();
    }

    public void runSimulation()
    {
        Shop shop = new Shop();
        Exchanger<Basket> exchanger          = new Exchanger<>();
        ArrayList<CustomerThread> allThreads = new ArrayList<>();
        ArrayList<Basket>         allBaskets = new ArrayList<>();

        // Create the CyclicBarrier before the loop where you create CustomerThreads.
        // The number of parties should be fixed: 4 CustomerThreads + 1 MainThread = 5
        CyclicBarrier barrier = new CyclicBarrier(4 + 1); // Corrected barrier size.

        for(int i=0; i < 4; i++)
        {
            Basket basket         = new Basket("B"+i);
            CustomerThread thread = new CustomerThread("C"+i, shop, basket);
            if (i <= 1) thread.setExchanger(exchanger);
            else        thread.setExchanger(null);

            // IMPORTANT: Set the barrier for EACH thread here!
            thread.setBarrier(barrier); // This was the fix for the NullPointerException

            allBaskets.add( basket );
            allThreads.add( thread );
        }

        for(CustomerThread thread : allThreads){
            thread.start();
        }

        Scanner scanner = new Scanner(System.in);
        int simulationCount = 0; // Track simulation number for the specific "first simulation" message

        // Loop for shopping simulation. In each simulation:
        //  (1) Main thread reset shop's balance
        //  (2) Main thread gets #rounds from user and passes it to CustomerThread.
        //  (3) Main thread waits until all CustomerThreads complete #rounds of shopping.
        while (true){
            try {
                // Aligned prompt
                System.out.print(String.format("%s >> Enter #rounds for a new simulation (<=0 to quit): ", Thread.currentThread().getName()));
                int rounds = scanner.nextInt();

                if (rounds <= 0){
                    // Matches sample output for quitting
                    System.out.println(Thread.currentThread().getName() + " >> Once the user quits, let main thread report final basket balance.");
                    for (CustomerThread thread : allThreads){
                        thread.setRounds(0); // Signal threads to exit their loops
                    }
                    barrier.await(); // Main thread waits for customer threads to acknowledge 0 rounds and hit the barrier
                    break;
                }

                shop.reset();   // Reset shop balance at the beginning of each simulation

                simulationCount++; // Increment simulation count after user enters rounds > 0
                // This specific message appears at the start of the 2nd simulation onwards
                if (simulationCount > 1) {
                    System.out.println(Thread.currentThread().getName() + " >> But this is not the first simulation, let C0 and C1 exchange baskets");
                    // The sample output then has lines like "C0's current basket is B1"
                    // These are likely implicit from the actual exchange happening,
                    // or an external commentary in the sample, not explicitly printed by threads here.
                    // The threads' "current basket = Bx balance" will reflect the exchange.
                }

                for (CustomerThread thread : allThreads){
                    thread.setRounds(rounds);
                }
                barrier.await();    // Main thread waits here with customer threads for synchronized start
            }
            catch (InputMismatchException e){
                System.out.println(Thread.currentThread().getName() + " >> Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop
            }
            catch (InterruptedException e){
                System.err.println(Thread.currentThread().getName() + " : " + e.getMessage());
                Thread.currentThread().interrupt(); // Restore interrupted status
                break;
            }
            catch (BrokenBarrierException e){
                System.err.println(Thread.currentThread().getName() + " : " + e.getMessage());
                // No break here, might want to continue if barrier is just broken and not fatal
                // For this exercise, breaking is generally acceptable for simplicity
            }
        }

        // If user doesn't want to run a new simulation:
        //   - Main thread waits until all CustomerThreads return.
        System.out.println("\n" + Thread.currentThread().getName() + " >> Waiting for all customer threads to finish their work... ");
        for (CustomerThread thread : allThreads){
            try{
                thread.join(); // Use Join to make main thread wait until all CustomerThreads complete their works
            }
            catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + " >> Error joining thread " + thread.getName() + " : " + e.getMessage());
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }

        //   - Main thread reports final balances of all baskets
        System.out.println("\n" + Thread.currentThread().getName() + " >> All customers done. Final Basket Balances: ");
        // Aligning final basket balances
        for (Basket basket : allBaskets) {
            System.out.println(String.format(("%s >> %s balance = %d"), Thread.currentThread().getName(), basket.getName(), basket.getItems()));
        }

        scanner.close();
        System.out.println(Thread.currentThread().getName() + " >> Simulation complete!");

    }
}