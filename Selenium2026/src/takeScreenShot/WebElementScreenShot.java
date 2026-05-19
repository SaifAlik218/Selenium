package takeScreenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.*;
import java.util.NoSuchElementException;

import org.openqa.selenium.io.FileHandler;

import locator.PreCondition;

public class WebElementScreenShot {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/button?sublist=0");
		Thread.sleep(3000);
		WebElement yesButton = driver.findElement(By.xpath("//button[text()='Yes']"));
		yesButton.click();
		try {
			WebElement successMsg = driver.findElement(By.xpath("//span[contains(text(),'You selected \"Yes\"')]"));
			if (successMsg.isDisplayed()) {
				TakeScreenShot.sucessTakeScreenShot(driver, WebElementScreenShot.class.getSimpleName());
				System.out.println("User clicked on Yes button sucessfully..");
			}
		} catch (Exception e) {
			TakeScreenShot.failTakeScreenShot(driver, WebElementScreenShot.class.getSimpleName());
			System.out.println("User failed to click on Yes button.." + e);
		}

		PreCondition.closeBrowser(driver);
	}

}
