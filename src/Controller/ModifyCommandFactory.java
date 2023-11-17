package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Model.*;
import View.*;

public class ModifyCommandFactory implements CommandFactory {
    private ArrayList<PIR> PIRs;
    private Display display = new Display();
    private Menu menu;
    private String typeValue;
    protected int modifyIndex;

    @Override
    public Command create() throws Exception {
        HashMap<String, ModifyCommandFactory> recordType =  new HashMap<String, ModifyCommandFactory>(); //store the recordTpye and corresponding create class
            recordType.put("Event", new ModifyEventFactory());
            recordType.put("Contact", new ModifyContactFactory());
            recordType.put("Task", new ModifyTaskFactory());
            recordType.put("TextNote", new ModifyTextNoteFactory());
        
        String userInput = menu.displayModifyMenu();
        int givenID = Integer.parseInt(userInput); //get userInput
        int ID;
            for(int i = 0;i < PIRs.size();i++){ //find the record by ID
                ID = PIRs.get(i).getID();
                if(givenID == ID){
                    typeValue = PIRs.get(i).getType();
                    display.displayMessage("Editing: " + PIRs.get(i).getString()); //show the record being modify
                    ModifyCommandFactory commandFactory = recordType.get(typeValue); //call corresponding ModifyCommandFactory
                    commandFactory.setPIR(PIRs);
                    commandFactory.setMenu(menu);
                    commandFactory.setModifyIndex(i);
                    return commandFactory.create();

                }
            }
            throw new Exception("Not such id: " + givenID);
    }

    @Override
    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    @Override
    public void setMenu(Menu menu){
        this.menu = menu;
    }

    public void setModifyIndex(int modifyIndex){
        this.modifyIndex = modifyIndex;
    }
}
