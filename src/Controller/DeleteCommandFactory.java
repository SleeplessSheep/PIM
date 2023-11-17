package Controller;

import java.util.ArrayList;

import Model.PIR;
import View.Menu;

public class DeleteCommandFactory implements CommandFactory{
    private ArrayList<PIR> PIRs;
    private Menu menu;
    
    public Command create() throws Exception {
        String userInput = menu.displayDeleteMenu(); //ask user the ID of record that he/she want to delete
        int givenID = Integer.parseInt(userInput);
        int ID;
        for(int i = 0;i < PIRs.size();i++){ //find the index by the ID
            ID = PIRs.get(i).getID();
            if(givenID == ID){
                Command command = new DeleteCommand(PIRs, i);
                return command;
            }
        }
        throw new Exception("Not such id: " + givenID); //if the ID is not found
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
