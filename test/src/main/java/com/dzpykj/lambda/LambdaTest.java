package com.dzpykj.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings({ "all" })
public class LambdaTest {
	
	public static void test01(){
//		// Java 8之前：
//		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		for (String feature : features) {
//		    System.out.println(feature);
//		}
		
		// Java 8之后：
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
		// 看起来像C++的作用域解析运算符
		features.forEach(System.err::println);
	}
	
	public static void test02(){
	    List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
	 
//	    System.out.println("Languages which starts with J :");
	    filter(languages, (str)->((String) str).startsWith("J"));
	 
//	    System.out.println("Languages which ends with a ");
	    filter(languages, (str)->((String) str).endsWith("a"));
	 
//	    System.out.println("Print all languages :");
	    filter(languages, (str)->true);
	 
//	    System.out.println("Print no language : ");
	    filter(languages, (str)->false);
	 
//	    System.out.println("Print language whose length greater than 4:");
	    filter(languages, (str)->((String) str).length() > 4);
	}
	 
	public static void filter(List<String> names, Predicate predicate) {
//	    for(String name: names)  {
//	        if(predicate.test(name)) {
//	            System.out.println(name + "===");
//	        }
//	    }
	    
	    names.forEach(n -> {if(predicate.test(n)) {
	            System.out.println(n + "===");
	        }});
	}
	
	
	public static void test03(){
		//获取数字的个数、最小值、最大值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		int sum = primes.stream().mapToInt((x) -> 1+x).sum();
		System.out.println(sum+"=====");
		
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}
	
	
	
	
	public static void main(String[] args) {
		//test01();
		test02();
//		test03();
	}
}
