package Controller;

import java.util.ArrayList;

import Model.*;
import View.*;
public class DeleteCommand implements Command{
    private ArrayList<PIR> PIRs;
    private PIR record;
    private int index;
    private Display display = new Display();

    public DeleteCommand(ArrayList<PIR> PIRs, int index){ //constructor for print PIR by index, which is found by provided ID
        this.PIRs = PIRs;
        this.index = index;
    }

    public void execute() {
        record = PIRs.remove(index);//Remove the record from the arrayList
        display.displayMessage("Deleted: " + record.getString());
    }
}
