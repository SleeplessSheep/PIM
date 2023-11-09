package Model;

import java.text.SimpleDateFormat;

public abstract class PIR { //PIR stand for Personal Information Record
    protected String type; //the type of PIR, it could be Contact, Event, Task, TextNote
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    protected static int counter = 0;
    protected int ID;
    public abstract String getString(); //return the info of the record as String in certain format
    public String getType(){//return the type
        return this.type;
    } 

    public int getID(){
        return this.ID;
    }
}
