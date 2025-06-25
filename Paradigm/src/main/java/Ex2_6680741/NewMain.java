package Ex2_6680741;
/*
Members :
    Pitchayut Boonporn    6680741
    Napat     Wanavejkul  66880024
*/

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class NewMain {
    public static void main(String[] args){
        
        String path                 = "src/main/java/Ex2_6680741/";
        String inputFilename        = path + "countries.txt";
        String outputFilename       = path + "output.txt";
        
        try{
            File inputFile          = new File(inputFilename);
            Scanner fileScan        = new Scanner(inputFile);
            
            File outputFile         = new File(outputFilename);
            PrintWriter write       = new PrintWriter(outputFile);
            
            String name = null;
            double population = 0, area = 0, density;
            
            // Input - density from users
            Scanner myObj = new Scanner(System.in);
            System.out.print("Enter the density treshold : ");
            
            double userDensity = myObj.nextDouble();
            System.out.println("The density is now set to : " + userDensity);
            
            
            // Headers
            write.printf("%10s %30s %30s %15s    (>%.1f) \n", "Country", "Population", "Area(km2)", "Density", userDensity);
            write.printf("===================================================================================================\n");
            
            // List all elements & density & treshold comparison 
            while (fileScan.hasNext()){
                name = fileScan.next();
                population = fileScan.nextDouble();
                area = fileScan.nextDouble();
                
                // Population : 
                String population_str = printEasy(population);
                
                // Area :
                String area_str = printEasy(area);
                
                // Calculate density + check density w.r.t treshold here
                density = population/area;
                String isLower = "No";
                if (density > userDensity) isLower = "Yes";
                
                // Print in the output file
                write.printf("%-15s %30s %30s %10.2f %10s \r\n", name, population_str, area_str, density, isLower);
                write.flush();
            }
            write.close(); // This is very important
        }
        catch (Exception e){ 
        System.out.println("There's an error occur somewhere!");
        }
        
    }
    
    // Method : printEasy
    public static String printEasy(double value){
        String s = "";

        String patternString = "#,###,###,###";     // 1,000,000,000
        DecimalFormat myFormat = new DecimalFormat(patternString);
        String myStr = myFormat.format(value);

        if (value < 1000) {
            s = String.format("%s           ", myStr);
            return s;
        }
        else if (value >= 1000000000){
            double B = value/1000000000;  
            s = String.format("%13s = %6.2f B", myStr, B);
            return s;
        }
        else if (value >= 1000000){
            double M = value/1000000;
            s = String.format("%13s = %6.2f M", myStr, M);
        return s;
        }
        else if (value >= 1000) {        
            double K = value/1000;
            s = String.format("%13s = %6.2f K", myStr, K);
            return s;
        }
        else return "ERROR!";
    }
}
    
