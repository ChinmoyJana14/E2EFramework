# E2EFramework
# Quick Pro Tips
////////////////////////////**********************Selenium - Java Questions*************************************
1. Diff between JVM, JDK & JRE?
JVM :
The Java Virtual Machine (JVM) is the virtual machine that run the Java bytecodes. 
The JVM doesn't understand Java source code, that's why you compile your *.java files to obtain *.class files that contain the bytecodes understandable by the JVM
JDK:  develop and execute(run) the Java program
JRE:an environment to only run(not develop) the java program(or application)onto your machine

2. WebDriver is an Interface - ChromeDriver/FirefoxDriver are the implemented classes of the Interface.
 If we use ChromeDriver ref variable this will not work for other browser specific methods


3. driver.quit -> close all instances of the browser
	driver.close -> close current instance of the browser
	
4. Arraylist - for dynamic array

5.  String a = "abcd"; 
	String b = "abcd";//Same reference
		a == b; //True

	String a = new String("abcd");//New Object
	String b = new String("abcd");//New Object
		a == b; // False

6. 	//Print reverse order	
		String s = "a b c d";
		for(int i=s.length()-1; i>=0; i--) {
			System.out.println(s.charAt(i));
		}


7. Locators: 
	Sequence for preferences: ID->Name->LinkText->Partial LinkText->TagName->ClassName->CSSSelector->XPath
	Xpath        //Custom -> Slowest as it traverse the dom objects
		
	CSS Selector //Custom - 	
		CSS Selectors help to identify the elements. And it's comparatively faster in locating elements on a webpage than XPath especially in IE browsers.
		CSS is considered to be the next best option to locate elements if unique id or name is not available.
		Xpath allows bidirectional flow which means the traversal can be both ways from parent to child and child to parent as well. 
			Css allows only one directional flow which means the traversal is from parent to child only.
		TagName : Tagname of the particular node.(Input)
		# : Hash sign is used to symbolize ID attribute. It is mandatory to use the hash sign for ID attribute in CSS Selectors.
		CSS = <TagName> # <value of ID Attribute> <[AttributeName = Value of attribute]>
		. : The dot sign is used to symbolize Class attribute. It is mandatory to use dot sign for the Class attribute in CSS Selectors.
		CSS = <TagName> . <value of Class Attribute> <[AttributeName = Value of attribute]>
		CSS = <TagName> <. or #> <value of Class or ID Attribute> <[AttributeName = Value of attribute]>
			Attribute Name : Attribute name of the node. ( id, value, name, type, src, and alt )
			Attribute Value : Value of the attribute. (login_id, text_value, username, login_button and SignUp_button.)
		Note: We will not use (/,//,@) in CSS Selectors. As / will be replaced as > and // will be replaced as whitespace
		CSS Classname - We can also pull the class tag by using (by.className).
			<input id="User" name="admin" class="required" type="text">
				//WebElement CheckElements = driver.findElements(By.className("required"));
		CSS Class – Here we need to replace (Class with **. *).
			**<input id="User" name="admin" class="required" type="text">
				//WebElement CheckElements = driver.findElements(By.cssSelector(".required"));
		We can also locate elements using CSS Selectors by performing partial matching on attribute values as follows:
		Match a prefix – ^ as in input[id^='email'] retrieves element whose id begins with text email.
		Match a suffix – $ as in input[id$='email'] retrieves element whose id ends with text email.
		Match a sub string - * as in input[id*='email'] retrieves element whose id contains text "email".
			<input class="email" id="userEmailname" type="text"/>
		//webdriver.findElement(By.cssSelector("input[id^='use']"));
		//webdriver.findElement(By.cssSelector("input[id$='name']"));
		//webdriver.findElement(By.cssSelector("input[id*='mail']"));

						//driver.findElement(By.cssSelector("input[placeholder='Email']:nth-child(2)")); for parent child it uses space unlike xpath which uses 
						//driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
						//driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
						
			HTML: <a href="https://courses.rahulshettyacademy.com/sign_in" class="theme-btn register-btn"><span class="icon fa fa-lock"></span>Login</a>
			Code: driver.findElement(By.cssSelector("a.theme-btn.register-btn[href$='sign_in']")).click();
			
			<input type="email" name="email" id="email" required="" autocomplete="email" class="form-input p-v-1-xs p-l-2-xs p-r-4-xs col-12-xs bodyMain">
			driver.findElement(By.cssSelector("input[type='email']")).sendKeys("sanujana8@gmail.com");
			
			<div class="bodySmall m-b-3-xs text-center-xs auth-flash-error" style="" css="1"></div>
			String error = driver.findElement(By.cssSelector("div[class$='flash-error']")).getText();
			
			multiple attribute cssSelector
			a[href*='https://files.small'][rel='noopener noreferrer']
			
			<ul>
				<li>Firefox</li>
				<li>Google Chrome</li>
				<li>Internet Explorer</li>
				<li>Opera</li>
				<li>Safari</li>
			</ul>		
			"ul->li:nth-of-type(4)" -> cssSelector for Opera
			
	name 
	Class Name 
	Tag Name 
	Link Text 
	Partial Link Text 
	Examples:
		Absolute XPath - It will be in long, and you can see HTML DOM Structure which will be followed by single (/).
			/html/body/div/selection/div[2]/div/div/input[1]
		Relative XPath – It will be short, and it will start in the middle of the HTML DOM Structure which will be followed by double (//).
			//input[@value='Google Search']
		WebElement locateByID = driver.findElement(By.id("coursename"));
		WebElement locateByName = driver.findElement(By.name("coursetitle"));
		WebElement findByClassAttribute = driver.findElement(By.className("email"));
		WebElement findByFullText = driver.findElement(By.linkText("Google_HomePage"));
		WebElement findByPartialText = driver.findElement(By.PartialLinkText("Google"));
		By text: button[text()='Log Out'] or *[text()='Log Out']
				button[contains(@text,'PROCEED TO CHECKOUT')]  if Text is an attribute of the HTML
				button[contains(text(),'PROCEED TO CHECKOUT')]

		By Following axis: //input[@id='course']/following::* will identify the element following the node represented by input id "course".
							//header/dev/button[1]/following-sibling::button[1]
		By Parent axis: //input[@id='course']/parent::* will identify the parent node of element represented by input id "course".
							//header/dev/button[1]/parent::div/parent::header
		
		webdriver.findElement(By.xpath("input[starts-with(@id,'user')]")); //Reg Exppression
		webdriver.findElement(By.xpath("input[ends-with(@id,'name)']")); //Reg Exppression
		webdriver.findElement(By.xpath("input[contains(@id,'mail')]")); //Reg Exppression
				By Contains: //button[contains(@class='submit')]
		
		
8. 	implicit wait - applicable for all objects
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Pros: Simple one liner code
		Why Bad?
			1. The time is applicable for all cases throughout the driver instance, so we have to declare max wait of all cases.
				Now if others decrease performance but below max time- test can't catch it
			2. If there are glitches, it will wait for No of glictches * max wait time
	Explicit wait - For specific element - implementing Wait Interface
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elem;
		elem= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		elem.click();
	Thread.sleep - It is a static wait, and it is not a good practice to use it in scripts as it waits without any condition.
		1. Where there is an UPDATE will happen in the page by some prev actions and will take some time to reflect as there are some backend operation
		2. reCAPTCHA -> Selenium is fast, need to wait so that browser understand it's not a software handling the browser
		Thread.Sleep(1000); 
		// 1000 = 1 second.
	Fluent Wait - It is the maximum wait as for condition, and the frequency checks the existence of the object of the condition. -implementing Wait Interface
		Frequency: Let's say we keep 10 seconds for an element to be available on the page, but it will check its availability once in every 5 seconds.	
		The timeout of 10 seconds and frequency is 5 seconds by ignoring "NoSuchElementException" throws.
		 
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)						
				.withTimeout(Duration.ofSeconds(10)) 			
				.pollingEvery(Duration.ofSeconds(5)) 			
				.ignoring(NoSuchElementException.class);
				
				WebElement elem = wait.until(new Function<WebDriver, WebElement>() {

										@Override
										public WebElement apply(WebDriver driver) {
											if(driver.findElement(By.cssSelector("")).isDisplayed())
											{
												return driver.findElement(By.cssSelector(""));
											} else
											{
											   return null;
											}
										}
									});
				System.out.println(driver.findElement(By.cssSelector("")).getText());
		A function can also be used to return objects instead of a Boolean value, but A predicate is similar to a function but it always returns a Boolean expression
		
9. ElementClickInterceptedExeption: Element is there but in changing state withing same webpage
	Thread.sleep(2000);  // To be stable
		
9.  mouse hover on a web element
	// Instantiating Action Interface 
	Actions actions=new Actions(driver);
	// howering on the dropdown
	actions.moveToElement(driver.findElement(By.id("id of the dropdown"))).perform();
	// Clicking on one of the items in the list options
	WebElement subLinkOption=driver.findElement(By.id("id of the sub link"));
	subLinkOption.click();

10. Same origin policy?--RC

11. How to select value in a dropdown?  Select class ref variable
		import org.openqa.selenium.support.ui.Select;
		Select s= new Select(driver.findElement(By.id("element")));			
		s.selectByValue("value");
		s.selectByIndex(5);
		s.selectByVisibleText("VisibleText");	

12. navigation commands? start after basic objects loaded, not all object like driver.get()
		driver.navigate().back();Pressing the browser’s back button:
		navigate().forward() Pressing the browser’s forward button:
		driver.navigate().refresh();
		navigate().to()
		driver.get() : It's used to go to the particular website , But it doesn't maintain the browser History and cookies so , 
					we can't use forward and backward button , if we click on that , page will not get schedule
					get() performs navigating to a webpage and waiting for the page to load(until onload() is finished). That's all.
		driver.navigate() : it's used to go to the particular website , but it maintains the browser history and cookies, 
					so we can use forward and backward button to navigate between the pages during the coding of Testcase
					But the navigate interface exposes the ability to move backwards and forwards in your browser history.
					
13.  How to click on a hyper link using linkText?
	driver.findElement(By.linkText(“Google”)).click();
	driver.findElement(By.partialLinkText(“Goo”)).click();
	
14. How to handle frame in WebDriver?
	driver.switchTo().frame(“ID of the frame“);

16. TestNG - Controlling test cases - TestNG executes methods in alphabetical order,
		@Test annotation followed by method to run the test	
		TestSuite->TestFolder(Module)->TestCases
		testng.xml -> To run selected test cases from the project
						By Commenting out or removing from the xml
						<exclude name="Login42"></exclude> - Exclude this test
						<include name="Login33"></include> - Exclude all except this  	
						<exclude name="Test2.*"></exclude>	- Exclude all started with Test2 from the class
						<package name="test"></package> - Include all from the package of the module
		Annotations -> @BeforeTest execute at first of the module/test
						@AfterTest execute at last of the module/test
						@BeforeSuite and @AfterSuite - Similarly but scope is full suite
						@BeforeMethod and @AfterMethod - Execute for each method but scope is for the class
						@Test(priority=0) - method with priority 0 runs before priority 1
						@Test(groups={"Sanity"}) - Add in all the method // Used to run specific tests from every classes
										<test name="sample test">
										 <groups>
										   <run>
											  <include name ="Sanity"/>
										   <run>
										 </groups>
										</test>
						@Test (priority = 1)
						@Test (dependsOnMethods={"Method Name 1","Method Name 2"}) //
						@Test (enabled = false)//
						@Test (timeOut = 4000)
						@Test(groups= {"Smoke"}, dependsOnMethods={"Test23"})
						
		Parameterization-> Drive common variables to scripts, 
						   Parameterization can be performed at the suite, class, and test level of the testng.xml file
						   @Parameters need to be defined for each @Test method
								<suite name="suiteName">
									<parameter name="URL" value="fresco.me"/>
									<parameter name="UserName" value="Prem"/>
								</suite>
									@Parameters({"URL" , "UserName"})
									@Test
									public void LogIn(String url, String uname){
									System.out.println(url);
									System.out.println(uname);
									}
									
		Dataprovider ->	 By default method name becomes the dataprovider name by default
									@DataProvider (name = "data-provider")
									public Object[][] getData(){
										
										return new Object[][] {{"firstSetUsername", "firstSetUserpassword" }, 
																{"secondSetUsername", "secondSetUserpassword"}};

									}

									@Test (dataProvider = "data-provider")
									public void LogIn(String username, String password)
										{
										System.out.println(username);
										System.out.println(password);
										}
		Listeners ->    TestNG Listeners enable to execute separate blocks of code when a particular action takes place 
						OnStart- OnStart method is called when any Test starts.
						onTestStart - when a test method started
						onTestSuccess- onTestSuccess method is called on the success of any Test.
						onTestFailure- onTestFailure method is called on the failure of any Test.
						onTestSkipped- onTestSkipped method is called on skipped of any Test.
						onTestFailedButWithinSuccessPercentage- method is called each time Test fails but is within success percentage.
						onFinish- onFinish method is called after all Tests are executed.
						Example:On Testfailure, a screenshot script can be written in the failure listeners method	
						@Listeners(<packageName>.<className>.class)  - For one class
						Adding in TestNG.xml for all classes like below
						<suite name="suitename">
							<listeners>
								   <listener class-name="package.className"/> 
							</listeners>
						</suite>
						import org.testng.ITestContext;
						import org.testng.ITestListener;
						import org.testng.ITestResult;
						public class Listeners implements ITestListener{
							@Override		
							public void onTestFailure(ITestResult Result) 					
							{		
								System.out.println("The name of the testcase failed is :"+Result.getName());	
									//TakesScreenshot
							}
						}	
		Reports-> By default after refreshing the project - test-output->index.html/emailable-report.html		
		
		Cross Browser -> There will be different test and also there will be <parameter name="browser" value="Chrome" /> in testng.xml before each test	
						And the code will be like with Parameter Annotations
						@BeforeTest
						@Parameters("browser")
						public void setup(String browser) throws Exception{
							if(browser.equalsIgnoreCase("firefox")){
								System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
								driver = new FirefoxDriver();
							}
							else if(browser.equalsIgnoreCase("chrome")){
								System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
								driver = new ChromeDriver();
							}
									else if(browser.equalsIgnoreCase("Edge")){
										System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
										driver = new EdgeDriver();
									}
							else{
								throw new Exception("Browser is not correct");
							}
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						}
		Parallel Execution-> To execute test cases with different browsers in the same machine at the same time we can integrate Testng framework with Selenium WebDriver.
			<?xml version="1.0" encoding="UTF-8"?>
			<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
			<suite name="TestSuite" thread-count="2" parallel="tests">
			   <test name="ChromeTest">
				  <parameter name="browser" value="Chrome" />
				  <classes>
					 <class name="parallelTest.CrossBrowserScript" />
				  </classes>
			   </test>
			   <test name="FirefoxTest">
				  <parameter name="browser" value="Firefox" />
				  <classes>
					 <class name="parallelTest.CrossBrowserScript" />
				  </classes>
			   </test>
			   <test name="EdgeTest">
				  <parameter name="browser" value="Edge" />
				  <classes>
					 <class name="parallelTest.CrossBrowserScript" />
				  </classes>
			   </test>
			</suite>

		
17. Maven: Build Management Tool
		Benefits
		1. No dependency on managing Jar files
		2. Maintain common project structure
		3. Provides build management tool to integrate in CI tool
		4. Plugins installation
		5. Provide compile error in CI tool
		Installation: Download the apache-maven-<v-no>-bin.zip from https://maven.apache.org/download.cgi and unzipped. 
					  Set MAVEN_HOME variable with maven location and Path variable with bin bolder location in system Variable
					  Eclipse->File->New->Project->Maven Project
					  In Select archetype 
					  select GroupId org.apache.maven.archetypes and ArtifactId maven-archetype-quickstart for Selenium Project
					  Provide GroupId and ArtifactId name
					  OR From Normal Project to Right Click->Configure->Convert to Maven project
		Terminologies:
		GroupId-> Unique Id for identifying each dependency or project name 
		arctifactId->Sub project or Jar name
		verion-> version of that Jar
		Commands
			mvn test - clean, compile follwong by running all tests. Class name should start or end with Test
	Maven Surefire Plug in: used during the test phase of the build lifecycle to execute the unit tests of an application
		To execute test cases from test folder of the maven project
		run mvn test in cmd in the project path to build and run the tests with download dependencies
		Need name the test class appending with Test in the last
		Need to set installed java version in project build path
	TestNG + Maven: To execute specifc testng.xml
			(https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html)
		1. Add configuration node in pom.xml inside surefire-plugin to run from testng.xml else it will run all tcs
				<pluginManagement>
			      <plugins>
			        <plugin>
			          <groupId>org.apache.maven.plugins</groupId>
			          <artifactId>maven-surefire-plugin</artifactId>
			          <version>3.0.0-M5</version>
						<configuration>
				          <suiteXmlFiles>
				            <suiteXmlFile>testng2.xml</suiteXmlFile>
				          </suiteXmlFiles>
				        </configuration>
			        </plugin>
			      </plugins>
			    </pluginManagement>
		2. Go to the pom.xml location in cmd and run the command mvn test
		To run single test-> mvn -Dtest=SeleniumTwoTest test 
		Profile: To manage multiple suite to run via multiple testng.xml -> mvn test -P<Profile_id_Name>

18. Grid: 
		Run in multiple machines from single machine
		Balance the load automatically
		Client->Router->Distributor->Node and store session id/machine ip in Session map
			If same session, Router-> Node
		SetUp: (Hub and Nodes Mode)
			1. Download Selenium Server (Grid)
			2. Place the jar with all the driver in one folder
			3. Start the Hub - which eventually Starts Router, Distributor, Session Map , New Session Queue, Event Bus
				Go to the folder and run the command java -jar <SeleniumJarname> hub
			4. http://192.168.20.23:4444  hub started
			
			5. Open another cmd and
				Start the Node in Same Machine where Hub is running
				java -jar <SeleniumJarname> node --detect-drivers true
			6. Check the added node with capability
			
			7. For different node machines
				Repet step 1 & 2 in the node machine
			8. Browsers needs to be installed
				There are 2 sockets,XPUB and XSUB in two different ports. So need to ping these two ports from the different Node machine
			9. java -jar <SeleniumJarname> node --detect-drivers true -- publish-events tcp://<ipaddressofhub> --subscribe-events tcp:// <ipaddressofhub>
			
			10.Distributor auto choose the Node based on capability and load
						DesiredCapabilities capabilities = new DesiredCapabilities();
						capabilities.setBrowserName("chrome");
						capabilities.setPlatform(Platform.WIN10);
						capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						
						//Hub URL and Run Conditions for the Router
						WebDriver driver = new RemoteWebDriver(new URL("http://192.168.20.23:4444"),capabilities);
						driver.get("http://google.com");

15. Web based PopUp:	accepting javascript alert
        Alert alert = driver.switchTo().alert();
		alert.accept();
		void dismiss() – The dismiss() method clicks on the “Cancel” button as soon as the pop-up window appears.
		void accept() – The accept() method clicks on the “Ok” button as soon as the pop-up window appears.
		String getText() – The getText() method returns the text displayed on the alert box.
		void sendKeys(String stringToSend) – The sendKeys() method enters the specified string pattern into the alert box.
		
19.  Window based pop up?		AutoIT, Robot class
		Window Authentication PopUp:
			append username and password with the url
			https://<username>:<passowrd>@SiteUrl
		File Upload: Auto IT
			Download and install
			open SciTE from the installation loaction -> the editor
			open Au3Info_x64 from the installation location -> spy tool for window objects
			write the script like below
				ControlFocus("Open","","Edit1")
				ControlSetText("Open","","Edit1","C:\Repository\SeleniumJava\AutoIT\Admit Card.pdf")
				ControlClick("Open","","Button1")
			Save the file as .au3
			Right click and compile the file-> generate .exe file
			Runtime.getRuntime().exec("C:\\Repository\\SeleniumJava\\AutoIT\\fileupload.exe");
		File Download: set default download path
					String downloadPath = System.getProperty("user.dir") + File.separator + "target";
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("download.default_directory",downloadPath);      
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", prefs);
							//Click the download button
							File file = new File(downloadPath + File.separator +  "Admit Card-images.zip");
							file.delete();
							wait.until(ExpectedConditions.elementToBeClickable(download)).click();	
							boolean fileFound = false;
							for(int i= 0; i<=10; i++)
							{		
								Thread.sleep(2000);
								if(file.exists())
								{ 
									fileFound = true;
									break;
								}
							}
							if(fileFound)
							{
								System.out.println("File Downloaded");
							}else
							{
								System.out.println("File Not Downloaded");
							}
49. Cookie PopUp
		List<WebElement> cookiePopUps = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[.='Got it']")));
		int NoOfcookiePopUp = cookiePopUps.size();
			if(NoOfcookiePopUp>0)
			{
				driver.findElement(By.xpath("//span[.='Got it']")).click();
			}

20.	Mouse hover: 
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.interactions.Action;
	Actions Class
	// Instantiating Action Interface
	Actions actions=new Actions(driver);
	// howering on the dropdown
	actions.moveToElement(driver.findElement(By.id("id of the dropdown"))).perform();
	
	For multiple action sequences:
		Actions actions=new Actions(driver);
		actions.keyDown(element, Keys.SHIFT).sendKeys("TextToBeConvertAndSendInUpperCase").keyUp(Keys.SHIFT);
		//Now, build this sequence using the build() method of Actions class and get the composite action
		Action action = actions.build();
		//Action Interface - used to perform the actions sequence using perform() method of Action Interface
		action.perform();
	
	// Clicking on one of the items in the list options
	WebElement subLinkOption=driver.findElement(By.id("id of the sub link"));
	subLinkOption.click();
	
	Mouse Actions in Selenium:
		doubleClick(): Performs double click on the element
		clickAndHold(): Performs long click on the mouse without releasing it
		dragAndDrop(): Drags the element from one point and drops to another
		moveToElement(): Shifts the mouse pointer to the center of the element
		contextClick(): Performs right-click on the mouse
		
	Keyboard Actions in Selenium:
		sendKeys(): Sends a series of keys to the element
		keyUp(): Performs key release
		keyDown(): Performs keypress without release
	Refresh	
		sendKeys(Keys.F5)
		driver.navigate().to(driver.getCurrentUrl())
		driver.navigate().refresh()
	
21. How to retrieve CSS properties of an element?
	driver.findElement(By.id(“id“)).getCssValue(“name of css attribute”);
	driver.findElement(By.id(“id“)).getCssValue(“font-size”);

22. How to take screenshot?
		import org.apache.commons.io.FileUtils;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Repository\\SeleniumJava\\google.jpg"));
		
23. Drag n Drop
	WebElement From = driver.findElement(By.xpath(".//*[@id='text1']/"));
	WebElement To = driver.findElement(By.xpath(".//*[@id='textbox2']/"));	 
	Actions builder = new Actions(driver);	 
	Action dragAndDrop = builder.clickAndHold(From)	 
	.moveToElement(To)	 
	.release(To)	 
	.build();	 
	dragAndDrop.perform();
	
24. Hidden Element:
		The hidden elements are the ones which are present in the DOM but not visible on the page.
		Mostly the hidden elements are defined by the CSS property style="display:none;". 
		In case an element is a part of the form tag, it can be hidden by setting the attribute type to the value hidden
		Also for -> ElementClickInterceptedException
	 import org.openqa.selenium.JavascriptExecutor;	
	 // identify element and click
      driver.findElement(By.id("hide-textbox")).click();
      // Javascript executor class with executeScript method
      JavascriptExecutor j = (JavascriptExecutor) driver;
      // identify element and set value
      j.executeScript ("document.getElementById('displayed-text').value='Selenium';");
      String s = (String) j.executeScript("return document.getElementById('displayed-text').value");
      System.out.print("Value entered in hidden field: " +s);
	  
25. pageLoadStrategy:
		When navigating to a new page via URL, by default Selenium will wait until the Document’s Ready State is “complete.” 
		The document.readyState property of a document describes the loading state of the current document.
			Strategy	Ready State			Notes
			normal		complete			Used by default, waits for all resources to download
			eager		interactive			DOM access is ready, but other resources like images may still be loading
			none		Any					Does not block WebDriver at all
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

26. Handling Windows:
		Set<String> windows =  driver.getWindowHandles();
		Iterator<String> it = windows.iterator();		
			String mainWindow = iter.next();
			String childWindow iter.next();
		driver.switchTo().window(childWindow);
		
		driver.get("http://google.com"); // wait untill full page load
		driver.navigate().to("http://google.com"); // start after basic objects loaded

27. Handle Calendar:
		String mon = "Nov 2023";
		String day = "23";
		driver.findElement.By.xpath("xpath of date picker").click();
		WebElement currentMonth = driver.findElement.By.xpath("xpath of current month displayed");
		while(true){
			if (currentMonth.getText().equals(mon)){
				break;
			} else{
				driver.findElement.By.xpath("xpath of next button").click();
			}
		}
		driver.findElement.By.xpath("//[@class='datepicker']/div[1]/table/tbody/tr/td[contains(text(),'" + day + "')]").click();

28. Soft Assert: even if an assertion fails, execution continues
		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(true);
		// Enables to dispaly the failure/error of the assert, in the console. 
		assertion.assertAll();

29. Timeout Configuration
		TestNG allows users to configure a time period to wait for a test to completely execute 
		Test Suite Level 
			public class TimeoutSuite
			{
				@Test
				public void timeTestOne() throws InterruptedException {      //Fails
					Thread.sleep(1000);
					System.out.println("Time test method one");
				}

				@Test
				public void timeTestTwo() throws InterruptedException {      //Passes
					Thread.sleep(400);
					System.out.println("Time test method two");
				}
			}
			<suite name="Time test Suite" time-out="500" verbose="1" >
			  <test name="Timeout Test" >
				<classes>
				  <class name="com.howtodoinjava.test.TimeoutSuite" />
				</classes>
			  </test>
			</suite>
			
		Test Method Level
			public class TimeoutMethod
			{
				@Test(timeOut = 500)
				public void timeTestOne() throws InterruptedException {          //Fails
					Thread.sleep(1000);
					System.out.println("Time test method one");
				}

				@Test(timeOut = 500)
				public void timeTestTwo() throws InterruptedException {
					Thread.sleep(400);
					System.out.println("Time test method two");
				}
			}
				
30. Selenium Framework Types
		Linear Scripting Framework -  Record and Playback 
		Modular Testing Framework - The individual test scripts of small application module are later combined as a larger test script by using a master script
		Keyword driven Testing Framework - 
		Data-driven Testing Framework
		Hybrid Testing Framework
		Behavior-driven Development Framework
23. JavascriptExecutor:
	Scrolling:
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");	
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
	Generate Alert Pop Window
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Js.executeScript("alert('hello world');");
	Click Action
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	Refresh Browser
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.executeScript("history.go(0)");
	Get InnerText of a Webpage
		JavascriptExecutor js = (JavascriptExecutor)driver;
		string sText =  js.executeScript("return document.documentElement.innerText;").toString();
	Get Title of a WebPage
		JavascriptExecutor js = (JavascriptExecutor)driver;
		string sText =  js.executeScript("return document.title;").toString();

24. Data Driven Framework

26. Database connection
		import  java.sql.Connection;		
		import  java.sql.Statement;		
		import  java.sql.ResultSet;		
		import  java.sql.DriverManager;		
		import  java.sql.SQLException;		
		public class  SQLConnector {				
				public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
						//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
						String dbUrl = "jdbc:mysql://localhost:3306/emp";					
						String username = "UserName";							
						String password = "Password";				
						String query = "select *  from employee;";								
						Class.forName("com.mysql.jdbc.Driver");			
						Connection con = DriverManager.getConnection(dbUrl,username,password);	
					    Statement stmt = con.createStatement();						
						ResultSet rs= stmt.executeQuery(query);							
						while (rs.next()){
									String myName = rs.getString(1);								        
									String myAge = rs.getString(2);					                               
									System. out.println(myName+"  "+myAge);		
							}			
						con.close();			
				}
		}

