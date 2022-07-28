package Framework.E2EframeWork;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class ValidateNavBarTest extends Base{
	
	public WebDriver driver;
	public WebDriverWait wait;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage l;
	
	@BeforeTest
	public void Initialize() throws Exception {
		driver = InitializeDriver();
		driver.get(property.getProperty("url"));
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void ValidatePageNavBar() throws Exception {

		l= new LandingPage(driver,wait);		
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Successfully Validated Navigation Existence Text");
	}
	
	@Test
	public void ValidateTest2() {		
		l= new LandingPage(driver,wait);		
		log.info("Successfully Validated ...");
	}
	
	
	@AfterTest
	public void TearDown() {
		driver.quit();
		log.info("Browser Clossing");
	}
		

}
