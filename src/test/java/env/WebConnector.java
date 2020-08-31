package env;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebConnector{

	private static Object key = new Object();
	Properties OR = null;
	public static Properties CONFIG = null;
	public static WebDriver driver = null;
	private static WebConnector wc;
	public static Logger logger = Logger.getLogger(WebConnector.class);
	JavascriptExecutor jse;
	

	public WebConnector() {

		if (OR == null) {

			try {
				// Initialise OR
				// PropertyConfigurator.configure("devpinoyLogger");
				OR = new Properties();
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + "\\ConfigFiles\\OR.properties");
				OR.load(fs);

				// select config file correspoding to env.
				CONFIG = new Properties();
				fs = new FileInputStream(System.getProperty("user.dir") + "\\ConfigFiles\\" + OR.getProperty("testEnv")
						+ "_config.properties");
				CONFIG.load(fs);

				// logProperties.load(new FileInputStream(LOG_PROPERTIES_FILE));
				// PropertyConfigurator.configure(logProperties);
				logger.info("Logging initialized.");
				jse = (JavascriptExecutor) driver;
				
				// report=new ExtentReports("C:\\report\\LearnAutomation.html");

				// test.log(LogStatus.INFO,"ssdssd");

			} catch (Exception e) {

				System.out.println("error in initalisation");
				// throw new RuntimeException("Unable to load logging property "
				// + LOG_PROPERTIES_FILE);
			}

		}
	}

	public static WebConnector getInstance() {
		synchronized (key) {
			if (wc == null)
				wc = new WebConnector();
		}
		return wc;
	}

	public void log(String msg) {
		logger.info(msg);
	}

	// Open Browser
	public static WebDriver openBrowser() {
		
		String browserType=CONFIG.getProperty("browser");
		System.out.println("Browser To be launched : "+browserType);

		if (browserType.equals("Mozilla")) {
			driver = new FirefoxDriver();
			logger.info("Opening Mozilla.........");
			// test=report.startTest("VerifyBlogTitle");

		} else if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("************ Test Starts ************");
			System.out.println("");
			logger.info("Opening Chrome.........");
		} else if (browserType.equals("IE")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\ChromeDriver\\chromedriver.exe");
			logger.info("Opening IE.........");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;

	}

	/*// navigates to a URL
	public void navigate(String URL) {
		log("Naviating to " + CONFIG.getProperty(URL));
		driver.get(CONFIG.getProperty(URL));
		System.out.println("");
	}*/

	// clicking on any object
	public void click(String objectName) {
		log("Clicking on " + objectName);

		WebElement element = getSingleElement(objectName);
		element.click();
		// driver.findElement(By.xpath(OR.getProperty(objectName))).click();
	}

	public void type(String text, String objectName) {
		log("Typing in " + objectName);
		getSingleElement(objectName).sendKeys(text);
		
	}
	
	public void select(String objectName) {
		log("Selecting from " + objectName);
		// driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(text);
		getSingleElement(objectName).click();
		
	}

	public void navigateback() {
		log("Navigating to back page from current page  ");
		driver.navigate().back();

	}

	public boolean isElementPresent(String objectName) {
		log("Checking object presence " + objectName);
		// int count=findElementFromiframe(objectName).;
		int count = driver.findElements(By.xpath(OR.getProperty(objectName))).size();
		if (count == 0)
			return false;
		else
			return true;
	}

	/****************************
	 * Element extraction function
	 *******************************/
	
	public WebElement elementFinder(String locatorkey) {

		WebElement e = null;
		try {
			e = driver.findElement(By.xpath((OR.getProperty(locatorkey))));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		} catch (Exception ex) {

		}

		return e;
	}
	
	public WebElement getSingleElement(String locatorkey) {
		
		driver.switchTo().defaultContent();
		
		String identifierOS = OR.getProperty(locatorkey);
		if (identifierOS == null) {
			log("Element with ID " + locatorkey + " not found!");
			return null;
		}
		log("Identifier ID: " + locatorkey + " - " + identifierOS);
		System.out.println("");

		WebElement elementFound = null;
		elementFound = elementFinder(locatorkey); // Method to find element

		if (elementFound == null) {
			int iframeCountL1 = driver.findElements(By.tagName("iframe")).size();
			MyLoop: for (int i = 0; i < iframeCountL1; i++) {
				driver.switchTo().frame(i);
				elementFound = elementFinder(locatorkey); // Method to find element in layer 1
					
				if (!(elementFound == null))
					break MyLoop;

				if (elementFound == null) {
					int iframeCountL2 = driver.findElements(By.tagName("iframe")).size();
					for (int j = 0; j < iframeCountL2; j++) {
						driver.switchTo().frame(j);
						elementFound = elementFinder(locatorkey); //Method to find element in layer 1
						
						if (!(elementFound == null))
							break MyLoop;

						if (elementFound == null) {
							int iframeCountL3 = driver.findElements(By.tagName("iframe")).size();
							for (int k = 0; k < iframeCountL3; k++) {
								driver.switchTo().frame(k);
								elementFound = elementFinder(locatorkey); // Method
																			
								if (!(elementFound == null)) {
									break MyLoop;
								} else driver.switchTo().defaultContent();

							}
							driver.switchTo().defaultContent();
						}
					}
					driver.switchTo().defaultContent();

				}
			}
		}
		
		return elementFound;

	}
	
	
	
	
	/*public WebElement elementFinder(String locatorkey) {
	    driver.switchTo().defaultContent();
	    WebElement element = driver.findElement(By.xpath(OR.getProperty(locatorkey)));
	    return element;
	}


	public WebElement findElement(String locatorkey) {
	    WebElement elementFound = null;
	    elementFound = elementFinder(locatorkey);
	    
	    if(elementFound!=null) {
	        return elementFound;
	    }
	    
	    int iframeCount = driver.findElements(By.tagName("iframe")).size();
	    for (int i = 0; i < iframeCount; i++) {
	        driver.switchTo().frame(i);
	        elementFound = findElement(locatorkey);
	        driver.switchTo().defaultContent();
	        if(elementFound!=null) {
	            break;
	        }
	    }
	    return elementFound;
	}*/
	
