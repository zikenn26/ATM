package ATMPackage;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        introduction();
        HashMap<Integer, Account> data = new HashMap<Integer, Account>();
        ATMFunctionalities menu = new ATMFunctionalities();

    }

    public static void introduction(){
        System.out.println("Welcome to the ATM");
    }

    public void mainMenu() throws IOException
    {
        Scanner menuInput = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n1 - Login");
                System.out.println("2 - Create Account");
                System.out.print("\nChoice: ");
                int choice = menuInput.nextInt();
                switch (choice) {
                    case 1:
//                        login();
                        end = true;
                        break;
                    case 2:
//                        createNewAccount();
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
        System.out.println("\nThank You for using this ATM.\n");
        menuInput.close();
        System.exit(0);
    }
}
