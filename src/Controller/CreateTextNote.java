package Controller;

import java.util.ArrayList;

import Model.*;
import View.*;

public class CreateTextNote implements Command {
    private Display display = new Display();
    private String content;
    private PIR textNote;
    private ArrayList<PIR> PIRs; 

    public CreateTextNote(ArrayList<PIR> PIRs, String content) { //constructor of CreateTextNote
        this.PIRs = PIRs;
        this.content = content;
    }

    public void execute(){
        textNote = new TextNote(content);
        PIRs.add(textNote);
        String buf = "New record created|" + textNote.getString();
        display.displayMessage(buf);
    }
}
