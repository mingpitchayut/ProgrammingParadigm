package Note;

/**
 *
 * @author MUIC-1409
 */
public class J3 {
    public static void main(String[] args){
        // Java Math
        
        // Math.max(x,y) & Math.min(x,y)
        int x = Math.max(5, 10);
        System.out.println(x);      // Output : 10
        
        int y = Math.min(1,9);
        System.out.println(y);      // Output : 1
        
        // Math.sqrt(x)
        double z = Math.sqrt(4);                     
        System.out.println(z);      // Output : 2
        
        // Math.abs(x) : Return positive value
        double hehe = Math.abs(-4.6);
        System.out.println(hehe);      // Output : 4
        
        // Math.random() : Return a random number between "0.0" and "1.0"
        System.out.println(Math.random());
        
        int randomNum = (int) (Math.random()*101);      // 0 to 100
        System.out.println(randomNum);
        
        
        
        /*
        Java Conditions and If Statements
            Usual logical conditions from mathematics:
                Less than: a < b
                Less than or equal to: a <= b
                Greater than: a > b
                Greater than or equal to: a >= b
                Equal to a == b
                Not Equal to: a != b
        */
        
        // If-else
        
        if (20>18){
            System.out.println("20 is Greater than 18");
        } 
        
        int time = 22;
        if (time < 10){
            System.out.println("Good Morning");
        } 
        else if (time < 18){
            System.out.println("Good Afternoon");
        }
        else System.out.println("Good Evening");
        
        // Short Hand if...else
        // AKA ternary operator 
        
        time = 20;
        String result = (time < 18) ? "Good Day!" : "Good Evening";     // Just if..else 
        System.out.println(result);
        
        
        
        // Java Switch Statements
       
        int day = 8;
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4: 
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            
            // Default Keyword
            default:
                System.out.println("Error!");
        }
        
        
        // While-loop
        int i = 0;
        while (i<5){
            System.out.println(i);
            i++;
        }
        
        // Do/While Loop
        i = 0;
        do {
            System.out.println(i);
            i++;
        } while(i<5);
        
        // Real-life Examples
        // 1. 
        int countdown = 3;
        while (countdown > 0){
            System.out.println(countdown);
            countdown--;
        }
        System.out.println("Happy New Year!!!");
        
        // 2.
        int dice = 1;
        while (dice <= 6){
            if (dice < 6){
                System.out.println("No Yatzy!");
            }
            else System.out.println("Yatzy!");
            dice += 1;
        }
      
        
        
        // For Loop
        /*
        Statement 1 : executed 1 time before the execution
        Statement 2 : condition
        Statement 3 : executed everytime
        */
        
        for (i = 0; i < 5; i++){
            System.out.println(i);
        }
        
        // For-Each Loop
        /*
        for (type variableName : arrayName) {}
        */

        String[] cars = {"Haval", "BMW", "Toyota"};
        for (String car : cars) {
            System.out.println(car);
        }
        // https://www.w3schools.com/java/java_foreach_loop.asp
        
        // Real-life example
        // printing out even numbers from 0-10
        for (i=0; i<=10; i+=2){
            System.out.println(i);
        }



        // Java Break
        //      - it is used for jumping out of a loop, switch, etc.
        for (i = 0; i<10; i++){
            if (i==4) break;
            System.out.println(i);
        }
        
        // Java Continue 
        //      - it is used for breaking one iteration in a loop
        for (i = 0; i<10; i++){
            if (i==4) continue;
            System.out.println(i);
        }

        // More example of Java Continue
        i = 0;
        while (i < 10) {
            if (i==4) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }


    }
}
