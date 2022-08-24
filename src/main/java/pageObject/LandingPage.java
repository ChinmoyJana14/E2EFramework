package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	private By popup = By.xpath("//button[contains(.,'NO THANKS')]");//"//button[text()='NO THANKS']"
	
	public LoginPage Login() {
		
		//driver.findElement(login).click();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(login))).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(login));
		LoginPage lp = new LoginPage(driver, wait);
		return lp;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup);
	}
	
	public int getNoOfPopup() {
		return driver.findElements(popup).size();
	}
}
