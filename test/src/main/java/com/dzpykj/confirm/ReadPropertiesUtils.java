package com.dzpykj.confirm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * 读取.properties配置内容
 * @author ChaiXY
 */
public class ReadPropertiesUtils {

	/**
	 * 根据路径获取全部配置
	 * @param filePath 文件的全路径
	 */
	public static Properties getProps(String filePath) throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		return getProps(in);
	}

	/**
	 * 获取配置文件的全部配置
	 */
	private static Properties getProps(InputStream in) throws Exception {
		Properties props = new Properties();
		try {
			props.load(in);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return props;
	}

	/**
	 * 废弃
	 * @param filePath 文件的相对路径
	 * @param propertiesFileName 配置文件的名字(不带后缀)
	 * @param key 配置文件中的key
	 */
	@Deprecated
	public static String getValue(String filePath, String propertiesFileName, String key) throws Exception {
		InputStream in = null;
		if (StringUtils.isBlank(filePath)) {
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName + ".properties");
		} else {
			in = new FileInputStream(filePath + File.separator + propertiesFileName + ".properties");
		}
		Properties props = getProps(in);
		if (props.isEmpty()) {
			return null;
		}
		// 处理中文乱码
		return new String(getProps(in).getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
	}
	
	/**
	 * 根据键获取配置文件的值
	 * @param filePath 文件的全路径
	 * @param key 配置文件中的key
	 */
	public static String getValue(String filePath, String key) throws Exception {
		InputStream in =  new FileInputStream(filePath);
		Properties props = getProps(in);
		if (props.isEmpty()) {
			return null;
		}
		// 处理中文乱码
		return new String(getProps(in).getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
	}


	/**
	 * 修改或添加键值对 如果key存在，修改, 反之，添加。
	 * @param filePath 文件的全路径
	 * @param parameterName 键
	 * @param parameterValue 键对应的值
	 */
	public static void writeProperties(String filePath, String parameterName, String parameterValue) throws IOException {
		Properties prop = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		// 从输入流中读取属性列表（键和元素对）
		prop.load(in);
		// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
		// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
		OutputStream out = new BufferedOutputStream(new FileOutputStream(filePath));
		prop.setProperty(parameterName, parameterValue);
		// 以适合使用 load 方法加载到 Properties 表中的格式，
		// 将此 Properties 表中的属性列表（键和元素对）写入输出流
		prop.store(out, "Update '" + parameterName + "' value");
		out.close();
	}

	/**
	 * 删除 根据 parameterName。
	 * @param filePath 文件的全路径
	 * @param parameterName 键
	 */
	public static void deleteProperties(String filePath, String parameterName) throws IOException {
		Properties prop = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		prop.load(in);
		prop.remove(parameterName);
		OutputStream out = new BufferedOutputStream(new FileOutputStream(filePath));
		prop.store(out, "Delete " + parameterName);
		out.close();
	}
	
	/**
	 * 获取文件夹下面指定文件名的文件
	 * @param file 文件夹对象
	 * @param fileName 文件名(不含后缀)
	 */
	public static List<File> getFileNameInDirectory(File file, String fileName) {
		List<File> wantFiles = new LinkedList<File>();
		File[] files = file.listFiles();
		if (files == null) {
			return wantFiles;
		}
		List<File> fileList = new ArrayList<File>();
		for (File f : files) {
			fileList.add(f);
		}
		Collections.sort(fileList, new Comparator<File>() {
			public int compare(File o1, File o2) {
				if (o1.isDirectory() && o2.isFile())
					return -1;
				if (o1.isFile() && o2.isDirectory())
					return 1;
				return o2.getName().compareTo(o1.getName());
			}
		});

		for (File f : fileList) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			if (fileName != null && f.getName().indexOf(fileName) != -1) {
				map.put("name", f.getName());
			}
			wantFiles.add(f);
		}
		return wantFiles;
	}
}
