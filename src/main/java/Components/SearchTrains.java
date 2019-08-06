package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static Util.ElementUtils.*;
import com.sun.beans.finder.FieldFinder;

import cucumbertests.BaseClass;

public class SearchTrains 
{
	public static By fmLcn=By.xpath("//input[contains(@placeholder,'from station')]");
	public static By toLcn=By.xpath("//input[contains(@placeholder,'to station')]");
	public static By goBtn=By.id("SrhDiv");
	public static void srchTrains(String frm,String to)
	{
		findObjects(fmLcn).sendKeys(frm);
		new Actions(BaseClass.driver).sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER)).build().perform();
		findObjects(toLcn).sendKeys(to);
		new Actions(BaseClass.driver).sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER)).build().perform();
		findObjects(goBtn).click();
		
	}
	
}
