package com.grt.test;

public class RegexTest {
	public static void main(String[] args) {
		
		String str = "asdf,,as,df";
		String[] split = str.split("\\pP");//通过标点分词
		System.out.println(split.length);//4
	}
}
