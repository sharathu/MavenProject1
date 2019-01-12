package src.test;

import java.util.ArrayList;

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
import generic.SqlConnection;
import pom.AccountCredentials_Page;
import pom.AccountOptions_Page;
import pom.GlobalValues;
import pom.GoogleAuthenticatorPage_Main;
import pom.PersonalInformationPage_IBE_Main;
import pom.SecurityQuestionsPage_Main;*/
import src.pom.*;

public class IBE_Enrollment {
	static WebDriver driver;
	boolean bln_Status;
	boolean bln_textComparision;
	boolean bln_Buttons;
	//Fetching required data from excel
	ExcelOperations excel= new ExcelOperations();
	String firstname;
	String lastname;
	String Username;
	String Password;
	String SecurityAnswer;
	String emailAddress;
	String PhoneNumber;
	String DOB;
	{
		try {
			firstname= excel.ReadExcel(GlobalValues.TestDataPath, "Enrollment", 2, 8);
			lastname= excel.ReadExcel(GlobalValues.TestDataPath, "Enrollment", 2, 4);
			Username= excel.ReadExcel(GlobalValues.TestDataPath, "Enrollment", 2, 6);
			Password= excel.ReadExcel(GlobalValues.TestDataPath, "Enrollment", 2, 7);
			emailAddress = excel.ReadExcel(GlobalValues.TestDataPath, "Enrollment", 2, 5);
			SecurityAnswer = excel.ReadExcel(GlobalValues.TestDataPath, "Enrollment", 2, 10);
			PhoneNumber = excel.ReadExcel(GlobalValues.TestDataPath, "Enrollment", 2, 11);
			DOB= excel.ReadExcel(GlobalValues.TestDataPath, "Enrollment", 2, 3);
			} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//@Test(priority=1)
	@BeforeMethod
	void chooseDriver() throws Exception
	{
		 String browsername=new ExcelOperations().ReadExcel(GlobalValues.ExecutionController, "ExecutionController", 2, 4);
		 System.out.println(browsername);
		 IBE_Enrollment.driver=new BaseClass().BaseClassMethod(browsername,new ExcelOperations().ReadExcel(GlobalValues.TestDataPath,"Enrollment",2,2));
		 
		 System.out.println(driver.toString());
		 //Updating the email in server DB
		 
		 SqlConnection.sql("pp27fallint", "10.130.13.123", "sa", "N3xtG3n2014", "update ngweb_account_email set email_address='skenrollment_@nextgen.com' where email_address='"+emailAddress+"'", "update");
	}
	
	@Test//(priority=2)
	public void IbeEnr() throws Exception
	{
		
		TermsAndConditions_Main terms= new TermsAndConditions_Main(TokenEnrollment.driver);
		PageFactory.initElements(driver, terms);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Terms and conditions - patient portal"))
			{terms.IAccept_btn.click();
			Thread.sleep(4000);
			
			// Verifying the personal information page
			
			if(driver.getTitle().equalsIgnoreCase("Personal Information - Patient Portal"))
				{
					System.out.println("Personal Information page");
					//System.out.println(driver.toString());
					PersonalInformationPage_IBE_Main personal_info= PageFactory.initElements(driver, PersonalInformationPage_IBE_Main.class);
							//initElements(driver, PersonalInformationPage_IBE_Main.class);
					boolean InfoTextValidation = personal_info.Info_txt.getText().equals("Please enter the following information to verify your identity.");
					boolean Header1Validation= personal_info.Header1_txt.getText().equals("Welcome "+firstname+" "+lastname);
					boolean emailValidation = personal_info.Email_Address_txt.getText().equals(emailAddress);
					System.out.println(InfoTextValidation+" "+Header1Validation+" "+emailValidation+" "+personal_info.PersonalInfo_BrdCrumb.isEnabled()+" "+personal_info.PersonNumber_InputField.isDisplayed());
					
					// Static content validation on personal info page
					
					if(InfoTextValidation & Header1Validation & emailValidation & personal_info.PersonalInfo_BrdCrumb.isEnabled() & !personal_info.PersonNumber_InputField.isDisplayed())
						{
							
							personal_info.EnterPhoneDOB(PhoneNumber, DOB);
							System.out.println("Phone number- "+PhoneNumber+" and DOB is "+DOB);
							System.out.println("Entered personal info and clicked the Next button");
							
							//Account Options page
							System.out.println("Account Options page--Started");
							AccountOptions_Page account= PageFactory.initElements(driver, AccountOptions_Page.class);
							
							if(driver.getTitle().equalsIgnoreCase("Account options - Patient Portal"))
							{
								System.out.println("Account Options page");
								boolean bln_Status=  personal_info.PersonalInfo_BrdCrumb.isEnabled() & personal_info.AccountOptions_BrdCumb.isEnabled();
								boolean bln_textComparision= account.Welcome_Patient_Header1.getText().equals("Welcome "+firstname+" "+lastname) & account.patient_email_txt.getText().equals(emailAddress);
								boolean bln_Buttons= account.SignupNew_Btn.isEnabled() & account.AddToExisting_btn.isEnabled();
								System.out.println("bln_Status "+bln_Status);
								System.out.println("bln_textComparision "+bln_textComparision);
								System.out.println("bln_Buttons "+bln_Buttons);
										
								if(bln_Status & bln_textComparision & bln_Buttons)
								{
									account.SignupNew_Btn.click();
									Thread.sleep(3000);
									
									//Account credentials page
									
									AccountCredentials_Page accnt_cred= PageFactory.initElements(driver, AccountCredentials_Page.class);
									if(driver.getTitle().equalsIgnoreCase("Account credentials - Patient Portal"))
									{
										System.out.println("Account Credentials page");
										bln_Status= account.AccountOptions_Brdcum.isEnabled() & personal_info.PersonalInfo_BrdCrumb.isEnabled() & accnt_cred.AccountCredentials_brdcumb.isEnabled();
										bln_textComparision= accnt_cred.page_header1.getText().equals("Set up account");
										bln_Buttons= accnt_cred.Next_Btn.isEnabled() & accnt_cred.Cancel_btn.isEnabled();
										System.out.println("bln_Status "+bln_Status);
										System.out.println("bln_textComparision "+bln_textComparision);
										System.out.println("bln_Buttons "+bln_Buttons);
										
										if(bln_Status & bln_textComparision & bln_Buttons)
										{
											accnt_cred.Username_input.sendKeys(Username);
											accnt_cred.Password_input.sendKeys(Password);
											Thread.sleep(2000);
											accnt_cred.ConfirmPassword.sendKeys(Password);
											Thread.sleep(1000);
											accnt_cred.Next_Btn.click();
											System.out.println("Username and password is entered and clicked on the Next button");
											Thread.sleep(4000);
											
											//Security questions page
											SecurityQuestionsPage_Main security=PageFactory.initElements(driver, SecurityQuestionsPage_Main.class);
											
											JavascriptExecutor js= (JavascriptExecutor)driver;
											
											if(driver.getTitle().equalsIgnoreCase("Security Questions - Patient portal"))
											{	
												System.out.println("Security Questions page");
												bln_Status= account.AccountOptions_Brdcum.isEnabled() & personal_info.PersonalInfo_BrdCrumb.isEnabled() & accnt_cred.AccountCredentials_brdcumb.isEnabled() & security.SecurityQuestions_BrdCrumb.isEnabled();
												bln_textComparision= security.PageHeader1_txt.getText().equals("Set up security questions") & security.instruction_txt.getText().equals("Please select five unique security questions, then enter your answer for each.");
												bln_Buttons= security.Submit_btn.isEnabled() & security.Cancel_btn.isEnabled();
																								
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
														
														// Google authentication page
														GoogleAuthenticatorPage_Main google= PageFactory.initElements(driver, GoogleAuthenticatorPage_Main.class);
														bln_Status=account.AccountOptions_Brdcum.isEnabled() & personal_info.PersonalInfo_BrdCrumb.isEnabled() & accnt_cred.AccountCredentials_brdcumb.isEnabled() & security.SecurityQuestions_BrdCrumb.isEnabled() & google.GoogleAuth_brdCrumb.isEnabled();
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
															System.out.println("Google authenticator page");
															if(bln_Status & bln_textComparision & bln_Buttons)
															{
																google.IamNotInterested_link.click();
																Thread.sleep(9000);
																if(driver.getTitle().equals("Dashboard - Patient Portal"))
																	new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Enrollment is successful");
															}
															else
															new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "WebElements on Google authenticator page is not displayed as expected");
														}
														else
															new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Enrollment Failed- Page title is not matched with google authenticator page and displayed as "+driver.getTitle());
													
														System.out.println("IBE enrollment logic is executed successfully");
													}
												else
												 new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "WebElements on Security Questions page is not displayed as expected");
															
											}
											else
												new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Enrollment Failed- Page title is not for security question page matched and displayed as "+driver.getTitle());
											
										}
										else
											new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Enrollment Failed- Web elements on Account credentials page is not displayed as expected");
									}
									else
										new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Enrollment Failed- Page title is not matched and displayed as "+driver.getTitle());
									
									
								}
								else
								{
									new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Enrollment is Failed- All the elements are not displayed as expected on "+driver.getTitle());
								}
							}
							else
								new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Enrollment is Failed- Page title is not displayed as expected and displayed as "+driver.getTitle());
							
						}
					
					else
						{
							excel.WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Either content validation is wrong or Page Title is wrongly displayed as "+driver.getTitle());
						}
				}
			
			else
				{
					new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Page Title is wrongly displayed as "+driver.getTitle());
				}
			}
		
		else
			new ExcelOperations().WriteToExcel(GlobalValues.ExecutionController, "ExecutionController", 2, 5, "Failed--Terms and Conditions page is not loaded");
	}

	@AfterMethod
	void Logout() throws Exception
	{
		if(driver.getTitle().equals("Dashboard - Patient Portal")){
			new LoginLogOut(driver).Logout();
			Thread.sleep(4000);
			driver.close();
			
		}
		
		else
		{
			System.out.println("Dashboard Page is not displayed");
			new ExcelOperations().WriteToExcel(GlobalValues.TestDataPath, "Enrollment", 2, 9, "Enrollment Passed but unable to logout of the application and the current page title is "+driver.getTitle());
		}
	}
	
}
