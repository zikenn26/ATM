package ATMPackage;
import java.io.IOException;
// zst to check

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
