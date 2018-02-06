package com.dzpykj.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void test(){
		//构造函数传入double类型的1.22,结果不精确;构造函数传入字符串类型的1.22,结果精确
		//通常建议优先使用String构造方法
//		BigDecimal k = new BigDecimal("1.22");
//		System.out.println(k);//1.22
//		BigDecimal z = new BigDecimal(1.22);
//		System.out.println(z);//1.2199999999999999733546474089962430298328399658203125
		
//		double a = 1.1;
//		double b = 0.9;
//		System.out.println(a-b);//0.20000000000000007
//		BigDecimal i = new BigDecimal(a);
//		BigDecimal j = new BigDecimal(b);
//		System.out.println(i.subtract(j));//0.20000000000000006661338147750939242541790008544921875
		
//		String a = "3";
//		String b = "2.1";
//		BigDecimal i = new BigDecimal(a);
//		BigDecimal j = new BigDecimal(b);
//		System.out.println(i.subtract(j));//0.2 结果精确
//		System.out.println(i.add(j));
////		System.out.println(i.divide(j));
//		System.out.println(i.divide(j,3,BigDecimal.ROUND_HALF_EVEN));
//		System.out.println(i.multiply(j));
//		System.out.println();
//		System.out.println(i.compareTo(j)); //即左边比右边数大，返回1，相等返回0，比右边小返回-1。
//											//注意:不可用equals进行相等的判断,equals比较是两个BigDecimal对象的地址。 
//		String k = i.subtract(j).toString();
//		System.out.println(k);//2.0
		
//		NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用   
//	    NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用   
//	    percent.setMaximumFractionDigits(4); //百分比小数点最多3位   
//	    BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额  
//	    BigDecimal interestRate = new BigDecimal("0.0000008"); //利率     
//	    BigDecimal interest = loanAmount.multiply(interestRate); //相乘  
//	    System.out.println("贷款金额:\t" + currency.format(loanAmount));   
//	    System.out.println("利率:\t" + percent.format(interestRate));   
//	    System.out.println("利息:\t" + currency.format(interest));   
		
		String a = "1.66728";
		String b = "1.55555";
		BigDecimal i = new BigDecimal(a);
		BigDecimal j = new BigDecimal(b);
//		System.out.println(i);
//		System.out.println(i.setScale(2, BigDecimal.ROUND_HALF_EVEN));//四舍五入
//		System.out.println(i.setScale(3, BigDecimal.ROUND_HALF_EVEN));
		
//		System.out.println(i);
//		System.out.println(i.setScale(2, BigDecimal.ROUND_UP));//不管是不是大于0.5,直接+1
//		System.out.println(i.setScale(3, BigDecimal.ROUND_UP));
		
//		System.out.println(i);
//		System.out.println(i.setScale(2, BigDecimal.ROUND_DOWN));//不管是不是大于0.5,直接-1
//		System.out.println(i.setScale(3, BigDecimal.ROUND_DOWN));
		
		//ROUND_HALF_UP: 遇到.5的情况时往上近似,例: 1.5 -> 2
		//ROUND_HALF_DOWN : 遇到.5的情况时往下近似,例: 1.5 -> 1
		//ROUND_HALF_UP不建议使用
//		System.out.println(j);
//		System.out.println(j.setScale(2, BigDecimal.ROUND_HALF_UP));
//		System.out.println(j.setScale(3, BigDecimal.ROUND_HALF_UP));
		//ROUND_HALF_DOWN不建议使用
//		System.out.println(j);
//		System.out.println(j.setScale(0, BigDecimal.ROUND_HALF_DOWN));
//		System.out.println(j.setScale(2, BigDecimal.ROUND_HALF_DOWN));
//		System.out.println(j.setScale(3, BigDecimal.ROUND_HALF_DOWN));
//		System.out.println(j.setScale(4, BigDecimal.ROUND_HALF_DOWN));
//		System.out.println(j.setScale(5, BigDecimal.ROUND_HALF_DOWN));
		//
//		BigDecimal c = new BigDecimal(1.5);
//        System.out.println("down="+c.setScale(0,BigDecimal.ROUND_HALF_DOWN)+"/tup="+c.setScale(0,BigDecimal.ROUND_HALF_UP));
		
	}
	
	public static void main(String[] args) {
		test();
	}
	
	/*
	BigDecimal.
	ROUND_HALF_EVEN 四舍五入
	
	
	
	
	
	*/
	
	/*
	 BigDecimal常用方法描述:
	 add(BigDecimal) BigDecimal对象中的值相加，然后返回这个对象。
	 subtract(BigDecimal) BigDecimal对象中的值相减，然后返回这个对象。
	 multiply(BigDecimal) BigDecimal对象中的值相乘，然后返回这个对象。
	 divide(BigDecimal) BigDecimal对象中的值相除，然后返回这个对象。
	 toString() 将BigDecimal对象的数值转换成字符串。
	 doubleValue() 将BigDecimal对象中的值以双精度数返回。
	 floatValue()  将BigDecimal对象中的值以单精度数返回。
	 longValue() 将BigDecimal对象中的值以长整数返回。
	 intValue() 将BigDecimal对象中的值以整数返回。
	 */
}
