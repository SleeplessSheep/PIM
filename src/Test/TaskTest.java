package Test;
import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class TaskTest { //all test here should pass without any error
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //same as PIR's dateFormat

    @Test
    void testConstructor() { //test Constructor of Contact with AI-generated data
        // Get the current date and time
        Date now = new Date();

        // Create a Calendar object with the current date and time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        // Add 30 minutes to the current time for the alarm
        calendar.add(Calendar.MINUTE, 30);
        Date deadline = calendar.getTime();
        Task task = new Task("description", deadline);

        assertEquals("description", task.getDescription());
        assertEquals(deadline, task.getDeadline());
    }

    @Test
    void testSetDescription() { //test setDescription method and use getDescription method to verify
        Task task = new Task("description", new Date());
        task.setDescription("new description");

        assertEquals("new description", task.getDescription());
    }

    @Test
    void testSetDeadline() { //test setDeadline method and use getDeadline method to verify
        Task task = new Task("description", new Date());
        Date newDeadline = new Date();
        task.setDeadline(newDeadline);

        assertEquals(newDeadline, task.getDeadline());
    }

    @Test
    void testGetString() { //test getString and check is it equals to expected
        Date deadline = new Date();
        Task task = new Task("description", deadline);

        String expected = task.getID() + "| Task| description: description| deadline: " + dateFormat.format(deadline);
        assertEquals(expected, task.getString());
    }

    @Test
    void testGetExportData() { //test getExportData and check is it equals to expected
        Date deadline = new Date();
        Task task = new Task("description", deadline);

        String expected = "Task\n" + "description\n" + dateFormat.format(deadline) + "\n";
        assertEquals(expected, task.getExportData());
    }
}
