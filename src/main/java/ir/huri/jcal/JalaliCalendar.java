package ir.huri.jcal;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JalaliCalendar {

    private int year, month, day;

    /**
     * Today Jalali Date
     */
    public JalaliCalendar() {
        fromGregorian(new GregorianCalendar());
    }

    /**
     * Create a ir.huri.jcal.JalaliCalendar object
     * @param year Jalali Year
     * @param month Jalali Month
     * @param day Jalali Day
     */
    public JalaliCalendar(int year, int month, int day) {
        set(year, month, day);
    }


    /**
     * Create a ir.huri.jcal.JalaliCalendar object from gregorian calendar
     * @param gc gregorian calendar object
     */
    public JalaliCalendar(GregorianCalendar gc){
        fromGregorian(gc);
    }


    /**
     * Create a ir.huri.jcal.JalaliCalendar object from Localdate(java 8)
     * @param ld local date object
     */
    public JalaliCalendar(LocalDate ld) {
        fromGregorian(GregorianCalendar.from(ld.atStartOfDay(ZoneId.systemDefault())));
    }


    /**
     * Create a ir.huri.jcal.JalaliCalendar object from Date object
     * @param date Date object
     */
    public JalaliCalendar(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        fromGregorian(gc);
    }

    /**
     * Convert current jalali date to gregorian date
     * @return date converted gregorianDate
     */
    public GregorianCalendar toGregorian() {
        int julianDay = toJulianDay();
        return julianDayToGregorianCalendar(julianDay);
    }

    /**
     * set date from gregorian date
     * @param gc input gregorian calendar
     */
    public void fromGregorian(GregorianCalendar gc){
        int jd = gregorianToJulianDayNumber(gc);
        fromJulianDay(jd);
    }

    /**
     * @return yesterday date
     */
    public JalaliCalendar getYesterday() {
        return getDateByDiff(-1);
    }

    /**
     * @return tomorrow date
     */
    public JalaliCalendar getTomorrow() {
        return getDateByDiff(1);
    }

    /**
     * get Jalali date by day difference
     * @param diff number of day diffrents
     * @return jalali calendar diffحزن
     */
    public JalaliCalendar getDateByDiff(int diff) {
        GregorianCalendar gc = toGregorian();
        gc.add(Calendar.DAY_OF_MONTH, diff);
        return new JalaliCalendar(gc);
    }

    /**
     * @return day Of Week
     */
    public int getDayOfWeek() {
        return toGregorian().get(Calendar.DAY_OF_WEEK);
    }

    /**
     * @return get first day of week
     */
    public int getFirstDayOfWeek() {
        return toGregorian().getFirstDayOfWeek();
    }

    /**
     *
     * @return day name
     */
    public String getDayOfWeekString() {
        switch (getDayOfWeek()) {
            case 1:
                return "یک‌شنبه";
            case 2 :
                return "دوشنبه";
            case 3:
                return "سه‌شنبه";
            case 4:
                return "چهارشنبه";
            case 5:
                return "پنجشنبه";
            case 6:
                return "جمعه";
            case 7:
                return "شنبه";
            default:
                return "نامعلوم";
        }
    }

    /**
     *
     * @return month name
     */
    public String getMonthString() {
        switch (getMonth()) {
            case 1:
                return "فروردین";
            case 2 :
                return "اردیبهشت";
            case 3:
                return "خرداد";
            case 4:
                return "تیر";
            case 5:
                return "مرداد";
            case 6:
                return "شهریور";
            case 7:
                return "مهر";
            case 8:
                return "آبان";
            case 9:
                return "آذر";
            case 10:
                return "دی";
            case 11:
                return "بهمن";
            case 12:
                return "اسفند";
            default:
                return "نامعلوم";
        }
    }


    /**
     * get String with the following format :
     *  یکشنبه ۱۲ آبان
     * @return String format
     */

    public String getDayOfWeekDayMonthString() {
        return getDayOfWeekString() + " " + getDay() + " " + getMonthString() ;
    }

    /**
     *
     * @return return whether this year is a jalali leap year
     */
    public boolean isLeap() {
        return  getLeapFactor(getYear()) == 0;
    }

    public int getYearLength() {
        return  isLeap() ? 366 : 365;
    }

    public int getMonthLength() {
        if ( getMonth() < 7 ) {
            return 31;
        } else if ( getMonth() < 12 ) {
            return 30;
        } else if ( getMonth() == 12 ) {
            if (isLeap())
                return 30;
            else
                return 29;
        }
        return 0;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void set(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JalaliCalendar that = (JalaliCalendar) o;

        return year == that.year && month == that.month && day == that.day;
    }

    private int gregorianToJulianDayNumber(GregorianCalendar gc) {
        int gregorianYear = gc.get(GregorianCalendar.YEAR);
        int gregorianMonth = gc.get(GregorianCalendar.MONTH) + 1;
        int gregorianDay = gc.get(GregorianCalendar.DAY_OF_MONTH);

        return  (((1461 * (gregorianYear + 4800 + (gregorianMonth - 14) / 12)) / 4
                + (367 * (gregorianMonth - 2 - 12 * ((gregorianMonth - 14) / 12))) / 12
                - (3 * ((gregorianYear + 4900 + (gregorianMonth - 14) / 12) / 100)) / 4 + gregorianDay
                - 32075) - (gregorianYear + 100100 + (gregorianMonth - 8) / 6) / 100 * 3 / 4 + 752);
    }

    private int julianToJulianDayNumber(JulianCalendar jc) {
        int julianYear = jc.getYear();
        int julianMonth = jc.getMonth();
        int JulianDay = jc.getDay();

        return (1461 * (julianYear + 4800 + (julianMonth - 14) / 12)) / 4
                + (367 * (julianMonth - 2 - 12 * ((julianMonth - 14) / 12))) / 12
                - (3 * ((julianYear + 4900 + (julianMonth - 14) / 12) / 100)) / 4 + JulianDay
                - 32075;
    }

    private GregorianCalendar julianDayToGregorianCalendar(int JulianDayNumber) {

        int j = 4 * JulianDayNumber + 139361631 + (4 * JulianDayNumber + 183187720) / 146097 * 3 / 4 * 4 - 3908;
        int i = (j % 1461) / 4 * 5 + 308;

        int gregorianDay = (i % 153) / 5 + 1;
        int gregorianMonth = ((i / 153) % 12) + 1;
        int gregorianYear = j / 1461 - 100100 + (8 - gregorianMonth) / 6;

        return new GregorianCalendar(gregorianYear, gregorianMonth - 1, gregorianDay);
    }

    private void fromJulianDay(int JulianDayNumber) {
        GregorianCalendar gc = julianDayToGregorianCalendar(JulianDayNumber);
        int gregorianYear = gc.get(GregorianCalendar.YEAR);

        int jalaliYear, jalaliMonth, jalaliDay;

        jalaliYear = gregorianYear - 621;

        GregorianCalendar gregorianFirstFarvardin = new JalaliCalendar(jalaliYear, 1, 1).getGregorianFirstFarvardin();
        int JulianDayFarvardinFirst = gregorianToJulianDayNumber(gregorianFirstFarvardin);
        int diffFromFarvardinFirst = JulianDayNumber - JulianDayFarvardinFirst;



        if (diffFromFarvardinFirst >= 0) {
            if (diffFromFarvardinFirst <= 185) {
                jalaliMonth = 1 + diffFromFarvardinFirst / 31;
                jalaliDay = (diffFromFarvardinFirst % 31) + 1;
                set(jalaliYear, jalaliMonth, jalaliDay);
                return;
            } else {
                diffFromFarvardinFirst = diffFromFarvardinFirst - 186;
            }
        } else {
            diffFromFarvardinFirst = diffFromFarvardinFirst + 179;
            if (getLeapFactor(jalaliYear) == 1)
                    diffFromFarvardinFirst = diffFromFarvardinFirst + 1;
            jalaliYear -= 1;
        }


        jalaliMonth = 7 + diffFromFarvardinFirst / 30;
        jalaliDay = (diffFromFarvardinFirst % 30) + 1;
        set(jalaliYear, jalaliMonth, jalaliDay);
    }

    private int toJulianDay() {
        int jalaliMonth = getMonth();
        int jalaliDay = getDay();

        GregorianCalendar gregorianFirstFarvardin = getGregorianFirstFarvardin();
        int gregorianYear = gregorianFirstFarvardin.get(Calendar.YEAR);
        int gregorianMonth = gregorianFirstFarvardin.get(Calendar.MONTH) + 1;
        int gregorianDay = gregorianFirstFarvardin.get(Calendar.DAY_OF_MONTH);

        JulianCalendar julianFirstFarvardin = new JulianCalendar(gregorianYear, gregorianMonth, gregorianDay) ;


        int julianDay = julianToJulianDayNumber(julianFirstFarvardin) + (jalaliMonth - 1) * 31 - jalaliMonth / 7 * (jalaliMonth - 7)
                + jalaliDay - 1;

        return julianDay;
    }


    private GregorianCalendar getGregorianFirstFarvardin() {
        int marchDay = 0;
        int[] breaks = { -61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181, 1210,
                1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178 };

        int jalaliYear = getYear();
        int gregorianYear = jalaliYear + 621;
        int jalaliLeap = -14;
        int jp = breaks[0];

        int jump = 0;
        for (int j = 1; j <= 19; j++) {
            int jm = breaks[j];
            jump = jm - jp;
            if (jalaliYear < jm) {
                int N = jalaliYear - jp;
                jalaliLeap = jalaliLeap + N / 33 * 8 + (N % 33 + 3) / 4;

                if ((jump % 33) == 4 && (jump - N) == 4)
                    jalaliLeap = jalaliLeap + 1;

                int GregorianLeap = (gregorianYear / 4) - (gregorianYear / 100 + 1) * 3 / 4 - 150;

                marchDay = 20 + (jalaliLeap - GregorianLeap);

                if ((jump - N) < 6)
                    N = N - jump + (jump + 4) / 33 * 33;

                break;
            }

            jalaliLeap = jalaliLeap + jump / 33 * 8 + (jump % 33) / 4;
            jp = jm;
        }

        return new GregorianCalendar(gregorianYear, 2, marchDay);
    }

    private int getLeapFactor(int jalaliYear) {
        int leap = 0;
        int[] breaks = { -61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181, 1210,
                1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178 };

        int jp = breaks[0];

        int jump = 0;
        for (int j = 1; j <= 19; j++) {
            int jm = breaks[j];
            jump = jm - jp;
            if (jalaliYear < jm) {
                int N = jalaliYear - jp;

                if ((jump - N) < 6)
                    N = N - jump + (jump + 4) / 33 * 33;

                leap = ((((N + 1) % 33) - 1) % 4);

                if (leap == -1)
                    leap = 4;

                break;
            }

            jp = jm;
        }

        return leap;
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", getYear(), getMonth(), getDay());
    }


    private class JulianCalendar {
        int year;
        int month;
        int day;

        public JulianCalendar(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }
        public int getMonth() {
            return month;
        }
        public int getDay() {
            return day;
        }
    }



}
