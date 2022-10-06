package ATMPackage;

import java.io.IOException;

public interface ATMInterface {
    public void mainMenu() throws IOException;
    void deposit();
    void withdrawal();
    void pinChange();
    void viewBalance();

}
