package com.grt.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

public class ExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		test2();
		// test1();

	}

	public static void test2() throws FileNotFoundException {
		InputStream input = new FileInputStream("C:\\694fujian\\201712201759270601.xls");
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(input);
			Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
			int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
			int columtotal = sheet.getRow(0).getPhysicalNumberOfCells();// 表头总共的列数
			System.out.println("总行数:" + totalRow + ",总列数:" + columtotal);
			for (int i = 1; i <= totalRow; i++) {// 遍历行
				for (int j = 0; j < columtotal; j++) {
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
				}
				System.out.println();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void test1() throws EncryptedDocumentException, InvalidFormatException, IOException {
		InputStream inputStream = new FileInputStream("C:\\694fujian\\201712201759270601.xls");
		// InputStream inp = new
		// FileInputStream("C:/Users/H__D/Desktop/workbook.xls");

		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheetAt(0);

		DataFormatter formatter = new DataFormatter();
		for (Row row : sheet) {
			for (Cell cell : row) {
				CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
				// 单元格名称
				System.out.print(cellRef.formatAsString());
				System.out.print(" - ");

				// 通过获取单元格值并应用任何数据格式（Date，0.00，1.23e9，$ 1.23等），获取单元格中显示的文本
				String text = formatter.formatCellValue(cell);
				System.out.println(text);

				// 获取值并自己格式化
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:// 字符串型
					System.out.println(cell.getRichStringCellValue().getString());
					break;
				case Cell.CELL_TYPE_NUMERIC:// 数值型
					if (DateUtil.isCellDateFormatted(cell)) { // 如果是date类型则
																// ，获取该cell的date值
						System.out.println(cell.getDateCellValue());
					} else {// 纯数字
						System.out.println(cell.getNumericCellValue());
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:// 布尔
					System.out.println(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:// 公式型
					System.out.println(cell.getCellFormula());
					break;
				case Cell.CELL_TYPE_BLANK:// 空值
					System.out.println();
					break;
				case Cell.CELL_TYPE_ERROR: // 故障
					System.out.println();
					break;
				default:
					System.out.println();
				}
			}
		}
	}

}