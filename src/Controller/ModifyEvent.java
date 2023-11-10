package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.*;
import View.Display;

public class ModifyEvent implements Command {
    private Display display = new Display();
    private String description;
    private Date startingTime;
    private Date alarm;
    private Event event;
    private ArrayList<PIR> PIRs; 
    private int modifyIndex;

    public ModifyEvent(ArrayList<PIR> PIRs, String description, Date startingTime, Date alarm, int modifyIndex){
        this.PIRs = PIRs;
        this.description = description;
        this.alarm = alarm;
        this.startingTime = startingTime;
        this.modifyIndex = modifyIndex;
    }

    @Override
    public void execute(){
        event = (Event)PIRs.get(modifyIndex);
        display.displayMessage("Editing: " + event.getString());
        event.setDescription(description);
        event.setStartingTime(startingTime);
        event.setAlarm(alarm);
        String buf = "Record modified|" + event.getString();
        display.displayMessage(buf);
    }
}
