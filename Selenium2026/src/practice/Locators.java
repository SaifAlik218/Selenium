package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		boolean flagButton = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/button");
		Thread.sleep(3000);
		WebElement yesButton = driver.findElement(By.id("btn"));
		if (yesButton.isEnabled()) {
			yesButton.click();
			flagButton = true;
		}
		System.out.println(yesButton + " " + flagButton);
		PreCondition.closeBrowser(driver);
	}

}
