package Framework.E2EframeWork;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPwdpage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePageTest extends Base{
	
	public WebDriver driver;
	public WebDriverWait wait;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage l;
	LoginPage lp;
	ForgotPwdpage fp;
	
	@BeforeTest
	public void Initialize() throws Exception {
		driver = InitializeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test(dataProvider="getData")
	public void LogInTry(String UserName, String Password, String msg) throws Exception {
		driver.get(property.getProperty("url"));
		//Accessing diff class method by creating object or inheritance i.e extends
		l = new LandingPage(driver,wait);
		lp =l.Login();//reducing the no of object creation in test as this action will land to new page
		lp.EmailField().sendKeys(UserName);
		lp.PasswordField().sendKeys(Password);
		lp.LogInButton().click();
		fp = lp.ForgotPassword();//Returing new object in the pagObject class itself for making test less heavy
		fp.Email().sendKeys("ivalidemail@test.com");
		fp.SendMeIns().click();
		log.info(msg);
	}
	
	@Test
	public void LogInTryTest2(){
		l = new LandingPage(driver,wait);
		log.info("This LogInTryTest2");
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
		log.info("Browser Clossing");
	}
	
	@DataProvider
	 public Object[][] getData() {
		//Row stand for no of cycles one test will run
		//column stand for how many total values for each test
		Object[][] data = new Object[2][3]; 
		
		data[0][0]="test@gmail.com";
		data[0][1]="testPwd";
		data[0][2]="Bad User";
		
		data[1][0]="test2@gmail.com";
		data[1][1]="testPwd2";
		data[1][2]="Bad User 2";
		
		return data;
	}

}
