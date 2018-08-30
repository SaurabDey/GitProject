package orgtest.com.GitProject;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginClass {

	WebDriver driver;
	XSSFWorkbook excel;
	XSSFSheet sheet;
	
	public LoginClass(WebDriver driver, XSSFWorkbook excel, XSSFSheet sheet) {
		this.driver=driver;
		this.excel=excel;
		this.sheet=sheet;
	}

	public void loginM() 
	{
		String usernameFromExcel = sheet.getRow(1).getCell(0).getStringCellValue();

		String passwordFromExcel = sheet.getRow(1).getCell(1).getStringCellValue();

		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys(usernameFromExcel);
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(passwordFromExcel);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		loginBtn.click();
		
	}

}
