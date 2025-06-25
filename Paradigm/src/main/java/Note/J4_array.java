package Note;

public class J4_array{
    public static void main(String[] args){
        /*
        Arrays are used to store multiple values in a single variable
        */
        // This is a string array
        String[] cars = {"Jolion", "Mercedes", "H6", "Vios"};
        
        // This is an integer array
        int[] one_five = {1, 2, 3, 4, 5};
        
        for (int num :  one_five){
            System.out.print(num+" ");
        }
        
        for (String car : cars){
            System.out.print(car+" ");
        }
        
        
        // To access the elements of an Array
        String[] cars2 = {"Jolion", "Mercedes", "H6", "Vios"};
        System.out.println("\n"+cars2[0]);
        
        // To change the value of a specific element
        cars2[0] = "BMW";
        System.out.println(cars2[0]);
        
        // To find out the number of the elements in an Array
        int len_of_cars2 = cars2.length;
        System.out.println(len_of_cars2);       // Outputs 4
        
        // Loop through an Array
        for (int i = 0; i < cars.length; i++){
            System.out.print(cars[i]+" ");
            if (i == cars.length-1){
                System.out.print("\n");
            }
        }
        
        // Loop through an Array with "For Each"
        for (String car : cars){
            System.out.println(car);
        }
        
        
        // Now, let's tackle the Real-life examples
        // Ex1 : Average Age Calculator
        int ages[] = {18, 19, 20, 24, 26, 30, 42};
        
        float avg, sum = 0;
        
        for (int age : ages){
            sum += age;
        }
        
        avg = sum/ages.length;
        
        System.out.printf("The average age is %.2f \n", avg);
        
        // Ex2 : Find lowest age among different age
     // int ages[] = {18, 19, 20, 24, 26, 30, 42};
        int lowestAge = ages[0];
        
        for (int i = 0; i < ages.length ; i++){
            if (ages[i]<lowestAge) lowestAge = ages[i];
        }
        
        System.out.printf("The lowest age is %d \n", lowestAge);
        
        
        
        // Multi-dimentional Arrays : Store as a tabular form(like rows, columns)
        int[][] myNumbers = {{1,2,3,4}, {5,6,7,}};
        
        // To access : myNumbers[0][0]
        System.out.println(myNumbers[0][3]); // outputs 4
        
        // to change the element values : 
        myNumbers[1][2] = 9;
        System.out.println(myNumbers[1][2]); // outputs 9
        
        // Loop through a multi-dimensional array 
        // We use a for loop inside another for loop to get the elements of a 2 dm array (i,j)
        // int[][] myNumbers = {{1,2,3,4}, {5,6,9}};
        int i,j;
        for (i=0; i<myNumbers.length; i++){
            for (j=0; j<myNumbers[i].length; j++){
                System.out.print(myNumbers[i][j]);
            }
        }
        System.out.println("\n");
        
        // Or we could just use For Each
        // int[][] myNumbers = {{1,2,3,4}, {5,6,9}};
        for (int[] row : myNumbers){
            for (int item : row){
                System.out.println(item);
            }
        }
        
    }

}