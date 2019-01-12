package src.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TokenDetails 
{
	WebDriver driver;
	public TokenDetails(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="ctl00_ContentPlaceHolder1_breadCrumbSiteBar_sitebardlist_ctl00_lnkSideBar")
	public WebElement TokenDetails_brdcumb;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_HeaderContainer_lblWelcomeMsg")
	public WebElement Header1_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_lblWizardStep1IntroText")
	public WebElement Info_txt;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_wzdPatientEnrollment_txtTokenNumber\"]")
	//@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_lblWizardStep1IntroText")
	public WebElement TokenField_input;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_lblWhatIsToken")
	public WebElement WhatIsToken_link;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_txtDateOfBirth")
	public WebElement DOB_input;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_txtLastName")
	public WebElement Last_Name_input;
	
	@FindBy (id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_txtEmailAddress")
	public WebElement EmailAddress_input;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_ckNoEmailAddress")
	public WebElement I_DoNotHaveEmail_chkbox;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_StartNavigationTemplateContainerID_btnStartNextButton")
	public WebElement Next_btn;
	
	@FindBy (id="ctl00_ContentPlaceHolder1_wzdPatientEnrollment_StartNavigationTemplateContainerID_btnStartCancelButton")
	public WebElement Cancel_btn;
	
	//public String PageTitle= driver.getTitle();
}
