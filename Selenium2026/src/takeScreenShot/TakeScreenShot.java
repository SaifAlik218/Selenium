package takeScreenShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot {
	private static final String SCREEN_PATH = "/Users/testuser/Desktop/Selenium/Selenium2026/ScreenShots";

	public static void sucessTakeScreenShot(WebDriver driver, String classname) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver; // to downcast
		File folder = new File(SCREEN_PATH); // to create file obj
		if (!folder.exists()) 
		{
			folder.mkdir();
			
		}
		File screenshot = takeScreenShot.getScreenshotAs(OutputType.FILE); // to take screenshot
		int count = folder.listFiles() != null ? folder.listFiles().length + 1 : 1;// to update the count
		File file = new File(SCREEN_PATH + "/success_" + classname + "_" + count + ".png");// to upload intp path
		FileHandler.copy(screenshot, file);
	}

	public static void failTakeScreenShot(WebDriver driver, String classname) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File folder = new File(SCREEN_PATH);// to create file obj
		if (!folder.exists()) 
		{
			folder.mkdir();
			
		}
		File screenshot = takeScreenShot.getScreenshotAs(OutputType.FILE); // to take screenshot
		int count = folder.listFiles() != null ? folder.listFiles().length + 1 : 1; // to take count
		File file = new File(SCREEN_PATH + "/fail_" + classname + "_" + count + ".png");// to upload into path
		FileHandler.copy(screenshot, file);
	}

}
