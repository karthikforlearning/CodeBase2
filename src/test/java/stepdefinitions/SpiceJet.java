package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static cucumbertests.BaseClass.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Components.SpiceJetReuse;
import Util.BrowserUtils;
import Util.ElementUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumbertests.BaseClass;

public class SpiceJet {
	
	public static List<WebElement> ftrWindow;

	@Given("^User should open Browser$")

	public void user_should_open_Browser() throws Throwable {
		BrowserUtils.launchBrowser();
	}

	@When("^User should invoke spice jet application$")
	public void user_should_invoke_spice_jet_application() throws Throwable {
		BrowserUtils.navigateApp("https://www.spicejet.com");
	}

	@Given("^User should be in Spice Jet Home page\\.$")
	public void user_should_be_in_Spice_Jet_Home_page() throws Throwable {
		if (ElementUtils.findObjects(By.xpath("//a[@title='SpiceJet']")).isDisplayed()) {
			System.out.println("Spice Jet home page is displayed");
		} else {
			System.out.println("Spice Jet home page is not displayed");
		}
	}

	@When("^Open all the features and Count Number of Windows$")
	public void open_all_the_features_and_Count_Number_of_Windows() throws Throwable {
		if (BaseClass.driver.findElements(By.xpath("//div[@id='traveller-home']/child::div")).size() != 0) {
			System.out.println("Total Number of features are"
					+ BaseClass.driver.findElements(By.xpath("//div[@id='traveller-home']/child::div")).size());
		} else {
			System.out.println("Total Number Features are not displayed as expected.");
		}
		
		ftrWindow=SpiceJetReuse.openFeatures();
		Set<String> hndles=BaseClass.driver.getWindowHandles();
		ArrayList wnd=new ArrayList(hndles);
		for(int i=0;i<wnd.size();i++)
		{
			driver.switchTo().window(wnd.get(i).toString());
			if(driver.getTitle().contains("Small & Medium Enterprise"))
			{
				System.out.println("Small and Medium window opened");
			}
			else
			{
				driver.close();
			}
		}
	}

	@Then("^Close all the Windows except SME Window$")
	public void close_all_the_Windows_except_SME_Window() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
