package methods;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import env.BaseTest;

public class FileUpload implements BaseTest {

	public void UploadFile() throws InterruptedException, IOException {

		String filePath = "C:\\Users\\sampada.s.chendake\\Desktop\\Invoice 1.pdf";

		String autoScriptPath = "C:\\selenium\\FinalProject\\GitCloning\\data\\AutoIT\\InvoiceProcessingFileUpload.exe";

		Thread.sleep(2000);

		driver.switchTo().activeElement().sendKeys(filePath);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Runtime.getRuntime().exec(autoScriptPath);

	}

}
