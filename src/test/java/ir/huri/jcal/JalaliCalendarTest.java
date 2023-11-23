package ir.huri.jcal;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by mohammad on 4/15/16.
 */
public class JalaliCalendarTest {

    @Test
    public void testGregorianToJalali() {
        JalaliCalendar codeCreationDate = new JalaliCalendar(new GregorianCalendar(2016, Calendar.APRIL, 16));
        assertEquals(codeCreationDate, new JalaliCalendar(1395, 1, 28));

        JalaliCalendar myRoomMateBirthday = new JalaliCalendar(new GregorianCalendar(1992, Calendar.OCTOBER, 25));
        assertEquals(myRoomMateBirthday, new JalaliCalendar(1371, 8, 3));

        JalaliCalendar myBirthday = new JalaliCalendar(new GregorianCalendar(1992, Calendar.NOVEMBER, 18));
        assertEquals(myBirthday, new JalaliCalendar(1371, 8, 27));

        JalaliCalendar boundaryDay = new JalaliCalendar(new GregorianCalendar(2016, Calendar.JANUARY, 31));
        assertEquals(boundaryDay, new JalaliCalendar(1394, 11, 11));

        JalaliCalendar otherBoundaryDay = new JalaliCalendar(new GregorianCalendar(2017, Calendar.JANUARY, 20));
        assertEquals(otherBoundaryDay, new JalaliCalendar(1395, 11, 1));
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

        JalaliCalendar codeCreationDate = new JalaliCalendar(new GregorianCalendar(2016, Calendar.APRIL, 16));
        assertEquals(codeCreationDate.toString(), "1395-01-28");
    }

    @Test
    public void testRelativeDates() {
        JalaliCalendar myFriendsBirthday = new JalaliCalendar(1372, 4, 8);
        JalaliCalendar nextDay = myFriendsBirthday.getTomorrow();
        JalaliCalendar prevDay = myFriendsBirthday.getYesterday();
        JalaliCalendar boundaryDay = new JalaliCalendar(1372, 8, 30).getDateByDiff(2);
        JalaliCalendar boundaryDay2 = new JalaliCalendar(1372, 1, 15).getDateByDiff(20);

        assertEquals(nextDay, new JalaliCalendar(1372, 4, 9));
        assertEquals(prevDay, new JalaliCalendar(1372, 4, 7));
        assertEquals(boundaryDay, new JalaliCalendar(1372, 9, 2));
        assertEquals(boundaryDay2, new JalaliCalendar(1372, 2, 4));
    }

    @Test
    public void testWeekDay() {
        JalaliCalendar testCreationDate = new JalaliCalendar(1395, 1, 30);
        assertEquals(testCreationDate.getDayOfWeekString(), "دوشنبه");

        JalaliCalendar myRoomMateBirthday = new JalaliCalendar(1371, 8, 3);
        assertEquals(myRoomMateBirthday.getDayOfWeekString(), "یک‌شنبه");

        JalaliCalendar myBirthday = new JalaliCalendar(1371, 8, 27);
        assertEquals(myBirthday.getDayOfWeekString(), "چهارشنبه");
    }

    @Test
    public void testLeap() {
        JalaliCalendar leapYear = new JalaliCalendar(1391, 1, 1);
        assertTrue(leapYear.isLeap());

        JalaliCalendar leapYear2 = new JalaliCalendar(1395, 1, 1);
        assertTrue(leapYear2.isLeap());

        JalaliCalendar leapYear3 = new JalaliCalendar(1383, 12, 20);
        assertTrue(leapYear3.isLeap());

        JalaliCalendar notLeapYear1 = new JalaliCalendar(1396, 1, 1);
        assertFalse(notLeapYear1.isLeap());

        JalaliCalendar notLeapYear2 = new JalaliCalendar(1398, 12, 1);
        assertFalse(notLeapYear2.isLeap());

        JalaliCalendar notLeapYear3 = new JalaliCalendar(1380, 7, 1);
        assertFalse(notLeapYear3.isLeap());

        JalaliCalendar notLeapYear4 = new JalaliCalendar(1384, 12, 1);
        assertFalse(notLeapYear4.isLeap());

        assertEquals(366, leapYear.getYearLength());
        assertEquals(366, leapYear2.getYearLength());
        assertEquals(366, leapYear3.getYearLength());

        assertEquals(365, notLeapYear1.getYearLength());
        assertEquals(365, notLeapYear2.getYearLength());
        assertEquals(365, notLeapYear3.getYearLength());
        assertEquals(365, notLeapYear4.getYearLength());

        assertEquals(31, leapYear.getMonthLength());
        assertEquals(30, leapYear3.getMonthLength());

        assertEquals(31, notLeapYear1.getMonthLength());
        assertEquals(29, notLeapYear2.getMonthLength());
        assertEquals(30, notLeapYear3.getMonthLength());
        assertEquals(29, notLeapYear4.getMonthLength());
    }


}
