package Util;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static cucumbertests.BaseClass.*;

public class BrowserUtils
{
	

	public static void launchBrowser() {
		WebDriverManager.chromedriver().version("75.0").setup();
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
	}

	public static void navigateApp(String url) {
		driver.get(url);
		
	}
	public static void closeBrowser()
	{
		driver.quit();
	}
	
}
