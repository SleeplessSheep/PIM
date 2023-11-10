package Controller;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.*;
import View.Menu;


public class CreateEventFactory extends CreateCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;
    private String format = "yyyy-MM-dd HH:mm";

    public Command create() throws Exception {
        String[] userInputs = menu.createEvent();
        String description = userInputs[0];
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date startDate = formatter.parse(userInputs[1]);
        Date alarmDate = formatter.parse(userInputs[2]);
        return new CreateEvent(PIRs, description, startDate, alarmDate);
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