28. Links count in a page
		System.out.println(driver.findElements(By.tagName("a")).size());
29. Limiting Scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

30. Link Check// smart way
				int links = columnFooterDriver.findElements(By.tagName("a")).size();
		System.out.println(links);
		
		for(int i = 1; i<links; i++) {			
			String clickOnTheLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);			
			columnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnTheLinkTab);			
		}
		wait.until(ExpectedConditions.numberOfWindowsToBe(links));
		Set<String> windows = driver.getWindowHandles();//["ParentWindowId","ChildWindowId"]
		Iterator<String> it = windows.iterator();
		it.next();//For parent window	
		  while (it.hasNext()) {
			  		driver.switchTo().window(it.next());
			  		System.out.println("Child Window Title " + driver.getTitle());
	        }
		
31. Chrome Options	https://chromedriver.chromium.org/capabilities
		For 
			setHttpProxy
			addExtensions
			custom profile
			Using a Chrome executable in a non-standard location
			Block pop-up windows
			Set download directory
			setAcceptInsecureCerts(true)

32. Cookie handle
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");// it should navigate to home page after clicking any element
		
			
31. Broken Link Check:
		 List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	      SoftAssert softAssert =new SoftAssert();
	      	for(WebElement link : links)
	      		{
		          String url= link.getAttribute("href");
		          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
		          conn.setRequestMethod("HEAD");
		          conn.connect();
		          int respCode = conn.getResponseCode();
		          System.out.println(respCode);
		          softAssert.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
	       }
	      	softAssert.assertAll();	
