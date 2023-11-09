package Controller;

import java.util.ArrayList;

import Model.*;
import View.*;
public class DisplayCommand implements Command{
    private ArrayList<PIR> PIRs;
    private PIR record;
    private Display display = new Display();

    public DisplayCommand(ArrayList<PIR> PIRs){ //constructor for print all
        this.PIRs = PIRs;
    }

    public DisplayCommand(ArrayList<PIR> PIRs, PIR record){ //constructor for print PIR by number
        this.PIRs = PIRs;
        this.record = record;
    }

    public void execute() {
        if(record == null){
            display.displayPIRs(PIRs);
        }else {
            display.displayMessage(record.getString());
        }
    }
}
