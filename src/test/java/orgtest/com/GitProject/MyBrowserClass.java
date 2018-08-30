package orgtest.com.GitProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public void bt() throws IOException
	{
		File f= new File("Resource/Book1.xlsx");
		FileInputStream fis= new FileInputStream(f);
		
		XSSFWorkbook excel= new XSSFWorkbook(fis);
		XSSFSheet sheet= excel.getSheet("Sheet1");
		
		String usernameFromExcel=sheet.getRow(1).getCell(0).getStringCellValue();
		
		String passwordFromExcel=sheet.getRow(1).getCell(1).getStringCellValue();
		
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
		
	}
	
	@AfterTest
	public void at()
	{
		driver.quit();
	}
}
