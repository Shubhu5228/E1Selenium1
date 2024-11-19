package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("E:\\selenium excel\\docs.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		//sh.createRow(2).createCell(1).setCellValue("Hiii");
		sh.getRow(2).createCell(2).setCellValue("Yes");
		FileOutputStream fos=new FileOutputStream("E:\\selenium excel\\docs.xlsx");
		wb.write(fos);
		
	}

}
