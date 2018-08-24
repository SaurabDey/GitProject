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
		WebElement username= driver.findElement(By.id("email"));
		username.sendKeys("Saurab@gmail.com");
		WebElement password= driver.findElement(By.id("pass"));
		password.sendKeys("12345");
		WebElement loginBtn= driver.findElement(By.xpath("//input[@type='submit']"));
		loginBtn.click();;
		
		System.out.println("Chandus Chnages");
	}
	
	@AfterTest
	public void at()
	{
		driver.quit();
	}
}
