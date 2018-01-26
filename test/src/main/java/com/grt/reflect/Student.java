package com.grt.reflect;

public class Student {
	public String id;
	public String name;
	public String age;
	public String height;
	
	public Student(String id, String name, String age, String height) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	public Student() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
}
