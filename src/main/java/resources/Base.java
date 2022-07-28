package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Base {
	
	public WebDriver driver;
	public Properties property;
	
	public WebDriver InitializeDriver() throws Exception {
		FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator +"src\\main\\java\\resources\\data.properties");
		property = new Properties();
		property.load(inputStream);
		
		String browserName = property.getProperty("browser");
		//String browserName = System.getProperty("browser");//maven to read property so that we can run from cmd
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "E:\\Software\\Grid\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.contains("chrome")){
			System.setProperty("webdriver.chrome.driver","E:\\Software\\Grid\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}			
			driver = new ChromeDriver(options);
		}
				else if(browserName.equalsIgnoreCase("Edge")){
					System.setProperty("webdriver.edge.driver","E:\\Software\\Grid\\msedgedriver.exe");
					driver = new EdgeDriver();
				}
		else{
			
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+ File.separator +"screenshot" + File.separator + testCaseName +".png";
		FileUtils.copyFile(scrFile, new File(destinationPath));
		return destinationPath;
	}

}
