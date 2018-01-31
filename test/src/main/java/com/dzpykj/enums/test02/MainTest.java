package com.dzpykj.enums.test02;

public class MainTest {
	
	public static void test01(){
		System.out.println(Constant.Color.RED.getIndex()+" : "+Constant.Color.RED.getName());
	}
	
	public static void test02(){
		for (Constant.Color w : Constant.Color.values()) {
			System.out.println(w + " --> " + w.ordinal() + " : " + w.getDeclaringClass());
			System.out.println(w.getIndex()+" : "+w.getName());
			System.out.println(w.getAll());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		test01();
		test02();
	}
}
