package src.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleAuthenticatorPage_Main {
	WebDriver driver;
	public GoogleAuthenticatorPage_Main(WebDriver driver){
		this.driver= driver;
	}
	
	@FindBy(id="ctl00_ContentPlaceHolder1_breadCrumbSiteBar_sitebardlist_ctl04_lnkSideBar")
	public WebElement GoogleAuth_brdCrumb;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_googleAuth_lblProtectAccountHeader")
	public WebElement PageHeader1_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_googleAuth_lblInstructions")
	public WebElement Instruction1_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_googleAuth_lblInfoHeader")
	public WebElement InfoHeader_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_googleAuth_lblInfoText")
	public WebElement Instruction2_txt;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$wzdPatientEnrollment$googleAuth$btnGetStarted")
	public WebElement GetStarted_btn;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_googleAuth_lnkToDashboard")
	public WebElement IamNotInterested_link;
	
	
}
