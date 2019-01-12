package src.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurityQuestionsPage_Main {

	WebDriver driver;
	public SecurityQuestionsPage_Main(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="ctl00_ContentPlaceHolder1_breadCrumbSiteBar_sitebardlist_ctl03_lnkSideBar")
	public WebElement SecurityQuestions_BrdCrumb;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_HeaderContainer_lblWelcomeMsg")
	public WebElement PageHeader1_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_lblInstructions")
	public WebElement instruction_txt;

	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_ddlSecurityQuestions1")
	public WebElement SecurityQuestions_Dropdown1;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_txtSecurityAnswer1")
	public WebElement Security_Answer1;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_ddlSecurityQuestions2")
	public WebElement SecurityQuestions_Dropdown2;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_txtSecurityAnswer2")
	public WebElement Security_Answer2;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_ddlSecurityQuestions3")
	public WebElement SecurityQuestions_Dropdown3;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_txtSecurityAnswer3")
	public WebElement Security_Answer3;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_ddlSecurityQuestions4")
	public WebElement SecurityQuestions_Dropdown4;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_txtSecurityAnswer4")
	public WebElement Security_Answer4;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_ddlSecurityQuestions5")
	public WebElement SecurityQuestions_Dropdown5;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_secQuestions_txtSecurityAnswer5")
	public WebElement Security_Answer5;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_FinishNavigationTemplateContainerID_btnFinishButton")
	public WebElement Submit_btn;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_FinishNavigationTemplateContainerID_btnFinishCancelButton")
	public WebElement Cancel_btn;
}
