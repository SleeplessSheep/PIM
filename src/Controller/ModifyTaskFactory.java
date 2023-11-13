package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.PIR;
import View.Menu;

public class ModifyTaskFactory extends ModifyCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;
    public String format = "yyyy-MM-dd HH:mm";

    @Override
    public Command create() throws Exception {
            String[] userInputs = new String[3];
            userInputs = menu.createTask();
            String description = userInputs[0];
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date deadline = formatter.parse(userInputs[1]);
            return new ModifyTask(PIRs, description, deadline, modifyIndex);
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
