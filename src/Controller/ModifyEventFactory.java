package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.*;
import View.Menu;

public class ModifyEventFactory extends ModifyCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;
    public String format = "yyyy-MM-dd HH:mm";

    @Override
    public Command create() throws Exception {
        String[] userInputs = new String[3];
        userInputs = menu.createEvent(); //get new data from userInput
        String description = userInputs[0];
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date startDate = formatter.parse(userInputs[1]);
        Date alarmDate = formatter.parse(userInputs[2]);
        return new ModifyEvent(PIRs, description, startDate, alarmDate, modifyIndex);
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
