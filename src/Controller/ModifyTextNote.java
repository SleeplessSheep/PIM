package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.*;
import View.Display;

public class ModifyTextNote implements Command {
    private Display display = new Display();
    private String content;
    private TextNote textNote;
    private ArrayList<PIR> PIRs; 
    private int modifyIndex;

    public ModifyTextNote(ArrayList<PIR> PIRs, String content, int modifyIndex) {
        this.PIRs = PIRs;
        this.content = content;
        this.modifyIndex = modifyIndex;
    }

    @Override
    public void execute(){
        textNote = (TextNote)PIRs.get(modifyIndex);
        textNote.setNoteContent(content);
        String buf = "Record modified|" + textNote.getString();
        display.displayMessage(buf);
    }
}
