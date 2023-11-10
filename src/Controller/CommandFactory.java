package Controller;

import java.util.ArrayList;
import Model.PIR;
import View.*;

//interface for command factory like createCommandFactory, and CommandFactory help to link up different create command
public interface CommandFactory {
    
    public Command create() throws Exception;
    public void setPIR(ArrayList<PIR> PIRs);
    public void setMenu(Menu menu);
}
