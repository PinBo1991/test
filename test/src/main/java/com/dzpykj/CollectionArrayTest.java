package com.dzpykj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CollectionArrayTest {
	public static void main(String[] args){
		String[] strs = {"1","2"};
		System.out.println(Arrays.toString(strs));
		test02(strs);
//		List<String> list = new ArrayList();
//		test02(list);
	}
	
	public static void test02(String... args){
		System.out.println(StringUtils.isAnyBlank(args));
		System.out.println(StringUtils.isAnyEmpty(args));
		
		System.out.println(StringUtils.isAllBlank("".split(",")));
		System.out.println(StringUtils.isAnyEmpty("".split(",")));
		
		String[] strs1 = {};
		System.out.println(StringUtils.isAnyBlank(strs1));
		System.out.println(StringUtils.isAnyEmpty(strs1));
	}
}
