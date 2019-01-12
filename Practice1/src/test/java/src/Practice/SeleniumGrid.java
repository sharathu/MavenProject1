package src.Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class SeleniumGrid {
	WebDriver driver;
	DesiredCapabilities cap;
	@Parameters({"nodeurl","browser"})
	@Test
	private void browserOpen(String nodeurl, String browser) throws MalformedURLException
	{
		
		switch (browser)
		{
		case "firefox": cap= DesiredCapabilities.firefox();
			break;
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			cap=DesiredCapabilities.chrome();
			break;
		case "internet explorer":
			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			cap=DesiredCapabilities.internetExplorer();
			
		}
		
		
		//cap.setBrowserName(browser);
		//cap.setCapability("plotform", "VISTA");
		//System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		driver=new  RemoteWebDriver (new URL(nodeurl),cap);
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com");
		driver.quit();
	}
	
}
