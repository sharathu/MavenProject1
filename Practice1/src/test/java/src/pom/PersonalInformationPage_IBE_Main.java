package src.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPage_IBE_Main {
	static WebDriver driver;
	public PersonalInformationPage_IBE_Main(WebDriver driver)
	{
		PersonalInformationPage_IBE_Main.driver= driver;
	}

	@FindBy(id="ctl00_ContentPlaceHolder1_breadCrumbSiteBar_sitebardlist_ctl00_lnkSideBar")
	public WebElement PersonalInfo_BrdCrumb;

	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_txtPhoneNumber")
	public WebElement PhoneNumber_InputField;

	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_txtDateOfBirth")
	public WebElement DOB_InputField;

	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_ckHavePersonNumber")
	public WebElement PersonNumber_ChkBox;

	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_StartNavigationTemplateContainerID_btnStartNextButton")
	public WebElement Next_Button;

	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_StartNavigationTemplateContainerID_btnStartCancelButton")
	public WebElement Cance_Button;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_txtPersonNumber")
	public WebElement PersonNumber_InputField;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_HeaderContainer_lblWelcomeMsg")
	public WebElement Header1_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_HeaderContainer_lblWelEmailMessage")
	public WebElement Email_Address_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_lblWizardStep1IntroText")
	public WebElement Info_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_breadCrumbSiteBar_sitebardlist_ctl01_lnkSideBar")
	
	public WebElement AccountOptions_BrdCumb;
	
	public void EnterPhoneDOB(String phone, String DOB) throws InterruptedException
	{
		PhoneNumber_InputField.sendKeys(phone);
		DOB_InputField.sendKeys(DOB);
		Next_Button.click();
		Thread.sleep(4000);

	}
}
