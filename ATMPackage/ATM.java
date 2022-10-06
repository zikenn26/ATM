package ATMPackage;
import java.io.IOException;
//import java.util.HashMap;

public class ATM {
    public static void main(String[] args) throws IOException {
        introduction();
//        HashMap<Integer, Account> data = new HashMap<Integer, Account>();
        ATMFunctionalities menu = new ATMFunctionalities();
        menu.mainMenu();

    }

    public static void introduction(){
        System.out.println("Welcome to the ATM");
    }
}
