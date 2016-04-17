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
        JalaliCalendar codeCreationDate = new JalaliCalendar(new GregorianCalendar(2016, 4, 16));
        assert codeCreationDate.getDay() == 28;
        assert codeCreationDate.getMonth() == 1;
        assert codeCreationDate.getYear() == 1395;

        JalaliCalendar myRoomMateBirthday = new JalaliCalendar(new GregorianCalendar(1992, 10, 25));
        assert myRoomMateBirthday.getDay() == 3;
        assert myRoomMateBirthday.getMonth() == 8;
        assert myRoomMateBirthday.getYear() == 1371;

        JalaliCalendar myBirthday = new JalaliCalendar(new GregorianCalendar(1992, 11, 18));
        assert myBirthday.getDay() == 27;
        assert myBirthday.getMonth() == 8;
        assert myBirthday.getYear() == 1371;
    }

    @Test
    public void testJalaliToGregorian() {
        GregorianCalendar codeCreationDate = new JalaliCalendar(1395, 1, 28).toGregorian();
        assert codeCreationDate.get(Calendar.DAY_OF_MONTH)  == 16;
        assert codeCreationDate.get(Calendar.MONTH) ==  4;
        assert codeCreationDate.get(Calendar.YEAR) == 2016;

        GregorianCalendar myRoomMateBirthday = new JalaliCalendar(1371, 8, 3).toGregorian();
        assert myRoomMateBirthday.get(Calendar.DAY_OF_MONTH)  == 25;
        assert myRoomMateBirthday.get(Calendar.MONTH) ==  10;
        assert myRoomMateBirthday.get(Calendar.YEAR) == 1992;

        GregorianCalendar epoch = new JalaliCalendar(1348, 10, 11).toGregorian();
        assert epoch.get(Calendar.DAY_OF_MONTH)  == 1;
        assert epoch.get(Calendar.MONTH) ==  1;
        assert epoch.get(Calendar.YEAR) == 1970;
    }

    @Test
    public void testToString() {
        JalaliCalendar myRoomMateBirthday = new JalaliCalendar(1371, 8, 3);
        assert myRoomMateBirthday.toString().equals("1371-08-03");

        JalaliCalendar codeCreationDate = new JalaliCalendar(new GregorianCalendar(2016, 4, 16));
        assert codeCreationDate.toString().equals("1395-01-28");
    }

    @Test
    public void testRelativeDates() {
        JalaliCalendar myFriendsBirthday = new JalaliCalendar(1372, 4, 8);
        JalaliCalendar nextDay = myFriendsBirthday.getTomorrow();
        JalaliCalendar prevDay = myFriendsBirthday.getYesterday();

        assert nextDay.equals(new JalaliCalendar(1372,4, 9));
        assert prevDay.equals(new JalaliCalendar(1372,4, 7));

    }
}
