package src.test;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import src.generic.*;
/*import generic.ExcelOperations;
import generic.LoginLogOut;
import generic.TokenDetails;
import pom.AccountCredentials_Page;
import pom.AccountOptions_Page;
import pom.GlobalValues;
import pom.GoogleAuthenticatorPage_Main;
import pom.LoginPage_Main;
import pom.NewToPatientPortal;
import pom.SecurityQuestionsPage_Main;*/
import src.pom.*;

public class TokenEnr_Main {
	static WebDriver driver;
	//@Test(priority=1)
	@BeforeMethod
	void chooseDriver() throws Exception
	{
		Logger log= Logger.getLogger("devpinoyLogger");
		log.debug("Execution has started");
		
		 String browsername=new ExcelOperations().ReadExcel(GlobalValues.ExecutionController, "ExecutionController", 1, 4);
		 System.out.println(browsername);
		 TokenEnr_Main.driver=new BaseClass().BaseClassMethod(browsername, GlobalValues.Main_URL);
	}
	@Test//(priority=2)
	public void tokenEnr() throws Exception
	{
		LoginPage_Main createNew= PageFactory.initElements(driver, LoginPage_Main.class);
		createNew.CreateAccount_link.click();
		Thread.sleep(7000);
		TermsAndConditions_Main terms= new TermsAndConditions_Main(TokenEnrollment.driver);
		PageFactory.initElements(driver, terms);
		//terms.IAccept_btn.click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Terms and conditions - patient portal"))
			{terms.IAccept_btn.click();
			Thread.sleep(3000);}
		else
			new ExcelOperations().WriteToExcel(GlobalValues.ExecutionController, "ExecutionController", 1, 5, "Failed--Terms and Conditions page is not loaded");
		
		// New to Patient Portal Page.--Clicking on I have an enrollment token
		NewToPatientPortal newToPortal= new NewToPatientPortal(driver);
				PageFactory.initElements(driver, newToPortal);
		if(driver.getTitle().equalsIgnoreCase("your medical home on the web - Patient Portal"))
		{
			String Header1=newToPortal.Header1_txt.getText();
			String info= newToPortal.Info_txt.getText();
			if (Header1.equals("New to Patient Portal") & info.equals("This is your first step in the enrollment process. Please select the option that applies to you.") )
			{
				newToPortal.TokenEnrollment_btn.click();
				Thread.sleep(3000);
			}
			else 
				System.out.println("The header is"+Header1+" And the info is "+info);				
		}
		else
			System.out.println("\"The page title is displayed as\""+driver.getTitle());
		
		//Token Details page
		
		TokenDetails token= new TokenDetails(driver);
				PageFactory.initElements(driver, token);
		//Page Title validation
				Thread.sleep(5000);
				
				String TokenDetails=new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "Enrollment", 1, 1);
				String DOB= new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "Enrollment", 1, 3);
				String LastName= new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "Enrollment", 1, 4);
				String email=new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "Enrollment", 1, 5);
				String UserName=new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "Enrollment", 1, 6);
				String Password=new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "Enrollment", 1, 7);
		if(driver.getTitle().equalsIgnoreCase("Token details - Patient Portal"))
		{	
			System.out.println(token.TokenDetails_brdcumb.isEnabled());
			System.out.println(token.Header1_txt.getText());
			System.out.println(token.Info_txt.getText());
			if(token.TokenDetails_brdcumb.isEnabled() & token.Header1_txt.getText().equals("Enter token details") & token.Info_txt.getText().equals("Please enter the following information to verify your identity."))
			{
				token.TokenField_input.sendKeys(TokenDetails);
				token.DOB_input.sendKeys(DOB);
				token.EmailAddress_input.sendKeys(email);
				token.Last_Name_input.sendKeys(LastName);
				token.Next_btn.click();
			}
		}
		else 
		{
			System.out.println("Page title is displayed as " + driver.getTitle());
		}
		
		String FirstName= new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "Enrollment", 1, 8);
		Thread.sleep(4000);
		// To validate the enrollment options on Account Options page and to navigate to further page.->Signing up for the new enrollment
		AccountOptions_Page account= PageFactory.initElements(driver, AccountOptions_Page.class);
		if(driver.getTitle().equalsIgnoreCase("Account options - Patient Portal"))
		{
		
			boolean bln_Status=  account.AccountOptions_Brdcum.isEnabled() & token.TokenDetails_brdcumb.isEnabled();
			boolean bln_textComparision= account.Welcome_Patient_Header1.getText().equals("Welcome "+FirstName+" "+LastName) & account.patient_email_txt.getText().equals(email);
			boolean bln_Buttons= account.SignupNew_Btn.isEnabled() & account.AddToExisting_btn.isEnabled();
			System.out.println("bln_Status "+bln_Status);
			System.out.println("bln_textComparision "+bln_textComparision);
			System.out.println("bln_Buttons "+bln_Buttons);
					
			if(bln_Status & bln_textComparision & bln_Buttons)
			{
				account.SignupNew_Btn.click();
			}
			else
			{
				new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "Enrollment is Failed- All the elements are not displayed as expected");
			}
		}
		else
			new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "Enrollment is Failed- Page title is not displayed as expected");
		
		Thread.sleep(5000);
		
		// To validate the options on Account credentials page.
		boolean bln_Status;
		boolean bln_textComparision;
		boolean bln_Buttons;
		AccountCredentials_Page accnt_cred= PageFactory.initElements(driver, AccountCredentials_Page.class);
		if(driver.getTitle().equalsIgnoreCase("Account credentials - Patient Portal"))
		{
			bln_Status= account.AccountOptions_Brdcum.isEnabled() & token.TokenDetails_brdcumb.isEnabled() & accnt_cred.AccountCredentials_brdcumb.isEnabled();
			bln_textComparision= accnt_cred.page_header1.getText().equals("Set up account");
			bln_Buttons= accnt_cred.Next_Btn.isEnabled() & accnt_cred.Cancel_btn.isEnabled();
			System.out.println("bln_Status "+bln_Status);
			System.out.println("bln_textComparision "+bln_textComparision);
			System.out.println("bln_Buttons "+bln_Buttons);
			
			if(bln_Status & bln_textComparision & bln_Buttons)
			{
				accnt_cred.Username_input.sendKeys(UserName);
				accnt_cred.Password_input.sendKeys(Password);
				Thread.sleep(2000);
				accnt_cred.ConfirmPassword.sendKeys(Password);
				Thread.sleep(1000);
				accnt_cred.Next_Btn.click();
				System.out.println("Username and password is entered and clicked on the Next button");
			}
			else
				new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "Enrollment Failed- The elements on Account credentials page is not displayed as expected");
		}
		else
			new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "Enrollment Failed- Page title is not matched and displayed as "+driver.getTitle());
		
		Thread.sleep(4000);
		
		// logics for the security question page needs to be written here
		
		SecurityQuestionsPage_Main security=PageFactory.initElements(driver, SecurityQuestionsPage_Main.class);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		if(driver.getTitle().equalsIgnoreCase("Security Questions - Patient portal"))
		{	
			bln_Status= account.AccountOptions_Brdcum.isEnabled() & token.TokenDetails_brdcumb.isEnabled() & accnt_cred.AccountCredentials_brdcumb.isEnabled() & security.SecurityQuestions_BrdCrumb.isEnabled();
			bln_textComparision= security.PageHeader1_txt.getText().equals("Set up security questions") & security.instruction_txt.getText().equals("Please select five unique security questions, then enter your answer for each.");
			bln_Buttons= security.Submit_btn.isEnabled() & security.Cancel_btn.isEnabled();
			/*System.out.println(bln_Status);
			System.out.println(bln_textComparision);
			System.out.println(bln_Buttons);*/
			
			System.out.println("bln_Status "+bln_Status);
			System.out.println("bln_textComparision "+bln_textComparision);
			System.out.println("bln_Buttons "+bln_Buttons);
			
			if(bln_Status & bln_textComparision & bln_Buttons)
				{
					ArrayList<WebElement> dropdown= new ArrayList<WebElement>();
					dropdown.add(security.SecurityQuestions_Dropdown1);
					dropdown.add( security.SecurityQuestions_Dropdown2);
					dropdown.add( security.SecurityQuestions_Dropdown3);
					dropdown.add( security.SecurityQuestions_Dropdown4);
					dropdown.add( security.SecurityQuestions_Dropdown5);
					
					for(WebElement d: dropdown)
					{
						Select drop;
						drop=new Select(d);
						drop.selectByIndex(1);
						Thread.sleep(3000);
						js.executeScript("arguments[0].scrollIntoView();", d);
					}
					
					ArrayList<WebElement> Answer= new ArrayList<WebElement>();
					Answer.add(security.Security_Answer1);
					Answer.add(security.Security_Answer2);
					Answer.add(security.Security_Answer3);
					Answer.add(security.Security_Answer4);
					Answer.add(security.Security_Answer5);
					String Sec_Answer= new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "Enrollment", 1, 10);
					for(WebElement e: Answer)
					{
						e.sendKeys(Sec_Answer);
						js.executeScript("arguments[0].scrollIntoView();", e);
						
					}
					js.executeScript("arguments[0].scrollIntoView();", security.Submit_btn);
					security.Submit_btn.click();
					Thread.sleep(6000);
				}
			else
			 new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "WebElements on Security Questions page is not displayed as expected");
						
		}
		else
			new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "Enrollment Failed- Page title is not matched and displayed as "+driver.getTitle());
		
		// Google authenticator page
		GoogleAuthenticatorPage_Main google= PageFactory.initElements(driver, GoogleAuthenticatorPage_Main.class);
		bln_Status=account.AccountOptions_Brdcum.isEnabled() & token.TokenDetails_brdcumb.isEnabled() & accnt_cred.AccountCredentials_brdcumb.isEnabled() & security.SecurityQuestions_BrdCrumb.isEnabled() & google.GoogleAuth_brdCrumb.isEnabled();
		bln_textComparision=google.PageHeader1_txt.getText().equals("Protect your account with Google Authenticator")
				& google.Instruction1_txt.getText().equals("Each time you sign in to your Patient Portal account, you�ll need your password and verification code.")
				& google.InfoHeader_txt.getText().equals("Make your account more secure")
				& google.Instruction2_txt.getText().equals("Each time you log in, a unique verification code will be sent to your phone through the Google Authenticator app. Enter this code after your password for an extra layer of security.");
		
		bln_Buttons= google.GetStarted_btn.isEnabled() & google.IamNotInterested_link.isEnabled();
		System.out.println(bln_Status);
		System.out.println(bln_textComparision);
		System.out.println(bln_Buttons);
		if(driver.getTitle().equals("Google Authenticator - Patient Portal"))
		{
			if(bln_Status & bln_textComparision & bln_Buttons)
			{
				google.IamNotInterested_link.click();
				Thread.sleep(8000);
				if(driver.getTitle().equals("Dashboard - Patient Portal"))
					new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "Token enrollment is successful");
			}
			else
			new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "WebElements on Google authenticator page is not displayed as expected");
		}
		else
			new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "Enrollment Failed- Page title is not matched and displayed as "+driver.getTitle());
	
		System.out.println("Token enrollment logic is executed successfully");
							
	}
	
	//@Test(priority=3)
	@AfterMethod
	void Logout() throws Exception
	{
		if(driver.getTitle().equals("Dashboard - Patient Portal")){
			new LoginLogOut(driver).Logout();
			
		}
		
		else
		{
			System.out.println("Dashboard Page is not displayed");
			new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 1, 9, "Enrollment Failed- Page title is not matched and displayed as "+driver.getTitle());
		}
	}
}
