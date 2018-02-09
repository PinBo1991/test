package com.dzpykj.confirm;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

/**
 * 过滤器适配器
 * @author ChaiXY
 */
public abstract class AbstractFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	@Override
	public void destroy() {}
}
