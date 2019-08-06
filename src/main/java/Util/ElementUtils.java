package Util;
import static cucumbertests.BaseClass.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
public class ElementUtils 
{
	public static WebElement element;
	public static List<WebElement> elmnts;
	public static WebElement findObjects(By locator) 
	{
		exit : for(int i=0;i<5;i++)
		{
			try
			{
				element=driver.findElement(locator);
				break exit;
				
			}
			catch(StaleElementReferenceException exc)
			{
				driver.navigate().refresh();
			}
			catch(Exception e)
			{
				try
				{
				Thread.sleep(10000);
				}
				catch(InterruptedException msg)
				{
					
				}
			}
		}
		return element;
		
	}
	
	public static List<WebElement> findSimilar(By locators)
	{
		exit : for(int i=0;i<5;i++)
		{
			try
			{
				elmnts=driver.findElements(locators);
				break exit;
				
			}
			catch(StaleElementReferenceException exc)
			{
				driver.navigate().refresh();
			}
			catch(Exception e)
			{
				try
				{
				Thread.sleep(5000);
				}
				catch(InterruptedException msg)
				{
					
				}
			}
		}
		return elmnts;
		
	}
}
