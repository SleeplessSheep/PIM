package Test;
import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextNoteTest { //all test here should pass without any error
    @Test
    void testConstructor() {
        TextNote textNote = new TextNote("note content");

        assertEquals("note content", textNote.getNoteContent());
    }

    @Test
    void testSetNoteContent() {
        TextNote textNote = new TextNote("note content");
        textNote.setNoteContent("new note content");

        assertEquals("new note content", textNote.getNoteContent());
    }

    @Test
    void testGetString() {
        TextNote textNote = new TextNote("note content");

        String expected = textNote.getID() + "| TextNote| content: note content";
        assertEquals(expected, textNote.getString());
    }

    @Test
    void testGetExportData() {
        TextNote textNote = new TextNote("note content");

        String expected = "TextNote\n" + "note content\n";
        assertEquals(expected, textNote.getExportData());
    }
}
