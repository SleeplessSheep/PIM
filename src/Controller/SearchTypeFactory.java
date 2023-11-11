package Controller;

import java.util.ArrayList;

import Model.*;
import View.Menu;

public class SearchTypeFactory extends SearchCommandFactory{
    private ArrayList<PIR> PIRs;
    private Menu menu;

    public Command create() throws Exception {
        String type;
        boolean NegationIndicator;
        type = menu.askType();
        NegationIndicator = menu.askNegationIndicator();

        return new SearchType(PIRs, resultList, type, NegationIndicator);
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
