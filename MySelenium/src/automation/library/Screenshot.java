package automation.library;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void takeScreenshot(WebDriver driver, String name) throws IOException {

		// Calendar cal = Calendar.getInstance();

		TakesScreenshot ss = (TakesScreenshot) driver;
		File fs = ss.getScreenshotAs(OutputType.FILE);
		File fd = new File("./screenshot/" + name + ".png");
		FileUtils.copyFile(fs, fd);
	}

}
