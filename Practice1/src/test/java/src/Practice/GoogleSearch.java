package src.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class GoogleSearch {

	 WebDriver driver;
	 
	
	public static void main(String...args) throws InterruptedException
	{
		GoogleSearch google= new GoogleSearch();
		WebDriver driver= google.driver;
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://google.com");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium"+Keys.ENTER);
		List<WebElement> list= new ArrayList<WebElement>();
		list=driver.findElements(By.xpath("//div[@class='r']/a[contains(@href,'https://')]"));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++)
		{
			Thread.sleep(4000);
			List<WebElement> list1= new ArrayList<WebElement>();
			list1=driver.findElements(By.xpath("//div[@class='r']/a[contains(@href,'https://')]"));
			//System.out.println(list1.get(i).getAttribute("href"));
			if(!list1.get(i).isDisplayed())
			{
				JavascriptExecutor js=(JavascriptExecutor) driver; 
				
				js.executeScript("window.scrollBy(0,1500)");
				//js.executeScript("arguments[0].scrollIntoView();", list1.get(i));
				Thread.sleep(4000);
				if(!list1.get(i).isDisplayed())
					continue;
				
			}
			try{
			list1.get(i).click();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			
		}		
		driver.quit();
	}
}
