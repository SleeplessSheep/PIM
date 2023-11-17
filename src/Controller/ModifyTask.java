package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.*;
import View.Display;

public class ModifyTask implements Command {
        private Display display = new Display();
    private String description;
    private Date deadline;
    private Task task;
    private ArrayList<PIR> PIRs; 
    private int modifyIndex;

    public ModifyTask(ArrayList<PIR> PIRs, String description, Date deadline, int modifyIndex) { //construct of ModifyTask
        this.PIRs = PIRs;
        this.description = description;
        this.deadline = deadline;
        this.modifyIndex = modifyIndex;
    }

    @Override
    public void execute(){
        task = (Task)PIRs.get(modifyIndex); //get the task from PIRs using Index
        task.setDescription(description); //update the data using set method
        task.setDeadline(deadline);
        String buf = "Record modified|" + task.getString();
        display.displayMessage(buf);
    }
}
