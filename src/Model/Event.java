package Model;
import java.util.Date;

public class Event extends PIR {
    private String description;
    private Date startingTime;
    private Date alarm;

    public Event(String description, Date startingTime, Date alarm){//constructor of event
        this.ID = ++counter;
        this.description = description;
        this.startingTime = startingTime;
        this.alarm = alarm;
        this.type = "Event";
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String newDescription){ //update Description
        this.description = newDescription;
    }

    public Date getStartingTime(){
        return this.startingTime;
    }

    public void setStartingTime(Date startingTime){ //update startingTime
        this.startingTime = startingTime;
    }

    public Date getAlarm(){
        return this.alarm;
    }

    public void setAlarm(Date alarm){ //update startingTime
        this.alarm = alarm;
    }
    
    public String getString(){
        return ID + "| " + type + "| description:" + description + "| starting time: " + dateFormat.format(startingTime) + "| alarm: " + dateFormat.format(alarm);
    }

    public String getExportData() {
        String buf = type + "\n" + description + "\n" + dateFormat.format(startingTime) + "\n" + dateFormat.format(alarm) + "\n";
        return buf;
    }
}