********************Selenium 4********************************************	
	import static org.openqa.selenium.support.locators.RelativeLocator.*;
32. Relative Locators: not applicable for flex element
		above()
		below() WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
					driver.findElement(with(By.tagName("input")).below(dob)).click();
		toLeftOf()
		toRightOf() driver.findElement(with(By.tagName("Input")).toRightOf(By.cssSelector("#inlineRadio1"))).click();
		near()

33. 
ple Tab/Window InvokeHandler	
		driver.get("https://rahulshettyacademy.com/angularpractice/");		
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW); //we can use this too
		Set<String> windows = driver.getWindowHandles();//["ParentWindowId","ChildWindowId"]
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();//For parent window
		String childWindow =it.next();//For child window
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");
		String s = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(s);

34. Partial Screenshot
		WebElement nameBox = driver.findElement(By.cssSelector("input[name='name']"));		
		File scrFile = nameBox.getScreenshotAs(OutputType.FILE);//Partial Screenshot
		FileUtils.copyFile(scrFile, new File("C:\\Repository\\SeleniumJava\\SeleniumTextScreenshot.jpg"));
		
35. Height & Width
		getRect().getHeight()
		getRect().getWidth()
		getRect().getDimension()
		getRect().getDimension().getHeight()
********************END of Selenum 4*****************************			
		
