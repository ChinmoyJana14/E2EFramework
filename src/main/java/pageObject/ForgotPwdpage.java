package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPwdpage {
	WebDriver driver;
	
	private By email = By.cssSelector("#user_email");
	private By sendIns = By.cssSelector("input[value='Send Me Instruction']");
	
	 ForgotPwdpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement Email() {
		return driver.findElement(email);
	}
	
	public WebElement SendMeIns() {
		return driver.findElement(sendIns);
	}

}
