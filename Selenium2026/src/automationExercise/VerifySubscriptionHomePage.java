package automationExercise;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;

public class VerifySubscriptionHomePage extends VerifySearchProduct 
{
	public static WebDriver subscriptionHomePage()
	{
		driver = PreCondition.openBrowser(URL);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		VerifySearchProduct.scrollWebPage();
		PreCondition.closeBrowser(driver);
		return driver;	
	}
	public static void main(String[] args) {
		subscriptionHomePage();
	}
}
