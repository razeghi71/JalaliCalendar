# JalaliCalendar

JalaliCalendar is a Persian Calendar for java Inspired by Roozh project. It has a better API and more developer friendly

# How To Use

To Create a Jalali Date use the constructor :
```java    
JalaliCalendar jalaliCalendar = new JalaliCalendar(1395, 1, 28); // create a new JalaliCalendar object with specified date
```

To Covert a Gregorian Date to Jalali :

```java
JalaliCalendar jalaliDate = new JalaliCalendar(new GregorianCalendar(2016, 4, 16)); // create a new JalaliCalendar object with date : 1395-1-28
```

To Convert a Jalali Date to Gregorian Date :

```java
JalaliCalendar jalaliCalendar = new JalaliCalendar(1395, 1, 28); // create a new JalaliCalendar object with specified date
jalaliCalendar.toGregorian(); // create a new GregorianCalendar object with date 2016-4-16
```


