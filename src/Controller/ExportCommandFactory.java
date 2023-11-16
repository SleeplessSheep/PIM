package Controller;

import java.util.ArrayList;

import Model.PIR;
import View.Menu;

public class ExportCommandFactory implements CommandFactory {
    private ArrayList<PIR> PIRs;
    private Menu menu;

    public Command create() throws Exception {
        String fileName = menu.askExportFileName();
        fileName = "..\\PIM\\pim\\" + fileName + ".pim";
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
