package StepDefinations;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;*/
import com.sun.tools.corba.se.idl.constExpr.Or;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import env.BaseTest;
import env.WebConnector;
import methods.AppSpecificMethods;
import methods.NavigateMethods;

public class Step_Definations implements BaseTest {

	public static Logger logger = Logger.getLogger(WebConnector.class);

	@Given("^navigate to application \"([^\"]*)\"$")
	public void navigate_to_application(String arg1) throws Throwable {

		navigationObj.navigate(arg1);
	}

	@Given("^launch new window by clicking on button \"([^\"]*)\"$")
	public void launch_new_window_by_clicking_on_button(String elementid) throws Throwable {
		// wc.launchNewWindowByClickingOnObject(elementid);
	}

	@Given("^I logged in with username \"(.*?)\" and password \"(.*?)\" to launch \"(.*?)\" view$")
	public void Login(String userName, String passWord, String expectedView) throws Throwable {
		appMethodsObj.appLogin(userName, passWord, expectedView);
	}

	@Then("^I click on loginbutton to launch the \"([^\"]*)\" view$")
	public void i_click_on_loginbutton_to_launch_the_view(String expectedView) throws Throwable {
		appMethodsObj.login(expectedView);

	}

	@Given("^I navigate back$")
	public void navigateTobackPage() throws Throwable {
		wc.navigateback();
	}

	@Given("^I logged out from portal$")
	public void LogoutFromPortalvew() throws Throwable {

		String userIconElementid = "user_icon";
		String logoutlistElementid = "logout";
		actionMouseOver(userIconElementid, logoutlistElementid);
	}

	@Given("^I navigate to My Profile Page$")
	public void NavigatToMyProfile() throws Throwable {

		String userIconElementid = "user_icon";
		String MyProfileElementId = "myProfile";
		actionMouseOver(userIconElementid, MyProfileElementId);

	}

	@Given("^I navigate to company profile Page$")
	public void NavigatToCompanyProfile() throws Throwable {

		String ProfileTabId = "profile_tab";
		String MyProfileElementId = "companyProfile";
		actionMouseOver(ProfileTabId, MyProfileElementId);

	}

	@Given("^I note down RITM $")
	public void saveRitm() throws Throwable {

	}

	@Then("^check that element \"(.*?)\" is displayed$")
	public void thenCheckElementIsDisplayed(String asscessName) throws Throwable {
		assertionObj.isElementDisplayed(asscessName);
	}

	@Then("^check that iframe element \"(.*?)\" is displayed$")
	public boolean thenCheckiframeElementIsDisplayed(String id) throws Throwable {

		Thread.sleep(2);

		WebElement element = wc.getSingleElement(id);
		if ((element == null)) {
			Assert.fail("Element not found by locatorKay : " + id);
		}
		Assert.assertTrue("Element " + id + " was not displayed", true);
		return true;
	}

	@Then("^I type value: \"(.*?)\" in the element: \"(.*?)\"$")
	public boolean typeValueInSelectedElement(String value, String id) throws Throwable {

		Thread.sleep(2);
		WebElement element = wc.getSingleElement(id);
		if (element == null) {
			element = navigationObj.switchWindows(id);
			// element.sendKeys(value);
		} else {
			element.sendKeys(value);
		}
		return true;
	}

	@Then("^I click on the element: \"(.*?)\"$")
	public boolean clickOnElement(String id) throws Throwable {
		appMethodsObj.clickElement(id);
		return true;
	}

	/*
	 * @Then("^check that element \"([^\"]*)\" is displayed when new window opens$"
	 * ) public void
	 * check_that_element_is_displayed_when_new_window_opens(String id) throws
	 * Throwable { navigationObj.switchWindows();
	 * assertionObj.isElementDisplayed(id); }
	 */

	/*
	 * @Then("^I forceclick on the element: \"(.*?)\"$") public boolean
	 * forceclickOnElement(String catalogs) throws Throwable {
	 * 
	 * appMethodsObj.forceClick(catalogs); return true;
	 * 
	 * }
	 */

	@Then("^I check the checkbox is ticked :\"([^\"]*)\"$")
	public void i_check_the_checkbox_is_ticked(String checkBox) throws Throwable {
		appMethodsObj.checkBoxCheckedOrNot(checkBox);
	}

	@Given("^I scroll up the window$")
	public void scrollwindowUp() throws Throwable {
		wc.scrollwindowup();
		Thread.sleep(5000);
	}

	@Given("^I scroll down the window$")
	public void scrollwindowDown() throws Throwable {
		wc.scrollwindowDown();
		Thread.sleep(5000);
	}

	@Given("^fill the data for input filed:\"(.*?)\"from data table row:\"(.*?)\"$")
	public void inputTestDataFromDataTable(String filedName, String dataRowUniquekey) throws Throwable {
		// Hashtable<String,String> testData=env.DataUtil.getTestData(xls,
		// dataRowUniquekey);
		appMethodsObj.dataprovider(filedName, dataRowUniquekey);

	}

	public static void actionMouseOver(String elementId, String listElementId) throws Throwable {

		logger.info("Mouse Houverign");
		Thread.sleep(5000);
		Actions action = new Actions(WebConnector.driver);
		action.moveToElement(wc.getSingleElement(elementId)).perform();
		Thread.sleep(2000);
		action.moveToElement(wc.getSingleElement(listElementId)).click().perform();

	}

	@Given("^check that element \"([^\"]*)\" is displayed in new tab$")
	public void check_that_element_is_displayed_in_new_tab(String id) throws Throwable {

		logger.info("Checking element in new Tab");
		Thread.sleep(5000);
		Actions action = new Actions(WebConnector.driver);
		action.sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();
		assertionObj.isElementDisplayed(id);

	}

	@Given("^I click on the element: \"([^\"]*)\" in new tab$")
	public void i_click_on_the_element_in_new_tab(String id) throws Throwable {

		logger.info("Clicking element in new Tab");
		Thread.sleep(5000);
		Actions action = new Actions(WebConnector.driver);
		action.sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();
		appMethodsObj.clickElement(id);

	}

	@Then("^select switch Client to switch client from dropdown$")
	public void select_switch_Client_to_switch_client_from_dropdown() throws Throwable {

		String userIconElementid = "user_icon";
		String switchClientlistElementid = "switchClient";
		actionMouseOver(userIconElementid, switchClientlistElementid);
	}

	
	@Then("^I select the client \"([^\"]*)\" and click on OK$")
	public void i_select_the_client_and_click_on_OK_from_profile_to_launch_view(String elementId)
			throws Throwable {
		
		appMethodsObj.switchClient(elementId);
	}
	
	@Then("^I Select the file in File Browser and Upload it\\.$")
	public void i_Select_the_file_in_File_Browser_and_Upload_it() throws Throwable {
		uploadFileObj.UploadFile();
	}

}
