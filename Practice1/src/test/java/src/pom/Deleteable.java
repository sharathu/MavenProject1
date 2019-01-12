package src.pom;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Deleteable {
	
	public static void main (String [] args)throws Exception{

	//File xl= new File("c:/users/sharathu/desktop/TestData.xlsx");
	FileInputStream fis= new FileInputStream("c:/users/sharathu/desktop/TestData.xlsx");
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sh= wb.getSheetAt(0);
	Row row= sh.createRow(0);
	
	for (int i=0;i<=5;i++)
	{
		Cell cell=row.createCell(i);
	//cell.setCellType(cell.CELL_TYPE_STRING);
	cell.setCellValue("SKRow 0 column"+i);
	}
	Row rowvar= sh.getRow(0);
	for(int i=0;i<=5;i++)
	{
		Cell cellvar=rowvar.getCell(i);
		System.out.println(cellvar);
	}
	
	
	FileOutputStream fos= new FileOutputStream("c:/users/sharathu/desktop/TestData.xlsx");
	wb.write(fos);
	//wb.close();
	
	}	
}
