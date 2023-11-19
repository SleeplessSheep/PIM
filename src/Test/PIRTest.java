package Test;

import Model.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PIRTest { //all test here should pass without any error
    @Test
    public void testPIRsArrayList(){ //test some ArrayList operation that may use in the program
        // Create an ArrayList of PIR objects
        ArrayList<PIR> PIRs = new ArrayList<PIR>();

        // Create instances of Contact, Event, Task, and TextNote
        Contact contact = new Contact("name", "address", 22109288);
        Event event = new Event("description", new Date(), new Date());
        Task task = new Task("description", new Date());
        TextNote textNote = new TextNote("note content");

        // Add the instances to the ArrayList
        PIRs.add(contact); //index should be 0
        PIRs.add(event);
        PIRs.add(task);
        PIRs.add(textNote);

        // Check that the ArrayList contains the right number of elements
        assertEquals(4, PIRs.size());

        // Check that the ArrayList contains the instances
        assertTrue(PIRs.contains(contact));
        assertTrue(PIRs.contains(event));
        assertTrue(PIRs.contains(task));
        assertTrue(PIRs.contains(textNote));

        // Check that the ArrayList remove Object equal to orgin Object
        PIR removeContact = PIRs.remove(0);
        assertEquals(contact, removeContact);

        //use ID to search for Object in the ArrayList
        int ID = textNote.getID();
        int getID;
        for(int i = 0;i < PIRs.size();i++){ 
            getID = PIRs.get(i).getID(); 
            if (getID == ID) { //found
                assertEquals(textNote, PIRs.get(i));
            }
        }
    }

}
