package Model;
import java.time.format.DateTimeFormatter;

public class Event extends PIR {
    private String description;
    private DateTimeFormatter startingTime;
    private DateTimeFormatter alarm;

    public Event(String description, DateTimeFormatter startingTime, DateTimeFormatter alarm){//constructor of event
        this.description = description;
        this.startingTime = startingTime;
        this.alarm = alarm;

    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String newDescription){ //update Description
        this.description = newDescription;
    }

    public DateTimeFormatter getStartingTime(){
        return this.startingTime;
    }

    public void setStartingTime(DateTimeFormatter startingTime){ //update startingTime
        this.startingTime = startingTime;
    }

    public DateTimeFormatter getAlarm(){
        return this.alarm;
    }

    public void setAlarm(DateTimeFormatter alarm){ //update startingTime
        this.alarm = alarm;
    }
    
    public String getString(){
        return "Event| description:" + description + "| starting time: " + startingTime + "| alarm: " + alarm;
    }
}

