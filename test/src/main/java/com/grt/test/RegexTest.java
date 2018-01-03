package com.grt.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args) {
		// test01();
		// test02();
		// test03();
		// test04();
//		test05();
		test06();
	}

	public static void test01() {
		String str = "asdf,,as,df";
		String[] split = str.split("\\pP");// 通过标点分词
		System.out.println(split.length);// 4
	}

	public static void test02() {
		String s = "A876X";
		// 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
		// 在这里，我们要提取最后一个数字，正则规则就是"一个数字加上大于等于0个非数字再加上结束符"
		Pattern pattern = Pattern.compile("(\\d)[^\\d]*$");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find())
			System.out.println(matcher.group(1));
	}

	public static void test03() {
		Pattern p = Pattern.compile("\\d+");

		Matcher m = p.matcher("aaa2223bb4455");
		System.out.println(m.find()); // 匹配2223
		System.out.println(m.start()); // 返回3
		System.out.println(m.end()); // 返回7,返回的是2223后的索引号
		System.out.println(m.group()); // 返回2223
		System.out.println("-----------------");

		Matcher m2 = p.matcher("2223bb");
		System.out.println(m2.lookingAt());// 匹配2223
		System.out.println(m2.start());// 返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
		System.out.println(m2.end());// 返回4
		System.out.println(m2.group());// 返回2223
		System.out.println("-----------------");

		Matcher m3 = p.matcher("2223"); // 如果Matcher m3=p.matcher("2223bb");
										// 那么下面的方法出错，因为不匹配返回false
		System.out.println(m3.matches()); // 匹配整个字符串
		System.out.println(m3.start());// 返回0
		System.out.println(m3.end());// 返回3,原因相信大家也清楚了,因为matches()需要匹配所有字符串
		System.out.println(m3.group()); // 返回2223
	}

	public static void test04() {
		Pattern p = Pattern.compile("([a-z]+)(\\d+)");
		Matcher m = p.matcher("aaa2223bb");
		// Pattern p = Pattern.compile("\\d+");
		// Matcher m = p.matcher("aaa2223bb4455");

		System.out.println(m.find());// 匹配aaa2223
		System.out.println(m.groupCount());// 返回2,因为有2组
		System.out.println(m.start(1));// 返回0 返回第一组匹配到的子字符串在字符串中的索引号
		System.out.println(m.start(2));// 返回3
		System.out.println(m.end(1));// 返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
		System.out.println(m.end(2));// 返回7
		System.out.println(m.group(1));// 返回aaa,返回第一组匹配到的子字符串
		System.out.println(m.group(2));// 返回2223,返回第二组匹配到的子字符串
	}

	public static void test05() {
		// String str = "ming tian,ni haoo";
		// String reg = "\\b[a-z]{4}\\b";
		// Pattern p = Pattern.compile(reg);// 把正则封装成对象
		// Matcher m = p.matcher(str);// 让正则与要作用的字符串进行匹配

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("aaa2223bb4455");

		while (m.find()) {// 按规则作用于字符串，并进行查找
			System.out.println(m.group());// 获取匹配后的结果
		}
	}

	public static void test06() {
		String str = "中华人民共和国政府信息公开条例";
		String reg = "(.*?)(信息)(.*?)(公开)(.*?)(?!例).*(?=[\\pP])";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str + ".");
		if (m.find()) 
			System.out.println(m.group());
	}

	public static void test07() {
	}

}
