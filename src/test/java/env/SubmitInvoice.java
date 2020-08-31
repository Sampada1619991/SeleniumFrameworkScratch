package env;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubmitInvoice {
	
	
	//import com.sun.jna.platform.FileUtils;

	public class Portal {
		
		public WebDriver driver;    
		 
		@BeforeTest	
		public void OpenIAPPortalLink() throws Throwable
		{	
					 /*************** Open Link ***************/
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\ChromeDriver\\chromedriver.exe");
			 driver=new ChromeDriver(); 
			 driver.get("https://accentureplcuksubdev1.service-now.com");		 
			 driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			 driver.switchTo().frame("gsft_main"); 
			 getscreenshot();
			 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);		 
		}
		
		@Test (priority=1, description="To check login functionality is working or not")
		
		public void Login() throws Throwable
		{
			 /*************** Login ***************/
			 
			/* File dt = new File("C:\\Users\\shriyash.khisti\\Documents\\Selenium\\Workspace\\Data.xlsx");
			 FileInputStream fis = new FileInputStream(dt);
			 XSSFWorkbook wb = new XSSFWorkbook(fis);
			 XSSFSheet sheet1 = wb.getSheetAt(0);*/
			 String userid1 = "forceten.supplier.user";
			 String pass1 = "12345";
			// userid1 = sheet1.getRow(1).getCell(0).getStringCellValue();
			 
		//	 pass1 =  Integer.toString((int) sheet1.getRow(1).getCell(1).getNumericCellValue());
			 
			 //String pass2 = new 
		
			 System.out.println(userid1 +"and"  );
			 
			 
			 WebElement userid = driver.findElement(By.xpath("//input[@id='user_name']"));
			 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 userid.sendKeys(userid1);
			 WebElement pass = driver.findElement(By.xpath("//input[@id='user_password']"));
			 pass.sendKeys(pass1);
			 WebElement button1 = driver.findElement(By.xpath("//button[@id='sysverb_login']"));
			 button1.click();
			 driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
			 getscreenshot();
		
		}
		
		@Test (priority=2, description="Clicking on Submit tab and verify its working or not")
		
		public void ClickOnSubmit() throws Throwable
		{
			WebElement submit = driver.findElement(By.xpath("//li[@id='submittab']"));
			submit.click();
			getscreenshot();
			    
		}
		
		@Test (priority=3, description="Clicking on PTP tab and verify its working or not")
		
		public void ClickOnPTP() throws Throwable
		{
			 WebElement ptp = driver.findElement(By.xpath("//li[@id='ptp']"));
			 ptp.click();
	         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);      
	       //  WebElement Inv = driver.findElement(By.linkText("Submit Invoice"));
	         getscreenshot();
		}
		
		@Test (priority=4, description="Clicking on Submit Invoice tab and verify its working or not")
		
		public void ClickOnSubmitInvoice() throws Throwable
		{
			WebElement Inv = driver.findElement(By.linkText("Submit Invoice"));
	        Inv.click();
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
	        jse.executeScript("window.scrollBy(0,250)", "");
	        driver.switchTo().frame("myFrame");
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        getscreenshot();
	        
		}
		
		@Test (priority=5, description="Fill the Submit Invoice form and Submit it")
		
		public void SubmitInvoiceForm() throws Throwable
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			/************* Selecting Legal Entity *****************/
	        driver.findElement(By.xpath("//a[@id='lookup.IO:42df7fce37c8764041bb1a7943990ec4']")).click();
	    
	        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        String parentWindow = driver.getWindowHandle();
	        Set<String> handles =  driver.getWindowHandles();
	        		for(String windowHandle  : handles)
	        				{
	        					if(!windowHandle.equals(parentWindow))
	        						{
	        							driver.switchTo().window(windowHandle);
	        							driver.findElement(By.linkText("FT1")).click();                  
	        							driver.switchTo().window(parentWindow); //cntrl to parent window                
	        						}
	        				}
	                           
	  
	        driver.switchTo().frame("myFrame");
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);   
	       
	        /****************** Selecting Company code *************/
	        
	        driver.findElement(By.id("lookup.IO:fef8f6d33762920003b812c543990e12")).click();
	        
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        driver.manage().window().maximize(); 
	        String parentWindow1 = driver.getWindowHandle();
	        Set<String> handles1 =  driver.getWindowHandles();
	        		for(String windowHandle  : handles1)
	        				{
	        					if(!windowHandle.equals(parentWindow1))
	        						{
	        							driver.switchTo().window(windowHandle);
	        							driver.findElement(By.linkText("ForceTen_UK")).click();
	                        			driver.switchTo().window(parentWindow); //cntrl to parent window                
	        						}
	        				}
	                           
	  
	        driver.switchTo().frame("myFrame");
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        
	        
	        
	        /************ Select Document Type*******************/
	        
	        Select drpdwn1 = new Select(driver.findElement(By.id("IO:49f7f2d33762920003b812c543990e84")));
	        drpdwn1.selectByIndex(3);
	        getscreenshot();
	        
	        /*************** Enter Short description **************/
	        
	        driver.findElement(By.id("IO:93b5e4973744324003b812c543990e58")).sendKeys("Submit invoice by automation");
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	                     
	        
	        /*************** Attaching PDF ***************/
	        WebElement attach = driver.findElement(By.xpath("//*[@id='macro_IO:c72f1d143776520041bb1a7943990e22']/div[2]/table/tbody/tr[2]/td/a/img"));
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        attach.click();
	        jse.executeScript("window.scrollBy(0,-550)", "");
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        WebElement chsefile = driver.findElement(By.xpath("//input[@id='attachFile']"));
	        chsefile.click();
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        Runtime.getRuntime().exec("C:\\Users\\shriyash.khisti\\Documents\\Selenium\\Script5.exe");
	        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
	       // Thread.sleep(10000);
	        jse.executeScript("window.scrollBy(0, -250)", "");       
	        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);        
	        driver.findElement(By.xpath("//*[@id='attachment']/div/div/header/button")).click();
	        getscreenshot();
	        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	        
	        /************ Select Main Attachment*******************/
	        
	        Select drpdwn2 = new Select(driver.findElement(By.id("IO:d769ecd7377ed20041bb1a7943990e37")));
	        drpdwn2.selectByIndex(1);
	       
	        jse.executeScript("window.scrollBy(0,250)", "");
	        
	       // jse.executeScript("window.scrollBy(0,250)", "");
	        driver.findElement(By.id("IO:67589522374cbe0003b812c543990ec3")).sendKeys("Test");
	        getscreenshot();
	        
	        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	        
	        WebElement element = driver.findElement(By.id("order_now"));
	        //Actions action = new Actions(driver);
	       // element.sendKeys("  ");
	        element.click();         
	       // action.moveToElement(element).click().perform();
	        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
	        jse.executeScript("window.scrollBy(0,-250)", "");
	        driver.findElement(By.linkText("Submit Invoice")).click();
	        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
	        getscreenshot();
		}
		
		@Test (priority=6, description="Retrive RITM number and write it inn excel")
		
		public void PrintRITMNumber() throws Throwable
		{
			File dt = new File("C:\\Users\\shriyash.khisti\\Documents\\Selenium\\Workspace\\Data.xlsx");
			FileInputStream fis = new FileInputStream(dt);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);		 
			WebElement RITM = driver.findElement(By.id("sys_readonly.sc_req_item.number"));
	        String name = RITM.getAttribute("value");
	        System.out.println(" " +name); 
	        getscreenshot();
	        sheet1.getRow(1).createCell(2).setCellValue(name);
	        FileOutputStream fout = new FileOutputStream(dt);
	        wb.write(fout);
	        ((WebDriver) wb).close();
		}
		
		 public void getscreenshot() throws Exception 
	     {
			 String timeStamp; 
			 File screenShotName; 
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			 //The below method will save the screen shot in d drive with name "screenshot.png" 
			 timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
			 screenShotName = new File("C:\\Screenshots\\"+timeStamp+".png"); 
			 FileUtils.copyFile(scrFile, screenShotName); 
			 //String filePath = screenShotName.toString(); 
			// String path = "<img srcFile="\"file://"" alt="\"\"/" />"; 
			// Reporter.log(path); 
			 
	     }

	}


}
