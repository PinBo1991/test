package com.grt.test;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
//	@RequestMapping("fire")
//	@ResponseBody
//	public Object test(HttpServletRequest request){
////		System.out.println("IP ADDR = "+request.getRemoteAddr());
////		System.out.println("server 2");
//		
//        Enumeration<String> e = request.getHeaderNames();
//        while(e.hasMoreElements()){
//            String headerName = e.nextElement();//透明称
//            Enumeration<String> headerValues = request.getHeaders(headerName);
//            while(headerValues.hasMoreElements()){
//                System.out.println(headerName+":"+headerValues.nextElement());
//            }
//        }
//        System.out.println("真实IP:"+request.getHeader("x-real-ip"));
//		return "server 2--"+request.getHeader("x-real-ip");
//	}
	
//	@RequestMapping("/test")
//	public Object test1(){
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/WEB-INF/test.jsp");
//		mav.addObject("testmav", "success");
//		return mav;
//	}
	
	@RequestMapping("/test")
	@ResponseBody
	public Object test1(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/test.jsp");
		mav.addObject("testmav", "success");
		return "ahaha";
//		return mav;
	}
	
	@RequestMapping("/eye")
	@ResponseBody
	public Object eye(){
		System.out.println("aaaaaa");
		return "111";
	}
	
	@RequestMapping("/log")
	@ResponseBody
	public String testLog(){
		for (int i = 0; i < 10000; i++) {
			logger.debug(i+" aaaaaaaaaaaa");
		}
		return "完成";
	}
	
	
}
