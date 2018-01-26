package com.grt.test;

public class ContinueTest {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("i="+i);
			for (int j = 0; j < 10; j++) {
				System.out.println("j="+j);
				break;
				//continue;
			}
			System.out.println();
		}
	}
	
}
