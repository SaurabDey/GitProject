package orgtest.com.GitProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyBrowserClass 
{
	WebDriver driver;
	@BeforeTest
	public void bt()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}
	
	@Test
	public void t()
	{
		FacebookLoginPage log= new FacebookLoginPage(driver);
		log.loginMethod();
		
//		FaceBookDashboardPage po= new FaceBookDashboardPage(driver);
//		po.postMethd();
	}
	
	@AfterTest
	public void at()
	{
		driver.quit();
	}
}
