package Controller;

import java.util.ArrayList;

import Model.PIR;
import View.Menu;

public class DeleteCommandFactory implements CommandFactory{
    private ArrayList<PIR> PIRs;
    private Menu menu;
    
    public Command create() throws Exception {
        String userInput = menu.displayDeleteMenu();
        int givenID = Integer.parseInt(userInput);
        int ID;
        for(int i = 0;i < PIRs.size();i++){
            ID = PIRs.get(i).getID();
            if(givenID == ID){
                Command command = new DeleteCommand(PIRs, i);
                return command;
            }
        }
        throw new Exception("Not such id: " + givenID);
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
