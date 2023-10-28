package Model;
import java.time.format.DateTimeFormatter;

public class Task extends PIR {
    private String description;
    private DateTimeFormatter deadline;

    public Task(String description, DateTimeFormatter deadline){//constructor of task 
        this.description = description;
        this.deadline = deadline;

    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String newDescription){ //update Description
        this.description = newDescription;
    }

    public DateTimeFormatter getDeadline(){
        return this.deadline;
    }

    public void setDeadline(DateTimeFormatter newDeadline){ //update Deadline
        this.deadline = newDeadline;
    }
    
    public String getString(){
        return "Task| description: " + description + "| deadline: " + deadline;
    }
}
