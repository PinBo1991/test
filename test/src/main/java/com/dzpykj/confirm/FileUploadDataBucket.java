package com.dzpykj.confirm;

import java.io.File;

/**
 * 上传文件暂存数据的桶
 * @author ChaiXY
 */
public class FileUploadDataBucket {
    /**即将要保存的文件*/
    public File desFile;
    /**源文件*/
    public File srcFile;
    /**源文件名(带后缀)*/
    public String srcFileName;
    /**储存文件的名称(带后缀)*/
    public String desFileName;
    /**文件类型*/
    public String suffixName;
    /**基础路径*/
    public String basePath;
    /**针对不同功能存放文件可能有不同的文件夹,或者同一模块不同文件类型要存在不同的文件夹,都会在基础路径下新建文件夹,此字段用于存放基础路径后的各自的路径*/
    public String ownPath;
    /**数据存储的存放路径*/
    public String dbFilePath;
    /**文件大小MB*/
    public String fileSize;
    /**文件md5*/
    public String contentMD5;
    
    
	public File getDesFile() {
		return desFile;
	}
	public void setDesFile(File desFile) {
		this.desFile = desFile;
	}
	public File getSrcFile() {
		return srcFile;
	}
	public void setSrcFile(File srcFile) {
		this.srcFile = srcFile;
	}
	public String getSrcFileName() {
		return srcFileName;
	}
	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}
	public String getDesFileName() {
		return desFileName;
	}
	public void setDesFileName(String desFileName) {
		this.desFileName = desFileName;
	}
	public String getSuffixName() {
		return suffixName;
	}
	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}
	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	public String getOwnPath() {
		return ownPath;
	}
	public void setOwnPath(String ownPath) {
		this.ownPath = ownPath;
	}
	public String getDbFilePath() {
		return dbFilePath;
	}
	public void setDbFilePath(String dbFilePath) {
		this.dbFilePath = dbFilePath;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getContentMD5() {
		return contentMD5;
	}
	public void setContentMD5(String contentMD5) {
		this.contentMD5 = contentMD5;
	}
	@Override
	public String toString() {
		return "{desFile=" + desFile + ", srcFile=" + srcFile + ", srcFileName=" + srcFileName
				+ ", desFileName=" + desFileName + ", suffixName=" + suffixName + ", basePath=" + basePath
				+ ", ownPath=" + ownPath + ", dbFilePath=" + dbFilePath + ", fileSize=" + fileSize + ", contentMD5="
				+ contentMD5 + "}";
	}
}
