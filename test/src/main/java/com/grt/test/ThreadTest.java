package com.grt.test;

public class ThreadTest extends Thread {
	
	String str;
	
	public ThreadTest(String str){
		this.str = str;
	}
	
	@Override
	public void run() {
		String tname = Thread.currentThread().getName();
		for (int i = 0; i < 1000000; i++) {
			System.out.println(tname+" "+i);
		}
	}
	
	
	public static void main(String[] agrs){
		ThreadTest tt1 = new ThreadTest("aaaa");
		ThreadTest tt2 = new ThreadTest("bbbb");
		tt1.start();
		tt2.start();
	}
	
}