36. Golabl Variable - property file
		FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator +"src\\data.properties");//read the file
		Properties property = new Properties();
		property.load(inputStream);
		System.out.println(property.getProperty("url"));
		//run time update
		property.setProperty("browser", "Firefox");
		//For physical update
		FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+ File.separator +"src\\data.properties");
		property.store(outputStream, null);
		
37. Jenkins
		Download the .war file
		go to the path and run java -jar jenkins.war -httpPort=9090 in cmd
		java -jar jenkins.war -httpPort=9090 --enable-future-java // for java.lang.UnsupportedClassVersionError
		 or 
		Execute the msi file
		
		Manage Jenkins->Global Tool Configuration->Add jdk same like local->Add maven same like local-> save
		New Item->Enter a name-> Freestyle project
		Advance->Use custom workspace->place the project inside JENKINS_HOME dir i.e C:\Users\chinm\.jenkins-> provide the path ${JENKINS_HOME}/MavenJava in Jenkins
		Build Trigger->Build periodically
			MINUTE	Minutes within the hour (0–59)
			HOUR	The hour of the day (0–23)
			DOM	The day of the month (1–31)
			MONTH	The month (1–12)
			DOW	The day of the week (0–7) where 0 and 7 are Sunday.
				30 7 * * *  -> Means daily 7:30 AM
		Build->Invoke top-Level maven target->Maven Version->mvn command in Goals like "test -PSanity"
		Post-build Actions->
		Save
		Build Now
		
		TestNG Reporting
			Manage Jenkins->Manage Plugins->TestNG->Job->Configure->Post-build Actions->Publish TestNG Results
		
		Build Paramiterization:
		To set browser from cmd- add the below line
		//String browserName = property.getProperty("browser"); // remove this line with below
		String browserName = System.getProperty("browser");
		mvn test -Dbrowser=chrome
		In Jenkins -> Configure->This project is parameterized->Add Parameter->Choice Parameter-> provide name and choices-> it will reflect in the dropdown of build with parameter
					In jenkins Build->provide test -Dbrowser=$"browser"  //
		
