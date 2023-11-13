package Controller;

import java.util.ArrayList;

import Model.*;
import View.Menu;
public class ModifyContactFactory extends ModifyCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;

    @Override
    public Command create() throws Exception {
        String[] userInputs = new String[3];
        userInputs = menu.createContact();
        String name = userInputs[0];
        String address = userInputs[1];
        int mobileNumber = Integer.parseInt(userInputs[2]);
        return new ModifyContact(PIRs, name, address, mobileNumber, modifyIndex);
    }

    @Override
    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    @Override
    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
