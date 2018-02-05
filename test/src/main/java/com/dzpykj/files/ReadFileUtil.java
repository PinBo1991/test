package com.dzpykj.files;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


/**
 * 读取文件内容的工具类(word,pdf,excel)
 * @author ChaiXY
 */
public class ReadFileUtil {
	@Value("${file_base_path}")
	private static String FILE_BASE_PATH;//年报附件存放位置

	private static final Logger LOGGER = LoggerFactory.getLogger(ReadFileUtil.class);

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
			String con = content.replaceAll("\n","");
			if(StringUtils.isBlank(con) && is !=null){
				Read_pdf(file, FILE_BASE_PATH);
			}
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
	@SuppressWarnings("deprecation")
	public static String readExcel(File file) {
		StringBuilder sb = new StringBuilder();
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(file);
			wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
			int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
			//System.out.println("总行数:" + totalRow + ",总列数:" + columtotal);
			for (int i = 1; i <= totalRow; i++) {// 遍历行
				int columtotal = sheet.getRow(i).getPhysicalNumberOfCells();// 表头总共的列数
				for (int j = 0; j < columtotal; j++) {
					//sheet.getRow(i).getCell(j).setCellType(CellType.BOOLEAN);
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					sb.append(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
					//System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
				}
				//System.out.println();
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
	
	public static void Read_pdf(File pdfPath, String outPath)
			throws IOException {
		PDDocument pd = PDDocument.load(pdfPath);
		PDFRenderer pdfRenderer = new PDFRenderer(pd);
		BufferedImage combined = null;
		for (int page = 0; page < pd.getNumberOfPages(); ++page) {
			BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 96,
					ImageType.RGB);
//			if (page == 0) {
				combined = bim;
//			} else {
//				combined = merge(combined, bim);
				String path = outPath+page+".png";
				File outFile = new File(path);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				ImageIO.write(bim, "png", out);// 写图片
				byte[] b = out.toByteArray();
				FileOutputStream output = new FileOutputStream(outFile);
				output.write(b);
				out.close();
				output.close();
//			}
		}

//		File outFile = new File(outPath);
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		ImageIO.write(combined, "png", out);// 写图片
//		byte[] b = out.toByteArray();
//		FileOutputStream output = new FileOutputStream(outFile);
//		output.write(b);
//		out.close();
//		output.close();

		pd.close();
	}
	
	@SuppressWarnings("unused")
	private static BufferedImage merge(BufferedImage image1, BufferedImage image2) {
        BufferedImage combined = new BufferedImage(
                image1.getWidth(),
                image1.getHeight() + image2.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        Graphics g = combined.getGraphics();
        g.drawImage(image1, 0, 0, null);
        g.drawImage(image2, 0, image1.getHeight(), null);
        g.dispose();
        return combined;
    }

	public static void main(String[] args) throws IOException {
//		System.out.println(readWord(new File("C:\\694fujian\\Test.doc")));
//		System.out.println(readPdf(new File("C:\\694fujian\\201712211552480401.pdf")));
//		System.out.println(readExcel(new File("C:\\694fujian\\201712201759270601.xls")));
		
		System.out.println(getText(new File("E:\\694fujian\\201801221425280901.xls")));
	}
}
