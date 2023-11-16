package Model;
import java.util.Date;

public class Task extends PIR {
    private String description;
    private Date deadline;

    public Task(String description, Date deadline){//constructor of task 
        this.ID = ++counter;
        this.description = description;
        this.deadline = deadline;
        this.type = "Task";
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String newDescription){ //update Description
        this.description = newDescription;
    }

    public Date getDeadline(){
        return this.deadline;
    }

    public void setDeadline(Date newDeadline){ //update Deadline
        this.deadline = newDeadline;
    }
    
    public String getString(){
        return ID + "| " + type + "| description: " + description + "| deadline: " + dateFormat.format(deadline);
    }

    public String getExportData() {
        String buf = type + "\n" + description + "\n" + dateFormat.format(deadline) + "\n";
        return buf;
    }
}
