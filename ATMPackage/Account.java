package ATMPackage;

public class Account {
//    final keyword is a non-access modifier used for variables, methods and classes, which make them non-changeable.
//    final makes them impossible to inherit and override.
    private final int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private String customerName;


//    Constructor to enter some pre-defined account details
    public Account(int customerNumber, int pinNumber, double checkingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
    }
    public Account(int customerNumber, int pinNumber, double checkingBalance, String customerName) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.customerName = customerName;
    }
    public Account(int customerNumber, String customerName, int pinNumber) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.pinNumber = pinNumber;
    }

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
    public double updateBalance(double amount ,int choice){
        if(choice == 1){
            checkingBalance = checkingBalance + amount;
        }
        else if (choice == 2){
            checkingBalance = checkingBalance - amount;
        }
        return checkingBalance;
    }
    public void updatePin(int newPin){
        this.pinNumber = newPin;
    }

}
