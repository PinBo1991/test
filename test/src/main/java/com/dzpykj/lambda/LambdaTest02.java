package com.dzpykj.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest02 {
	
	public static void main(String[] args) {
		//test01();
		//test02();
		test03();
	}
	public static void test01(){
		User user1 = new User("1", "zhangsan", 24, "man");
		User user2 = new User("2", "lisi", 24, "woman");
		User user3 = new User("3", "wangwu", 25, "man");
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getAge));
//		Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(s -> s.getAge()));
		System.out.println(map);
		
		Map<Integer, Long> collect = users.stream().collect(Collectors.groupingBy(User::getAge,Collectors.counting()));
		System.out.println(collect);
		
		map.forEach((k,v) -> System.out.println(v.size()));
		
		users.stream()
					.filter(user -> user.getAge() == 24)
					.distinct()
					.collect(Collectors.toList())
					.forEach(user -> user.setAge(34));
		System.out.println(users.toString());
	}
	
	
	public static void test02(){
		
		Map<String,Object> user1 = new HashMap<String,Object>();
		user1.put("id", 1);
		user1.put("name", "zhangsan");
		user1.put("age", 24);
		user1.put("gender", "man");
		
		Map<String,Object> user2 = new HashMap<String,Object>();
		user2.put("id", 2);
		user2.put("name", "lisi");
		user2.put("age", 24);
		user2.put("gender", "woman");
		
		Map<String,Object> user3 = new HashMap<String,Object>();
		user3.put("id", 3);
		user3.put("name", "wangwu");
		user3.put("age", 25);
		user3.put("gender", "man");
		
		List<Map<String,Object>> users = new ArrayList<Map<String,Object>>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		Map<Object, List<Map<String, Object>>> collect1 = users.stream().collect(Collectors.groupingBy(s -> s.get("age")));
		System.out.println(collect1);
		
		Map<Object, Long> collect2 = users.stream().collect(Collectors.groupingBy(s -> s.get("age"),Collectors.counting()));
		System.out.println(collect2);
		
		Map<Object, Map<Object, List<Map<String, Object>>>> collect3 = 
				users.stream().collect(Collectors.groupingBy(s -> s.get("age"),Collectors.groupingBy(s -> s.get("id"))));
		System.out.println(collect3);
		
		users.stream().filter(user -> (Integer)user.get("age") == 24).forEach(user -> user.put("age", 34));
		System.out.println(users);
	}
	
	public static void test03(){
		String[] numbers={"1","2","3","4","5","6","7"};
		List<String> l = Arrays.asList(numbers);
		List<Integer> r = l.stream()
					.map(e -> new Integer(e))
	                .filter(e -> true)
	                .distinct()
	                .collect(Collectors.toList());
		System.out.println("distinctPrimary result is: " + r);
		
		Map<Integer, Integer> collect = l.stream()
					.map(e -> new Integer(e))
			        .filter(e -> true)
			        .distinct()
			        .collect(Collectors.toMap(e->e, e->e));
		System.out.println(collect);
	}
	
//	public static void test01(){
//		
//	}
//	public static void test01(){
//		
//	}
//	public static void test01(){
//		
//	}
}
