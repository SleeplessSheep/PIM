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

    public ModifyTask(ArrayList<PIR> PIRs, String description, Date deadline, int modifyIndex) {
        this.PIRs = PIRs;
        this.description = description;
        this.deadline = deadline;
        this.modifyIndex = modifyIndex;
    }

    @Override
    public void execute(){
        task = (Task)PIRs.get(modifyIndex);
        task.setDescription(description);
        task.setDeadline(deadline);
        String buf = "Record modified|" + task.getString();
        display.displayMessage(buf);
    }
}
