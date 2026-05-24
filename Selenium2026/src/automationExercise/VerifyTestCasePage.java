package automationExercise;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locator.PreCondition;

public class VerifyTestCasePage extends VerifyUserIsAbleToEnterDetails {
	protected static WebDriver driver;
	protected static String URL = "https://automationexercise.com/#google_vignette";
	protected static String testCasePage = "https://automationexercise.com/test_cases";
	protected static int pageScroll = 5;

	public static WebDriver testCasePage() throws InterruptedException {
		driver = PreCondition.openBrowser();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		js = (JavascriptExecutor) driver;
		driver.get(URL);
		driver.navigate().to(testCasePage);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[text()='Test Cases']")));

		for (int i = 0; i < pageScroll; i++) {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,300);");
		}
		WebElement verificationText = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//p[text()='Copyright © 2021 All rights reserved']")));
		js.executeScript("arguments[0].scrollIntoView(true);", verificationText);
		System.out.println("Footer verified: " + verificationText.getText());
		PreCondition.closeBrowser(driver);
		return driver;
	}
}
