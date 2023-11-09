package Model;

public class TextNote extends PIR {
    private String noteContent;

    public TextNote(String noteContent){ 
        //constructor of textNote 
        this.ID = ++counter;
        this.noteContent = noteContent;
        this.type = "TextNote";
    }

    public String getString(){ 
        return ID + "| " + type + "| " + this.noteContent;
    }
    
}
