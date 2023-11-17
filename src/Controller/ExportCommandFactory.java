package Controller;

import java.util.ArrayList;

import Model.PIR;
import View.Menu;

public class ExportCommandFactory implements CommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;

    public Command create() throws Exception {
        String fileName = menu.askExportFileName(); //get the file name from userInput
        fileName = "..\\PIM\\pim\\" + fileName + ".pim"; //the file path would be ..\PIM\pim\fileName.pim
        Command command = new ExportCommand(PIRs, fileName);
        return command;
    }

    public void setPIR(ArrayList<PIR> PIRs){
        this.PIRs = PIRs;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