38. Extend Reporting
		Add extentreports dependency from mvnrepository into pom.xml
					ExtentReports extentReports;	
					@BeforeTest
					public void config() {
						String path = System.getProperty("user.dir") +"\\reports\\index.html";
						ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
						sparkReporter.config().setDocumentTitle("Test Results");
						sparkReporter.config().setReportName("Chinmoy Selenium Practice Test Results");
						extentReports = new ExtentReports();
						extentReports.attachReporter(sparkReporter);
						extentReports.setSystemInfo("Chinmoy", "Automation Tester");		
					}	
					@Test
					public void Intitial() {
						extentReports.createTest("Intitial");
						System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
						WebDriver driver = new ChromeDriver();	
						driver.get("https://www.amazon.com/");
						driver.manage().window().maximize();
						System.out.println(driver.getTitle());
						extentReports.flush();
					}

39. Git     https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html
		To introduce yourself with git
			git config  --global user.name "Chinmoy"
			git config  --global user.email "sanujana8@gmail.com"
			Cd go to the repo folder
			git init -> to introduce the folder/ files to git
			git add * -> takes a modified file in your working directory and places the modified version in a staging area
			git commit -m "Commit message" -> git commit takes everything from the staging area and 
												makes a permanent snapshot of the current state of your repository that is associated with a unique identifier
			git remote add origin https://github.com/ChinmoyJana14/KeywordDrivenFramework01.git -> for adding the github repo
			git push origin master -> for push to master branch		
			git checkout -b read-from-excel  -> check out feature branch
			git status -> show changes in stage, always peform before push
			git pull <remote> <branch> -> to get updated code from remote
			git merge <branchname> ->To merge a different branch into your active branch:
			git branch -> to show current working branch
			
			
