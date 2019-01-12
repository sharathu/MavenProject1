package src.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCredentials_Page {
	public WebDriver driver;
	public AccountCredentials_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="ctl00_ContentPlaceHolder1_breadCrumbSiteBar_sitebardlist_ctl02_lnkSideBar")
	public WebElement AccountCredentials_brdcumb;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_HeaderContainer_lblWelcomeMsg")
	public WebElement page_header1;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_EnterCredentials_txtUserNameLogin")
	public WebElement Username_input;
	
	@FindBy (id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_EnterCredentials_securePassword_txtPassword")
	public WebElement Password_input;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_EnterCredentials_lblUIDCriteriaLength")
	public WebElement Username_Constraint;
	
	@FindBy(id="splCharLinkctl00_ContentPlaceHolder1_wzdPatientEnrollment_EnterCredentials_securePassword_lblPWCriteriaSpecChar")
	public WebElement SpecialCharacter_link;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_EnterCredentials_securePassword_txtConfirmPW")
	public WebElement ConfirmPassword;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_StepNavigationTemplateContainerID_btnStepNextButton")
	public WebElement Next_Btn;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_StepNavigationTemplateContainerID_btnStepCancelButton")
	public WebElement Cancel_btn;
	
	//Mobile site compose new button--- xpath-- //a[@id="compose"]/span[@class="ui-btn-inner"]/span[1]
}
