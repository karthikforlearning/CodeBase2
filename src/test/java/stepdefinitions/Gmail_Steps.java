package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import Components.ComposeEmail;
import Components.SignIn;
import Util.BrowserUtils;
import Util.ElementUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumbertests.BaseClass;

public class Gmail_Steps {

	public WebDriver driver = BaseClass.driver;
	public String sbj = "RecvdGenq";
	public String bdy = "text3456";

	@Given("^User should launch Browser and invoke application$")
	public void user_should_launch_Browser_and_invoke_application() throws Throwable {
		BrowserUtils.launchBrowser();
		BrowserUtils.navigateApp("https://gmail.com");

	}

	@When("^User should enter valid credentials and signin$")
	public void user_should_enter_valid_credentials_and_signin() throws Throwable {
		SignIn.enterValidCred("karthiksitsme@gmail.com", "ashirwad@1289");

	}

	@Then("^User should be in gmail inbox page\\.$")
	public void user_should_be_in_gmail_inbox_page() throws Throwable {
		if (ElementUtils.findObjects(By.xpath("//div[contains(text(),'Compose')]")).isDisplayed()) {
			System.out.println("User is in inbox page");
		} else {
			System.out.println("User not in the inbox page");
		}

	}

	@Given("^User should click on compose email\\.$")
	public void user_should_click_on_compose_email() throws Throwable {
		// lt=BaseClass.driver.findElements(By.xpath("//table[@id=':2p']//tr")).size();
		ComposeEmail.compEmail();

	}

	@When("^User should enter valid fields in new message window and Click send\\.$")
	public void user_should_enter_valid_fields_in_new_message_window_and_Click_send() throws Throwable {

		ComposeEmail.sendEmail("karthiksitsme@gmail.com", sbj, bdy);
		Thread.sleep(8000);

	}

	@Then("^User should verify email in inbox\\.$")
	public void user_should_verify_email_in_inbox() throws Throwable {
		BaseClass.driver.navigate().refresh();
		Thread.sleep(5000);

		if (ElementUtils.findObjects(By.xpath("(//span[text()='"+sbj+"'])[2]")).isDisplayed()) {
			System.out.println("EMail Received");

		}
		else
		{
			System.out.println("Email Not Received");
		}
	}

	@When("^Logout and Close Browser$")
	public void logout_and_Close_Browser() throws Throwable {
	    ComposeEmail.logOut();
	    BrowserUtils.closeBrowser();
	}
	
	

	@When("^Select Email and Delete$")
	public void select_Email_and_Delete() throws Throwable {
		ComposeEmail.deleteEmail(sbj);
	    
	}

	@Then("^Check Email should be deleted$")
	public void check_Email_should_be_deleted() throws Throwable {
	   
	}

}
