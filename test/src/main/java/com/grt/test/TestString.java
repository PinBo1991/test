package com.grt.test;

public class TestString {

	public static void main(String[] args) {
//		TestString ts = new TestString();
//		ts.test02();
		test03();
	}
	
	public void test02(){
		String str = "zxcv";
		test01(str);
		System.out.println(str);
	}
	
	
	public void test01(String str){
		str = "========";
	}
	
	public static void test03(){
//		String str = ",1234,af,adf,zxcv,uiop,";
//		String str = "1234,af,adf,zxcv,uiop,";
		String str = "";
		str = str.replaceFirst(",", "");
		System.out.println(str);
	}
}
