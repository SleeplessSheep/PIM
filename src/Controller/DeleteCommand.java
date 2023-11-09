package Controller;

import java.util.ArrayList;

import Model.*;
import View.*;
public class DeleteCommand implements Command{
    private ArrayList<PIR> PIRs;
    private PIR record;
    private int index;
    private Display display = new Display();

    public DeleteCommand(ArrayList<PIR> PIRs, int index){ //constructor for print PIR by number
        this.PIRs = PIRs;
        this.index = index;
    }

    public void execute() {
        record = PIRs.remove(index);
        display.displayMessage("Deleted: " + record.getString());
    }
}
