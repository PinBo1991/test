package com.grt.test;

public class SplitTest {
	public static void test01(){
		String str = "qwrezxcvuiop";
		String[] split = str.split("");
		for(int i = 0;i<split.length;i++){
			System.out.println(split[i]);
		}
	}
	
	public static void test02(){
		//String str = "";
		//String str = ",1,";
		//String str = ",";
		String str = ",1,1,";
		System.out.println(str.split(",").length);
		for (int i = 0; i < str.split(",").length; i++) {
			System.out.println("--"+str.split(",")[i]+"--");
		}
	}
	
	public static void main(String[] args) {
		//test01();
		//test02();
		//System.out.println("aaa".split(",").length);
		
		System.out.println(",1,".split(",").length);
	}
}
