package com.dzpykj.files.upload;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzpykj.files.FileUploadDataBucket;
import com.dzpykj.files.FileUploadUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FileUploadTestController {
	
	@RequestMapping("/fileUpload")
	@ResponseBody
	public String upload(HttpServletRequest req) throws IOException{
		List<FileUploadDataBucket> dataBuckets = FileUploadUtils.uploadFiles(req,"E:\\fiels","pic");
		String jsonStr = new ObjectMapper().writeValueAsString(dataBuckets).toString();
		System.out.println(jsonStr);
		return jsonStr;
	}
	
}
