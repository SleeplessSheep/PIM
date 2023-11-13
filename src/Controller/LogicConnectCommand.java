package Controller;

import java.util.ArrayList;

import Model.*;
import View.Display;

public class LogicConnectCommand implements Command {
    private ArrayList<PIR> temp1; 
    private ArrayList<PIR> temp2;
    private ArrayList<PIR> resultList;
    private String logicConnector;
    Display display = new Display();

    public LogicConnectCommand(ArrayList<PIR> temp1, ArrayList<PIR> temp2, ArrayList<PIR> resultList, String logicConnector){
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.resultList = resultList;
        this.logicConnector = logicConnector;
    }

    public void execute(){
        int ID1, ID2, resultID;
        boolean foundFlag;
        switch (logicConnector) {
            case "&&":
                for(int i = 0;i < temp1.size();i++){
                    ID1 = temp1.get(i).getID();
                    for(int j = 0;j < temp2.size();j++){
                        ID2 = temp2.get(j).getID();
                        foundFlag = false;
                        if(ID1 ==  ID2){ //both ArrayList have this ID
                            for(int k = 0;k < resultList.size() ;k++){ //find if it already added
                                resultID = resultList.get(k).getID();
                                if (ID2 == resultID) {
                                    foundFlag = true;
                                    continue;
                                }
                            }
                            if (!foundFlag) {
                                resultList.add(temp2.get(j));
                            }
                        }
                    }
                }
                temp1.clear();
                temp2.clear();
                temp1 = resultList;
                break;
            case "||":
                for(int i = 0;i < temp1.size();i++){
                    resultList.add(temp1.get(i)); //add all record in temp1 into resultList 
                }
                for(int j = 0;j < temp2.size();j++){ //check if record in temp2 already in resultList
                    ID2 = temp2.get(j).getID();
                    foundFlag = false;
                    for(int k = 0;k < resultList.size() ;k++){
                        ID1 = temp1.get(k).getID();
                        if (ID2 == ID1) {
                            foundFlag = true;
                            continue;
                        }
                    }
                    if (!foundFlag) {
                        resultList.add(temp2.get(j));
                    }
                }
                temp1.clear();
                temp2.clear();
                temp1 = resultList;
                break;
            
        
            default:
                break;
        }
        display.displayMessage("After connected with " + logicConnector);
        //display.displayPIRs(resultList);
    }
}
