package Test;

import Model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class EventTest { //all test here should pass without any error
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Test
    public void testConstructor() {

        // Get the current date and time
        Date now = new Date();

        // Create a Calendar object with the current date and time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        // Add 30 minutes to the current time for the alarm
        calendar.add(Calendar.MINUTE, 30);
        Date alarm = calendar.getTime();

        // Add an additional 30 minutes (total 1 hour from now) for the startingTime
        calendar.add(Calendar.MINUTE, 30);
        Date startingTime = calendar.getTime();

        Event event = new Event("description", startingTime, alarm);

        assertTrue(event.getDescription().equals("description"));
        assertTrue(event.getStartingTime().equals(startingTime));
        assertTrue(event.getAlarm().equals(alarm));
    }

    @Test
    public void testConstructor_false() {

        // Get the current date and time
        Date now = new Date();

        // Create a Calendar object with the current date and time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        // Add 30 minutes to the current time for the alarm
        calendar.add(Calendar.MINUTE, 30);
        Date alarm = calendar.getTime();

        // Add an additional 30 minutes (total 1 hour from now) for the startingTime
        calendar.add(Calendar.MINUTE, 30);
        Date startingTime = calendar.getTime();

        Event event = new Event("description", startingTime, alarm);

        assertFalse(event.getDescription().equals("Wrong description"));
        assertFalse(event.getStartingTime().equals(alarm));
        assertFalse(event.getAlarm().equals(startingTime));
    }

    @Test
    public void testSetDescription() {
        Event event = new Event("description", new Date(), new Date());
        event.setDescription("new description");

        assertEquals("new description", event.getDescription());
    }

    @Test
    public void testSetStartingTime() {
        Event event = new Event("description", new Date(), new Date());
        Date newStartingTime = new Date();
        event.setStartingTime(newStartingTime);

        assertEquals(newStartingTime, event.getStartingTime());
    }

    @Test
    public void testSetAlarm() {
        Event event = new Event("description", new Date(), new Date());
        Date newAlarm = new Date();
        event.setAlarm(newAlarm);

        assertEquals(newAlarm, event.getAlarm());
    }

    @Test
    public void testGetString() {
        Date startingTime = new Date();
        Date alarm = new Date();
        Event event = new Event("description", startingTime, alarm);

        String expected = event.getID() + "| Event| description:description| starting time: " + dateFormat.format(startingTime) + "| alarm: " + dateFormat.format(alarm);
        assertEquals(expected, event.getString());
    }

    @Test
    public void testGetExportData() {
        Date startingTime = new Date();
        Date alarm = new Date();
        Event event = new Event("description", startingTime, alarm);

        String expected = "Event\n" + "description\n" + dateFormat.format(startingTime) + "\n" + dateFormat.format(alarm) + "\n";
        assertEquals(expected, event.getExportData());
    }
}
