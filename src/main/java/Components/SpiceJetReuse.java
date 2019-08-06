package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Util.BrowserUtils.*;

import cucumbertests.BaseClass;

import static Util.ElementUtils.*;
import static cucumbertests.BaseClass.*;
import java.util.List;
import java.util.Set;

public class SpiceJetReuse {
	public static By lstEleme = By.xpath("//div[@id='traveller-home']/child::div//a[1]/span[1]");
	public static List<WebElement> elmn;
	public static By clsGst = By.id("GSTClose");

	public static List<WebElement> openFeatures() throws InterruptedException {
		String s = driver.getWindowHandle();
		System.out.println(s);
		elmn = findSimilar(lstEleme);
		int i = 0;
		for (WebElement ftr : elmn) {

			if (ftr.getText().contains("GST Invoice")) {
				ftr.click();
				findObjects(clsGst).click();

			} else if (ftr.getText().contains("Corporate Traveller")) {
				continue;
			} else {
				ftr.click();

			}
			driver.switchTo().window(s);
			Thread.sleep(9000);
			// driver.navigate().refresh();
		}

		return elmn;
	}
}
