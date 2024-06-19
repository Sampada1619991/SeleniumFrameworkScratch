package methods;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import StepDefinations.*;

//import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;

import StepDefinations.Step_Definations;
import env.BaseTest;
import env.DataUtil;
import env.WebConnector;
import env.Xls_Reader;

public class AppSpecificMethods implements BaseTest {

	public static Logger logger = Logger.getLogger(WebConnector.class);

	/*
	 * This method will login in app and validate the view for the correctness.
	 * It will also handle the pop up displayed for selection of multiple
	 * client.
	 */
	public void appLogin(String userName, String passWord, String expectedView) throws Throwable {

		wc.type(userName, "userNameTextBox");
		wc.type(passWord, "passWordTextBox");
		wc.click("loginButton");
		Thread.sleep(5);
		wc.log("####  Check if Screen to select client is displayed  ####");

		WebElement element = wc.getSingleElement("MoreThanOneClinet");
		element = wc.getSingleElement("MoreThanOneClinet");
		if (!(element == null)) {
			selectClient();
		}

		if (expectedView.contains("con")) {
			WebElement E = wc.getSingleElement("filterNavigator");
			Assert.assertTrue("*** Error **** Console View is not launched", !(E == null));
		} else if (expectedView.contains("por")) {
			Assert.assertTrue("*** Error **** Portal View is not launched",
					!(wc.getSingleElement("forceTen_Logo") == null));

		}

	}

	// On login page handle client selection when multiple clients are avaible
	public boolean selectClient() throws Throwable {

		String id = "OK";
		wc.click(id);
		Thread.sleep(5);

		try {
			WebDriverWait wait = new WebDriverWait(WebConnector.driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = WebConnector.driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			Assert.assertTrue(alert.getText().contains("Thanks."));
		} catch (Exception e) {
			// exception handling
		}

		return true;

	}

	// Search for RITM using Navigator Filter
	public void searchRITMUsingFilterNavigator(String ritmNo, String id) throws Throwable {
		Thread.sleep(5000);
		String elementid = "OpenRecords_Item";
		wc.click(id);
		wc.type(ritmNo, elementid);

	}

	// Select option from the collection

	public void selectOptionFromLoopup(String name, String id) throws InterruptedException {

		navigationObj.switchWindows(id);

		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String loopUPListElementName = name;

		String firstPart = "//a[contains(text(),'";
		String lastPart = "')]";
		String lookUplistItemTobeSelected = firstPart + loopUPListElementName + lastPart;

		WebElement element = wc.getSingleElement(lookUplistItemTobeSelected);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public void copyRITM(String id) throws HeadlessException, UnsupportedFlavorException, IOException {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		WebElement element = wc.getSingleElement(id);

		clipboard.setContents(new StringSelection((element).getText()), null);
		wc.log("ClipBorad Value is : ***********" + clipboard);

		String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		System.out.println("Clipborad Data is : *************" + data);

		File file = new File("C://RITM//RITM.txt");
		BufferedWriter output = null;
		if (file.exists() && !file.isDirectory()) {
			try {
				output = new BufferedWriter(new FileWriter(file));
				output.write(data);
				wc.log("Data Written successfully ***********");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (output != null) {
					output.close();
				}
			}
		} else {
			try {
				file.getParentFile().mkdir();
				file.createNewFile();
				output.write(data);
				wc.log("Data Written successfully ***********");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (output != null) {
					output.close();
				}
			}
		}
	}

	/**********************************
	 * Data Provider
	 *******************************************/

	public void dataprovider(String inputfiledLableId, String uniqueIdForDatatableRow) {

		String dataTableKey = inputfiledLableId.split("_")[0]; // Extract input
																// filed label
																// from the id.
		HashMap<String, String> testData = env.DataUtil.getData(xls, uniqueIdForDatatableRow); // get
																								// the
																								// value
																								// from
																								// data
																								// table
																								// using
																								// key
		wc.type(testData.get(dataTableKey), inputfiledLableId);

	}

	public void login(String expectedView) throws Throwable {

		wc.click("loginButton");
		Thread.sleep(5);
		wc.log("####  Check if Screen to select client is displayed  ####");

		WebElement element = wc.getSingleElement("MoreThanOneClinet");
		element = wc.getSingleElement("MoreThanOneClinet");
		if (!(element == null)) {
			selectClient();
		}

		if (expectedView.contains("con")) {
			WebElement E = wc.getSingleElement("filterNavigator");
			Assert.assertTrue("*** Error **** Console View is not launched", !(E == null));
		} else if (expectedView.contains("por")) {
			Assert.assertTrue("*** Error **** Portal View is not launched",
					!(wc.getSingleElement("forceTen_Logo") == null));

		}

	}

	public void checkBoxCheckedOrNot(String checkBox) {

		WebElement checkbox = wc.getSingleElement("rememberMe");

		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public void clickElement(String id) throws InterruptedException {

		Thread.sleep(3000);
		WebElement element = wc.getSingleElement(id);
		//element.click();

		Actions actions = new Actions(driver);
		
		actions.moveToElement(element).click().perform();
		
	/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element);*/
		/*if (element.isEnabled()) {
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} else {
			logger.info("Element is not Clickable Or Already Clicked");
		}*/

	}

	public void switchClient(String elementId) throws Throwable {
		
		WebElement mySelectElement = wc.getSingleElement("clientDropDown");
		Select dropdown= new Select(mySelectElement);
		
		//dropdown.selectByVisibleText("ForceTen");

		if(elementId== "forcetenDropDown"){
			
			dropdown.selectByVisibleText("ForceTen");
		}
		else{
			
			dropdown.selectByVisibleText("Unilever");
		}
		
		if (!(mySelectElement == null)) {
			selectClient();
		}
		
	}

	/*
	 * public void forceClick(String catalogs) {
	 * 
	 * WebElement catalog = wc.getSingleElement(catalogs);
	 * 
	 * JavascriptExecutor executor = (JavascriptExecutor)driver;
	 * executor.executeScript("arguments[0].click();", catalog); }
	 */
}
	
