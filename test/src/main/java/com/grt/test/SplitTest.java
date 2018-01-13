package com.grt.test;

public class SplitTest {
	public static void test01(){
		String str = "qwrezxcvuiop";
		String[] split = str.split("");
		for(int i = 0;i<split.length;i++){
			System.out.println(split[i]);
		}
	}
	
	public static void main(String[] args) {
		test01();
	}
}
