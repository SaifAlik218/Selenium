package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.PreCondition;

public class VerifyIsButtonClickable {

	public static void main(String[] args) throws InterruptedException {
		boolean flagButton = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/button/buttonSubmit?sublist=3");
		Thread.sleep(5000);
		WebElement yesButton = driver.findElement(By.id("sat_a"));
		if (yesButton.isEnabled()) {
			yesButton.click();
			flagButton = true;
			if (flagButton == true) {
				WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
				submitButton.click();
			}
		}
		WebElement yesSelectedMsg = driver.findElement(By.xpath("//span[contains(text(),'You Selected')]"));
		if (yesSelectedMsg.isDisplayed()) {
			System.out.println("User has submitted the request successfully");

		} else {
			System.out.println("User has not submitted the request successfully");
		}
		PreCondition.closeBrowser(driver);
	}

}
