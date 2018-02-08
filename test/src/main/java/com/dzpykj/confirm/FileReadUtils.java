package com.dzpykj.confirm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取文件内容的工具类(word,pdf,excel)
 * @author ChaiXY
 */
public class FileReadUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileReadUtils.class);

	/**
	 * 判断参数文件的类型,并进行读取
	 * @param file 文件
	 * @return 文件的内容
	 */
	public static String getText(File file){
		String fileName = file.getName();
		if(fileName.endsWith(".doc")||fileName.endsWith(".docx")) return readWord(file);
		else if (fileName.endsWith(".xls")||fileName.endsWith(".xlsx")) return readExcel(file);
		else if(fileName.endsWith(".pdf")) return readPdf(file);
		else return null;
	}
	
	/**
	 * 读取word文件内容
	 * @param path 文件路径
	 * @return word文件内容
	 */
	public static String readWord(File file) {
		String result = null;
		FileInputStream fis = null;
		WordExtractor wordExtractor = null;
		try {
			fis = new FileInputStream(file);
			wordExtractor = new WordExtractor(fis);
			result = wordExtractor.getText();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				if (fis != null) fis.close();
				if (wordExtractor != null) wordExtractor.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return result;
	}
	
	/**
	 * 读取pdf文件内容
	 * @param path 文件路径
	 * @return pdf文件内容
	 */
	public static String readPdf(File file) {
		PDDocument document = null;
		String content = null;
		InputStream is = null; 
		try {
			// 方式一：
			is = new FileInputStream( file );
			PDFParser parser = new PDFParser(new RandomAccessBuffer(is)); 
			parser.parse(); // 加载 pdf 文档 
			document = parser.getPDDocument();
			// 方式二：
			//document = PDDocument.load(pdfFile);
			int pages = document.getNumberOfPages();// 获取页码
			PDFTextStripper stripper = new PDFTextStripper();// 读文本内容
			stripper.setSortByPosition(true);// 设置按顺序输出
			stripper.setStartPage(1);
			stripper.setEndPage(pages);
			content = stripper.getText(document);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				if(document != null) document.close();
				if(is != null) is.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return content;
	}
	
	/**
	 * 读取Excel文件内容
	 * @param path 文件路径
	 * @return Excel文件内容
	 */
	public static String readExcel(File file) {
		StringBuilder sb = new StringBuilder();
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(file);
			wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
			if(sheet != null){
				int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
				//System.out.println("总行数:" + totalRow + ",总列数:" + columtotal);
				for (int i = 0; i <= totalRow; i++) {// 遍历行
					Row row = sheet.getRow(i);
					int columtotal = row.getLastCellNum();// 表头总共的列数
					if(row != null){
						for (int j = 0; j < columtotal; j++) {
							//sheet.getRow(i).getCell(j).setCellType(CellType.BOOLEAN);
							Cell cell = sheet.getRow(i).getCell(j);
							if(cell != null){
								cell.setCellType(CellType.STRING);
								sb.append(cell.getStringCellValue() + " ");
								//System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
							}
						}
						//System.out.println();
					}
				}
			}
			

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				if(is != null) is.close();
				if(wb != null) wb.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return sb.toString();
	}
}
