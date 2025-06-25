package Ex3_6680741;

// Sub Class : HumanCustomer
public class HumanCustomer extends Customer{ 
    
    // spa options (face, body, hand, foot) – you may use individual booleans or array of booleans.
    boolean[] spaOptions;           // [face, body, hand, foot]
    
    // Constructor
    public HumanCustomer(int i, boolean[] spa1) { 
        super(i);           // Call the Superclass constructor for ID
        spaOptions = spa1;
    }
    
    
    String[] spa = {"face", "body", "hand", "foot"};
    
    // printCustomer()
    public void printCustomer(){
        String total_str = "";
        for (int i=0; i<4; i++){
            if (spaOptions[i] == true) total_str = total_str + " " + spa[i];
        }
        
        System.out.printf("Customer %3d (Human) >>                               Spa Options =%s \n", getID(), total_str);
    }
    
    // calculatePrice()
    public void calculatePrice(){
        int total_price = 0;
        if (spaOptions[0] == true) total_price = total_price + 1200;    // Face
        if (spaOptions[1] == true) total_price = total_price + 1200;    // Body
        if (spaOptions[2] == true) total_price = total_price + 600;     // Hand
        if (spaOptions[3] == true) total_price = total_price + 800;     // Foot
        
        System.out.printf("Customer %3d (Human) >> Total Price = %d \n", ID, total_price);
        
    }
}
