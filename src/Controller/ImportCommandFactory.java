package Controller;

import java.util.ArrayList;

import Model.PIR;
import View.Menu;

public class ImportCommandFactory implements CommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;

    public Command create() throws Exception{
        String fileName = menu.askImportFileName(); //ask for the file name. for fileName.pim, user should input fileName
        fileName = "..\\PIM\\pim\\" + fileName + ".pim"; //file path and file name
        Command command = new ImportCommand(PIRs, fileName);
        return command;
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
