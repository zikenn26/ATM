package atmPackage;
import java.io.IOException;

public class ATM {
    public static void main(String[] args) throws IOException {
        introduction();
        ATMFunctionalities menu = new ATMFunctionalities();
        menu.mainMenu();
    }

    public static void introduction(){
        System.out.println("Welcome to the ATM");
    }
}
