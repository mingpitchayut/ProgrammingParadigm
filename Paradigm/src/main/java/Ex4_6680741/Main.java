/*
Member : 
Pitchayut Boonporn 6680741
*/

package Ex4_6680741;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        // Create an arrayList<> : airlines
        ArrayList<Airline> airlines = new ArrayList<Airline>();
        
        // Scan the file
        String path = "src/main/java/Ex4_6680741/";
        String inputFilename = path + "airlines.txt";
        
        try{
            File inputFile = new File(inputFilename);
            Scanner fileScan = new Scanner(inputFile);
            // Skip Next Line
            if (fileScan.hasNextLine()) fileScan.nextLine();
            
            while(fileScan.hasNextLine()){
                String line = fileScan.nextLine();
                String []cols = line.split(",");
                    
                // Formatting cols
                String name = cols[0].trim();
                String code = cols[1].trim();
                int aircraft = Integer.parseInt(cols[2].trim());
                int destination = Integer.parseInt(cols[3].trim());
                
                // Keep it in the ArrayList<> "airlines"
                airlines.add(new Airline(name, code, aircraft, destination));
            }
        // Close the scanner
        fileScan.close();
        } catch (FileNotFoundException e){
            System.err.println("Error!");
            System.err.println(e.getMessage());
        }
        
        // Sorting ArrayList
        Collections.sort(airlines);
        System.out.println("Airline                                Aircraft        Destinations");
        System.out.println("===================================================================");
        // Print Sorted airlines
        for (Airline a : airlines){
            a.printFormat();
        }
        System.out.println("===================================================================");
        
        
        // Keep asking user to choose between searching, filtering, or quiting the program
        
        Scanner scanTxt = new Scanner(System.in);
        System.out.println("Enter s/S to search airlines; f/F to filter airlines; else to quit");
        String userInput = scanTxt.next();
        
        while (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("f")){
            // Case input = 's'
            if (userInput.equalsIgnoreCase("s")){
                System.out.print("Enter Airline Code : ");
                String inputCode = scanTxt.next();
                boolean flag = false;
                
                // 1st Loop to check
                for (Airline a : airlines){
                    if (inputCode.equalsIgnoreCase(a.getCode())){
                        flag = true;
                    }
                }
                // Second Loop for printing
                if (flag == true){
                    System.out.println("Airline                                Aircraft        Destinations");
                    System.out.println("===================================================================");
                
                    // Loop to check
                    for (Airline a : airlines){
                        if (inputCode.equalsIgnoreCase(a.getCode())){
                            a.printFormat();
                        }
                    }
                }
                else{
                    System.out.printf("Code '%s' not found. \n", inputCode);
                    continue;
                }    
            }
            // Case input = 'f'
            else {
                System.out.print("Enter min aircraft thresold : ");
                // Input validation for integers
                while (!scanTxt.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanTxt.next(); // Consume the invalid input
                    System.out.print("Enter min thresold : ");
                }
                // If it's int
                int minAircraft = scanTxt.nextInt();
                boolean foundFlag = false;
                System.out.println("Airline                                Aircraft        Destinations");
                System.out.println("===================================================================");
                for (Airline a : airlines) {
                    if (a.getAircraft() >= minAircraft) {
                        a.printFormat();
                        foundFlag = true;
                    }
                }
                if (!foundFlag) {
                    System.out.println("No airlines found matching the filter criteria.");
                }
                System.out.println("===================================================================");
            }
            
            System.out.println("Enter s/S to search airlines; f/F to filter airlines; else to quit");
            userInput = scanTxt.next();
        }
        scanTxt.close();
    }
}

