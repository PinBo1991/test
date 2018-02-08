package com.dzpykj.confirm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载工具类
 * @author ChaiXY
 */
public class FileDownloadUtils {
	
	/**
	 * 文件下载
	 * @param path 文件全路径
	 * @return 是否下载成功
	 */
	public static boolean downloadFiles(String path, HttpServletResponse response) throws IOException {
		boolean success = false;
		// path是指欲下载的文件的路径。
		File file = new File(path);
		// 取得文件名。
		String filename = file.getName();
		// 取得文件的后缀名。
		//String fileSuffixName = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
		
		// 以流的形式下载文件。
		InputStream fis = new BufferedInputStream(new FileInputStream(path));
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		// 清空response
		response.reset();
		// 设置response的Header
		//response.addHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
		response.addHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes(), "ISO-8859-1"));
		response.addHeader("Content-Length", "" + file.length());
		OutputStream os = new BufferedOutputStream(response.getOutputStream());
		response.setContentType("application/octet-stream");
		//response.setContentType("application/octet-stream;charset=UTF-8");
		// response.setContentType("application/" +fileSuffixName + ";charset = UTF-8"); //设置字符集和文件后缀名
		os.write(buffer);
		os.flush();
		os.close();
		success = true;
		return success;
	}
}
