package src.test;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import src.generic.BaseClass;
import src.generic.ClassImport;
import src.pom.GlobalValues;

public class ExecutionController{
	static WebDriver driver;
	
	@Test
	public static void main1() throws Exception {
		
		FileInputStream testdata= new FileInputStream(GlobalValues.TestDataPath);
		XSSFWorkbook TestData= new XSSFWorkbook(testdata);
		
		FileInputStream excutionControl= new FileInputStream(GlobalValues.ExecutionController);
		XSSFWorkbook exe_control= new XSSFWorkbook(excutionControl);
		XSSFSheet ExecutionController= exe_control.getSheet("ExecutionController");
		
		int rowcount= ExecutionController.getLastRowNum();
		// To check the execution indicator
		for(int i=1;i<=rowcount;i++)
		{
			Row row= ExecutionController.getRow(i);
			Cell column= row.getCell(2);
			String CellData= column.getStringCellValue();
			if ((CellData.toLowerCase().equals("y")) ^ (CellData.toLowerCase().equals("yes")))
			{
				// To check whether it is IBE enrollment or not
				//Row ibe= ExecutionController.getRow(i);
				Row row1= ExecutionController.getRow(i);
				/*Cell ibeClmn= row1.getCell(6);
				String ibe_Enrollment= ibeClmn.getStringCellValue();*/
				
				Cell column1=row1.getCell(4);
				String browser= column1.getStringCellValue();
				Cell column2= row1.getCell(3);
				String site= column2.getStringCellValue();
				
				//To check whether main Site or mobile site
				if(site.toLowerCase().equals("main"))
				{
					Cell ibeClmn= row1.getCell(6);
					String ibe_Enrollment= ibeClmn.getStringCellValue();
					if (ibe_Enrollment.toLowerCase().equals("y"))
					{
						XSSFSheet TestDataSheet= TestData.getSheet("Enrollment");
						String ibeid= TestDataSheet.getRow(1).getCell(2).getStringCellValue();
						driver=new BaseClass().BaseClassMethod(browser,GlobalValues.Main_IBE_URL+ibeid);
						String className=row.getCell(1).getStringCellValue();
						System.out.println("Execution of the class "+ className+" has started");
						
						//This will initiate the IBE enrollment process in main site
						new ClassImport(className,driver);
						continue;
					}
					else
					{
						driver=new BaseClass().BaseClassMethod(browser,GlobalValues.Main_URL);
						String className=row.getCell(1).getStringCellValue();
						System.out.println("Execution of the class "+ className+" has started");
						
					//This will initiate the token enrollment in main site
						new ClassImport(className,driver);
						continue;
					}
					
				}
				
				else if(site.toLowerCase().equals("mobile"))
				{
					Cell ibeClmn= row1.getCell(6);
					String ibe_Enrollment= ibeClmn.getStringCellValue();
					if (ibe_Enrollment.toLowerCase().equals("y"))
					{
						XSSFSheet TestDataSheet= TestData.getSheet("Enrollment");
						String ibeid= TestDataSheet.getRow(1).getCell(2).getStringCellValue();
						driver=new BaseClass().BaseClassMethod(browser,GlobalValues.Mobile_IBE_URL+ibeid);
						String className=row.getCell(1).getStringCellValue();
						System.out.println("Execution of the class "+ className+" has started");
						new ClassImport(className,driver);
						continue;
					}
					else
					{
						driver=new BaseClass().BaseClassMethod(browser,GlobalValues.Mobile_URL);
						String className=row.getCell(1).getStringCellValue();
						System.out.println("Execution of the class "+ className+" has started");
						new ClassImport(className,driver);
						continue;
					}
				}
			}							
		}		
		//TestData.close();
		//exe_control.close();
	}
}
