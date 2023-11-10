package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Model.*;
import View.*;

public class ModifyCommandFactory implements CommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;
    private String typeValue;
    protected int modifyIndex;

    @Override
    public Command create() throws Exception {
        HashMap<String, CommandFactory> recordType =  new HashMap<String, CommandFactory>(); //store the recordTpye and corresponding create class
            recordType.put("Event", new ModifyEventFactory());
        
        String userInput = menu.displayModifyMenu();
        int givenID = Integer.parseInt(userInput);
        int ID;
            for(int i = 0;i < PIRs.size();i++){
                ID = PIRs.get(i).getID();
                if(givenID == ID){
                    typeValue = PIRs.get(i).getType();
                    modifyIndex = i;
                    CommandFactory commandFactory = recordType.get(typeValue);
                    //CommandFactory commandFactory = (CommandFactory) Class.forName(type).getDeclaredConstructor().newInstance();
                    commandFactory.setPIR(PIRs);
                    commandFactory.setMenu(menu);
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
}
