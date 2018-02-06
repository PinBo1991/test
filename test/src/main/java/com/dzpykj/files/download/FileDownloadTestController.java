package com.dzpykj.files.download;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadTestController {
	
	@RequestMapping("download")
	public String download(HttpServletResponse response) throws IOException{
		System.err.println(1111);
		//String path = "F:\\日常积累\\做程序员那么痛苦，你为什么没选择放弃.png";
		String path = "D:\\apache-tomcat-8.5.20-windows-x86.zip";
		boolean success = FileDownloadUtils.downloadFiles(path, response);
		return "asdf";
	}
}
