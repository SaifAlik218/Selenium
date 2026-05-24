package automationExercise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;
import takeScreenShot.TakeScreenShot;

public class VerifySubscriptionOnCartPage extends VerifySubscriptionHomePage {
	protected static String cartPageURL = "https://automationexercise.com/view_cart";
	protected static String className = VerifySubscriptionOnCartPage.class.getSimpleName();

	public static WebDriver subcriptionCartPage() {
		driver = PreCondition.openBrowser(URL);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			WebElement cartLink = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='/view_cart'])[1]")));
			cartLink.click();
			cartPage();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PreCondition.closeBrowser(driver);
		}
		return driver;
	}

	public static void cartPage() throws IOException {
		try {
			wait.until(ExpectedConditions.urlToBe(cartPageURL));
			WebElement subscriptionText = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Subscription']")));
			System.out.println("Expected text is present in the webpage :" + subscriptionText.getText());
//			TakeScreenShot.sucessTakeScreenShot(driver, className);
		} catch (Exception e) {
//			TakeScreenShot.failTakeScreenShot(driver, className);
			System.out.println("Expected text is not present in the webpage: " + driver.getCurrentUrl());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		subcriptionCartPage();
	}
}
