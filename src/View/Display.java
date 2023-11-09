package View;

import java.util.ArrayList;
import Model.*;

//this view module only print out message, no return value or BufferedReader
public class Display {

    public void displayMessage(String message){
        System.out.println(message);
    }

    public void displayIndex(){

    }

    public void displayPIRs(ArrayList<PIR> PIRs){
        int size = PIRs.size();
        System.out.println("There are " + size + " records.");
        for(int i = 0; i < size; i++){
            System.out.println(PIRs.get(i).getString());
        }
    }
}
