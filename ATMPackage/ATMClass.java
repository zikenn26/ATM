package ATMPackage;
import java.util.Scanner;

public class ATMClass {
    public static void main(String[] args) {
        ATMInterface object = new ATMFunctionalities();
        int menuItem;
        while(true) {
            menuItem = menu();
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

    public static int menu() {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Main Menu");
        System.out.println();
        System.out.println("0. Exit the program");
        System.out.println("1. Withdrawal");
        System.out.println("2. Deposit");
        System.out.println("3. View Balance");
        System.out.println("4. Pin Change");
        System.out.println();
        System.out.print("Enter choice: ");
        choice = input.nextInt();

        return choice;
    }

}
