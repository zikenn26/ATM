package atmPackage;

import java.io.IOException;

public interface ATMInterface {
    void mainMenu() throws IOException;
    void deposit(Account acc);
    void withdrawal(Account acc);
    void pinChange(Account acc) throws IOException;
    void viewBalance(Account acc);
    void getLogin() throws IOException;
    void createAccount() throws IOException;

}
