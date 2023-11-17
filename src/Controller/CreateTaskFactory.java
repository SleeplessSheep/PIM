package Controller;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.*;
import View.Menu;

public class CreateTaskFactory extends CreateCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;
    private String format = "yyyy-MM-dd HH:mm";

    public Command create() throws Exception { //get userInput to createTask then pass it to constructor
        String[] userInputs = menu.createTask();
        String description = userInputs[0];
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date deadLine = formatter.parse(userInputs[1]);
        return new CreateTask(PIRs, description, deadLine);
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
