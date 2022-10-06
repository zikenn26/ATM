package ATMPackage;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
//    private double savingBalance = 0;

    private String customerName;
    Scanner input = new Scanner(System.in);


//    Constructor to enter some pre-defined account details
    public Account(int customerNumber, int pinNumber, double checkingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
    }
//    public Account(int customerNumber, int pinNumber, double checkingBalance, String customerName) {
//        this.customerNumber = customerNumber;
//        this.pinNumber = pinNumber;
//        this.checkingBalance = checkingBalance;
//        this.customerName = customerName;
//    }
    public int getPinNumber() {
        return pinNumber;
    }
    public double getBalance() {
        return checkingBalance;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
    public String getCustomerName(){
        return customerName;
    }
}
