package Controller;
import java.util.ArrayList;

import Model.*;
import View.Menu;

public class CreateContactFactory extends CreateCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;

    public Command create() throws Exception {
        String[] userInputs = menu.createContact();
        String name = userInputs[0];
        String address = userInputs[1];
        int mobileNumber = Integer.parseInt(userInputs[2]);
        return new CreateContact(PIRs, name, address, mobileNumber);
        
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
