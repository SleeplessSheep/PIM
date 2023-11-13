package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.*;
import View.*;

public class CreateContact implements Command{
    private Display display = new Display();
    private String name;
    private String address;
    private int mobileNumber;
    private PIR contact;
    private ArrayList<PIR> PIRs; 

    public CreateContact(ArrayList<PIR> PIRs, String name, String address, int mobileNumber){
        this.PIRs = PIRs;
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    public void execute(){
        contact = new Contact(name, address, mobileNumber);
        PIRs.add(contact);
        String buf = "New record created|" + contact.getString();
        display.displayMessage(buf);
    }
}
