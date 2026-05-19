package locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreCondition {
	public static String checkbox = "file:///Users/testuser/Desktop/Selenium/PracticeOfLogicalProgramms/src/practice/CheckBox.html";
	public static String facebookURl = "https://www.facebook.com/";
	public static String myntraURL = "https://www.myntra.com/";
	public static WebDriver driver;

	public static WebDriver openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
		driver.quit();
	}

}