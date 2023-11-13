package Controller;

import java.util.Date;
import java.util.ArrayList;

import Model.*;
import View.*;

public class CreateTask implements Command {
    private Display display = new Display();
    private String description;
    private Date deadline;
    private PIR task;
    private ArrayList<PIR> PIRs; 
    
    public CreateTask(ArrayList<PIR> PIRs, String description, Date deadline){
        this.PIRs = PIRs;
        this.description = description;
        this.deadline = deadline;
    }

    public void execute(){
        task = new Task(description, deadline);
        PIRs.add(task);
        String buf = "New record created|" + task.getString();
        display.displayMessage(buf);
    }
}
