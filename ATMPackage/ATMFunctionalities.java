package ATMPackage;

import java.io.IOException;
import java.util.*;


public class ATMFunctionalities implements ATMInterface{
    Scanner sc = new Scanner(System.in);
//    HashMap<Integer, Account> data = new HashMap<>();
    HashMap<Integer, Account> data = new HashMap<Integer, Account>();

    public void mainMenu() throws IOException {

        HashMap<Integer, Account> data = new HashMap<>();
        data.put(952141, new Account(952141, 9521, 1000, "Gulshan"));
        data.put(154561, new Account(154561, 1545, 2000, "Ashish"));
        data.put(123456, new Account(123456, 1234, 20000));

        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n1 - Login");
                System.out.println("2 - Create Account");
//                For iteration
                Iterator it = data.entrySet().iterator();

                Map.Entry pair = (Map.Entry) it.next();
                Account acc = (Account) pair.getValue();
//                System.out.println(data.entrySet());
//                System.out.println("key-set  " + data.keySet());    //zst to check
//                System.out.println("acc    " + acc);    //zst to check
//                System.out.println("pair    " + pair);  //zst to check
//                System.out.println("pinNumber:    " + acc.getPinNumber());  //zst to check
//                System.out.println("Balance:    " + acc.getBalance());  //zst to check
                System.out.print("\nChoice: ");     //Choose option 1 , as option 2 is not yet done
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        getLogin();
                        end = true;
                    case 2:
//                        createNewAccount();
                            end = true;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                sc.next();
            }
        }
        System.out.println("\nThank You for using this ATM.\n");
        sc.close();
        System.exit(0);
    }

    public void getLogin() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        int Number = 0;
        int pin = 0;
        while (!end) {
            try {
                System.out.print("\nEnter your customer number: ");
                Number = sc.nextInt();
                System.out.print("\nEnter your PIN number: ");
                pin = sc.nextInt();
                Account acc2=data.get(Number);
                Iterator it = data.entrySet().iterator();

//                This while loop in never getting executed !!!!
//                Please HELP !!!!!
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    Account acc = (Account) pair.getValue();
                    if (data.containsKey(Number) && pin == acc.getPinNumber()) {
                        getChecking(acc);
                        end = true;
                        break;
                    }
                }
                if (!end) {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
            }
        }
    }

    public void getChecking(Account acc) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCheckings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("\nChoice: ");

                int selection = sc.nextInt();

                switch (selection) {
                    case 1:
//                        System.out.println("\nCheckings Account Balance: " + moneyFormat.format(acc.getCheckingBalance()));
                        break;
                    case 2:
//                        acc.getCheckingWithdrawInput();
                        break;
                    case 3:
//                        acc.getCheckingDepositInput();
                        break;

                    case 4:
//                        acc.getTransferInput("Checkings");
                        break;
                    case 5:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                sc.next();
            }
        }
    }

    @Override
    public void deposit() {

    }

    @Override
    public void withdrawal() {

    }

    @Override
    public void pinChange() {

    }

    @Override
    public void viewBalance() {

    }
}
