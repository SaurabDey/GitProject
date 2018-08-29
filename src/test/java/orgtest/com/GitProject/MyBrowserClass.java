package orgtest.com.GitProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyBrowserClass 
{
	WebDriver driver;
	ExtentTest test ;
	ExtentReports extent;
	@BeforeTest
	public void bt()
	{
		//-----ExtentHtmlReporter class
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("SaurabGitJenkins.html");
		htmlReporter.setAppendExisting(true);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Saurab - ExtentReports");
		htmlReporter.config().setTheme(Theme.DARK);
		
		//----extent reports class
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		//----extent test class
		test= extent.createTest("MyFirstTest");
		
		test.pass("Automation Started");
		test.log(Status.PASS, "Automation Started");
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		test.pass("Browser Started");
		
		driver.get("https://www.facebook.com");
		test.pass("URL launched successfully");
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		test.pass("We are in the Login Page");
	}
	
	@Test
	public void t()
	{
		try{
		test.pass("Login Started");
		FacebookLoginPage log= new FacebookLoginPage(driver,test);
		log.loginMethod();
		test.pass("Login successfully complted");
		}
		catch(Exception e)
		{
		test.fail("Something went wrong with FacebookLoginPage "+ e);
		}
//		FaceBookDashboardPage po= new FaceBookDashboardPage(driver);
//		po.postMethd();
	}
	
	@AfterTest
	public void at()
	{
		driver.quit();
		test.pass("End of execution");
		extent.flush();
	}
}
