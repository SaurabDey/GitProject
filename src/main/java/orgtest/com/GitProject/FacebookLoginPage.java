package orgtest.com.GitProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

public class FacebookLoginPage {

	WebDriver driver;
	 ExtentTest test;
	@FindBy(how=How.ID, using= "email")
	WebElement userName;

	@FindBy(id = "pass")
	WebElement passWord;

	@FindBy(xpath = "//input[@type='submi']")
	WebElement loginButton;

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}

	public FacebookLoginPage(WebDriver driver, ExtentTest test) {
		
        this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	public void loginMethod() {

		try {
			userName.sendKeys("Saurab@gmail.com");
			test.pass("Entered userName in Login Page");
			
			passWord.sendKeys("12345");
			test.pass("Entered password in Login Page");

			loginButton.click();
			test.pass("Clicked login button in Login Page");
			
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/login.php?login_attempt=1&lwv=110");
		} catch (Exception e) {
			
			try {
				test.fail("LoginMethod failed in Login Page").addScreenCaptureFromPath(screenshot("screenshot1.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			MediaEntityModelProvider mediaModel;
			try {
				mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshot("screenshot2.png")).build();
				test.fail("LoginMethod failed in Login Page using MediaEntityModelProvider", mediaModel);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		
		}
		
	}

	
	public String screenshot(String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\Screens\\"+screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;        
	}
}