40. Cucumber
			Install in eclipse from market place
			Create a maven project
			add cucumber dependency in pom.xml cucumber-java
			add junit dependency in pom.xml cucumber-junit for test runner
			Covert the project to Cucumber Project -> Right click->Configure
			TestRunner : Run multiple features
				@RunWith(Cucumber.class)
				@CucumberOptions(
						features = "src/test/java/features", //location of the feature files
						glue = {"stepDefinition"}), // location of the step definition classes
						monochrome = true, //better readable console
						plugin = {"pretty","html:target/HTMLReports/report.html",
										   "json:target/HTMLReports/report.json",
										   "junit:target/HTMLReports/report.xml"},// generate different reports
						publish = true, // publish report at for sharing with your team https://reports.cucumber.io/reports/
						tags ="@SmokeScenario", //run all the test cases with this tag from the features package
					public class TestRunner {	
					} 
			Scenario Outline: in feature file for parameterized scenario
	Cucumber TestNG Integration:
			Create TestNG xml with TestRunner class
				  <test name="ValidatingTitle">
					<classes>
					  <class name="cucumberOptions.TestRunner"/>
					</classes>
				  </test> <!-- Test -->
			Add cucumber-testng maven dependency in pom.xml
					<dependency>
						<groupId>io.cucumber</groupId>
						<artifactId>cucumber-testng</artifactId>
						<version>7.6.0</version>
					</dependency>
			Commenting out @RunWith(Cucumber.class) 
			TestRunner Class should extends AbstractTestNGCucumberTests Class
			Remove import io.cucumber.junit.CucumberOptions;
			Add import io.cucumber.testng.CucumberOptions;
			To run from cmd -> add the testng.xml in pom, recheck proper jre in build patch
			
