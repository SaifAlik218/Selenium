package locator;

import java.util.HashMap;
import java.util.Map;

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
		    options.addArguments(
		        "--disable-notifications",
		        "--disable-popup-blocking",
		        "--disable-infobars",
		        "--no-sandbox",
		        "--disable-extensions",
		        "--disable-blink-features=AutomationControlled" // hides automation flag
		    );
		    // Block known ad domains
		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("profile.default_content_setting_values.ads", 2);
		    prefs.put("profile.default_content_setting_values.notifications", 2);
		    options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
		driver.quit();
	}

}