package Model;

public class TextNote extends PIR {
    private String noteContent;

    public TextNote(String noteContent){ //constructor of textNote 
        this.noteContent = noteContent;
    }

    public String getString(){ 
        return "Text note| " + this.noteContent;
    }
    
}
