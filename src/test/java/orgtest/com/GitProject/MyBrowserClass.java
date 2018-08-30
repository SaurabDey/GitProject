package orgtest.com.GitProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	XSSFWorkbook excel;
	FileInputStream fis;
	File f;
	XSSFSheet sheet;
	@BeforeTest
	public void bt() throws IOException
	{
		f= new File("Resource/Book1.xlsx");
		fis= new FileInputStream(f);
		
		excel= new XSSFWorkbook(fis);
		sheet= excel.getSheet("Sheet1");
		
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}
	
	@Test
	public void t() throws IOException
	{
		
		int colunms=sheet.getRow(0).getPhysicalNumberOfCells();
		
		int rows= sheet.getPhysicalNumberOfRows();
		
		System.out.println(colunms);
		System.out.println(rows);
		
		
		String usernameFromExcel = sheet.getRow(1).getCell(0).getStringCellValue();

		String passwordFromExcel = sheet.getRow(1).getCell(1).getStringCellValue();

		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys(usernameFromExcel);
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(passwordFromExcel);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		loginBtn.click();
		
		sheet.getRow(1).createCell(3).setCellValue("Pass");
		
		
		
	}
	
	@AfterTest
	public void at() throws IOException
	{
		FileOutputStream fos= new FileOutputStream(f);
		excel.write(fos);
		excel.close();
		fos.close();
		fis.close();
		driver.quit();
	}
}
