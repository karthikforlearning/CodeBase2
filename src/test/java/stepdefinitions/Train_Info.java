package stepdefinitions;

import Util.BrowserUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static Util.ElementUtils.*;

import org.openqa.selenium.By;

import Components.SearchTrains;

public class Train_Info {

	@Given("^User should launch Any Browser$")
	public void user_should_launch_Any_Browser() throws Throwable {

		BrowserUtils.launchBrowser();
	}

	@When("^User should invoke indian rail info application$")
	public void user_should_invoke_indian_rail_info_application() throws Throwable {
		BrowserUtils.navigateApp("https://indiarailinfo.com/");

	}

	@Then("^User should be in IndianRail Info page\\.$")
	public void user_should_be_in_IndianRail_Info_page() throws Throwable {
		if (findObjects(By.id("SrhDiv")).isDisplayed()) {
			System.out.println("Indian Rail Info home page is displayed");
		} else {
			System.out.println("User not in the home page");
		}

	}

	@When("^User should select \"([^\"]*)\" and \"([^\"]*)\" station and click on Go\\.$")
	public void user_should_select_and_station_and_click_on_Go(String frm, String to) throws Throwable {
		SearchTrains.srchTrains(frm, to);
	}

	@Then("^Check the list of details displayed or not\\.$")
	public void check_the_list_of_details_displayed_or_not() throws Throwable {
		if (findObjects(By.xpath("//a[text()='Return']//following::div[2]")).getText().length() != 0) {
			System.out.println("List of trains displayed");
		} else {
			System.out.println("List of trains not displayed");
		}
	}

}
