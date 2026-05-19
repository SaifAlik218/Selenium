package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locator.PreCondition;

public class ClickAndHold {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/clickHold?sublist=0");
		Thread.sleep(2000);
		WebElement zoomButton = driver.findElement(By.id("circle"));
		Actions action = new Actions(driver);
		action.clickAndHold(zoomButton).perform();
		Thread.sleep(2000);
		action.release().perform();
		PreCondition.closeBrowser(driver);
	}

}
