package Test;
import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest { //all test here should pass without any error
    @Test
    void testConstructor() { //test Constructor of Contact with AI-generated data
        Contact contact = new Contact("name", "address", 22109288); 
        //it should create an Contact Object
        assertEquals("name", contact.getName());
        assertEquals("address", contact.getAddress());
        assertEquals(22109288, contact.getMobileNumber());
    }

    @Test
    void testSetName() { //test setName method and use getName method to verify
        Contact contact = new Contact("name", "address", 22109288);
        contact.setName("new name");

        assertEquals("new name", contact.getName());
    }

    @Test
    void testSetAddress() { //test setAddress method and use getAddress method to verify
        Contact contact = new Contact("name", "address", 22109288);
        contact.setAddress("new address");

        assertEquals("new address", contact.getAddress());
    }

    @Test
    void testSetMobileNumber() { //test setMobileNumber method and use getMobileNumber method to verify
        Contact contact = new Contact("name", "address", 22109288);
        contact.setMobileNumber(12345678);

        assertEquals(12345678, contact.getMobileNumber());
    }

    @Test
    void testGetString() { //test getString and check is it equals to expected
        Contact contact = new Contact("name", "address", 22109288);

        String expected = contact.getID() + "| Contact| name: name| address: address| mobile number: 22109288";
        assertEquals(expected, contact.getString());
    }

    @Test
    void testGetExportData() { //test getExportData and check is it equals to expected
        Contact contact = new Contact("name", "address", 22109288);

        String expected = "Contact\n" + "name\n" + "address\n" + "22109288\n";
        assertEquals(expected, contact.getExportData());
    }
}