package locator;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PreCondition {
	public static String checkbox = "file:///Users/testuser/Desktop/Selenium/PracticeOfLogicalProgramms/src/practice/CheckBox.html";
	public static String facebookURl = "https://www.facebook.com/";
	public static String myntraURL = "https://www.myntra.com/";
	public static WebDriver driver;

	public static WebDriver openBrowser() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("user-data-dir=/Users/testuser/ChromeAutomationProfile");

		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver openBrowser(String URL) {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("user-data-dir=/Users/testuser/ChromeAutomationProfile");

		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get(URL);

		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
		driver.quit();
	}

}