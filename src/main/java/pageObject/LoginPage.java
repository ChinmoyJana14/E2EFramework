package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	private By emailAddress = By.cssSelector("#user_email");
	private By password = By.cssSelector("#user_password");
	private By logInButton = By.cssSelector("input[value='Log In']");
	private By forgotpassword = By.cssSelector("a[href*='password']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement EmailField() {
		return driver.findElement(emailAddress);
	}
	
	public WebElement PasswordField() {
		return driver.findElement(password);
	}
	
	public WebElement LogInButton() {
		return driver.findElement(logInButton);
	}
	
	public ForgotPwdpage ForgotPassword() {
		driver.findElement(forgotpassword).click();
		return new ForgotPwdpage(driver);
	}

}
