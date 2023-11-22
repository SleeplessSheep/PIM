package Controller;

import java.util.ArrayList;

import Model.*;
import View.Display;

public class SearchText implements Command {
    private ArrayList<PIR> PIRs; //origin ArrayList<PIR> PIRs or ArrayList<PIR> resultList from the last time searching
    private ArrayList<PIR> resultList;
    private Display display = new Display();
    private String searchText;
    private boolean NegationIndicator;

    public SearchText(ArrayList<PIR> PIRs, ArrayList<PIR> resultList1, String searchText, boolean NegationIndicator){ //constructor of Search text
        this.PIRs = PIRs;
        this.searchText = searchText;
        this.NegationIndicator = NegationIndicator;
        this.PIRs = PIRs;
        resultList = resultList1;
    }

    public void execute(){
        String bufText;
        String bufType;
        Contact bufContact;
        Event bufEvent;
        Task bufTask;
        TextNote bufNote;
        
        for(int i = 0;i < PIRs.size();i++){
            bufType = PIRs.get(i).getType();
            switch (bufType) {
                case "Contact":
                    bufContact = (Contact)PIRs.get(i);
                    bufText = bufContact.getAddress();
                    if (containText(bufText, searchText, NegationIndicator)){
                        resultList.add(bufContact);
                    }else if(containText(bufContact.getName(), searchText, NegationIndicator)){
                        resultList.add(bufContact);
                    } //not matching
                    break;
                case "Event":
                    bufEvent = (Event)PIRs.get(i);
                    if(containText(bufEvent.getDescription(), searchText, NegationIndicator)){
                        resultList.add(bufEvent);
                    }
                    break;
                case "Task":
                    bufTask = (Task)PIRs.get(i);
                    if(containText(bufTask.getDescription(), searchText, NegationIndicator)){
                        resultList.add(bufTask);
                    }
                    break;
                case "TextNote":
                    bufNote = (TextNote)PIRs.get(i);
                    if(containText(bufNote.getNoteContent(), searchText, NegationIndicator)){
                        resultList.add(bufNote);
                    }
                    break;
            
                default:
                    break;//error
            }
        }
    }

    public boolean containText(String bufText, String searchText, boolean NegationIndicator){
        if(NegationIndicator){//Not
            if(!(bufText.toUpperCase().contains(searchText.toUpperCase()))){
                return true;//match [NOT contains searchText]
            }else{
                return false;
            }
        }else { //without NOT
            if(bufText.toUpperCase().contains(searchText.toUpperCase())){
                return true;//match [contains searchText]
            }else{
                return false;
            }
        }
    }

}
