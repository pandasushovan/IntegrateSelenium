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

public class TestBsnlBillPay extends ConfigWorks {

	@Test
	public void bsnl() throws InterruptedException, IOException {
		// log-in page: fill up user id, password and click sign-in
		driver.findElementById(PropertyFileReader.locatorReader("login_username_id"))
				.sendKeys(PropertyFileReader.AppConfigRead("Username"));
		driver.findElementById(PropertyFileReader.locatorReader("login_password_id"))
				.sendKeys(PropertyFileReader.AppConfigRead("Password"));
		driver.findElementById(PropertyFileReader.locatorReader("login_logon_button_id")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// on next page, click the Pay Now
		driver.findElementByCssSelector(PropertyFileReader.locatorReader("home_amount_clickable_css")).click();
		driver.findElementByXPath(PropertyFileReader.locatorReader("home_paynow_button_xpath")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//h1[text()='step-1']/parent::div/div/div[3]/div/h2/a")));

		// Actions act = new Actions(driver);
		// act.click(driver.findElementByXPath("//h1[text()='step-1']/parent::div/div/div[3]/div/h2/a")).perform();

		// System.out.println("element enabled : "
		// +driver.findElementByXPath("//h1[text()='step-1']/parent::div/div/div[3]/div/h2/a").isEnabled());

		// Click the Credit card banner
		driver.findElementByXPath(PropertyFileReader.locatorReader("payment_creditcard_banner_xpath")).click();

		// Wait until all types of cards are available and click the same
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElementByXPath(PropertyFileReader.locatorReader("payment_creditcard_option_xpath"))));
		driver.findElementByXPath(PropertyFileReader.locatorReader("payment_creditcard_option_xpath")).click();

		// Wait until all gateways are available and click the same
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElementByXPath(PropertyFileReader.locatorReader("payment_gateway_option_xpath"))));
		driver.findElementByXPath(PropertyFileReader.locatorReader("payment_gateway_option_xpath")).click();
		Screenshot.takeScreenshot(driver, this.getClass().toString());
		
	//********** Testing Area ************************
	//	JavascriptExecutor js = (JavascriptExecutor)driver;
	//	js.executeScript("window.scrollBy(0,200)", "");
	//	js.executeScript("document.getElementsByTagName('h1')[0].innerHTML = 'Saanvi will Pay'", "");
				
	}

}
