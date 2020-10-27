package base.library;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import automation.library.PropertyFileReader;

public class ConfigWorks {

	public ChromeDriver driver;

	@BeforeClass
	public void bsnlBefore() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(PropertyFileReader.AppConfigRead("URL"));

	}

	@AfterClass
	public void bsnlAfter() {
		driver.quit();
	}

}
