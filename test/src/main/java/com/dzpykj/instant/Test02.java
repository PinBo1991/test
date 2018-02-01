package com.dzpykj.instant;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Test02 {
	public static void main(String[] args) {
//		Month month = Month.of(2);
//	    System.out.println(month.getValue());       // 2
//	    System.out.println(month.minus(3));         // NOVEMBER
//	    System.out.println(month.plus(2));          // APRIL
//	    System.out.println(month.length(false));    // 28
//	    System.out.println(month.length(true));     // 29
//	    System.out.println(month.getDisplayName(TextStyle.FULL, Locale.getDefault()));      // 二月
	    
//	    LocalDate date = LocalDate.now();
//	    DayOfWeek dotw = date.getDayOfWeek();
//	    System.out.printf("%s is on a %s%n", date, dotw);         //2018-02-01 is on a THURSDAY
//	    System.out.printf("Next Monday: %s%n",
//	            date.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));// Next Monday: 2018-02-05
//	    System.out.printf("First day of Month: %s%n",
//	            date.with(TemporalAdjusters.firstDayOfMonth()));  // First day of Month: 2018-02-01
//	    System.out.printf("First Monday of Month: %s%n",
//	            date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));// First Monday of Month: 2018-02-05
	    
//	    LocalDateTime ldt = LocalDateTime.now();
//	    System.out.println(ldt.withNano(0));
	    
	    Clock clock = Clock.systemUTC(); 
	    System.out.println("Clock : " + clock); 
	    System.out.println(clock.millis());
	    System.out.println( System.nanoTime());
	    System.out.println(Clock.systemDefaultZone());
	    System.out.println(clock.getZone());
	    // Returns time based on system clock zone Clock defaultClock = 
	    Clock.systemDefaultZone(); 
	    System.out.println("Clock : " + clock); 
	}
}
