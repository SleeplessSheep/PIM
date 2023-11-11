package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.*;
import View.Display;

public class SearchDate implements Command{
    private ArrayList<PIR> PIRs; //origin ArrayList<PIR> PIRs or ArrayList<PIR> resultList from the last time searching
    private ArrayList<PIR> resultList;
    private Display display = new Display();
    private Date searchDate;
    private String dateLogic;


    public SearchDate(ArrayList<PIR> PIRs, ArrayList<PIR> resultList1, Date date, String dateLogic){
        this.PIRs = PIRs;
        this.searchDate = date;
        this.dateLogic = dateLogic;
        this.PIRs = PIRs;
        resultList = resultList1;
    }

    public void execute(){
        System.out.println("---SearchDate---execute()");
        Date bufDate;
        String bufString;
        Event bufEvent;
        Task bufTask;
        for(int i = 0;i < PIRs.size();i++){
            bufString = PIRs.get(i).getType();
            if(bufString.equals("Event")){
                bufEvent = (Event)PIRs.get(i);
                bufDate = bufEvent.getStartingTime();
                if(compareDate(bufDate, searchDate, dateLogic)){
                    resultList.add(bufEvent);
                }else{
                    bufDate = bufEvent.getAlarm();
                    if(compareDate(bufDate, searchDate, dateLogic)){
                        resultList.add(bufEvent);
                    }
                    continue; //type = event and date not match the searchDate and dateLogic
                }

            }else if(bufString.equals("Task")){
                bufTask = (Task)PIRs.get(i);
                bufDate = bufTask.getDeadline();
                if(compareDate(bufDate, searchDate, dateLogic)){
                    resultList.add(bufTask);
                }else{
                    continue; //type = task and date not match the searchDate and dateLogic
                }
            } 
            
        }
        

    }

    public boolean compareDate(Date bufDate, Date searchDate, String dateLogic){
        if (dateLogic.equals("<")) {
            if (bufDate.before(searchDate)) { //bufDate < searchDate
                return true;
            }else {
                return false;
            }
        }else if(dateLogic.equals(">")){
            if (bufDate.after(searchDate)) { //bufDate > searchDate
                return true;
            }else {
                return false;
            }
        }else if(dateLogic.equals("=")){
            if (bufDate.equals(searchDate)) { //bufDate = searchDate
                return true;
            }else {
                return false;
            }
        }else{
            //error
            return false;
        }
    }
}
