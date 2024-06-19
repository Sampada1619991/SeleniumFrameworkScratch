package env;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import methods.AppSpecificMethods;
import methods.AssertionMethods;
import methods.FileUpload;
import methods.NavigateMethods;

public  interface BaseTest {
	
	String path= System.getProperty("user.dir")+"//data//TestData.xlsx";
	WebConnector wc= WebConnector.getInstance();
	WebDriver driver = WebConnector.openBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Xls_Reader xls = new Xls_Reader(path);
	
	NavigateMethods navigationObj = new NavigateMethods();
	AssertionMethods assertionObj= new AssertionMethods();
	AppSpecificMethods appMethodsObj=new AppSpecificMethods();
	FileUpload uploadFileObj = new FileUpload();

	
}
