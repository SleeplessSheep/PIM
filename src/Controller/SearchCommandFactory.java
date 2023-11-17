package Controller;

import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.PIR;
import View.Display;
import View.Menu;

public class SearchCommandFactory implements CommandFactory{
    private ArrayList<PIR> PIRs;
    protected ArrayList<PIR> resultList = new ArrayList<PIR>();
    private ArrayList<PIR> temp1 = new ArrayList<PIR>();
    private ArrayList<PIR> temp2 = new ArrayList<PIR>(); //used when user need to combining two search result
    private Menu menu;
    Display display = new Display();
    
    private String logicConnector = "";
    private boolean SearchAgain; //Indicate if the user want to search again
    
    
    public Command create() throws Exception {
        HashMap<String, CommandFactory> searchFactory =  new HashMap<String, CommandFactory>(); //store the data type and corresponding searchFactory
                searchFactory.put("date", new SearchDateFactory());
                searchFactory.put("type", new SearchTypeFactory());
                searchFactory.put("text", new SearchTextFactory());

        SearchCommandFactory commandFactory;
        String criteria = menu.displaySearchMenu();
        
        Command command;

        switch (criteria) { //first attemp 
            case "type":
            case "text":
            case "date":
                commandFactory = (SearchCommandFactory)searchFactory.get(criteria);
                commandFactory.setPIR(PIRs);
                commandFactory.setMenu(menu);
                command = commandFactory.create();
                command.execute();
                temp1 = commandFactory.getResultList();
                break;
            default:
                throw new Exception("Not such criteria");
        }

        display.displayMessage("Current result:");
        display.displayPIRs(temp1);

        while(SearchAgain = menu.askSearchAgain()){ //keep search if the user type Y
            criteria = menu.displaySearchMenu();
            switch (criteria) { 
                case "type":
                case "text":
                case "date":
                    commandFactory = (SearchCommandFactory)searchFactory.get(criteria);
                    commandFactory.setPIR(PIRs);
                    commandFactory.setMenu(menu);
                    command = commandFactory.create();
                    command.execute();
                    temp2 = commandFactory.getResultList();
                    resultList.clear();
                    break;
                default:
                    throw new Exception("Not such criteria");
            }
            logicConnector = menu.askLogicConnector();
            command = new LogicConnectCommand(temp1, temp2, resultList, logicConnector);
            command.execute();
            display.displayPIRs(resultList);
        }
        
        return command;
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }

    public ArrayList<PIR> getResultList(){
        return resultList;
    }
}