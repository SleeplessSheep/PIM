package Controller;

import java.util.ArrayList;

import Model.*;
import View.Menu;

public class SearchTextFactory extends SearchCommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;
    
    public Command create() throws Exception {
        String text;
        boolean NegationIndicator;
        text = menu.askText();
        NegationIndicator = menu.askNegationIndicator();

        return new SearchText(PIRs, resultList, text, NegationIndicator);
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
