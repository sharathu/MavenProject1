package src.StepDefinition;

import java.io.IOException;

import org.testng.annotations.Test;

import src.Practice.Definition1;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import src.generic.BaseClass;

public class Definition {
	@Test
	@Given ("^I open the \"(.*)\" browser and launch \"(.*)\" site$")
	public void open_browser_and_launch_application(String browserName, String MmainOrMobileSite)
	{
		BaseClass base=new BaseClass();
		base.BaseClassMethod(browserName, MmainOrMobileSite);
	}
	@Test
	@Then("^I close the browser")
	public void browser_close()
	{
		Definition1.browser_close();
	}
	@Test
	@Then("^on \"(.*?)\" page, I verify the page title is displayed as \"(.*?)\"$")
	public static void verifyTitle(String PageName,String ExpectedTitle)
	{
		Definition1.verifyPageTitle(ExpectedTitle);
	}
	@Test
	@When("^on \"(.*)\" page, I set value in \"(.*)\" to \"(.*)\"$")
	public void Set_value_in_editbox(String PageName,String webelement,String text) throws IOException
	{
		Definition1.EnterText(PageName, webelement, text);
	}
	@Test
	@When("^on \"(.*)\" page, I click on \"(.*)\" \"(.*)\"$")
	public void ClickOnObject(String PageName, String webElement ,String ElementType) throws IOException, InterruptedException
	{
		Definition1.ClickObject(PageName, webElement);
	}
	
	@Test
	@Then("^on \"(.*)\" page, I verify \"(.*)\" is displayed$")
	public void VerifyObjectIsDisplayed(String PageName, String webElement) throws IOException
	{
		Definition1.VerifyObject_isDisplayed(PageName, webElement);
	}
	
	@Test
	@Then("^on \"(.*)\" page, I verify \"(.*)\" is enabled$")
	public void VerifyObjectIsEnabled(String PageName, String webElement) throws IOException
	{
		Definition1.VerifyObject_isEnabled(PageName, webElement);
	}
	
	@Test
	@Then("^on \"(.*)\" page, I verify \"(.*)\" is selected$")
	public void VerifyObjectIsSelected(String PageName, String webElement) throws IOException
	{
		Definition1.VerifyObject_isSelected(PageName, webElement);
	}
	
	@Test
	@Then ("^on \"(.*)\" page, I verify \"(.*)\" is displayed as \"(.*)\"$")
	public void TextVerification(String PageName, String webElement, String comparisionString) throws IOException
	{
		Definition1.textComparision(PageName, webElement, comparisionString);
	}
	@Test
	@When ("^on \"(.*)\" page, I click on \"(.*)\" and move to \"(.*)\" element$")
	public void mouseHover(String PageName, String webElement, String ChildElement) throws IOException
	{
		Definition1.mouseHover(PageName, webElement, ChildElement);
	}
	
	@Test
	@Then("^on \"(.*)\" page, I verify whether the \"(.*)\" grid contains \"(.*)\"$")
	public void GridData(String pageName,String Gridname, String webElement) throws IOException
	{
		Definition1.GridValidation(pageName, Gridname, webElement);
	}
	
	@Test
	@Then("^on \"(.*)\" page, I verify that the \"(.*)\" table contains \"(.*)\"$")
	public void TableVerificationStep(String pageName,String TableName, String VerificationContent) throws IOException
	{
		Definition1.TableContentVerification(pageName, TableName, VerificationContent);
	}
}
