package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Components.Trains;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumbertests.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Trains_Steps {

	WebDriver driver = BaseClass.driver;

	@Given("^User should launch Browser$")
	public void user_should_launch_Browser() throws Throwable {
		WebDriverManager.chromedriver().version("75.0").setup();
		driver=new ChromeDriver();
	   
	}

	@When("^User should invoke application$")
	public void user_should_invoke_application() throws Throwable {
		driver.get("https://www.cleartrip.com/");

	}

	@Then("^User should navigate to train page\\.$")
	public void user_should_navigate_to_train_page() throws Throwable {
		driver.findElement(By.xpath("//span[contains(text(),'Trains')]")).click();

	}

	@Given("^User should be in trains page$")
	public void user_should_be_in_trains_page() throws Throwable {
		if(driver.findElement(By.xpath("//h1[contains(text(),'Search trains')]")).isDisplayed())
		{
			System.out.println("User is in train page");
		}
		else
		{
			System.out.println("User not in the train page");
		}

	}

	@When("^User should enter valid fields in trains page and submit\\.$")
	public void user_should_enter_valid_fields_in_trains_page_and_submit() throws Throwable {
		Trains.setFromLoc();
		

	}

	

	@Then("^User should be in login popup\\.$")
	public void user_should_be_in_login_popup() throws Throwable {
		System.out.println("login popup");

	}

}