/*
	public WebElement findElement(String locatorkey) {
		driver.switchTo().defaultContent();
		WebElement e = null;
		String identifierOS = OR.getProperty(locatorkey);

		if (identifierOS == null) {
			log("Element with ID " + locatorkey + " not found!");
			return null;
		}
		log("Identifier ID: " + locatorkey + " - " + identifierOS);
		System.out.println("");

		try {
			if (identifierOS.startsWith("//")) {
				e = driver.findElement(By.xpath(identifierOS));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
				Thread.sleep(500);
			} else if (identifierOS.endsWith("_id"))
				e = driver.findElement(By.id(identifierOS));
			else if (identifierOS.endsWith("_name"))
				e = driver.findElement(By.name(identifierOS));
		} catch (Exception ex) {
			// report the failure
		}

		if (e == null) {

			e = findElementFromiframe(locatorkey);

		}

		return e;
	}

	*//***************************
	 * Find elements from iframes
	 ***************************************//*
	public WebElement findElementFromiframe(String locatorkey) {
		// jse.executeScript("window.scrollBy(0,-350)", "");

		WebElement e = null;
		String identifierOS = OR.getProperty(locatorkey);

		if (identifierOS == null) {
			log("Element with ID " + locatorkey + " not found!");
			return null;
		}
		// log("Identifier ID: " + locatorkey + " - " + identifierOS);

		int size = driver.findElements(By.tagName("iframe")).size();

		if (size == 0) {
			System.out.println("There are no iframes found on the screen ");
		} else {
			System.out.println("Total count of Iframe on screens are " + size);

		}

		for (int i = 0; i < size; i++) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(i);
			try {
				if (identifierOS.startsWith("//")) // Select element by xpath
				{
					e = driver.findElement(By.xpath(identifierOS));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
					Thread.sleep(500);
				}
				
				 * else{ e = driver.findElement(By.id(identifierOS)); //Select
				 * element by id }
				 

				// Currently disabled logic to select element finder method.
				else if (identifierOS.endsWith("_id"))
					e = driver.findElement(By.id(identifierOS));
				else if (identifierOS.endsWith("_name"))
					e = driver.findElement(By.name(identifierOS));

			} catch (Exception ex) {
				// report the failure
			}

			if (!(e == null)) {
				break;
			}
		}
		return e;
	}
*/
	/**************************** Swith Windows *******************************/

	public void switchWindows() {

		// String parentWindowboreclick = driver.getWindowHandle();
		// System.out.println("Parent window id before click
		// -"+parentWindowboreclick);

		/*
		 * WebElement ElementToBeClicked = findElement(elementId);
		 * ElementToBeClicked.click();
		 */

		Set<String> handles = driver.getWindowHandles();
		int TotalCountOfWindows = handles.size();
		System.out.println("Totol windows count" + TotalCountOfWindows);

		if (TotalCountOfWindows > 1) {
			Iterator<String> it = handles.iterator();

			String parentWidnow = it.next();
			System.out.println("Parent window id -" + parentWidnow);

			String newWindow = it.next();
			System.out.println("child window id  -" + newWindow);
			driver.switchTo().window(newWindow);
		}

		driver.switchTo().defaultContent();
	}

	/**************************** Switch frame 
	 * @throws InterruptedException *******************************/
	public void switchIframe() throws InterruptedException {
		//Actions action= new Actions(WebConnector.driver);
		//driver.switchTo().defaultContent();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("iframecoutn" + size);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		
	
		driver.findElement(By.xpath("//*[@id='order_now']")).click();
		Thread.sleep(5000);
		try {
		    WebDriverWait wait = new WebDriverWait(WebConnector.driver, 5);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = WebConnector.driver.switchTo().alert();
		    System.out.println(alert.getText());
		    alert.accept();
		    Assert.assertTrue(alert.getText().contains("Thanks."));
		} catch (Exception e) {
		    //exception handling
		}
		
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='order_now']")));
		/*
		 * for(int i=0; i<size; i++){ driver.switchTo().defaultContent();
		 */

	}
	
	
	

	/*******************************
	 * Scroll up/Down
	 ******************************/

	public void scrollwindowDown() throws InterruptedException {

		jse.executeScript("window.scrollBy(0,250)", "");

	}

	public void scrollwindowup() throws InterruptedException {
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	public String readRITM(String id) {

		String ritmcode;
		WebElement e = getSingleElement(id);
		ritmcode = e.getAttribute("value");
		return ritmcode;

	}

	/*
	 * public void endRep(){ report.endTest(test); report.flush();
	 */

}
