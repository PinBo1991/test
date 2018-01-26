package com.grt.test;

public class StringToHibernameFieldTest {
	public static void test01(String str){
		StringBuilder sb = new StringBuilder();
		String[] split = str.split("asdfzxcv");
		for (int i = 0; i < split.length; i++) {
			String str1 = split[i];
			
			sb.append("@Column(name = \""+str1.replace(" ", "")+"\")\r\n");
			sb.append("String "+test02(str1).replace(" ", "")+";\r\n");
			sb.append("\r\n");
		}
		System.out.println(sb);
	}
	
	public static String test02(String str1){
		StringBuilder sb = new StringBuilder();
		String[] split = str1.split("_");
		for (int i = 0; i < split.length; i++) {
			String s = split[i];
			if(i>0){
				s=s.substring(0, 1).toUpperCase() + s.substring(1);
			}
			sb.append(s);
		}
		return sb.toString().substring(0, sb.toString().length());
	}
	
	
	public static void main(String[] args) {
		

		String str = "trading_time asdfzxcv"+
		"trading_mode          asdfzxcv"+
		"pay_account           asdfzxcv"+
		"pay_name              asdfzxcv"+
		"pay_ider              asdfzxcv"+
		"pay_bank              asdfzxcv"+
		"receive_account       asdfzxcv"+
		"receive_name          asdfzxcv"+
		"receive_ider          asdfzxcv"+
		"receive_bank          asdfzxcv"+
		"currency_name         asdfzxcv"+
		"source_currency_amountasdfzxcv"+
		"transaction_record_id asdfzxcv"+
		"report_agency         asdfzxcv"+
		"trading_place         asdfzxcv"+
		"purpose               asdfzxcv"+
		"foreign_trade_type    asdfzxcv"+
		"userid                asdfzxcv";
		test01(str);
	}
	
}
