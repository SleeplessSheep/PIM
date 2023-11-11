package Controller;

import java.util.ArrayList;

import Model.*;
import View.Display;

public class SearchType implements Command {
    private ArrayList<PIR> PIRs; //origin ArrayList<PIR> PIRs or ArrayList<PIR> resultList from the last time searching
    private ArrayList<PIR> resultList;
    private Display display = new Display();
    private String searchType;
    private boolean NegationIndicator;

    public SearchType(ArrayList<PIR> PIRs, ArrayList<PIR> resultList1, String searchType, boolean NegationIndicator){
        this.PIRs = PIRs;
        this.searchType = searchType;
        this.NegationIndicator = NegationIndicator;
        this.PIRs = PIRs;
        resultList = resultList1;
    }

    public void execute(){
        String bufType;
        PIR bufRecord;
        for(int i = 0;i < PIRs.size();i++){
            bufType = PIRs.get(i).getType();
            if(NegationIndicator){//Not
                if(!bufType.equals(searchType)){
                bufRecord = PIRs.get(i);
                resultList.add(bufRecord);
                }
            }else { //without NOT
                if(bufType.equals(searchType)){
                bufRecord = PIRs.get(i);
                resultList.add(bufRecord);
                }
            }
        }
        
    }
}
