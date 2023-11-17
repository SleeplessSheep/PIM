package Controller;

import java.util.Date;
import java.util.ArrayList;

import Model.*;
import View.*;

public class CreateEvent implements Command{
    private Display display = new Display();
    private String description;
    private Date startingTime;
    private Date alarm;
    private PIR event;
    private ArrayList<PIR> PIRs; 

    public CreateEvent(ArrayList<PIR> PIRs, String description, Date startingTime, Date alarm){ //constructor of CreateEvent
        this.PIRs = PIRs;
        this.description = description;
        this.alarm = alarm;
        this.startingTime = startingTime;
    }

    public void execute(){
        event = new Event(description, startingTime, alarm); //create a PIR object
        PIRs.add(event);
        String buf = "New record created|" + event.getString();
        display.displayMessage(buf);
    }
    
}