package Controller;

import java.util.ArrayList;

import Model.*;
import View.Menu;

public class CreateTextNoteFactory extends CreateCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;

    public Command create() throws Exception { //get userInput and pass it to constructor
        String userInput = menu.createTextNote();
        return new CreateTextNote(PIRs, userInput);
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
