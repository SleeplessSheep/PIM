package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.*;
import View.Menu;

public class ModifyTextNoteFactory extends ModifyCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;

    @Override
    public Command create() throws Exception { 
        String userInputs = menu.createTextNote(); //get user input
        return new ModifyTextNote(PIRs, userInputs, modifyIndex);
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
