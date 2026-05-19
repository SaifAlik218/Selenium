package actionsClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import locator.PreCondition;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException, IOException {
		boolean flag = false;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		Thread.sleep(3000);
		WebElement doubleClick = driver.findElement(By.id("doubleBtn"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleClick).perform();
		try {
			WebElement status = driver.findElement(By.id("doubleStatus"));
			if (status.isDisplayed()) {
				flag = true;
				System.out.println("Double Click Detected: " + flag);
				File takeScreenShot = doubleClick.getScreenshotAs(OutputType.FILE);
				File folder = new File("/Users/testuser/Desktop/Selenium/Selenium2026/ScreenShots/");
				File[] files = folder.listFiles();
				int count = files.length + 1;
				File file = new File("/Users/testuser/Desktop/Selenium/Selenium2026/ScreenShots/doubleclickbuttonPass"
						+ count + ".png");
				FileHandler.copy(takeScreenShot, file);
			} else {
				System.out.println("Double Click Detected: " + flag);
				File takeScreenShot = doubleClick.getScreenshotAs(OutputType.FILE);
				File folder = new File("/Users/testuser/Desktop/Selenium/Selenium2026/ScreenShots/");
				File[] files = folder.listFiles();
				int count = files.length + 1;
				File file = new File("/Users/testuser/Desktop/Selenium/Selenium2026/ScreenShots/doubleclickbuttonfail"
						+ count + ".png");
				FileHandler.copy(takeScreenShot, file);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element no found");
		}
		PreCondition.closeBrowser(driver);
	}

}
