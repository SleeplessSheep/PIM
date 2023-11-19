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
    void testSetNoteContent() { //test Constructor of TextNote with AI-generated data
        TextNote textNote = new TextNote("note content");
        textNote.setNoteContent("new note content");

        assertEquals("new note content", textNote.getNoteContent());
    }

    @Test
    void testGetString() { //test setDescription method and use getDescription method to verify
        TextNote textNote = new TextNote("note content");

        String expected = textNote.getID() + "| TextNote| content: note content";
        assertEquals(expected, textNote.getString());
    }

    @Test
    void testGetExportData() { //test getExportData and check is it equals to expected
        TextNote textNote = new TextNote("note content");

        String expected = "TextNote\n" + "note content\n";
        assertEquals(expected, textNote.getExportData());
    }
}
