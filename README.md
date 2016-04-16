# ir.huri.jcal.JalaliCalendar

ir.huri.jcal.JalaliCalendar is a Persian Calendar for java Inspired by Roozh project. It has a better API and more developer friendly

# How To Use

To Create a Jalali Date use the constructor :
    
    ir.huri.jcal.JalaliCalendar jalaliCalendar = new ir.huri.jcal.JalaliCalendar(1395, 1, 28); // create a new ir.huri.jcal.JalaliCalendar object with specified date

To Covert a Gregorian Date to Jalali :

    ir.huri.jcal.JalaliCalendar jalaliDate = new ir.huri.jcal.JalaliCalendar(new GregorianCalendar(2016, 4, 16)); // create a new ir.huri.jcal.JalaliCalendar object with date : 1395-1-28

To Convert a Jalali Date to Gregorian Date :

    ir.huri.jcal.JalaliCalendar jalaliCalendar = new ir.huri.jcal.JalaliCalendar(1395, 1, 28); // create a new ir.huri.jcal.JalaliCalendar object with specified date
    jalaliCalendar.toGregorian(); // create a new GregorianCalendar object with date 2016-4-16