41. Log4j	Add dependency in pom.xml
			Use log.Error() to log when elements are not displayed in the page or if any validations fail
			Use Log.Debug() When each Selenium action is performed like click, SendKeys, getText()
			Use log.info() When operation is successfully completed ex: After loading page, or after any successful validations		
				Configuration.xml - Add to Build Source Path
					Where to log? Console or separate file	- Appenders tag
					How to Log? pattern - Appenders tag
					What to log?  -Loggers tag
						Root level - error(only error) or trace(entire log)
						Logger - set log level for specific packages	
							<?xml version="1.0" encoding="UTF-8" ?>						
								<Configuration status="WARN">
								  <Appenders>	
									<Console name="Console" target="SYSTEM_OUT">
									  <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
									</Console>
								  </Appenders>
								  <Loggers>
									<Logger name="beta.Demo1" level="error" additivity="false">
									  <AppenderRef ref="Console"/>
									</Logger>
									<Root level="trace">
									  <AppenderRef ref="Console"/>
									</Root>
								  </Loggers>
								</Configuration>
					Log in a specific file - add the RollingFile inside Appenders and set path using Properties in global level
								<Properties>
									<Property name="basePath">logs</Property>
								</Properties>
																			
								<RollingFile name="File" fileName="${basePath}/prints.log" filePattern="${basePath}/prints-%d{yyyy-MM-dd}.log">
								 <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
								  <SizeBasedTriggeringPolicy size="500" />
								</RollingFile>
			To know maven about log4j need to add resources in pom.xml inside build
							<resources>
							  <resource>
								<directory>src/main/java/resources</directory>
								<filtering>true</filtering>
							  </resource>
							</resources>
			public static Logger log = LogManager.getLogger(Demo.class.getName());
	
								
42. PageObject
			To store the webelements separate from tests
			To acces the webelements from the class, we need to pass the driver while creating the object of the class.
				to do so, we need to create a constructor in the welements class
					and in this constructor we need to assign the passed driver to the local driver i.e this.driver
			
43. Thread safe execution: same test object will not overrider by multiple thread in parallel execution
			ExtentTest test ;
			ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
				@Override
				public void onTestStart(ITestResult result) {
					test = reports.createTest(result.getMethod().getMethodName());
					extentTest.set(test);//First setting the test method object inside the thread safe object
				}
				@Override
				public void onTestSuccess(ITestResult result) {
					// TODO Auto-generated method stub
					extentTest.get().log(Status.PASS, "Test Passed");//Geeting the thread safe object from the pull and using for operation perticular to the test method test object
				}
		
