package methods;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import env.BaseTest;
import env.WebConnector;

public class NavigateMethods implements BaseTest {

	// navigates to a URL
	public void navigate(String URL) {
		wc.log("Naviating to " + WebConnector.CONFIG.getProperty(URL));
		driver.get(WebConnector.CONFIG.getProperty(URL));
		System.out.println("");

	}

	public WebElement switchWindows(String id) throws InterruptedException {

		WebElement element = null;
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

			// Below commented code is for testing purpose.

			driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			
			element = wc.getSingleElement(id);
			
			/*if(element==null){
				element=switchIframe();
				wc.log("Element in i frame");
			}
			wc.log("Element found in Window : **********");
			
			if(element.equals("TypeYourQuestionTextBox")){
				element.sendKeys("Hi I need Help");
			}*/
			
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();
			driver.switchTo().window(parentWidnow);
		}
		
		return element;
	}

	/****************************
	 * Switch frame
	 * 
	 * @throws InterruptedException
	 *******************************/
	public WebElement switchIframe() throws InterruptedException {
		// Actions action= new Actions(WebConnector.driver);

		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("###########  iframecount " + size);
		driver.switchTo().frame(0);

		int size2 = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Iframecount in first layer" + size2);

		driver.switchTo().frame(0);
		WebElement ee =wc.getSingleElement("welComeToPortalSupportTitle"); //  driver.findElement(By.xpath("//*[@id='order_now']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ee);
		ee.click();
		Thread.sleep(5000);
		wc.log("Element in i frame :"+ee);
		try {
			WebDriverWait wait = new WebDriverWait(WebConnector.driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = WebConnector.driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			// Assert.assertTrue(alert.getText().contains("Thanks."));
		} catch (Exception j) {
			// exception handling
		}
		return ee;

	}

}
