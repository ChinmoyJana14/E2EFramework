package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import pageObject.HomePage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class StepDefination extends Base {
	
	public WebDriverWait wait;
	LandingPage l;
	LoginPage lp;
	HomePage hp;

	@Given("Initialize browser with chrome")
	public void initialize_browser_with_chrome() throws Exception {
		driver = InitializeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));	}

	@Given("Navigate to {string} site")
	public void navigate_to_site(String url) {
		driver.get(property.getProperty(url));
		driver.manage().window().maximize();
	}

	@Given("Click on login in home page")
	public void click_on_login_in_home_page() {
		l = new LandingPage(driver,wait);
		if(l.getNoOfPopup()>0)
		{
			l.getPopup().click();
		}
		lp =l.Login();
	}

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		lp.EmailField().sendKeys(username);
		lp.PasswordField().sendKeys(password);
		Thread.sleep(2000);
		//lp.LogInButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(lp.LogInButton())).click();
	}

	@Then("Verify users is successfully logged in")
	public void verify_users_is_successfully_logged_in() {
		hp =new HomePage(driver);
		Assert.assertTrue(hp.SearchBox().isDisplayed());
	}
	
    @And("^close browser$")
    public void close_browser() throws Throwable {
        driver.close();
    }
}