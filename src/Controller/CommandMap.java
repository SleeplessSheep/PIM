package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Model.PIR;
import View.*;

//map user action
public class CommandMap {
    ArrayList<PIR> PIRs = new ArrayList<PIR>();
    Menu menu;

    //PIRs is the List of the personal information records, and menu hold the Input Stream to get user input
    public CommandMap(ArrayList<PIR> PIRs, Menu menu){
        this.PIRs = PIRs;
        this.menu = menu;
    }

    public void mapToCommand(String userEvent) throws Exception {//call corresponding commandFactory if the user input match any
        CommandFactory commandFactory;
		Command command;
        HashMap<String, CommandFactory> comFactories =  new HashMap< String, CommandFactory>();
			comFactories.put("Create", new CreateCommandFactory());
            comFactories.put("Print", new DisplayCommandFactory());
            comFactories.put("Delete", new DeleteCommandFactory());
            comFactories.put("Modify", new ModifyCommandFactory());
            comFactories.put("Search", new SearchCommandFactory());
			comFactories.put("Export", new ExportCommandFactory());
			comFactories.put("Import", new ImportCommandFactory());
        try{

            switch (userEvent) {
                case "Create":
                case "Delete":
                case "Export":
                case "Import":
                case "Print":
                case "Modify":
                    commandFactory = comFactories.get(userEvent);
                    commandFactory.setPIR(PIRs);
                    commandFactory.setMenu(menu);
                    command = commandFactory.create();
                    command.execute();
                    break;
                
                case "Search":
                    commandFactory = comFactories.get(userEvent);
                    commandFactory.setPIR(PIRs);
                    commandFactory.setMenu(menu);
                    command = commandFactory.create();
                    break;
                default:
                    break;
            }
        }catch (Exception e) {
            System.out.println("*** occur in mapToCommand ***" + e.getMessage());
        }
        System.out.println();
    }
}
