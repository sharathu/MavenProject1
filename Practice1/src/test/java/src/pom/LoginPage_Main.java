package src.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_Main {
	public  WebDriver driver;
	public LoginPage_Main(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//@FindBy(id="ctl00_ContentPlaceHolder1_Login2_txtUserName")
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_Login2_txtUserName\"]")
	public
	WebElement username_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Login2_txtPassword")
	public WebElement Password_txt;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Login2_lnkForgotUsername")
	public WebElement ForgotUsername_Link;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Login2_lnkForgotPassword")
	public WebElement ForgotPassword_link;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Login2_btnLogin1")
	public WebElement Login_btn;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Login2_lnkHavePasswordResetToken")
	public WebElement IHavePwdResetToken_link;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Login2_lnkCreateAccount")
	public WebElement CreateAccount_link;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Login2_lnkOnlineHelp")
	public WebElement OnlineHelp_link;
	
	@FindBy(id="ctl00_ContentPlaceHolder1_Login2_Label2")
	public WebElement IamNotReceivingEmail_link;
	
	@FindBy(id="ctl00_Footer1_lnkSiteMap")
	public WebElement SiteMAp_link;
	
	@FindBy(id="ctl00_Footer1_lnkPrivacyPolicy")
	public WebElement PrivacyPolicy_link;
	
	@FindBy(id="ctl00_Footer1_aMobileSite")
	public WebElement MobileSite_link;
	
	@FindBy(xpath="//*[@id=\"ctl00_SignOutButton\"]")
	public WebElement LogOut_link;
	
	
	//LoginPage_Main log= PageFactory.initElements(this.driver, this);
	
	
	
}
