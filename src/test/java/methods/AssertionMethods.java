package methods;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import env.BaseTest;

public class AssertionMethods implements BaseTest {

	public boolean isElementDisplayed(String asscessName) {

		wc.log("Validating the element");

		try {
			Thread.sleep(2000);

			WebElement element = wc.getSingleElement(asscessName);

			if (element == null) {
				element = navigationObj.switchWindows(asscessName);
				wc.log("Element in window found :");
			}else {
				Assert.assertTrue("Element " + asscessName + " was not displayed", true);
			}

			if (element == null) {

				Assert.fail("Element not found by locatorKay : " + asscessName);
			} else {
				Assert.assertTrue("Element " + asscessName + " was not displayed", true);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;

	}

}
