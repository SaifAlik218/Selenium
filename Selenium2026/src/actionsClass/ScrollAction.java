package actionsClass;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import locator.PreCondition;

public class ScrollAction {

	public static void main(String[] args) throws InterruptedException {
		boolean flag = true;
		WebDriver driver = PreCondition.openBrowser();
		driver.get("https://demoapps.qspiders.com/ui/scroll/newTabVertical");
		Thread.sleep(4000);
		WebElement complaints = driver.findElement(By.xpath("//h3[text()='8. Complaints']"));
		Actions action = new Actions(driver);
		action.scrollToElement(complaints).perform();

		PreCondition.closeBrowser(driver);

	}

}
