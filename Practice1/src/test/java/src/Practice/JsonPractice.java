package src.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import src.Utilities.webElement;
import src.generic.BaseClass;

public class JsonPractice {
	static WebDriver driver;
	public static void main(String[]args) throws IOException
	{
		/*BaseClass base= new BaseClass();
			driver= base.BaseClassMethod("chrome","https://phlvdqapport08.nextgen.com/ppmain");*/
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver= new ChromeDriver();	
		webElement jsonElemnt= new webElement(driver);
		System.out.println(jsonElemnt.getElement("RequestApptPage.json", "ApptReq_Label").toString());
	}
}
