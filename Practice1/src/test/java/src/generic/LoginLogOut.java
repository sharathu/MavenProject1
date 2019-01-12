package src.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import src.pom.GlobalValues;
import src.pom.LoginPage_Main;

public class LoginLogOut {
	public  static WebDriver driver;

	public LoginLogOut(WebDriver driver2) {
		LoginLogOut.driver=driver2;
	}
	public void Login() throws Exception
	{
		String username=new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "LoginPage", 1, 1);
		String password= new ExcelOperations().ReadExcel(GlobalValues.TestDataPath, "LoginPage", 1, 2);
		
		LoginPage_Main login= PageFactory.initElements(driver, LoginPage_Main.class);
		//Verifying the Page title
		String PageTitle=driver.getTitle();
		System.out.println(PageTitle);
		if(PageTitle.equals("Login - Patient Portal"))
		{
			//Sending user name
			System.out.println(username);
			System.out.println(password);
			Thread.sleep(3000);
			login.username_txt.sendKeys(username);
			login.Password_txt.sendKeys(password);
			login.Login_btn.click();
			Thread.sleep(3000);
			PageTitle= driver.getTitle();
			if (PageTitle.equalsIgnoreCase("Dashboard - Patient Poral"))
			System.out.println("login is successful");
			else if (PageTitle.contains("There is an error"))
				System.out.println("Login is failed as the error is encountered in login page");
			else
				System.out.println("login is failed as the dashboard page is not loaded yet");
		}
		
		else
			System.out.println("Login Page is not loaded");
	}
	
	public void Logout()
	{
		LoginPage_Main login= PageFactory.initElements(driver, LoginPage_Main.class);
		login.LogOut_link.click();
	}
}
