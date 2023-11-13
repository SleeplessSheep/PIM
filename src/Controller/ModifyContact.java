package Controller;

import java.util.ArrayList;

import Model.*;
import View.Display;

public class ModifyContact implements Command {
    private Display display = new Display();
    private String name;
    private String address;
    private int mobileNumber;
    private Contact contact;
    private ArrayList<PIR> PIRs; 
    private int modifyIndex;

    public ModifyContact(ArrayList<PIR> PIRs, String name, String address, int mobileNumber, int modifyIndex){
        this.PIRs = PIRs;
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.modifyIndex = modifyIndex;
    }

    @Override
    public void execute(){
        contact = (Contact)PIRs.get(modifyIndex);
        contact.setName(name);
        contact.setAddress(address);
        contact.setMobileNumber(mobileNumber);
        String buf = "Record modified|" + contact.getString();
        display.displayMessage(buf);
    }
}
