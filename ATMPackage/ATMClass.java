package ATMPackage;
import java.util.Scanner;

public class ATMClass {
    public static void main(String[] args) {
        ATMInterface object = new ATMFunctionalities();
        int menuItem=0;
        while(true){
            switch (menuItem){
                case 0  ->{
                    System.out.println("Thanks for using the ATM");
                    System.exit(0);
                }
//                case 1 ->withdrawal
//                case 2 -> Deposit
//                case 3 -> ViewBalance
//                case 4 -> Pin Change
                default -> System.out.println("Enter a valid option");

            }

        }
    }

}
