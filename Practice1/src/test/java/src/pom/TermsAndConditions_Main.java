package src.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TermsAndConditions_Main {
	public static WebDriver driver;
	  public TermsAndConditions_Main(WebDriver driver)
	{
		TermsAndConditions_Main.driver=driver;
	}

	@FindBy(id="ctl00_ContentPlaceHolder1_btnAccept")
	public WebElement IAccept_btn;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnDontAccept")
	public WebElement IDoNotAccept_btn;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_btnPrint")
	public WebElement Print_btn;
	
	@FindBy (xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lstLanguage\"]")
	public WebElement Language_dropdown;
	
	//public String PageTitle= driver.getTitle();
	
}
