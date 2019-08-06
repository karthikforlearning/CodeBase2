package Components;

import static Util.ElementUtils.findObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import Util.BrowserUtils;
import cucumbertests.BaseClass;

public class ComposeEmail {
	public static By cmpBtn = By.xpath("//div[contains(text(),'Compose')]");
	public static By toAddr = By.xpath("//div[contains(text(),'Recipients')]");
	public static By toAd=By.xpath("(//span[text()='To']//following::textarea)[1]");
	//public static By sbj = By.id(":77");
	public static By sbjt=By.xpath("//input[@name='subjectbox']");
	public static By bdy = By.xpath("//div[contains(@aria-label,'Message Body')]");
	public static By snd = By.xpath("(//div[contains(text(),'Send')])[2]");
	public static By lgt=By.xpath("//a[contains(@aria-label,'@gmail.com')]");
	public static By sgnOut=By.xpath("//a[text()='Sign out']");
	public static By dlt=By.xpath("//div[@aria-label='Delete']");
	
	public static void compEmail() {
		findObjects(cmpBtn).click();

	}

	public static void sendEmail(String ml,String sbjct,String bddy) throws InterruptedException {
		//findObjects(toAddr).click();
		Thread.sleep(5000);
		findObjects(toAd).sendKeys(ml);
		new Actions(BaseClass.driver).sendKeys(Keys.TAB).perform();
		findObjects(sbjt).click();
		findObjects(sbjt).sendKeys(sbjct);
		findObjects(bdy).sendKeys(bddy);
		findObjects(snd).click();
		
	}
	
	public static void deleteEmail(String sjj)
	{
		findObjects(By.xpath("(//span[text()='"+sjj+"'])[2]//preceding::tr[1]//td[2]/div[1]")).click();
		findObjects(dlt).click();
		
	}
	public static void logOut()
	{
		findObjects(lgt).click();
		findObjects(sgnOut).click();
	}
}
