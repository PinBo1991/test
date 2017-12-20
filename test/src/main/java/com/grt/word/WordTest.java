package com.grt.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordTest {
	public static void main(String[] args) throws Exception {
		 System.out.println(readWord("F://Test.doc"));
//		testReadByExtractor();
//		testReadByDoc();
	}

	public static void testReadByExtractor() throws IOException {
		InputStream is = new FileInputStream("F://Test.doc");
		XWPFDocument doc = new XWPFDocument(is);
		XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
		String text = extractor.getText();
		System.out.println(text);
//		CoreProperties coreProps = extractor.getCoreProperties();
		// printCoreProperties(coreProps);
		// close(is);

	}

	/**
	 * 输出CoreProperties信息
	 * 
	 * @param coreProps
	 */
	private static void printCoreProperties(CoreProperties coreProps) {
		System.out.println(coreProps.getCategory()); // 分类
		System.out.println(coreProps.getCreator()); // 创建者
		System.out.println(coreProps.getCreated()); // 创建时间
		System.out.println(coreProps.getTitle()); // 标题
	}

	/**
	 * 关闭输入流
	 * 
	 * @param is
	 */
	private static void close(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testReadByDoc() throws Exception {
		InputStream is = new FileInputStream("F://Test.doc");
		XWPFDocument doc = new XWPFDocument(is);
		List<XWPFParagraph> paras = doc.getParagraphs();
		for (XWPFParagraph para : paras) {
			// 当前段落的属性
			// CTPPr pr = para.getCTP().getPPr();
			System.out.println(para.getText());
		}
		// 获取文档中所有的表格
		List<XWPFTable> tables = doc.getTables();
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		for (XWPFTable table : tables) {
			// 表格属性
			// CTTblPr pr = table.getCTTbl().getTblPr();
			// 获取表格对应的行
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				// 获取行对应的单元格
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					System.out.println(cell.getText());
					;
				}
			}
		}
		close(is);
	}

	/**
	 * 
	 * @Title: getTextFromWord
	 * @Description: 读取word
	 * @param filePath
	 *            文件路径
	 * @return: String 读出的Word的内容
	 */
	public static String getTextFromWord(String filePath) {
		String result = null;
		File file = new File(filePath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			WordExtractor wordExtractor = new WordExtractor(fis);
			result = wordExtractor.getText();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * 读取word文件内容
	 * 
	 * @param path
	 * @return buffer
	 */
	public static String readWord(String path) {
		String buffer = "";
		try {
			if (path.endsWith(".doc")) {
				InputStream is = new FileInputStream(new File(path));
//				WordExtractor ex = new WordExtractor(is);
//				buffer = ex.getText();
//				ex.close();
				
				XWPFDocument doc = new XWPFDocument(is);
				XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
				String text = extractor.getText();
				System.out.println(text);
			} else if (path.endsWith(".docx")) {
				OPCPackage opcPackage = POIXMLDocument.openPackage(path);
				POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
				buffer = extractor.getText();
				extractor.close();
			} else {
				System.out.println("此文件不是word文件！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer;
	}

}
