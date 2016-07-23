# JalaliCalendar

JalaliCalendar is a Persian Calendar for java inspired from Roozh project. It has a better API and it's more developer friendly

# Add to Project

JalaliCalendar is available in jcenter. add jcenter() to your repository list in build.gradle. Then add this line to your dependencies:

```gradle
compile 'ir.huri.jcal:JalaliCalendar:1.3.0'
```

# Getting Started

First of all I should note that **java gregorian calenders month is 0 base** (YES! that's a bad design).

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
