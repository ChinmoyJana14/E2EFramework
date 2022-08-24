package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	private By searchBox = By.name("query");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement SearchBox() {
		return driver.findElement(searchBox);
	}

}
