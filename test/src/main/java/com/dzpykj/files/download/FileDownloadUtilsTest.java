package com.dzpykj.files.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class FileDownloadUtilsTest {
	public HttpServletResponse download(String path, HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			//String fileSuffixName = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=UTF-8");
			//response.setContentType("application/" +fileSuffixName + ";charset = UTF-8"); //设置字符集和文件后缀名
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}

	public void downloadLocal(HttpServletResponse response) throws FileNotFoundException {
		// 下载本地文件
		String fileName = "Operator.doc".toString(); // 文件的默认保存名
		// 读到流中
		InputStream inStream = new FileInputStream("c:/Operator.doc");// 文件的存放路径
		// 设置输出的格式
		response.reset();
		response.setContentType("bin");
		response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		// 循环取出流中的数据
		byte[] b = new byte[100];
		int len;
		try {
			while ((len = inStream.read(b)) > 0)
				response.getOutputStream().write(b, 0, len);
			inStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void downloadNet(HttpServletResponse response) throws MalformedURLException {
		// 下载网络文件
		int bytesum = 0;
		int byteread = 0;

		URL url = new URL("windine.blogdriver.com/logo.gif");

		try {
			URLConnection conn = url.openConnection();
			InputStream inStream = conn.getInputStream();
			FileOutputStream fs = new FileOutputStream("c:/abc.gif");

			byte[] buffer = new byte[1204];
			int length;
			while ((byteread = inStream.read(buffer)) != -1) {
				bytesum += byteread;
				System.out.println(bytesum);
				fs.write(buffer, 0, byteread);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void uiop(String fileName, String tmpFileName, HttpServletRequest request, HttpServletResponse response) throws IOException {  
        if(StringUtils.isEmpty(fileName) && StringUtils.isEmpty(tmpFileName)){  
            return;  
        }  
        File file = new File(tmpFileName);  
        if(!file.exists()) {  
            return;  
        }  
  
        String postfix = tmpFileName.substring(tmpFileName.lastIndexOf("."));  
        response.reset();  
        String userAgent = request.getHeader("User-Agent");  
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {  
            response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "utf-8") + postfix+"\"");  
        } else {  
            fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1"); // 下载的文件名显示编码处理  
            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + postfix+"\"");  
        }  
        response.setContentType("application/x-msdownload;charset=UTF-8");   
        FileInputStream fis = new FileInputStream(file);  
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());  
          
        byte[] buffer = new byte[2048];  
        int readlength = 0;  
        while((readlength = fis.read(buffer)) != -1){  
            bos.write(buffer,0,readlength);   
        }  
        try {  
            fis.close();  
        } catch (IOException e) {  
        }  
        try {  
            bos.flush();  
            bos.close();  
        } catch (IOException e) {  
        }  
    }  
	
	
}