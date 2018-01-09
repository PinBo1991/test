package com.grt.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestFasterXMLJson {
	public static void main(String[] args) throws IOException {
		Map<String,Object> map = new  HashMap<String,Object>();
		map.put("a", 111);
		map.put("b", "asdf");
		System.out.println(new ObjectMapper().writeValueAsString(map).toString());
		@SuppressWarnings("unchecked")
		Map<String,Object> readValue = new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(map).toString(), Map.class);
		System.out.println(readValue);
	}

}
