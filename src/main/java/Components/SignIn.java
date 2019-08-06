package Components;

import org.openqa.selenium.By;
import static Util.ElementUtils.*;

public class SignIn 
{
	public static By uname=By.id("identifierId");
	public static By nxt=By.xpath("//span[contains(text(),'Next')]");
	public static By pwd=By.xpath("//input[@name='password']");
	
	public static void enterValidCred(String ume,String pd)
	{
		findObjects(uname).sendKeys(ume);
		findObjects(nxt).click();
		findObjects(pwd).sendKeys(pd);
		findObjects(nxt).click();
	}
	
}
