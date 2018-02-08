package com.dzpykj.confirm;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 生成全数字/含字母的随机数
 * @author ChaiXY
 */
public class RandomUtils {
	
	private static final String RANDOM_STR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final Random RANDOM = new Random();
	/**
	 * 生成n位全数字随机数
	 * @param n 全数字随机数的长度
	 */
	public static String getRandNum(int n){
		StringBuilder sb = new StringBuilder("");
		for(int i =1;i<=n;i++){
			sb.append(""+(int)(Math.random()*9+1));
		}
		return sb.toString();
	}
	
	/**
	 * 随机生成六位数验证码 
	 */
	public static String getRandomNum(){
		return RANDOM.nextInt(900000)+100000+"";//(Math.random()*(999999-100000)+100000)+""
	}
	
	/**
	 * 生成n位含字母随机数
	 * @param n 含字母随机数的长度
	 */
	public static String getRandStr(int n){
        char[] rands = new char[n];
        for (int i = 0; i < rands.length; i++) { 
            int rand = (int) (Math.random() * RANDOM_STR.length()); 
            //int rand = RANDOM.nextInt(RANDOM_STR.length());
            rands[i] = RANDOM_STR.charAt(rand);
        } 
        String re = new String(rands);
        return re;
	}
	
	/**
	 * 测试随机数重复的概率
	 * @param type 区分类型:0全数字,1含字母 
	 * @param count 计划测试的随机数总个数
	 * @param length 全数字/含字母随机数的长度
	 */
	public static void checkExist(int type,int count,int length){
		Set<String> set = new HashSet<String>();
		if(type == 0){//全数字随机数
			for(int i=1;i<=count;i++){
				String randNum = getRandNum(length);
				if(set.contains(randNum)){
					System.out.println("第"+i+"次重复了");
					break;
				}
				set.add(randNum);
			}
		}else if(type == 1){ //含字母随机数
			for(int i=1;i<=count;i++){
				String randStr = getRandStr(length);
				if(set.contains(randStr)){
					System.out.println("第"+i+"次重复了");
					break;
				}
				set.add(randStr);
			}
		}
	}
	
	/**
	 * 获取从1970 年 1 月 1 日（00:00:00 GMT）至当前时间的总秒数,转化为16进制
	 * @return 推荐码
	 */
	//Long.toBinaryString(int i) 转二进制,Long.toHexString(int i)转十六进制,Long.toOctalString(int i)转八进制
	//Integer.toBinaryString(int i) 转二进制,Integer.toHexString(int i)转十六进制,Integer.toOctalString(int i)转八进制
	public static String getRecomdCode(){
		//new Date().getTime() 获取从1970 年 1 月 1 日（00:00:00 GMT）至当前时间的总秒数
		//Long.toHexString(Long l) 转化为16进制
		return Long.toHexString(new Date().getTime());
	} 

	public static void main(String[] args) {
		System.out.println(getRandomNum());
	}
}