/*
Members : 
Pitchayut Boonporn  6680741
Napat Wanavejkul    6680741
 */
package Ex4_6680741;
import java.util.*;

public class Airline implements Comparable<Airline> {
    private String name;
    private String code;
    private int aircraft;
    private int destinations;
    
    // Constructor
    public Airline(String n, String c, int a, int d){
        this.name = n;
        this.code = c;
        this.aircraft = a;
        this.destinations = d;
    }
    
    // get Methods
    public String getName(){return name;}
    public String getCode(){return code;}
    public int getAircraft(){return aircraft;}
    public int getDestinations(){return destinations;}
    
    // Printing Method
    public void printFormat(){
        System.out.printf("%-28s (%-3s) %8s %18s \n", name, code, aircraft, destinations);
    }
    
    // Advance Methods
    public int compareTo(Airline other){
        // Compare to aircraft first
        int aircraft1 = this.aircraft;
        int aircraft2 = other.getAircraft();
        // Compare
        if (aircraft1>aircraft2) return -1;
        else if (aircraft1<aircraft2) return 1;
        
        // If A1=A2, compare alphabets instead!
        else{
            String n1 = this.name;
            String n2 = other.getName();
            // Compare
            int x1 = n1.compareToIgnoreCase(n2);
            return x1;   
        }
    }
    public boolean equals(Object param){
        // Check if the object is null
        if (param == null){return false;}
        
        // Check if the object is instance of Airline
        if (!(param instanceof Airline)){return false;}
        
        // Cast Object to an airline object 
        Airline other = (Airline) param;
        
        // Compare the 'code' field for equality(case-sensitive)
        return this.code.equalsIgnoreCase(other.code);
    }
}

