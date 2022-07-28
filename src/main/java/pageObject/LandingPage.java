package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class LandingPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LandingPage(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait = wait;
	}

	private By login = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//div[@class='container']//div[@class='text-center']/child::h2");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public LoginPage Login() {
		
		driver.findElement(login).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
}
