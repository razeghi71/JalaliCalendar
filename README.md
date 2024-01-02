# JalaliCalendar

JalaliCalendar is a Persian Calendar for java inspired from Roozh project. It has a better API and it's more developer friendly

# Add to Project

JalaliCalendar is available in central maven repository. add `mavenCentral()` to your repository list in build.gradle. Then add this line to your dependencies:

```gradle
compile 'ir.huri:jalalicalendar:<version>'
```

# Getting Started

First of all I should note that **JAVA GREGORIAN CALENDERS MONTH IS 0 BASE SO JANUARY IS 0, FEBRUARY is 1, ...**

To Create a Jalali Date with specified year, month, day use the constructor :
```java    
JalaliCalendar jalaliCalendar = new JalaliCalendar(1395, 1, 28); 
```

To Covert a Gregorian Date to Jalali :

```java
JalaliCalendar jalaliDate = new JalaliCalendar(new GregorianCalendar(2016, 4, 16)); 
```

To Convert a Jalali Date to Gregorian Date :

```java
JalaliCalendar jalaliCalendar = new JalaliCalendar(1395, 1, 28);
GregorianCalendar gc = jalaliCalendar.toGregorian(); 
```

Read more examples in test files.
