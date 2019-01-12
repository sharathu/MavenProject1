package src.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountOptions_Page {

	public WebDriver driver;
	public AccountOptions_Page(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(id="ctl00_ContentPlaceHolder1_breadCrumbSiteBar_sitebardlist_ctl01_lnkSideBar")
	public WebElement AccountOptions_Brdcum;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_HeaderContainer_lblWelcomeMsg")
	public WebElement Welcome_Patient_Header1;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_HeaderContainer_lblWelEmailMessage")
	public WebElement patient_email_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_enrollOptions_Button1")
	public WebElement SignupNew_Btn;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_enrollOptions_Button2")
	public WebElement AddToExisting_btn;
	
	
}
