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
		System.out.println(i);
		System.out.println(i.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		System.out.println(i.setScale(3, BigDecimal.ROUND_HALF_EVEN));
		
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
	
	/*
	资料来源:https://www.cnblogs.com/yingchen/p/5459501.html
	BigDecimal.ROUND_HALF_XXX的各种用法
	在银行、帐户、计费等领域，BigDecimal提供了精确的数值计算。其中8种舍入方式值得掌握。
	1、ROUND_UP
	舍入远离零的舍入模式。
	在丢弃非零部分之前始终增加数字(始终对非零舍弃部分前面的数字加1)。
	注意，此舍入模式始终不会减少计算值的大小。
	
	2、ROUND_DOWN
	接近零的舍入模式。
	在丢弃某部分之前始终不增加数字(从不对舍弃部分前面的数字加1，即截短)。
	注意，此舍入模式始终不会增加计算值的大小。
	
	3、ROUND_CEILING
	接近正无穷大的舍入模式。
	如果 BigDecimal 为正，则舍入行为与 ROUND_UP 相同;
	如果为负，则舍入行为与 ROUND_DOWN 相同。
	注意，此舍入模式始终不会减少计算值。
	
	4、ROUND_FLOOR
	接近负无穷大的舍入模式。
	如果 BigDecimal 为正，则舍入行为与 ROUND_DOWN 相同;
	如果为负，则舍入行为与 ROUND_UP 相同。
	注意，此舍入模式始终不会增加计算值。
	
	5、ROUND_HALF_UP
	向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为向上舍入的舍入模式。
	如果舍弃部分 >= 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同。
	注意，这是我们大多数人在小学时就学过的舍入模式(四舍五入)。
	
	6、ROUND_HALF_DOWN
	向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则为上舍入的舍入模式。
	如果舍弃部分 > 0.5，则舍入行为与 ROUND_UP 相同;否则舍入行为与 ROUND_DOWN 相同(五舍六入)。
	
	7、ROUND_HALF_EVEN    银行家舍入法
	向“最接近的”数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
	如果舍弃部分左边的数字为奇数，则舍入行为与 ROUND_HALF_UP 相同;
	如果为偶数，则舍入行为与 ROUND_HALF_DOWN 相同。
	注意，在重复进行一系列计算时，此舍入模式可以将累加错误减到最小。
	此舍入模式也称为“银行家舍入法”，主要在美国使用。四舍六入，五分两种情况。
	如果前一位为奇数，则入位，否则舍去。
	以下例子为保留小数点1位，那么这种舍入方式下的结果。
	1.15>1.2 1.25>1.2
	
	8、ROUND_UNNECESSARY
	断言请求的操作具有精确的结果，因此不需要舍入。
	如果对获得精确结果的操作指定此舍入模式，则抛出ArithmeticException。
	因为我们是属于互联网金融行业，所有在进行计算的时候尽量使用ROUND_HALF_EVEN    银行家舍入法	
	*/
	
}
