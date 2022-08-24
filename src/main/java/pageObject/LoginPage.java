package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	private By emailAddress = By.cssSelector("#email");
	private By password = By.cssSelector("#password");
	private By logInButton = By.cssSelector("input[value='Log in']");
	private By forgotpassword = By.cssSelector("a[href*='password']");
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}


	public WebElement EmailField() {
		return driver.findElement(emailAddress);
	}
	
	public WebElement PasswordField() {
		return driver.findElement(password);
	}
	
	public WebElement LogInButton() {
		//return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(logInButton))).click();
		return driver.findElement(logInButton);
	}
	
	public ForgotPwdpage ForgotPassword() {
		driver.findElement(forgotpassword).click();
		return new ForgotPwdpage(driver);
	}

}
