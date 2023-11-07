package Model;

public abstract class PIR { //PIR stand for Personal Information Record
    string type; //the type of PIR, it could be Contact, Event, Task, TextNote
    public abstract String getString(); //return the info of the record as String in certain format
    public String getType(){//return the type
        return this.type;
    } 
}
