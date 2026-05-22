package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class DisabledCheckBoxClick {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://testing.qaautomationlabs.com/checkbox.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement disabledCheckBox = driver.findElement(By.xpath("//input[@id='chk3']"));
		
		js.executeScript("arguments[0].click();", disabledCheckBox);

	}

}
