package Framework.E2EframeWork;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObject.LandingPage;
import resources.Base;

public class ValidateTitleTest extends Base{
	
	public WebDriver driver;
	public WebDriverWait wait;
	JavascriptExecutor j;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage l;
	
	@BeforeTest
	public void Initialize() throws Exception {
		driver = InitializeDriver();
		log.info("Driver is initilized");
		driver.get(property.getProperty("url"));
		log.info("Navigated to HomePage");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void ValidatePageTitle() throws Exception {
		//Accessing diff class method by creating object or inheritance i.e extends
		 l= new LandingPage(driver,wait);	
		wait.until(ExpectedConditions.visibilityOf(l.getTitle()));
		j = (JavascriptExecutor) driver;
		j.executeScript("window.stop();");
		Assert.assertTrue(l.getTitle().getText().equalsIgnoreCase("Featured Courses 1"));
		log.info("Successfully Validated Text");
	}
	
	@Test
	public void ValidateTest2() {
		l= new LandingPage(driver,wait);	
		log.info("Successfully Validated Text");
	}
	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		driver.quit();
		log.info("Browser Clossing");
	}
		

}
