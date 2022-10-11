package atmPackage;

import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;


public class ATMFunctionalities implements ATMInterface{
    Scanner sc = new Scanner(System.in);
    Map<Integer, Account> data = new HashMap<>();

    public void mainMenu() throws IOException {

//        HashMap<Integer, Account> data = new HashMap<>();
        data.put(952141, new Account(952141, 9521, 1000, "Gulshan"));
        data.put(154561, new Account(154561, 1545, 2000, "Ashish"));
        data.put(123456, new Account(123456, 1234, 20000, "Anurag"));

        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n0 - Exit");
                System.out.println("1 - Login");
                System.out.println("2 - Create Account");
                System.out.print("\nChoice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 0 -> exit(0);
                    case 1 -> {
                        getLogin();
                        end = true;
                    }
                    case 2 -> {
                        createAccount();
                        end = true;
                    }
                    default -> System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                sc.next();
            }
        }
        System.out.println("\nThank You for using this ATM.\n");
        sc.close();
        exit(0);
    }

    public void getLogin() throws IOException {
        boolean end = false;
        int accountNumber;
        int pin;
        while (!end) {
            try {
                System.out.print("\nEnter your customer number: ");
                accountNumber = sc.nextInt();
                System.out.print("\nEnter your PIN number: ");
                pin = sc.nextInt();
//                Map.Entry is an interface that provides certain methods to access to the entry of the map.
//                These methods include : equals(), getValue(), getKey(), setValue()
                for (Map.Entry<Integer, Account> accountEntry : data.entrySet()) {
                    Account acc = accountEntry.getValue();
                    if (data.containsKey(accountNumber) && (pin == acc.getPinNumber())) {
                        getChecking(acc);
                        end = true;
                        break;
                    }
                }
                if (!end) {
                    System.out.println("\nWrong Customer AccountNumber or Pin");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
            }
        }
    }

    public void createAccount() throws IOException {
        int accountNumber = 0;
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nEnter your customer number ");
                accountNumber = sc.nextInt();
                Iterator it = data.entrySet().iterator();

                while (it.hasNext()) {
                    if (!data.containsKey(accountNumber)) {
                        end = true;
                        break;
                    }
                }
                if (!end) {
                    System.out.println("\nThis customer number is already registered");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                sc.next();
            }
        }
        sc.nextLine();
        System.out.println("\nEnter your name");
        String customerName = sc.nextLine();
        System.out.println("\nEnter PIN to be registered");
        int pin = sc.nextInt();
        data.put(accountNumber, new Account(accountNumber, customerName, pin));
        System.out.println("\nYour new account has been successfully registered!");
        System.out.println("\nRedirecting to login.............");
        getLogin();
    }

    public void getChecking(Account acc) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nChecking Account: ");
                System.out.println(" Type 0 - Exit");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - PIN Change");
                System.out.print("\nChoice: ");

                int selection = sc.nextInt();

                switch (selection) {
                    case 0 -> end = true;
                    case 1 -> viewBalance(acc);
                    case 2 -> withdrawal(acc);
                    case 3 -> deposit(acc);
                    case 4 -> System.out.println("Transfer section not yet developed");
//                        Transfer Funds
                    case 5 -> pinChange(acc);
                    default -> System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException | IOException e) {
                System.out.println("\nInvalid Choice.");
                sc.next();
            }
        }
    }

    @Override
    public void deposit(Account acc) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nDear " + acc.getCustomerName() + ", your account balance is Rs. "+acc.getBalance());
                System.out.print("\nEnter the amount you want to deposit to your account: ");
                double amount = sc.nextDouble();
                if (amount >= 0) {
//                    Implemented polymorphism in updateBalance->   1: deposit    2: withdrawal
                    acc.updateBalance(amount,1);
                    System.out.println("\nAfter withdrawal your current Account Balance is: Rs. " + acc.getBalance());
                    end = true;
                } else {
                    System.out.println("\nPlease enter a non negative amount.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                sc.next();
            }
        }
    }

    @Override
    public void withdrawal(Account acc) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("Dear " + acc.getCustomerName() + ", your account balance is Rs. "+acc.getBalance());
                System.out.print("\nEnter the amount you want to withdraw from your account: ");
                double amount = sc.nextDouble();
                if ((acc.getBalance() - amount) >= 0 && amount >= 0) {
//                    Implemented polymorphism in updateBalance->   1: deposit    2: withdrawal
                    acc.updateBalance(amount,2 );
                    System.out.println("\nAfter withdrawal your current Account Balance is: Rs. " + acc.getBalance());
                    end = true;
                } else {
                    System.out.println("\nPlease enter a non negative amount not exceeding your Balance.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                sc.next();
            }
        }
    }

    public void pinChange(Account acc) throws IOException{
        boolean end = false;
        int accountNumber;
        int pin;
        while (!end) {
            try {
                System.out.print("Enter the CURRENT PIN number: ");
                pin = sc.nextInt();
                System.out.println("Enter the NEW PIN number: ");
                int newPin = sc.nextInt();
                for (Map.Entry<Integer, Account> accountEntry : data.entrySet()) {
                    Account accountEntryValue = accountEntry.getValue();
                    if (data.containsKey(acc.getCustomerNumber()) && (pin == accountEntryValue.getPinNumber())) {
                        acc.updatePin(newPin);
                        end = true;
                        break;
                    }
                }
                if (!end) {
                    System.out.println("\nWrong Customer AccountNumber or Pin");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
            }
            System.out.println("Your PIN has been updated. Please login with the new PIN.");
            System.out.println("\nRedirecting to login.............");
            getLogin();
        }
    }
    @Override
    public void viewBalance(Account acc) {
        System.out.println("Dear " + acc.getCustomerName() + ", your account balance is Rs. "+acc.getBalance());
    }

}
