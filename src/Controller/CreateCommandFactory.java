package Controller;
import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateCommandFactory implements CommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;

    public Command create() throws Exception {
            HashMap<String, CommandFactory> recordType =  new HashMap<String, CommandFactory>(); //store the recordTpye and corresponding create class
                recordType.put("Event", new CreateEventFactory());
                recordType.put("Contact",new CreateContactFactory());
                recordType.put("Task", new CreateTaskFactory());
                recordType.put("TextNote", new CreateTextNoteFactory());

            String typeValue = menu.displayCreateMenu();
            CommandFactory commandFactory = recordType.get(typeValue);
            //CommandFactory commandFactory = (CommandFactory) Class.forName(type).getDeclaredConstructor().newInstance();
            commandFactory.setPIR(PIRs);
            commandFactory.setMenu(menu);
            return commandFactory.create();
        
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }



}