44. Head less:
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		
45. Can driver be static? 
		static variable - means all are accessing the same variable reference, not creating a new instance, shared object by all. 
			For sequence run WebDriver can be static but for parallel run it can override the driver instanciated for one tests
				To avoid this, we declare local variable of WebDriver in each test classes.
				Again plus point of static variable is less memory utilization

**********************CromeDevTools**************************************************
46. CromeDevTools : only in Chromium based browser i.e chrome and edge
		1. Capture, Monitor and Stub the network requests and responses
		2. Inject session cookies and perform basic Auth
		3. Mock device cordinates for Mobile/Tab view
		4. Check and monitor the site's performance
		5. Mock geolocation of the user
		6. Block the network requests - Block to load extra image files to avoid synch issues
		7. Mock faster/slower network speeds - set same speed of network in times of development 
		8. Execute and Debug JavaScript
	selenium send command to CDP methods which talk with chromedevtools
	CDP methods: https://chromedevtools.github.io/devtools-protocol/tot/Accessibility/
	
	Set Device:
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//selenium send command to CDP methods which talk with chromedevtools
	    devTools.send(Emulation.setDeviceMetricsOverride(700, 1000, 50, true, Optional.<Number> empty(),
	            Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
	            Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
	            Optional.<Viewport> empty(), Optional.<DisplayFeature> empty()));  
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");	
	Call CDP without Selenium Custom Method:
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width", 700);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 50);
		deviceMetrics.put("mobile", true);	
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
	Localization:
		Map<String, Object> cordinates = new HashMap<String, Object>();
		cordinates.put("latitude", 40);
		cordinates.put("longitude", 3);
		cordinates.put("accuracy", 1); 	
		driver.executeCdpCommand("Emulation.setGeolocationOverride", cordinates);
	
	NetworkActivityMonitor
				ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();		
		devTools.send(Network.enable(Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty()));		
		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			System.out.println(request.getRequest().getUrl());
			System.out.println(request.getRequest().getMethod());
		});		
		devTools.addListener(Network.responseReceived(), response -> 
		{
			System.out.println(response.getResponse().getUrl());
			System.out.println(response.getResponse().getStatus());

		});	
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		
	NetworkMock:
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();	
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request ->
		{
			if(request.getRequest().getUrl().contains("shetty")) 
			{
				String changeUrl = request.getRequest().getUrl().replace("=shetty", "=one");
				System.out.println(changeUrl);
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(changeUrl),
						Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			}else
			{
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();	
	}
	
	NetworkFailing:
		List<RequestPattern> patterns = Arrays.asList(
				new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())
				);
		devTools.send(Fetch.enable(Optional.of(patterns),Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request ->
		{
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
	
	NetworkBlock: Stop loading CSS/Images for fast operation
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));	
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.CSS")));
	
	NetworkSpeed: Scheduled run of the suite maight be in differnt time having less speed internet considered
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
		true-> for offline, to get the error message in test
		devTools.addListener(Network.loadingFailed(), loadingFailed -> 
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
	
	BasicAuthentication:
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
	BrowserConsoleLogCapture:
		//We need to write the below code inside Listener OnTestfailure method
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = entries.getAll();
		for (LogEntry logEntry : logs) {
			//We need to puch this inside Log4j file
			System.out.println(logEntry.getMessage());
		}
**********************CromeDevTools**************************************************		

47. org.openqa.selenium.StaleElementReferenceException
		This exception says that a web element is no longer present in the web page.
		This error is not the same as ElementNotVisibleException.
		StaleElementReferenceException is thrown when an object for a particular web element was created in the program without any problem and however;
		this element is no longer present in the window. This can happen if there was a
			Navigation to another page
			DOM has refreshed
			A frame or window switch
			
48. Sauce Labs: Running tests in different VMs and different browser versions as per adhoc requests
		Go to platform-configurator of sauce lab for auto generated code
		Go to user setting of profile of sauce lab for credential
		DesiredCapabilities Class: Connect sauce lab from test case -> Deprecated
			now use ChromeOptions		
				public static final String USERNAME = "oauth-sanujana8-a9cd5";
				public static final String ACCESSKEY = "9f02af03-714f-4ded-ad4a-bb5af887b900";
				//Go to platform-configurator of sauce lab for auto generated code
				//Go to user setting of profile of sauce lab for credential
				public static final String URL = "https://" + USERNAME +":"+ ACCESSKEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
				public static void main(String[] args) throws MalformedURLException {	
					
					ChromeOptions browserOptions = new ChromeOptions();		
					browserOptions.setPlatformName("Windows 10");
					browserOptions.setBrowserVersion("99");	
					
					Map<String, Object> sauceOptions = new HashMap<>();
					sauceOptions.put("build", "Google Test");	
					sauceOptions.put("name", "Chinmoy Practice");
					
					browserOptions.setCapability("sauce:options", sauceOptions);
					System.out.println(URL);
					RemoteWebDriver driver = new RemoteWebDriver(new URL (URL), browserOptions);	
					
					driver.get("https://google.com");
					WebElement searchBox = driver.findElement(By.name("q"));
					searchBox.sendKeys("Munu");
					searchBox.sendKeys(Keys.ENTER);
					driver.findElements(By.cssSelector("a[href^='https://munu']")).get(1).click();
					System.out.println(driver.getCurrentUrl());
					driver.close();
				}
		
		
		
		
			
		
		
		
		
		
