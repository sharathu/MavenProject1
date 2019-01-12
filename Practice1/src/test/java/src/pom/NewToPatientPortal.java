package src.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewToPatientPortal {

	WebDriver driver;
	public NewToPatientPortal(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="ctl00_ContentPlaceHolder1_enrollOptions_Button1")
	public WebElement TokenEnrollment_btn;
	
	@FindBy (id="ctl00_ContentPlaceHolder1_enrollOptions_Button2")
	public WebElement TemporaryUnPwd_btn;
	
	@FindBy(id="ctl00_Footer1_lstLanguage")
	public WebElement Language_dropdown;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_lblWelcomeMsg")
	public WebElement Header1_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_lblInstructions")
	public WebElement Info_txt;
	
	//public String PageTitle= driver.getTitle();
}
