package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.*;
import View.Menu;

public class SearchDateFactory extends SearchCommandFactory{
    private ArrayList<PIR> PIRs;
    private Menu menu;
    private String format = "yyyy-MM-dd HH:mm";

    public Command create() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date;
        String dateLogic;
        date = formatter.parse(menu.askDate());
        dateLogic = menu.askDateLogic();
        return new SearchDate(PIRs, resultList, date, dateLogic);
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
