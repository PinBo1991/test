package com.dzpykj.instant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;

public class DiyTest {
	
	public static void test01(){
		LocalDate today = LocalDate.now(); 
		int year = today.getYear(); 
		int month = today.getMonthValue(); 
		int day = today.getDayOfMonth(); 
		System.err.printf("Year : %d Month : %d day : %d \t %n", year, month, day); 
	}
	
	public static void test02(){
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14); 
		System.out.println("Your Date of birth is : " + dateOfBirth); 
	}
	
	public static void test03(){
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate date1 = LocalDate.of(2014, 01, 14); if(date1.equals(today)){ 
		    System.out.printf("Today %s and date1 %s are same date %n", today, date1); 
		} 
	}
	
	public static void test04(){
		LocalTime time = LocalTime.now(); System.out.println("local time now : " + time);
		LocalDate date = LocalDate.now(); System.out.println("local time now : " + date);
		LocalDateTime dt = LocalDateTime.now();System.out.println("local time now : " + dt);
	}
	
	public static void test05(){
		
		LocalDate today = LocalDate.now();
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14); 
		System.out.println("dateOfBirth="+dateOfBirth);
		
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth()); 
		System.out.println("birthday="+birthday);
		
		MonthDay currentMonthDay = MonthDay.from(today); 
		System.out.println("currentMonthDay="+currentMonthDay);
		
		if(currentMonthDay.equals(birthday)){ 
		    System.out.println("Many Many happy returns of the day !!"); 
		}else{ 
		    System.out.println("Sorry, today is not your birthday"); 
		} 
	}
	
	public static void test06(){
		LocalTime time = LocalTime.now(); 
		LocalTime newTime = time.plusHours(2); // adding two hours 
		System.out.println("Time after 2 hours : " + newTime); 
		System.out.println(time.getNano());
		
	}
	
	
	public static void main(String[] args) {
//		test01();
//		test02();
//		test03();
//		test04();
//		test05();
		test06();
	}
	
}
