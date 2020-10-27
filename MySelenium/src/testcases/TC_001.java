package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import automation.library.PropertyFileReader;
import automation.library.Screenshot;
import base.library.ConfigWorks;

public class TC_001 extends ConfigWorks {

	@Test
	public void bsnl() throws InterruptedException, IOException {
		// log-in page: fill up user id, password and click sign-in
		driver.findElementById(PropertyFileReader.locatorReader("login_username_id"))
				.sendKeys(PropertyFileReader.AppConfigRead("Username"));
		driver.findElementById(PropertyFileReader.locatorReader("login_password_id"))
				.sendKeys(PropertyFileReader.AppConfigRead("Password"));
		driver.findElementById(PropertyFileReader.locatorReader("login_logon_button_id")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

}
