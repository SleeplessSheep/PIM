package Controller;

import java.util.ArrayList;

import Model.*;
import View.*;

public class DisplayCommandFactory implements CommandFactory{
    private ArrayList<PIR> PIRs;
    private Menu menu;
    
    public Command create() throws Exception {
        String userInput = menu.displayListMenu(); //Ask the user what to display, it could be [ All ] and ID
        if(userInput.equals("All")){
            Command command = new DisplayCommand(PIRs);
            return command;
        }else {
            int givenID = Integer.parseInt(userInput);
            int ID;
            for(int i = 0;i < PIRs.size();i++){ //find the record index by ID
                ID = PIRs.get(i).getID();
                if(givenID == ID){
                    Command command = new DisplayCommand(PIRs, PIRs.get(i));
                    return command;
                }
            }
            throw new Exception("Not such id: " + givenID);
        }
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }

}