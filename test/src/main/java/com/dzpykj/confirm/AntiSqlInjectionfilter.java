package com.dzpykj.confirm;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 防SQL注入过滤器
 * @author ChaiXY
 */
public class AntiSqlInjectionfilter extends AbstractFilter {

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
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// 获得所有请求参数名
		Enumeration<String> params = req.getParameterNames();
		String sql = "";
		while (params.hasMoreElements()) {
			String name = params.nextElement().toString();
			String[] value = req.getParameterValues(name);
			for (int i = 0; i < value.length; i++) {
				sql = sql + value[i];
			}
		}
		if (sqlValidate(sql)) {
			// String ip = req.getRemoteAddr();
			throw new IllegalArgumentException("您发送请求中的参数中含有非法字符");
		} else {
			chain.doFilter(request, response);
		}
	}

	// 效验
	private boolean sqlValidate(String paramValue) {
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

//<!--在web.xml文件中的配置--> 
//<!-- 防止SQL注入的过滤器 --> 
//<filter> 
//    <filter-name>antiSqlInjection</filter-name> 
//    <filter-class>com.dzpykj.sql.AntiSqlInjectionfilter</filter-class> 
//</filter> 
//<filter-mapping> 
//    <filter-name>antiSqlInjection</filter-name> 
//    <url-pattern>/*</url-pattern> 
//</filter-mapping> 


