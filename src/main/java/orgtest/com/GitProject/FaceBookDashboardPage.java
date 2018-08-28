package orgtest.com.GitProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookDashboardPage 
{

	WebDriver driver;
	
	@FindBy (id="post")
	WebElement post;
	
	//By locator_Post= By.id("post");
	
	public FaceBookDashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void postMethd()
	{
		post.sendKeys("I had a great day");
	}
}
