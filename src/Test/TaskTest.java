package Test;
import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

class TaskTest { //all test here should pass without any error
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //same as PIR's dateFormat

    @Test
    void testConstructor() {
        Date deadline = new Date();
        Task task = new Task("description", deadline);

        assertEquals("description", task.getDescription());
        assertEquals(deadline, task.getDeadline());
    }

    @Test
    void testSetDescription() {
        Task task = new Task("description", new Date());
        task.setDescription("new description");

        assertEquals("new description", task.getDescription());
    }

    @Test
    void testSetDeadline() {
        Task task = new Task("description", new Date());
        Date newDeadline = new Date();
        task.setDeadline(newDeadline);

        assertEquals(newDeadline, task.getDeadline());
    }

    @Test
    void testGetString() {
        Date deadline = new Date();
        Task task = new Task("description", deadline);

        String expected = task.getID() + "| Task| description: description| deadline: " + dateFormat.format(deadline);
        assertEquals(expected, task.getString());
    }

    @Test
    void testGetExportData() {
        Date deadline = new Date();
        Task task = new Task("description", deadline);

        String expected = "Task\n" + "description\n" + dateFormat.format(deadline) + "\n";
        assertEquals(expected, task.getExportData());
    }
}
