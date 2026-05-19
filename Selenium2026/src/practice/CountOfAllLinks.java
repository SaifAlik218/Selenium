package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class CountOfAllLinks {

	public static void main(String[] args) {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://www.facebook.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links: "+ links.size());
		PreCondition.closeBrowser(driver);
	}

}
