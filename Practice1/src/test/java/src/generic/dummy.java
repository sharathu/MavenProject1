package src.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class dummy {

	public static void main(String[]args){
		
	System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe/");
	WebDriver driver= new FirefoxDriver();
	
	driver.get("Google.com");
	}
}
