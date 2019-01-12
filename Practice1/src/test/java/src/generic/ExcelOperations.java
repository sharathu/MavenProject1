package src.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ExcelOperations {

	public String ReadExcel(String FilePath, String SheetName,int RowNumber,int ColumnNumber) throws Exception
	{
		
		FileInputStream fis= new FileInputStream(FilePath);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheet(SheetName);
		Row row= sheet.getRow(RowNumber);
		Cell column= row.getCell(ColumnNumber);
		String CellData=column.getStringCellValue();
		fis.close();
		//wb.close();
		return CellData;
		
	}
	

	public void WriteToExcel(String FilePath, String SheetName,int RowNumber,int ColumnNumber,String msg) throws Exception
	{
		FileInputStream fis= new FileInputStream(FilePath);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheet(SheetName);
		Row row= sheet.getRow(RowNumber);
		Cell column= row.createCell(ColumnNumber);
		column.setCellValue(msg);
		//To save the changes
		FileOutputStream fos=new FileOutputStream(FilePath);
		wb.write(fos);
		fos.close();
		//wb.close();
	}
}
