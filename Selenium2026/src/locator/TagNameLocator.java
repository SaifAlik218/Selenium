package locator;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class TagNameLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new SafariDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement inputTag = driver.findElement(By.tagName("input"));
		inputTag.sendKeys("Saif");
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
	}

}
