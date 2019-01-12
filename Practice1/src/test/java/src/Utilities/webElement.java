package src.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jayway.jsonpath.JsonPath;

import src.pom.GlobalValues;

public class webElement {
	 WebDriver driver;
	public webElement(WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	public WebElement getElement(String FileName,String ElementKey) throws IOException
	{
		
		File json= new File (GlobalValues.JSON_FilePath+FileName);
		String str= JsonPath.read(json, "$."+ElementKey);
		String locator= str.substring(0,str.indexOf('#'));
		String locatorValue= str.substring(str.indexOf('#')+2,str.length());
		String element=locator+"=\""+locatorValue+"\"";
		System.out.println(element);
		WebElement elementValue=null;
		switch (locator.toLowerCase())
		{
			case "xpath":  elementValue= driver.findElement(By.xpath(locatorValue)) ;
				break;
			case "cssselector":  elementValue= driver.findElement(By.cssSelector(locatorValue)) ;
				break;
			case "classname":  elementValue= driver.findElement(By.className(locatorValue)) ;
				break;
			case "id":  elementValue=driver.findElement(By.id(locatorValue));
				break;
			case "name": elementValue= driver.findElement(By.name(locatorValue));
				break;
			case "linktext": elementValue= driver.findElement(By.linkText(locatorValue));
				break;
			case "partiallinktext": elementValue= driver.findElement(By.partialLinkText(locatorValue));
				break;
			case "tagname": elementValue= driver.findElement(By.tagName(locatorValue));
				break;
			
		}
		
		return elementValue;
	}
	public List<WebElement> getElements(String FileName, String ElementKey) throws IOException
	{
		File json= new File (GlobalValues.JSON_FilePath+FileName);
		String str= JsonPath.read(json, "$."+ElementKey);
		String locator= str.substring(0,str.indexOf('#'));
		String locatorValue= str.substring(str.indexOf('#')+2,str.length());
		String element=locator+"=\""+locatorValue+"\"";
		System.out.println(element);
		List<WebElement> elementValue=null;
		switch (locator.toLowerCase())
		{
			case "xpath":  elementValue= driver.findElements(By.xpath(locatorValue)) ;
				break;
			case "cssselector":  elementValue= driver.findElements(By.cssSelector(locatorValue)) ;
				break;
			case "classname":  elementValue= driver.findElements(By.className(locatorValue)) ;
				break;
			case "id":  elementValue=driver.findElements(By.id(locatorValue));
				break;
			case "name": elementValue= driver.findElements(By.name(locatorValue));
				break;
			case "linktext": elementValue= driver.findElements(By.linkText(locatorValue));
				break;
			case "partiallinktext": elementValue= driver.findElements(By.partialLinkText(locatorValue));
				break;
			case "tagname": elementValue= driver.findElements(By.tagName(locatorValue));
				break;
			
		}
		
		return elementValue;

	}
	
}
