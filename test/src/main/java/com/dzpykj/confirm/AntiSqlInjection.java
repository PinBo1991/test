package com.dzpykj.confirm;

/**
 * 防SQL注入工具类
 * @author ChaiXY
 */
public class AntiSqlInjection {

	public static final String keyWords;

	static {
		// 过滤掉的sql关键字，可以手动添加
		StringBuilder sb = new StringBuilder();
		sb.append("'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|");
		sb.append("char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|");
		sb.append("table|from|grant|use|group_concat|column_name|");
		sb.append("information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|");
		sb.append("chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#");
//		sb.append("'|%|--|and|or|not|use|insert|delete|update|select|count|group|union");
//		sb.append("|create|drop|truncate|alter|grant|execute|exec|xp_cmdshell|call|declare|source|sql");
		keyWords = sb.toString();
	}

	/**
	 * 检验是否有SQL注入
	 * @param paramValue request的值
	 * @return 有true,无false
	 */
	public static boolean sqlValidate(String paramValue) {
		paramValue = paramValue.toLowerCase();
		String[] keyWordsArray = keyWords.split("\\|");
		for (int i = 0; i < keyWordsArray.length; i++) {
			if (paramValue.indexOf(keyWordsArray[i]) >= 0) {
				return true;
			}
		}
		return false;
	}

}