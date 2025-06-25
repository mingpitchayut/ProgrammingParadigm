package Lab_Ch2;

import java.io.*;
import java.util.*;

class w2_4_ReadWriteFile  
{
  public static void main(String[] args)  
  {
        // Use separate scanner objects for keyboard and file input
        Scanner keyboardScan = new Scanner(System.in);
      
        // This is where we are
        String localDir = System.getProperty("user.dir");
        System.out.println("Current directory = " + localDir + "\n");

        // Don't use absolute path. Use only path relative to src
        // Use forward slash (/) instead of backward slash (\)
        String path        = "src/main/Java/Lab_Ch2/";
	String inputFilename  = path + "input.txt";
	String outputFilename = path + "output.txt";
        //String outFilename = "output2.txt";             // file is place outside src
        
	try 
        {
            File inputFile      = new File(inputFilename);
            Scanner fileScan = new Scanner(inputFile); 
            System.out.println("Read input from (relative path) " + inputFile.getPath());
            System.out.println("Read input from (absolute path) " + inputFile.getAbsolutePath() + "\n");
          
            
            File outputFile      = new File(outputFilename);
            PrintWriter write = new PrintWriter(outputFile);                              // overwrite (default)
            //PrintWriter write = new PrintWriter( new FileWriter(outFile, false) );   // overwrite
            //PrintWriter write = new PrintWriter( new FileWriter(outputFile, true)  );   // append
            write.println("test");
            while (fileScan.hasNext()) 
            {							
                String name	  = fileScan.next();
                double height = fileScan.nextDouble();
                int age = fileScan.nextInt();
                // Use \r\n when writing to file
                System.out.printf("%s  height = %.0f  age = %d \n", name, height*100, age);
                write.printf("%s  height = %.0f  age = %d \r\n", name, height*100, age);
            }
          
            fileScan.close();
            write.close();
          
            System.out.println("\nEnter 0 to delete output file"); int ans = keyboardScan.nextInt();
            if (ans == 0)
            {
                if (outputFile.exists()) outputFile.delete();
            }
	}
	catch(Exception e) {
            System.err.println("An error occurs. End program.");
            System.err.println(e);	  
            System.exit(-1);
	}
    }
}