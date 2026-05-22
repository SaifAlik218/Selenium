package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class ScrollIntoViewMethod {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://automationexercise.com/");
		WebElement subsriptionText = driver.findElement(By.xpath("//h2[text()='Subscription']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", subsriptionText);
		PreCondition.closeBrowser(driver);

	}

}
