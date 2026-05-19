package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://automationexercise.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement subscriptionText = driver.findElement(By.xpath("//h2[text()='Subscription']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Point locateSubscription = subscriptionText.getLocation();
		int x = locateSubscription.getX();
		int y = locateSubscription.getY();
		js.executeScript("window.scrollBy(arguments[0],arguments[1])", x, y);
		PreCondition.closeBrowser(driver);

	}
}
