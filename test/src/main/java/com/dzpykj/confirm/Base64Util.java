/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dzpykj.confirm;

import org.apache.commons.codec.binary.Base64;

/**
 * base64工具
 * @author ChaiXY
 *
 */
public class Base64Util {

	/**
	 * 加密
	 */
	public static String encrypt(String str) {
		byte[] ec = Base64.encodeBase64(str.getBytes(), true);
		String ec_result = new String(ec).replaceAll("\r|\n", "");
		return ec_result;
	}

	/**
	 * 解密
	 */
	public static String decode(String key) {
		byte[] dc = Base64.decodeBase64(key.getBytes());
		String dc_result = new String(dc).replaceAll("\r|\n", "");
		return dc_result;
	}
	
	public static void main(String[] args) {
		System.out.println(encrypt("asdf"));
		System.out.println(decode(encrypt("asdf")));
	}
	
}
