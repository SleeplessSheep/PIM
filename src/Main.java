import Model.*;
import View.*;
import Controller.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        ArrayList<PIR> PIRs = new ArrayList<PIR>();
        Menu menu = new Menu();

        CommandMap cm = new CommandMap(PIRs, menu);
        while (true) {
            //send user event to controller like sending a url request
            String userEvent = menu.displayMainMenu();
            cm = new CommandMap(PIRs, menu);
            cm.mapToCommand(userEvent);
        }

    }
}