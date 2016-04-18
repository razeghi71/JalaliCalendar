package ir.huri.jcal;

import ir.huri.jcal.JalaliCalendar;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by mohammad on 4/15/16.
 */
public class JalaliCalenderTest extends TestCase {

    @Test
    public void testGregorianToJalali() {
        JalaliCalendar codeCreationDate = new JalaliCalendar(new GregorianCalendar(2016, 3, 16));
        assertEquals(codeCreationDate, new JalaliCalendar(1395, 1, 28));

        JalaliCalendar myRoomMateBirthday = new JalaliCalendar(new GregorianCalendar(1992, 9, 25));
        assertEquals(myRoomMateBirthday, new JalaliCalendar(1371, 8, 3));

        JalaliCalendar myBirthday = new JalaliCalendar(new GregorianCalendar(1992, 10, 18));
        assertEquals(myBirthday, new JalaliCalendar(1371, 8, 27));
//
        JalaliCalendar boundaryDay= new JalaliCalendar(new GregorianCalendar(2016, 0, 31));
        assertEquals(boundaryDay, new JalaliCalendar(1394, 11, 11));
    }

    @Test
    public void testJalaliToGregorian() {
        GregorianCalendar codeCreationDate = new JalaliCalendar(1395, 1, 28).toGregorian();
        assertEquals(codeCreationDate.get(Calendar.DAY_OF_MONTH), 16);
        assertEquals(codeCreationDate.get(Calendar.MONTH), 3);
        assertEquals(codeCreationDate.get(Calendar.YEAR), 2016);

        GregorianCalendar myRoomMateBirthday = new JalaliCalendar(1371, 8, 3).toGregorian();
        assertEquals(myRoomMateBirthday.get(Calendar.DAY_OF_MONTH), 25);
        assertEquals(myRoomMateBirthday.get(Calendar.MONTH), 9);
        assertEquals(myRoomMateBirthday.get(Calendar.YEAR), 1992);

        GregorianCalendar epoch = new JalaliCalendar(1348, 10, 11).toGregorian();
        assertEquals(epoch.get(Calendar.DAY_OF_MONTH), 1);
        assertEquals(epoch.get(Calendar.MONTH), 0);
        assertEquals(epoch.get(Calendar.YEAR), 1970);
    }

    @Test
    public void testToString() {
        JalaliCalendar myRoomMateBirthday = new JalaliCalendar(1371, 8, 3);
        assertEquals(myRoomMateBirthday.toString(), "1371-08-03");

        JalaliCalendar codeCreationDate = new JalaliCalendar(new GregorianCalendar(2016, 3, 16));
        assertEquals(codeCreationDate.toString(), "1395-01-28");
    }

    @Test
    public void testRelativeDates() {
        JalaliCalendar myFriendsBirthday = new JalaliCalendar(1372, 4, 8);
        JalaliCalendar nextDay = myFriendsBirthday.getTomorrow();
        JalaliCalendar prevDay = myFriendsBirthday.getYesterday();

        assertEquals(nextDay, new JalaliCalendar(1372,4, 9));
        assertEquals(prevDay, new JalaliCalendar(1372,4, 7));
    }

    @Test
    public void testWeekDay() {
        JalaliCalendar testCreationDate = new JalaliCalendar(1395, 1, 30);
        assertEquals(testCreationDate.getDayofWeekString(), "دوشنبه");

        JalaliCalendar myRoomMateBirthday = new JalaliCalendar(1371, 8, 3);
        assertEquals(myRoomMateBirthday.getDayofWeekString(), "یک‌شنبه");

        JalaliCalendar myBirthday = new JalaliCalendar(1371, 8, 27);
        assertEquals(myBirthday.getDayofWeekString(), "چهارشنبه");
    }
}
