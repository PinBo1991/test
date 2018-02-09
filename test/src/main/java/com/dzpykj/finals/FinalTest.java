package com.dzpykj.finals;

import java.util.HashMap;
import java.util.Map;

public class FinalTest {
	public static final Map<String,Object> map;
	
	static{
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("1", "2");
		map = map1;
		map.put("3", "4");
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		
	}
}
