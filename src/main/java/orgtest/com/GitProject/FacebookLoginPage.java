package orgtest.com.GitProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FacebookLoginPage {

	WebDriver driver;

	@FindBy(how=How.ID, using= "email")
	WebElement userName;

	@FindBy(id = "pass")
	WebElement passWord;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	public void loginMethod() {

		userName.sendKeys("Saurab@gmail.com");

		passWord.sendKeys("12345");

		loginButton.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/login.php?login_attempt=1&lwv=110");
	}

}
