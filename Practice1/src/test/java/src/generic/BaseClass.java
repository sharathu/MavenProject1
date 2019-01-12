package src.generic;

/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public  class BaseClass {
	
	public static WebDriver driver;
	//public static String BrowerName;
	
	public WebDriver BaseClassMethod(String BrowserName, String URL){
		
			//this.BrowerName=BrowserName;
			if ((BrowserName.toLowerCase()).equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver= new ChromeDriver();
			}
			else if(BrowserName.toLowerCase().equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
				
				
				driver= new FirefoxDriver();
			}
			else if (BrowserName.toLowerCase().equals("ie") ^ BrowserName.toLowerCase().equals("internet explorer"))
			{
				System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
				driver= new InternetExplorerDriver();
			}
			
			driver.get(URL);
			driver.manage().window().maximize();
			return driver;
	}
	
	public static void main(String...args)
	{
		new BaseClass().BaseClassMethod("firefox","google.com");
	}
	
}
*/

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseClass {

	 public static WebDriver driver;
	 
	 public WebDriver BaseClassMethod(String Browsername, String URL)
	 {
		 if(driver==null)
		 {
			 switch (Browsername.toLowerCase())
			 {
			 case "firefox": 
				 System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe/");
				 driver=new FirefoxDriver();
				 break;
				 
			 case "chrome":
				 System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
					driver= new ChromeDriver();
					break;
			 case "ie":
				 System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
					driver=new InternetExplorerDriver();

			 }
		 }
		 driver.get(URL);
		 driver.manage().window().maximize();
		return driver;
	 }
	 
	 public void SnapShot(WebDriver driver, String FilePath) throws IOException
	 {
		 TakesScreenshot scrshot= (TakesScreenshot) driver;
		 File srcfile=  scrshot.getScreenshotAs(OutputType.FILE);
		 File DestFile= new File (FilePath);
		 FileUtils.copyFile(srcfile, DestFile);
		 
	 }
	 
	 public static void main(String[]args) throws IOException
	 {
		 BaseClass base= new BaseClass();
		 base.BaseClassMethod("Chrome","Https://phlvdqapport08.nextgen.com/ppmain");
		 base.SnapShot(driver, "C:\\Users\\Sharathu\\Desktop\\Screenshots\\LoginPage_Main.png");
	 }
}