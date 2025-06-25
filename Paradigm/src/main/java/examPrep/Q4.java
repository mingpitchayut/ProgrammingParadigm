package examPrep;

class YearException extends Exception {}
class ProfitException extends RuntimeException {}

class Company {
    static int CURRENT = 2025;
    String name; 
    double profit;
    int year;
    
    public Company(String line){
        name = "company"; profit = 0; year = CURRENT;
        init(line);
    }
    
    public void init(String line){
        try{
            String []cols = line.split(",");
            name = cols[0].trim();
            profit = getValidProfit(cols[1].trim());
            year = getValidYear(cols[2].trim());
        }
        catch(NumberFormatException e)          { System.err.println("Err >> 1"); } 
        catch(ArrayIndexOutOfBoundsException e) { System.err.println("Err >> 2"); }
        catch(YearException e)                  { System.err.println("Err >> 3"); }
        catch(Exception e) {
            System.err.println("Err >> 4, skip!"); return;
            // System.err.println("Err >> 4, skip!"); System.exit(0);
        }
        finally {
            System.out.printf("Out >> name = %s, profit = %.1f \n", name, profit);
        }
    }
    
    public int getValidYear(String s) throws YearException{
        int y = Integer.parseInt(s);
        if (y < CURRENT) throw new YearException();
        return y;
    }
    public double getValidProfit(String s) throws Exception{
        double p = Double.parseDouble(s);
        if (p < 0) throw new ProfitException();
        return p;
    }
}

public class Q4 {
    public static void main(String[] args){
        String line1 = "PepsiCo, -260, 1965";
        String line2 = "Samsung, 300.5, 2567";
        String line3 = "Walmart, 400$";
        
        //Company co1 = new Company(line1);
        //Company co2 = new Company(line2);
        Company co3 = new Company(line3);
    }
}
