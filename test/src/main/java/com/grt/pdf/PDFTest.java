package com.grt.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

public class PDFTest {


    	public static void main(String[] args) {

    		File pdfFile = new File("F://Test.pdf");
    		PDDocument document = null;
    		try {
    			// 方式一：
    			// InputStream input = null; input = new FileInputStream( pdfFile );
    			// //加载 pdf 文档 PDFParser parser = new PDFParser(new
    			// RandomAccessBuffer(input)); parser.parse(); document =
    			// parser.getPDDocument();
    			// 方式二：
    			document = PDDocument.load(pdfFile);

    			// 获取页码
    			int pages = document.getNumberOfPages();
    			// 读文本内容
    			PDFTextStripper stripper = new PDFTextStripper();
    			// 设置按顺序输出
    			stripper.setSortByPosition(true);
    			stripper.setStartPage(1);
    			stripper.setEndPage(pages);
    			String content = stripper.getText(document);
    			System.out.println(content);
    		} catch (Exception e) {
    			System.out.println(e);
    		}
    	}
}