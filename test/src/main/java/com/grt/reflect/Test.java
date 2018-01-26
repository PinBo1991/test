package com.grt.reflect;

import java.lang.reflect.Field;
import java.text.NumberFormat;

public class Test {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Student st = new Student("7", "8", "9", null);
		Student stt = new Student("1", "2", "3", "5");
		System.out.println(test01(st,stt));
		
		System.out.println(stt);
	}
	
	public static String test01(Student st,Student stt) throws IllegalArgumentException, IllegalAccessException{
		Field[] fields = Student.class.getDeclaredFields();
		
		int i = 0;
		int j = 0;
		for (Field field : fields) {
			field.setAccessible(true);
			//System.out.println(field.getName());
			Object object = field.get(st);
			if(object != null){
				//System.out.println(object);
				field.set(stt, object);
				j++;
			}
			i++;
		}
        NumberFormat numberFormat = NumberFormat.getInstance();  
        // 设置精确到小数点后2位  
        numberFormat.setMaximumFractionDigits(2);  
        String result = numberFormat.format((float) j / (float) i * 100);  
		return result;
	}
}
