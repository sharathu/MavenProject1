package src.Practice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import src.Utilities.webElement;
import src.generic.BaseClass;
import src.pom.GlobalValues;

public class Definition1 extends BaseClass{
	
	//static WebDriver driver= BaseClass.driver;
	
	static BaseClass base= new BaseClass();
	//closing the browser
	public static void browser_close()
	{
		BaseClass.driver.quit();
		BaseClass.driver=null;
	}
	
	//Verify the page title
	public static void verifyPageTitle(String pageTitle)
	{
		System.out.println(BaseClass.driver.toString());
		Assert.assertEquals(BaseClass.driver.getTitle(), pageTitle);
		
	}
	public static void EnterText(String pageName,String webElement, String Text) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		jsonElemnt.getElement(pageName+".json", webElement).sendKeys(Text);
		
	}
	public static void ClickObject(String pageName, String webElement) throws IOException, InterruptedException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		jsonElemnt.getElement(pageName+".json", webElement).click();
		Thread.sleep(3000);
	}
	
	public static void VerifyObject_isEnabled(String pageName,String webElement) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		jsonElemnt.getElement(pageName+".json", webElement).isEnabled();
	}
	
	public static void VerifyObject_isDisplayed(String pageName,String webElement) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		jsonElemnt.getElement(pageName+".json", webElement).isDisplayed();
	}
	
	public static void VerifyObject_isSelected(String pageName,String webElement) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		jsonElemnt.getElement(pageName+".json", webElement).isSelected();
	}
	
	public static void mouseHover(String pageName, String parentElement,String webElement) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		WebElement parent=jsonElemnt.getElement(pageName+".json", parentElement);
		
		//Mouse Hovering on the object
		Actions action=new Actions(BaseClass.driver);
		action.moveToElement(parent).perform();;
		
		//Clicking on the object within the mouse hover menu
		jsonElemnt.getElement(pageName+".json", webElement).click();
	}
	
	public static void selectValueInDropDown(String pageName,String webElement,String DropdownValue) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		
		//Selecting the option
		Select select= new Select(jsonElemnt.getElement(pageName+".json", webElement));
		String dropdown= DropdownValue.toLowerCase();
		switch (dropdown)
		{
			case "first" : select.selectByIndex(0);
			break;
			case "second": select.selectByIndex(1);
			break;
			case "third": select.selectByIndex(2);
			break;
			case "fourth": select.selectByIndex(3);
			break;
			case "sixth": select.selectByIndex(5);
			break;
			case "seventh": select.selectByIndex(6);
			break;
			case "eigth": select.selectByIndex(7);
			break;
			case "nineth": select.selectByIndex(8);
			break;
			case "tenth": select.selectByIndex(9);
			break;
			case "eleventh": select.selectByIndex(10);
			break;
			
			default: select.selectByVisibleText(DropdownValue);
			break;
		}
		
	}
	
	public static void textComparision(String pageName,String webElement,String comparisionString) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		String str=jsonElemnt.getElement(pageName+".json", webElement).getText();
		//BaseClass base= new BaseClass();
		if(str.equalsIgnoreCase(comparisionString))
		{
		System.out.println("Comparion is passed and the webElement text is displayed as expected");
		
		//base.SnapShot(driver, GlobalValues.Screenshot_Path+pageName+new SimpleDateFormat("MMddss").format(new Date())+".png");
		
		}
		else
		{
			System.out.println("Text comparison has failed and the text is displayed as "+str);
			base.SnapShot(driver, GlobalValues.Screenshot_Path+pageName+new SimpleDateFormat("MMddhhmmss").format(new Date())+".png");
		}	
	}
	
	public static void GridValidation(String pageName,String GridName,String VerificationString) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		List<WebElement> list= new ArrayList<WebElement>();
		
		list.addAll(jsonElemnt.getElements(pageName+".json", GridName));
		System.out.println("The list contains "+list.size()+" elements");
		Date date=new Date();
		SimpleDateFormat format= new SimpleDateFormat("MM/dd/yyyy");
		String date1= format.format(date);
		System.out.println("Today is "+date1);
		for(WebElement list1:list)
		{
			String str=list1.getText();
			System.out.println("The string is displayed as "+str);
			if(str.contains(VerificationString)&& str.contains(date1))
			{
				System.out.println("Verification is successful and the object is found in the grid at ");
				break;
			}
			else
			{
				System.out.println("The object is not found in the grid");
				base.SnapShot(driver, GlobalValues.Screenshot_Path+pageName+new SimpleDateFormat("MMddhhmmss").format(new Date())+".png");
			}
		}
	}
	public static void TableContentVerification(String pageName,String webElement,String VerificationString) throws IOException
	{
		webElement jsonElemnt= new webElement(BaseClass.driver);
		
		List<WebElement> list=new ArrayList<WebElement>();
		list.addAll(jsonElemnt.getElements(pageName+".json", webElement));
		
		//Getting the substring out of the given string
		String str1= VerificationString.substring(0,VerificationString.indexOf("/"));
		String str2= VerificationString.substring(str1.length()+1,VerificationString.length());
		
		System.out.println("The list contains "+list.size()+" elements");
		Date date=new Date();
		SimpleDateFormat format= new SimpleDateFormat("MM/dd/yyyy");
		String date1= format.format(date);
		System.out.println("Today is "+date1);
		for(WebElement list1:list)
		{
			String str=list1.getText();
			System.out.println("The string is displayed as "+str);
			if(str.contains(str1)&& str.contains(str2) && str.contains(date1))
			{
				System.out.println("Verification is successful and the object is found in the grid at ");
				break;
			}
			else
			{
				System.out.println("The object is not found in the grid");
				base.SnapShot(driver, GlobalValues.Screenshot_Path+pageName+new SimpleDateFormat("MMddhhmmss").format(new Date())+".png");
			}
		}
	}
	
}
