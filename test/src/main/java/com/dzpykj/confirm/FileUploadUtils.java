package com.dzpykj.confirm;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 文件上传
 * @author ChaiXY
 */
public class FileUploadUtils {
	
	/**
	 * 上传文件,并且回传数据桶(存储要保存到数据库的数据)
	 * @param request 
	 * @param basePath 基础路径(前后不要携带分隔符,工具类会自动补全)
	 * @param ownPath 针对不同功能存放文件可能有不同的文件夹,或者同一模块不同文件类型要存在不同的文件夹,都会在基础路径下新建文件夹,此字段用于存放基础路径后的各自的路径(前后不要携带分隔符,工具类会自动补全)
	 * @return 数据桶
	 */
	public static List<FileUploadDataBucket> uploadFiles(HttpServletRequest request, String basePath, String ownPath) throws IOException {
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        List<FileUploadDataBucket> dataBuckets = new ArrayList<>();
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                List<MultipartFile> multipartFiles = multiRequest.getFiles(iter.next());
                
                for(MultipartFile multipartFile:multipartFiles){
                	String srcFileName = multipartFile.getOriginalFilename();// 原名称 带后缀
                	String suffixName = srcFileName.substring(srcFileName.lastIndexOf(".") + 1);// 文件类型
                	String contentMD5 = DigestUtils.md5Hex(multipartFile.getBytes());
                	double size = (multipartFile.getSize() * 1.0) / (1024 * 1.0) / (1024 * 1.0);// MB
                	BigDecimal bg = new BigDecimal(size);
                	double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                	String fileSize = f1 + "";
                	
                	String desFileName = generateFileName() + "." + suffixName;
                	String dbFilePath = ownPath + File.separator + desFileName;
                	String desFilePath = basePath + File.separator + dbFilePath;
                	
                    File desFile = new File(desFilePath);
                    if (!desFile.exists()) {
                    	desFile.mkdirs();
                    }
                    
                    if (StringUtils.isNotBlank(srcFileName)) {
                    	multipartFile.transferTo(desFile);
                    	FileUploadDataBucket fudb = new FileUploadDataBucket();
                    	fudb.setBasePath(basePath);
                    	fudb.setContentMD5(contentMD5);
                    	fudb.setDbFilePath(dbFilePath);
                    	fudb.setDesFile(desFile);
                    	fudb.setDesFileName(desFileName);
                    	fudb.setFileSize(fileSize);
                    	fudb.setOwnPath(ownPath);
                    	fudb.setSrcFileName(srcFileName);
                    	fudb.setSuffixName(suffixName);
                    	dataBuckets.add(fudb);
                    }
                }
            }
        }
		return dataBuckets;
	}
	
	private static String generateFileName(){
		String dateStr = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		long timeMillis = System.currentTimeMillis();
		int random = new Random().nextInt(90)+10;
		return dateStr+timeMillis+random;
	}
	
}
