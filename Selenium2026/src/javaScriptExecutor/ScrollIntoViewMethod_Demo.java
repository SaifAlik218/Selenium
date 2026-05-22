package javaScriptExecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class ScrollIntoViewMethod_Demo 
{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://automationexercise.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		List<WebElement> anchorTag = driver.findElements(By.xpath("//a"));
		for (WebElement eachAnchorTag : anchorTag) 
		{
			js.executeScript("arguments[0].scrollIntoView(true)", eachAnchorTag);
			Thread.sleep(2000);
		}
	}
	

}
