package com.grt.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestCurrentHashMap {
	public static void test01(){
		Map map = new ConcurrentHashMap();
		map.put("q", "q");
		map.put("s", "s");
		map.put("r", "r");
		map.put("2", "2");
		map.put("1", "1");
		map.put("5", "5");
		map.put("6", "6");
		for(Object obj:map.values()){
			System.out.println(obj);
		}
	}
	
	public static void main(String[] args) {
		test01();
	}
}
