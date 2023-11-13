package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Model.PIR;
import View.*;

//map user action
public class CommandMap {
    ArrayList<PIR> PIRs = new ArrayList<PIR>();
    Menu menu;


    public CommandMap(ArrayList<PIR> PIRs, Menu menu){
        this.PIRs = PIRs;
        this.menu = menu;
    }

    public void mapToCommand(String userEvent) throws Exception {
        CommandFactory commandFactory;
		Command command;
        HashMap<String, CommandFactory> comFactories =  new HashMap< String, CommandFactory>();
			comFactories.put("Create", new CreateCommandFactory());
            comFactories.put("Print", new DisplayCommandFactory());
            comFactories.put("Delete", new DeleteCommandFactory());
            comFactories.put("Modify", new ModifyCommandFactory());
            comFactories.put("Search", new SearchCommandFactory());
			/*
			comFactories.put("Export","");
			comFactories.put("Import","");
			 */
        try{

            switch (userEvent) {
                case "Create":
                case "Delete":
                case "Export":
                case "Import":
                case "Print":
                case "Modify":
                    
                    //commandFactory = (CommandFactory) Class.forName(factory).getDeclaredConstructor().newInstance();
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
                    //SearchCommand have special logic, it execute inside the SearchCommandFactory
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
