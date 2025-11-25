import java.util.*;

class user{
    private int pin=1234;
    private double balance=5000;
    private int withdraw,deposit;
    ArrayList<String> mini = new ArrayList<>(); 

    public int getpin(){
        return pin;
    }
    
    public double getbalance(){
        return balance;
    }

    public void updatebalance(double amount){
        balance=amount;
    }
}

public class ATM{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("                                           Welcome to ATM");
        user u = new user();
        System.out.println("\nWelcome! Enter your PIN to proceed further");
        int attempts=0;

        while(attempts<3){
            int pin=sc.nextInt();
            if(pin==u.getpin()){
                System.out.println("Login successfully!!");
                while(true){
                System.out.println("                                 \nChoose number from 1 to 5 to move forward");
                System.out.println("\n1.Check Current Balance");
                System.out.println("2.Withdraw Amount");
                System.out.println("3.Deposit Amount");
                System.out.println("4.Mini Statement");
                System.out.println("5.Exit");

                int se=sc.nextInt();
                switch(se){ 
                    case 1 : 
                    System.out.println("\nYour Current Balance : Rs."+u.getbalance());
                    break;

                    case 2 : 
                    System.out.println("Enter amount to withdraw");
                    int we=sc.nextInt();

                    if(we>u.getbalance()){
                        System.out.println("Insufficient balance!!");
                    }
                    else{
                        System.out.println("Withdrawal successfully!!");
                        u.mini.add("Withdraw Rs. "+we);
                        u.updatebalance(u.getbalance()-we);
                    }
                    break;

                    case 3 : 
                    System.out.println("Enter amount to deposit");
                    int de=sc.nextInt();
                    System.out.println("Deposited successfully!!");
                    u.mini.add("Deposited : Rs. "+de);
                    u.updatebalance(u.getbalance()+de);
                    break;

                    case 4 :
                    System.out.println("--------------------- Mini Statement-------------------");
                    if(u.mini.isEmpty()){
                        System.out.println("No transactions yet!!");
                    }
                    else{
                        for(String s : u.mini){
                            System.out.println(s);
                        }
                    }
                    System.out.println("--------------------------------------------------------");
                    break;

                    case 5 : 
                    System.out.println("Thank you for visiting!!");
                    break;
                     
                    default : 
                    System.out.println("Please choose number from 1 to 5!!");
                }
                if(se==5){
                    break;
                }
            }
            
            }
            else{
                attempts++;
                System.out.println("Incorrect PIN , Enter correct PIN !!  Attempts left : "+(3-attempts));
            }
        }
        
        System.out.println("\nYour ATM account is temporarily blocked !! \nPlease try again after 24hrs.");
        
    }
}
